package com.constantcontact.util.http;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.Component;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.http.constants.ProcessorBase;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Low-level Class responsible with HTTP requests in Constant Contact.<br/>
 * Outside has access only to
 * {@link HttpProcessor#makeHttpRequest(String, HttpMethod, ContentType, String, String)}
 * 
 * @author ConstantContact
 */
public class HttpProcessor implements ProcessorBase {

    /**
     * Convenience method that automatically converts from Strings to bytes before calling makeHttpRequest.
     * @param urlParam
     * @param httpMethod
     * @param contentType
     * @param accessToken
     * @param data
     * @return
     */
    public CUrlResponse makeHttpRequest(String urlParam, HttpMethod httpMethod, ContentType contentType, String accessToken, String data) {
        byte[] bytes = null;
        
        if (data != null){
            bytes = data.getBytes();
        }
        
        return makeHttpRequest(urlParam, httpMethod, contentType, accessToken, bytes);
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
	 * @param accessToken
	 *            Constant Contact OAuth2 access token.
	 * @param data
	 *            A {@link String} containing the data or NULL when there is no
	 *            data to send (eg. in GET call).
	 * @return A {@link CUrlResponse} containing either the response data, or
	 *         the error info otherwise.
	 */
	public CUrlResponse makeHttpRequest(String urlParam, HttpMethod httpMethod, ContentType contentType, String accessToken, byte[] data) {

		BufferedReader reader = null;

		CUrlResponse urlResponse = new CUrlResponse();
		String responseMessage = null;
		String errorMessage = null;
		HttpURLConnection connection = null;
		try {

			connection = clientConnection(urlParam, httpMethod, contentType.getStringVal(), accessToken, data);

			responseMessage = executeRequest(connection, data, accessToken);

            System.out.println(responseMessage);

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

			List<CUrlRequestError> cUrlRequestErrors = new ArrayList<CUrlRequestError>();

			// if there is an error and response message is not empty capture server errors

			if (responseMessage != null) {
				try {
					List<CUrlRequestError> cUrlRequestErrors2 = Component.listFromJSON(responseMessage, CUrlRequestError.class);
					cUrlRequestErrors.addAll(cUrlRequestErrors2);

				} catch (ConstantContactComponentException e) {
					CUrlRequestError cUrlRequestError = new CUrlRequestError("error", errorMessage);
					cUrlRequestErrors.add(cUrlRequestError);
				}
			} else {
				CUrlRequestError cUrlRequestError = new CUrlRequestError("error", errorMessage);
				cUrlRequestErrors.add(cUrlRequestError);
			}
			urlResponse.setInfo(cUrlRequestErrors);

		} else {
			urlResponse.setBody(responseMessage);
		}
		return urlResponse;
	}

	private Map<String, List<String>> extractHeaders(HttpURLConnection connection) {
        return connection.getHeaderFields();
    }

    /**
	 * Create the Connection to the Constant Contact endpoint.
	 * 
	 * @param urlParam
	 *            The exact URL to request.
	 * @param httpMethod
	 *            The {@link HttpMethod} specifying the HTTP Method to use
	 *            (POST, GET, etc)
	 * @param contentType
	 *             The content type of the request body. Usually application/json
	 * @param accessToken
	 *            The Constant Contact OAuth2 access token.
	 * @return The Connection object
	 * @throws Exception
	 *             When something went wrong.
	 */

	private HttpURLConnection clientConnection(String urlParam, HttpMethod httpMethod, String contentType, String accessToken, byte[] data) throws Exception {

		String bindString = urlParam.contains("=") ? "&" : "?";
		urlParam = String.format("%1$s%2$sapi_key=%3$s", urlParam, bindString, ConstantContact.API_KEY);

		URL url = new URL(urlParam);
		
		System.out.println("URL :" + urlParam);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setReadTimeout(10000);
		connection.setUseCaches(false);

		connection.setRequestProperty(CONTENT_TYPE_HEADER, contentType);
		connection.addRequestProperty(ACCEPT_HEADER, JSON_CONTENT_TYPE);
		connection.addRequestProperty(AUTHORIZATION_HEADER, "Bearer " + accessToken);
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
            connection.setRequestMethod("PATCH");
            connection.setDoInput(true);
            connection.setDoOutput(true);
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
	private String executeRequest(HttpURLConnection connection, byte[] data, String accessToken) {
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
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
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

}
