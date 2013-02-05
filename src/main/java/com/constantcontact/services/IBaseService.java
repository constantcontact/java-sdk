package com.constantcontact.services;

import com.constantcontact.util.IRestClient;

/**
 * Interface for <code>BaseService</code> class.
 * 
 * @author ConstantContact
 *
 */
public interface IBaseService {
	/**
	 * Returns the REST client object.
	 * @return Returns the REST client object.
	 */
	IRestClient getRestClient();
	
	/**
	 * Sets the REST client object.
	 * @param restClient The REST client object.
	 */
	void setRestClient(IRestClient restClient);
}
