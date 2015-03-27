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
	private String accessToken;
	private String apiKey;
	
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
	 * Make HTTP GET request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return The response body, http info, and error (if one exists).
	 */
	public RawApiResponse get(String url) {
		return makeHttpRequest(url, HttpMethod.GET, this.getAccessToken(), null);
	}

	/**
	 * Make an HTTP POST request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	public RawApiResponse post(String url, String data) {
		return makeHttpRequest(url, HttpMethod.POST, this.getAccessToken(), data);
	}
	
	/**
     * Make an HTTP POST request with a Content-Type of multipart/form-data.
     * 
     * @param url Request URL.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */
    public RawApiResponse postMultipart(String url, MultipartBody data) {
        return makeMultipartRequest(url, this.getAccessToken(), data);
    }

	/**
	 * Make an HTTP PUT request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	public RawApiResponse put(String url, String data) {
		return makeHttpRequest(url, HttpMethod.PUT, this.getAccessToken(), data);
	}

	/**
	 * Make an HTTP DELETE request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token
	 * @return The response body, http info, and error (if one exists).
	 */
	public RawApiResponse delete(String url) {
		return makeHttpRequest(url, HttpMethod.DELETE, this.getAccessToken(), null);
	}

    /**
     * Make an HTTP PATCH request.
     *
     * @param url Request URL.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */
    public RawApiResponse patch(String url, String data) {
        return makeHttpRequest(url, HttpMethod.PATCH, this.getAccessToken(), data);
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
	public RestClient(String accessToken, String apiKey) {
		super();
		this.setHttpProcessor(new HttpProcessor(accessToken, apiKey));
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
