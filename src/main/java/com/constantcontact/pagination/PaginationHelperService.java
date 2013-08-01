package com.constantcontact.pagination;

import com.constantcontact.components.Component;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

//TODO documentation
public class PaginationHelperService extends BaseService {
	
	//TODO documentation
	public <T> ResultSet<T> getPage(String accessToken, Pagination pagination, Class<T> objectClass, TimeStampName timeStampName, String timeStamp)
			throws ConstantContactServiceException {
		ResultSet<T> pageResultSet = null;
		if (pagination.getNextLink() == null) {
			return null;
		}
		try {			
			String url = paginateUrl(Config.Endpoints.BASE_URL_HOST, pagination.getNextLink(), null);
			if(pagination.getNextLink() == null) {
				return null;
			}
			
			//append timestamp to the request if any.
			if (timeStampName != null && timeStamp != null) {
				url = appendParam(url, timeStampName.toString(), timeStamp);
			}
			
			// Get REST response
			CUrlResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				pageResultSet = Component.resultSetFromJSON(response.getBody(), objectClass);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
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

	//TODO documentation
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
