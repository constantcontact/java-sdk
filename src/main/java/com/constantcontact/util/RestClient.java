package com.constantcontact.util;

import com.constantcontact.util.http.HttpProcessor;
import com.constantcontact.util.http.HttpProcessor.HttpMethod;

/**
 * Class implementation of REST client.
 * 
 * @author ConstantContact
 *
 */
public class RestClient implements IRestClient {
	/**
	 * Make HTTP GET request.
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return The response body, http info, and error (if one exists).
	 */
	@Override
	public CUrlResponse get(String url, String accessToken) {
		return makeHttpRequest(url, HttpMethod.GET, accessToken, null);
	}

	/**
	 * Make an HTTP POST request. 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	@Override
	public CUrlResponse post(String url, String accessToken, String data) {
		return makeHttpRequest(url, HttpMethod.POST, accessToken, data);
	}

	/**
	 * Make an HTTP PUT request. 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	@Override
	public CUrlResponse put(String url, String accessToken, String data) {
		return makeHttpRequest(url, HttpMethod.PUT, accessToken, data);
	}

	/**
	 * Make an HTTP DELETE request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token
	 * @return The response body, http info, and error (if one exists).
	 */
	@Override
	public CUrlResponse delete(String url, String accessToken) {
		return makeHttpRequest(url, HttpMethod.DELETE, accessToken, null);
	}

	private CUrlResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
		return HttpProcessor.makeHttpRequest(urlParam, method, accessToken, data);
	}
}
