package com.constantcontact.pagination;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

/**
 * Service Layer Implementation for pagination in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class PaginationHelperService extends BaseService {
	
	private String accessToken;
	private String apiKey;
	
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
	 * Generic method that returns a {@link ResultSet} of objects, based on a {@link Pagination} object and a specified object class.
	 * 
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
	 * @param objectClass The class of the objects that are expected in the {@link ResultSet}.
	 * @return A {@link ResultSet} of "objectClass" that containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public <T> ResultSet<T> getPage(Pagination pagination, Class<T> objectClass)
			throws ConstantContactServiceException {
		
		if(pagination == null) {
			throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
		}
		
		ResultSet<T> pageResultSet = null;
		if (pagination.getNextLink() == null) {
			return null;
		}
		try {			
			String url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
			if(pagination.getNextLink() == null) {
				return null;
			}
			
			// Get REST response
			RawApiResponse response = getRestClient().get(url);
			if (response.hasData()) {
				pageResultSet = Component.resultSetFromJSON(response.getBody(), objectClass);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return pageResultSet;
	}
	
	/**
	 * Default constructor.
	 */
	public PaginationHelperService(String accessToken, String apiKey){
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}

	/**
	 * Contains a list of valid parameter names.
	 * 
	 * @author ConstantContact
	 *
	 */
	public static enum TimeStampName {
		MODIFIED_SINCE("modified_since"), 
		CREATED_SINCE("created_since");

		private final String stringValue;

		private TimeStampName(final String s) {
			stringValue = s;
		}

		public String toString() {
			return stringValue;
		}
	}
}
