package com.constantcontact.services.activities;

import com.constantcontact.components.Component;
import com.constantcontact.components.activities.contacts.request.AddContactsRequest;
import com.constantcontact.components.activities.contacts.request.ClearListsRequest;
import com.constantcontact.components.activities.contacts.request.ExportContactsRequest;
import com.constantcontact.components.activities.contacts.request.RemoveContactsRequest;
import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.components.activities.contacts.response.DetailedStatusReport;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.components.activities.contacts.types.BulkActivityStatus;
import com.constantcontact.components.activities.contacts.types.BulkActivityType;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;
import com.constantcontact.util.http.MultipartBody;

import java.util.List;

/**
 * Service Layer Implementation for the Bulk Activities in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class BulkActivitiesService extends BaseService implements IBulkActivitiesService {

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
	 * Add a large number of contacts in a single batch operation.<br>
	 * Implements the bulk add Contacts operation by calling the ConstantContact server side.
	 * 
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse addContacts(AddContactsRequest request) throws ConstantContactServiceException {
		System.out.println("Finish");
		if (request == null) {
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.instance().getBaseUrl() + Config.instance().getActivitiesAddContacts();
			String json = request.toJSON();
			RawApiResponse response = getRestClient().post(url, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
			}

			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

	public ContactsResponse addContacts(MultipartBody multipartRequest)
            throws ConstantContactServiceException {
	    
		if (multipartRequest == null) {
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		
	    ContactsResponse contactsResponse = null;
        try {
            String url = Config.instance().getBaseUrl() + Config.instance().getActivitiesAddContacts();
            RawApiResponse response = getRestClient().postMultipart(url,  multipartRequest);
            if (response.hasData()) {
                contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
            }

            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return contactsResponse;
	    
    }

	/**
	 * Implements the bulk remove Contacts From Lists operation by calling the ConstantContact server side.
	 * 
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse removeContactsFromLists(RemoveContactsRequest request) throws ConstantContactServiceException {
		
		if (request == null) {
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.instance().getBaseUrl() + Config.instance().getActivitiesRemoveFromLists();
			String json = request.toJSON();
			RawApiResponse response = getRestClient().post(url, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
			}
			if (response.isError()) {
               throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

    public ContactsResponse removeContactsFromLists(MultipartBody multipartRequest)
            throws ConstantContactServiceException {

    	if (multipartRequest == null) {
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
    	
        ContactsResponse contactsResponse = null;
        try {
            String url = Config.instance().getBaseUrl() + Config.instance().getActivitiesRemoveFromLists();
            RawApiResponse response = getRestClient().postMultipart(url, multipartRequest);
            if (response.hasData()) {
                contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        }
        catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        }
        catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return contactsResponse;
    }

	/**
	 * Implements the bulk clear Lists operation by calling the ConstantContact server side.
	 * 
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse clearLists(ClearListsRequest request) throws ConstantContactServiceException {
		
		if (request == null) {
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.instance().getBaseUrl() + Config.instance().getActivitiesClearLists();
			String json = request.toJSON();
			RawApiResponse response = getRestClient().post(url, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

	/**
	 * Implements the bulk export Contacts operation by calling the ConstantContact server side.
	 * 

	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse exportContacts(ExportContactsRequest request) throws ConstantContactServiceException {
		
		if (request == null) {
			throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
		}
		
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.instance().getBaseUrl() + Config.instance().getActivitiesExportContacts();
			String json = request.toJSON();
			RawApiResponse response = getRestClient().post(url, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

	/**
	 * Implements the bulk get Summary Report operation by calling the ConstantContact server side.
	 * 
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public List<SummaryReport> getSummaryReport() throws ConstantContactServiceException {
		List<SummaryReport> activitiesResponse = null;
		try {
			String url = Config.instance().getBaseUrl() + Config.instance().getActivities();

			RawApiResponse response = getRestClient().get(url);
			if (response.hasData()) {
				activitiesResponse = Component.listFromJSON(response.getBody(), SummaryReport.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return activitiesResponse;
	}

	/**
	 * Implements the bulk get Detailed Status Report operation by calling the ConstantContact server side.
	 * 
	 * @param status The status, as seen in {@link BulkActivityStatus}
	 * @param type The type, as seen in {@link BulkActivityType}
	 * @param id The id
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public List<DetailedStatusReport> getDetailedStatusReport(String status, String type, String id) throws ConstantContactServiceException {

		List<DetailedStatusReport> detailedStatusReports = null;

		String url = Config.instance().getBaseUrl() + Config.instance().getActivities();
		try {
			if (status != null && status.length() > 0) {
				url = appendParam(url, "status", status);
			}
			if (type != null && type.length() > 0) {
				url = appendParam(url, "type", type);
			}
			if (id != null && id.length() > 0) {
				url = appendParam(url, "id", id);
			}

			RawApiResponse response = getRestClient().get(url);
			if (response.hasData()) {
				detailedStatusReports = Component.listFromJSON(response.getBody(), DetailedStatusReport.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return detailedStatusReports;
	}

	/**
	 * Default constructor.
	 */
	public BulkActivitiesService(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
