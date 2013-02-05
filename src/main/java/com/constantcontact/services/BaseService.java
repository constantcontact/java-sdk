package com.constantcontact.services;

import com.constantcontact.util.IRestClient;
import com.constantcontact.util.RestClient;

/**
 * Super class for all services.
 * 
 * @author ConstantContact
 */
public abstract class BaseService implements IBaseService {
	private IRestClient restClient;

	/**
	 * Class constructor.
	 */
	public BaseService() {
		restClient = new RestClient();
	}
	
	/**
	 * Constructor with the option to supply an alternative rest client to be used.
	 * @param restClient RestClient Interface implementation to be used in the service.
	 */
	public BaseService(IRestClient restClient) {
		this.restClient = restClient;
	}
	
	/**
	 * Get the rest client being used by the service.
	 * @return Rest client.
	 */
	@Override
	public IRestClient getRestClient() {
		return restClient;
	}

	/**
	 * Set the rest client being used by the service.
	 * @param restClient Rest client.
	 */
	public void setRestClient(IRestClient restClient) {
		this.restClient = restClient;
	}
	
	/**
	 * Helper function to build a url depending on the offset and limit.
	 * @param url Url.
	 * @param offset Offset.
	 * @param limit Limit
	 * @return Returns an URL string.
	 */
	protected static String paginateUrl(String url, Integer offset, Integer limit) {
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
}
