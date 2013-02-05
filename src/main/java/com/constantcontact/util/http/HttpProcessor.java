package com.constantcontact.util.http;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;

/**
 * Class responsible for making http requests.
 * 
 * @author ConstantContact
 */
public class HttpProcessor {
	public static final String USER_AGENT_HEADER = "User-Agent";
	public static final String CONTENT_TYPE_HEADER = "Content-Type";
	public static final String HOST_HEADER = "Host";
	public static final String ACCEPT_HEADER = "Accept";
	private final static String AUTHORIZATION_HEADER = "Authorization";
	private final static String JSON_CONTENT_TYPE = "application/json";
	
	/**
	 * Make an http request.
	 * @param urlParam Request URL.
	 * @param httpMethod HTTP method.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data >Data to send with request.
	 */
	public static CUrlResponse makeHttpRequest(String urlParam, HttpMethod httpMethod, String accessToken, String data) {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpRequestBase request = null;
			request = buildHttpMethod(httpMethod);
			request.setURI(URI.create(urlParam));
			request.setHeader(CONTENT_TYPE_HEADER, JSON_CONTENT_TYPE);
			request.setHeader(ACCEPT_HEADER, JSON_CONTENT_TYPE);
			request.setHeader(AUTHORIZATION_HEADER, "Bearer " + accessToken);
			HttpResponse httpResp = null;
			CUrlResponse urlResponse = new CUrlResponse();
			String responseMessage = null;
			String errorMessage = null;
			try {
				httpResp = client.execute(request);
				urlResponse.setStatusCode(httpResp.getStatusLine().getStatusCode());
				if (urlResponse.getStatusCode() == HttpStatus.SC_NO_CONTENT) {
					return urlResponse;
				}
				responseMessage = EntityUtils.toString(httpResp.getEntity());
				if (responseMessage == null || responseMessage.trim() == "") {
					errorMessage = "Response was not returned or is null";
				}
				if (urlResponse.getStatusCode() != HttpStatus.SC_OK) {
					StatusLine statusLine = httpResp.getStatusLine();
					errorMessage = "Response with status: " + statusLine.getStatusCode() + " " + statusLine.getReasonPhrase();
					urlResponse.setError(true);
				}
			} catch (Exception e) {
				urlResponse.setError(true);
				errorMessage = e.getMessage();
			}
			if (urlResponse.isError()) {
				if (responseMessage != null && responseMessage.contains("error_message")) {
					urlResponse.setInfo(CUrlRequestError.listFromJSON(responseMessage, CUrlRequestError.class));
				} else {
					urlResponse.setBody(errorMessage);
				}
			} else {
				urlResponse.setBody(responseMessage);
			}
			return urlResponse;
	}

	/**
	 * Builds Htt request method based on <code>HttpMethod</code> enum value
	 * @param httpMethod <code>HttpMethod</code> enum value
	 * @return <code>HttpRequestBase</code> object.
	 */
	private static HttpRequestBase buildHttpMethod(HttpMethod httpMethod) {
		HttpRequestBase request = null;
		switch (httpMethod) {
			case DELETE:
				request = new HttpDelete();
				break;
			case GET:
				request = new HttpGet();
				break;
			case POST:
				request = new HttpPost();
				break;
			case PUT:
				request = new HttpPut();
				break;
		}
		return request;
	}
	
	/**
	 * Http methods.
	 *  
	 * @author ConstantContact
	 */
	public static enum HttpMethod {
		GET, POST, DELETE, PUT
	}
}
