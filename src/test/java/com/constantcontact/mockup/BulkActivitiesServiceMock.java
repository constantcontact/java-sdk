package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.activities.contacts.request.AddContactsRequest;
import com.constantcontact.components.activities.contacts.request.ClearListsRequest;
import com.constantcontact.components.activities.contacts.request.ExportContactsRequest;
import com.constantcontact.components.activities.contacts.request.RemoveContactsRequest;
import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.components.activities.contacts.response.DetailedStatusReport;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.constantcontact.util.Config;
import com.constantcontact.util.http.MultipartBody;

import java.util.List;

/**
 * Service Layer Implementation for the Bulk Activities in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class BulkActivitiesServiceMock extends BulkActivitiesService{

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
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse addContacts(AddContactsRequest request) throws ConstantContactServiceException {

    	if (request == null) {
    		throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
    	}
    	
		ContactsResponse contactsResponse = null;
		try {
				contactsResponse = Component.fromJSON(MockedServerResponses.addContactsBulkActivitiesData, ContactsResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

    @Override
	public ContactsResponse addContacts(MultipartBody multipartRequest)
            throws ConstantContactServiceException {

    	if (multipartRequest == null) {
    		throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
    	}	    
    	
	    ContactsResponse contactsResponse = null;
        try {
                contactsResponse = Component.fromJSON(MockedServerResponses.addContactsMultipartBulkActivitiesData, ContactsResponse.class);
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
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse removeContactsFromLists(RemoveContactsRequest request) throws ConstantContactServiceException {
		
    	if (request == null) {
    		throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
    	}
    	
    	ContactsResponse contactsResponse = null;
		try {
				contactsResponse = Component.fromJSON(MockedServerResponses.removeContactsFromListsBulkActivitiesData, ContactsResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

    @Override
    public ContactsResponse removeContactsFromLists(MultipartBody multipartRequest)
            throws ConstantContactServiceException {

    	if (multipartRequest == null) {
    		throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
    	}
    	
        ContactsResponse contactsResponse = null;
        try {
                contactsResponse = Component.fromJSON(MockedServerResponses.removeContactsFromListsMultipartBulkActivitiesData, ContactsResponse.class);
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
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse clearLists(ClearListsRequest request) throws ConstantContactServiceException {
		
    	if (request == null) {
    		throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
    	}
    	
    	ContactsResponse contactsResponse = null;
		try {
				contactsResponse = Component.fromJSON(MockedServerResponses.clearListsBulkActivitiesData, ContactsResponse.class);
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
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse exportContacts(ExportContactsRequest request) throws ConstantContactServiceException {
		
    	if (request == null) {
    		throw new IllegalArgumentException(Config.instance().getErrorBulkContactsRequestNull());
    	}
    	
    	ContactsResponse contactsResponse = null;
		try {
				contactsResponse = Component.fromJSON(MockedServerResponses.exportContactsBulkActivitiesData, ContactsResponse.class);
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
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	@Override
	public List<SummaryReport> getSummaryReport() throws ConstantContactServiceException {
		return this.getSummaryReport(null,null);
	}
	/**
	 * Implements the bulk get Summary Report operation by calling the ConstantContact server side.
	 *
	 * @param status The status, as seen in {@link com.constantcontact.components.activities.contacts.types.BulkActivityStatus}
	 * @param type The type, as seen in {@link com.constantcontact.components.activities.contacts.types.BulkActivityType}
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public List<SummaryReport> getSummaryReport(String status, String type) throws ConstantContactServiceException {
		List<SummaryReport> activitiesResponse = null;
		try {
				activitiesResponse = Component.listFromJSON(MockedServerResponses.getSummaryReportBulkActivitiesData, SummaryReport.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return activitiesResponse;
	}

	/**
	 * Implements the bulk get Detailed Status Report operation by calling the ConstantContact server side.
	 *
	 * @param id The id
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public DetailedStatusReport getDetailedStatusReport(String id) throws ConstantContactServiceException {

		DetailedStatusReport detailedStatusReport = null;

		String url = Config.instance().getBaseUrl() + Config.instance().getActivities();
		try {
				detailedStatusReport = Component.fromJSON(MockedServerResponses.getDetailedStatusReportBulkActivitiesData,
													   DetailedStatusReport.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return detailedStatusReport;
	}

	/**
	 * Default constructor.
	 */
	public BulkActivitiesServiceMock(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
