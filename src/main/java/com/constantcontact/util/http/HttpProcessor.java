package com.constantcontact.util.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.constantcontact.components.Component;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.util.RawApiRequestError;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.SdkVersion;
import com.constantcontact.util.http.constants.ProcessorBase;

/**
 * Low-level Class responsible with HTTP requests in Constant Contact.<br/>
 * Outside has access only to
 * {@link HttpProcessor#makeHttpRequest(String, HttpMethod, ContentType, String, String)}
 * 
 * @author ConstantContact
 */
public class HttpProcessor implements ProcessorBase {
	
	private String accessToken;
	private String apiKey;
	
    /**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
     * Convenience method that automatically converts from Strings to bytes before calling makeHttpRequest.
     * @param urlParam
     * @param httpMethod
     * @param contentType
     * @param data
     * @return
     */
    public RawApiResponse makeHttpRequest(String urlParam, HttpMethod httpMethod, ContentType contentType, String accessToken, String data) {
        byte[] bytes = null;
        
        if (data != null){
            bytes = data.getBytes(Charset.forName("utf-8"));
        }
        
        return makeHttpRequest(urlParam, httpMethod, contentType, this.getAccessToken(), bytes);
    }
    
	/**
	 * Makes a HTTP request to the Endpoint specified in urlParam and using the
	 * HTTP method specified by httpMethod.
	 * 
	 * @param urlParam
	 *            The URL of the resource, as a {@link String}
	 * @param httpMethod
	 *            The {@link HttpMethod}
	 * @param contentType
	 *             The request body's content type
	 * @param data
	 *            A {@link String} containing the data or NULL when there is no
	 *            data to send (eg. in GET call).
	 * @return A {@link RawApiResponse} containing either the response data, or
	 *         the error info otherwise.
	 */
	public RawApiResponse makeHttpRequest(String urlParam, HttpMethod httpMethod, ContentType contentType, String accessToken, byte[] data) {

		BufferedReader reader = null;

		RawApiResponse urlResponse = new RawApiResponse();
		String responseMessage = null;
		String errorMessage = null;
		HttpURLConnection connection = null;
		try {

			connection = clientConnection(urlParam, httpMethod, contentType.getStringVal(), this.getAccessToken(), data);

			responseMessage = executeRequest(connection, data);

            int responseCode = connection.getResponseCode();
			urlResponse.setStatusCode(responseCode);

			Map<String,List<String>> headers = extractHeaders(connection);
			urlResponse.setHeaders(headers);
			
			if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
				return urlResponse;
			}

			if (responseCode >= 300) {
				errorMessage = "Response with status: " + responseCode;
				urlResponse.setError(true);
			}
			if ( (responseCode != HttpURLConnection.HTTP_ACCEPTED) && (responseMessage == null || responseMessage.trim() == "") ) {
			    // ACCEPTED can have no body.
				errorMessage = "Response was not returned or is null. Status code: " + responseCode;
			}

		} catch (Exception e) {
			urlResponse.setError(true);
			errorMessage = e.getMessage();
            e.printStackTrace();
		} finally { // we must manually handle release

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}// silently ignore
				reader = null;
			}
			
			if (connection != null){
			    connection.disconnect();
			}
		}
		if (urlResponse.isError()) {

			List<RawApiRequestError> rawApiRequestErrors = new ArrayList<RawApiRequestError>();

			// if there is an error and response message is not empty capture server errors

			if (responseMessage != null) {
				try {
					List<RawApiRequestError> rawApiRequestErrors2 = Component.listFromJSON(responseMessage, RawApiRequestError.class);
					rawApiRequestErrors.addAll(rawApiRequestErrors2);

				} catch (ConstantContactComponentException e) {
					RawApiRequestError rawApiRequestError = new RawApiRequestError("error", errorMessage);
					rawApiRequestErrors.add(rawApiRequestError);
				}
			} else {
				RawApiRequestError rawApiRequestError = new RawApiRequestError("error", errorMessage);
				rawApiRequestErrors.add(rawApiRequestError);
			}
			urlResponse.setRawApiRequestError(rawApiRequestErrors);

		} else {
			urlResponse.setBody(responseMessage);
		}
		return urlResponse;
	}

	protected Map<String, List<String>> extractHeaders(HttpURLConnection connection) {
        return connection.getHeaderFields();
    }

    /**
	 * Create the Connection to the Constant Contact endpoint.
	 * 
	 * @param urlParam
	 *            The exact URL to request.
	 * @param httpMethod
	 *            The {@link com.constantcontact.util.http.constants.ProcessorBase.HttpMethod} specifying the HTTP Method to use
	 *            (POST, GET, etc)
	 * @param contentType
	 *             The content type of the request body. Usually application/json
	 * @return The Connection object
	 * @throws Exception
	 *             When something went wrong.
	 */

	protected HttpURLConnection clientConnection(String urlParam, HttpMethod httpMethod, String contentType, String accessToken, byte[] data) throws Exception {

		String bindString = urlParam.contains("=") ? "&" : "?";
		urlParam = String.format("%1$s%2$sapi_key=%3$s", urlParam, bindString, this.getApiKey());

		URL url = new URL(urlParam);
		
		//System.out.println("URL :" + urlParam);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setReadTimeout(10000);
		connection.setUseCaches(false);

		connection.setRequestProperty(CONTENT_TYPE_HEADER, contentType);
		connection.addRequestProperty(ACCEPT_HEADER, JSON_CONTENT_TYPE);
		connection.addRequestProperty(AUTHORIZATION_HEADER, "Bearer " + this.getAccessToken());
        connection.addRequestProperty(X_CTCT_REQUEST_SOURCE_HEADER, String.format("sdk.java.%1s", SdkVersion.instance().getCtctSdkVersion()));
		connection.addRequestProperty("Connection", "Keep-Alive");
		connection.addRequestProperty("Keep-Alive", "header");

		if (data != null){
			connection.addRequestProperty("Content-Length", "" + Integer.toString(data.length));
		}
		
		switch (httpMethod) {
		case POST:
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			break;
		case DELETE:
			connection.setRequestMethod("DELETE");
			break;
 		case PUT:
			connection.setRequestMethod("PUT");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			break;
        case PATCH:
            setRequestMethodUsingWorkaroundForJREBug(connection, "PATCH");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            break;
 		case GET:
		default:
			connection.setRequestMethod("GET");
		}
		
		return connection;
	}
	/**
	 * Sends the url request to the Constant Contact endpoint.
	 * Sends the associated data if any, and returns the server response.
	 * 
	 * @param connection
	 * @param data
	 * @param accessToken
	 * @return server response
	 */
	protected String executeRequest(HttpURLConnection connection, byte[] data) {
		try {
			// Send request
			if (data != null) {
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.write(data);
				wr.flush();
				wr.close();
			}
			
			//Get the response
			InputStream is = null;
			
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK || connection.getResponseCode()  == HttpURLConnection.HTTP_CREATED) {
				is = connection.getInputStream();
			} else {
				is = connection.getErrorStream();
			}
			
			if (is != null){
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("utf-8")));
			    String line;
			    StringBuffer response = new StringBuffer();
		
			    while ((line = rd.readLine()) != null) {
			        response.append(line);
			        response.append('\r');
			    }
			    rd.close();
			    return response.toString();
			}
			else {
			   return null;
			}

			
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}

    private final void setRequestMethodUsingWorkaroundForJREBug(final HttpURLConnection httpURLConnection, final String method) {
        try {
            httpURLConnection.setRequestMethod(method);
            // Check whether we are running on a buggy JRE
        } catch (final ProtocolException pe) {
            Class<?> connectionClass = httpURLConnection
                    .getClass();
            Field delegateField = null;
            try {
                delegateField = connectionClass.getDeclaredField("delegate");
                delegateField.setAccessible(true);
                HttpURLConnection delegateConnection = (HttpURLConnection) delegateField
                        .get(httpURLConnection);
                setRequestMethodUsingWorkaroundForJREBug(delegateConnection, method);
            } catch (NoSuchFieldException e) {
                // Ignore for now, keep going
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            try {
                Field methodField;
                while (connectionClass != null) {
                    try {
                        methodField = connectionClass
                                .getDeclaredField("method");
                    } catch (NoSuchFieldException e) {
                        connectionClass = connectionClass.getSuperclass();
                        continue;
                    }
                    methodField.setAccessible(true);
                    methodField.set(httpURLConnection, method);
                    break;
                }
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
	public HttpProcessor(String accessToken, String apiKey) {
		super();
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}

}
