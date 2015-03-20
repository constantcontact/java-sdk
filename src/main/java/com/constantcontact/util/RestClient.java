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

	private HttpProcessor httpProcessor;

	/**
	 * @return the httpProcessor
	 */
	public HttpProcessor getHttpProcessor() {
		return httpProcessor;
	}

	/**
	 * @param httpProcessor the httpProcessor to set
	 */
	public void setHttpProcessor(HttpProcessor httpProcessor) {
		this.httpProcessor = httpProcessor;
	}

	/**
	 * Make HTTP GET request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return The response body, http info, and error (if one exists).
	 */
	public RawApiResponse get(String url, String accessToken) {
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
	public RawApiResponse post(String url, String accessToken, String data) {
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
    public RawApiResponse postMultipart(String url, String accessToken, MultipartBody data) {
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
	public RawApiResponse put(String url, String accessToken, String data) {
		return makeHttpRequest(url, HttpMethod.PUT, accessToken, data);
	}

	/**
	 * Make an HTTP DELETE request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token
	 * @return The response body, http info, and error (if one exists).
	 */
	public RawApiResponse delete(String url, String accessToken) {
		return makeHttpRequest(url, HttpMethod.DELETE, accessToken, null);
	}

    /**
     * Make an HTTP PATCH request.
     *
     * @param url Request URL.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */
    public RawApiResponse patch(String url, String accessToken, String data) {
        return makeHttpRequest(url, HttpMethod.PATCH, accessToken, data);
    }

	protected RawApiResponse makeHttpRequest(String urlParam, HttpMethod method, String accessToken, String data) {
		return this.getHttpProcessor().makeHttpRequest(urlParam, method, ContentType.JSON, accessToken, data);
	}
	
	protected RawApiResponse makeMultipartRequest(String urlParam, String accessToken, MultipartBody data) {
	    
	    byte[] bodyBytes = data.getBytes();
	    
	    return this.getHttpProcessor().makeHttpRequest(urlParam, HttpMethod.POST, ContentType.FORM_DATA, accessToken, bodyBytes);
    }
	
	/**
	 * Default constructor.
	 */
	public RestClient() {
		super();
		this.setHttpProcessor(new HttpProcessor());
	}
}
