package com.constantcontact.services.base;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.constantcontact.util.IRestClient;
import com.constantcontact.util.RestClient;

/**
 * The Super class for <B>ALL</B> service layer classes in Constant Contact.<br/>
 * Implements just the operations common to all services.
 * 
 * @author ConstantContact
 */
public abstract class BaseService implements IBaseService {

	/**
	 * Rest Client
	 */
	private IRestClient restClient;

	/**
	 * Constant for UTF-8
	 */
	public static final String UTF8 = "UTF-8";

	/**
	 * Default constructor.<br/>
	 * Creates a new blank {@link RestClient}
	 */
	public BaseService() {
		super();
		restClient = new RestClient();
	}

	/**
	 * Constructor with the option to supply an alternative rest client to be used.
	 * 
	 * @param restClient RestClient Interface implementation to be used in the service.
	 */
	public BaseService(IRestClient restClient) {
		super();
		this.restClient = restClient;
	}

	/**
	 * Get the rest client being used by the service.
	 * 
	 * @return Rest client.
	 */

	public IRestClient getRestClient() {
		return restClient;
	}

	/**
	 * Set the rest client being used by the service.
	 * 
	 * @param restClient Rest client.
	 */
	public void setRestClient(IRestClient restClient) {
		this.restClient = restClient;
	}

	/**
	 * Helper function to build a url depending on the offset and limit.
	 * 
	 * @param url Url.
	 * @param offset Offset.
	 * @param limit Limit
	 * @return Returns an URL string.
	 */
	public static String paginateUrl(String url, Integer offset, Integer limit) {
		String paginateUrl = url;
		StringBuilder sb = new StringBuilder();
		if (offset != null) {
			sb.append("offset=").append(offset);
		}
		if (limit != null) {
			sb.append(sb.length() > 0 ? "&" : "").append("limit=").append(limit);
		}
		if (sb.length() > 0) {
			paginateUrl = sb.insert(0, url + "?").toString();
		}
		return paginateUrl;
	}

	/**
	 * Helper function to append a new parameter to an existing URL.<br/>
	 * Handles the cases:
	 * <UL>
	 * <LI>when the URL doesn't have any query parameters;</LI>
	 * <LI>when the URL already has query parameters;</LI>
	 * </UL>
	 * 
	 * @param url The original URL
	 * @param param The name of the parameter to be added in the URL
	 * @param value The value of the parameter to be added in the URL
	 * @return The processed URL.
	 * @throws UnsupportedEncodingException Thrown when illegal characters are detected.
	 */
	public static final String appendParam(String url, String param, String value) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder(url);
		if (value != null && value.length() > 0) {
			if (!url.contains("?")) {
				sb.append("?");
			} else {
				if (!url.endsWith("&")) {
					sb.append("&");
				}
			}
			sb.append(URLEncoder.encode(param, UTF8)).append("=").append(URLEncoder.encode(value, UTF8));
		}
		return sb.toString();
	}
}
