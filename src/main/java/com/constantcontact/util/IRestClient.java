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
	 * @return The response body, http info, and error (if one exists).
	 */
	RawApiResponse get(String url);

	/**
	 * Make an HTTP POST request.
	 * 
	 * @param url Request URL.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	RawApiResponse post(String url, String data);

    /**
     * Make an HTTP POST request with a multipart body.
     * 
     * @param url Request URL.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */	
	public RawApiResponse postMultipart(String url, MultipartBody data);
	
	/**
	 * Make an HTTP PUT request.
	 * 
	 * @param url Request URL.
	 * @param data Data to send with request.
	 * @return The response body, http info, and error (if one exists).
	 */
	RawApiResponse put(String url, String data);

	/**
	 * Make an HTTP DELETE request.
	 * 
	 * @param url Request URL.
	 * @return The response body, http info, and error (if one exists).
	 */
	RawApiResponse delete(String url);

    /**
     * Make an HTTP PATCH request.
     *
     * @param url Request URL.
     * @param data Data to send with request.
     * @return The response body, http info, and error (if one exists).
     */
    RawApiResponse patch(String url, String data);
}
