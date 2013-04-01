package com.constantcontact.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.Component;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.httpclient.HttpResponse;
import com.constantcontact.httpclient.client.methods.HttpDelete;
import com.constantcontact.httpclient.client.methods.HttpGet;
import com.constantcontact.httpclient.client.methods.HttpPost;
import com.constantcontact.httpclient.client.methods.HttpPut;
import com.constantcontact.httpclient.client.methods.HttpUriRequest;
import com.constantcontact.httpclient.entity.StringEntity;
import com.constantcontact.httpclient.impl.client.DefaultHttpClient;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.http.constants.ProcessorBase;

/**
 * Low-level Class responsible with HTTP requests in Constant Contact.<br/>
 * Outside has access only to {@link HttpProcessor#makeHttpRequest(String, HttpMethod, String, String)}
 * 
 * @author ConstantContact
 */
public class HttpProcessor implements ProcessorBase {

	/**
	 * Makes a HTTP request to the Endpoint specified in urlParam and using the HTTP method specified by httpMethod.
	 * 
	 * @param urlParam The URL of the resource, as a {@link String}
	 * @param httpMethod The {@link HttpMethod}
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data A {@link String} containing the data or NULL when there is no data to send (eg. in GET call).
	 * @return A {@link CUrlResponse} containing either the response data, or the error info otherwise.
	 */
	public static CUrlResponse makeHttpRequest(String urlParam, HttpMethod httpMethod, String accessToken, String data) {

		DefaultHttpClient client = new DefaultHttpClient();
		HttpUriRequest uriRequest = null;
		BufferedReader reader = null;
		StringBuilder buffer = null; // we'll use StringBuilder to reduce the amount of garbage collection
		String line = "";

		CUrlResponse urlResponse = new CUrlResponse();
		String responseMessage = null;
		String errorMessage = null;
		try {
			uriRequest = clientConnection(urlParam, httpMethod, accessToken, data);
			HttpResponse httpResponse = client.execute(uriRequest);

			int responseCode = httpResponse.getStatusLine().getStatusCode();
			urlResponse.setStatusCode(responseCode); // first of all, set the status code.

			if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) { // nothing else to do since we came out empty...
				return urlResponse;
			}

			if (responseCode != HttpURLConnection.HTTP_OK && responseCode != Config.HTTP_CODES.EMAIL_CAMPAIGN_SCHEDULE_CREATED) {
				String statusLine = httpResponse.getStatusLine().toString();
				errorMessage = "Response with status: " + statusLine;
				urlResponse.setError(true);
			}
			
			reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			buffer = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				buffer.append(line).append('\n');
			}
			responseMessage = buffer.toString();

			if (responseMessage == null || responseMessage.trim() == "") {
				errorMessage = "Response was not returned or is null";
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
			buffer = null;
			client = null;
		}
		if (urlResponse.isError()) {
			
			List<CUrlRequestError> cUrlRequestErrors = new ArrayList<CUrlRequestError>();
			
			//if there is an error and response message is not empty capture server errors
			if(responseMessage != null) {				
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


	/**
	 * Create the UriRequest to the Constant Contact endpoint.
	 * 
	 * @param urlParam The exact URL to request.
	 * @param httpMethod The {@link HttpMethod} specifying the HTTP Method to use (POST, GET, etc)
	 * @param accessToken The Constant Contact OAuth2 access token.
	 * @return A HttpUriRequest
	 * @throws Exception When something went wrong.
	 */
	
	private static HttpUriRequest clientConnection(String urlParam, HttpMethod httpMethod, String accessToken, String data) throws Exception {
		HttpUriRequest response;
		StringEntity params = new StringEntity("");
		String bindString = urlParam.contains("=") ?  "&" : "?";		
		urlParam = String.format("%1$s%2$sapi_key=%3$s", urlParam, bindString, ConstantContact.getInstance().getApiKey());
		
		switch (httpMethod) {
		case GET:
			HttpGet get = new HttpGet(urlParam);
			response = get;
			break;
		case POST:
			HttpPost post = new HttpPost(urlParam);	
			params = new StringEntity(data);
			post.setEntity(params);
		    response = post;
			break;
		case DELETE:
			HttpDelete delete = new HttpDelete(urlParam);
			response = delete;
			break;
		case PUT:
			HttpPut put = new HttpPut(urlParam);
			params = new StringEntity(data);
			put.setEntity(params);
			response = put;
			break;
		default:
			HttpGet get2 = new HttpGet(urlParam);
			response = get2;
			break;
		}

		response.setHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE);
		response.setHeader(ACCEPT_HEADER, JSON_CONTENT_TYPE);
		response.setHeader(AUTHORIZATION_HEADER, "Bearer " + accessToken);
		response.setHeader("Connection", "Keep-Alive");
		response.setHeader("Keep-Alive", "header");

		return response;
	}
	/**
	 * Default constructor.
	 */
	public HttpProcessor() {
		super();
	}

}
