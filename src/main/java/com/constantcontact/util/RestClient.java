package com.constantcontact.util;

import com.constantcontact.util.http.HttpProcessor;
import com.constantcontact.util.http.MultipartBody;
import com.constantcontact.util.http.constants.ProcessorBase.ContentType;
import com.constantcontact.util.http.constants.ProcessorBase.HttpMethod;

/**
 * Implementation of REST client in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class RestClient implements IRestClient {
	/**
	 * Make HTTP GET request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return The response body, http info, and error (if one exists).
	 */
	public CUrlResponse get(String url, String accessToken) {
		return makeHttpRequest(url, HttpMethod.GET, accessToken, null);
	}

	/**
	 * Make an HTTP POST request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	public CUrlResponse post(String url, String accessToken, String data) {
		return makeHttpRequest(url, HttpMethod.POST, accessToken, data);
	}
	
	/**
     * Make an HTTP POST request with a Content-Type of multipart/form-data.
     * 
     * @param url Request URL.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */
    public CUrlResponse postMultipart(String url, String accessToken, MultipartBody data) {
        return makeMultipartRequest(url, accessToken, data);
    }

	/**
	 * Make an HTTP PUT request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
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
	public CUrlResponse delete(String url, String accessToken) {
		return makeHttpRequest(url, HttpMethod.DELETE, accessToken, null);
	}

	private CUrlResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
		return HttpProcessor.makeHttpRequest(urlParam, method, ContentType.JSON, accessToken, data);
	}
	
	private CUrlResponse makeMultipartRequest(String urlParam, String accessToken, MultipartBody data) {
	    
	    byte[] bodyBytes = data.getBytes();
	    
	    return HttpProcessor.makeHttpRequest(urlParam, HttpMethod.POST, ContentType.FORM_DATA, accessToken, bodyBytes);
    }
	
	/**
	 * Default constructor.
	 */
	public RestClient() {
		super();
	}
}
