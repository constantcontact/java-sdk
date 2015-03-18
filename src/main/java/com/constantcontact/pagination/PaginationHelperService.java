package com.constantcontact.pagination;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

/**
 * Service Layer Implementation for pagination in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class PaginationHelperService extends BaseService {
	
	/**
	 * Generic method that returns a {@link ResultSet} of objects, based on a {@link Pagination} object and a specified object class.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param pagination
	 *          {@link Pagination} for fetching next set of data.
	 * @param objectClass The class of the objects that are expected in the {@link ResultSet}.
	 * @return A {@link ResultSet} of "objectClass" that containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public <T> ResultSet<T> getPage(String accessToken, Pagination pagination, Class<T> objectClass)
			throws ConstantContactServiceException {
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
			CUrlResponse response = getRestClient().get(url, accessToken);
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
	public PaginationHelperService(){
		super();
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
