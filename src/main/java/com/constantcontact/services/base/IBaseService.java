package com.constantcontact.services.base;

import com.constantcontact.util.IRestClient;

/**
 * Interface for {@link BaseService} class in Constant Contact.<br/>
 * All service layer interfaces must extend it!
 * 
 * @author ConstantContact
 * 
 */
public interface IBaseService {
	/**
	 * Returns the REST client object.
	 * 
	 * @return Returns the REST client object.
	 */
	IRestClient getRestClient();

	/**
	 * Sets the REST client object.
	 * 
	 * @param restClient The REST client object.
	 */
	void setRestClient(IRestClient restClient);
}
