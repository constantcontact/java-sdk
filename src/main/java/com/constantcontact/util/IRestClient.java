package com.constantcontact.util;

import com.constantcontact.util.http.MultipartBody;

/**
 * Interface for {@link RestClient} in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IRestClient {
	/**
	 * Make an HTTP GET request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token
	 * @return The response body, http info, and error (if one exists).
	 */
	CUrlResponse get(String url, String accessToken);

	/**
	 * Make an HTTP POST request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	CUrlResponse post(String url, String accessToken, String data);

    /**
     * Make an HTTP POST request with a multipart body.
     * 
     * @param url Request URL.
     * @param accessToken Constant Contact OAuth2 access token.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */	
	public CUrlResponse postMultipart(String url, String accessToken, MultipartBody data);
	
	/**
	 * Make an HTTP PUT request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	CUrlResponse put(String url, String accessToken, String data);

	/**
	 * Make an HTTP DELETE request.
	 * 
	 * @param url Request URL.
	 * @param accessToken Constant Contact OAuth2 access token
	 * @return The response body, http info, and error (if one exists).
	 */
	CUrlResponse delete(String url, String accessToken);

    //todo documentation
    CUrlResponse patch(String url, String accessToken, String data);
}
