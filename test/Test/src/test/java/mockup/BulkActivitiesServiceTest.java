package mockup;

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
public class BulkActivitiesServiceTest extends BulkActivitiesService{

	/**
	 * Add a large number of contacts in a single batch operation.<br>
	 * Implements the bulk add Contacts operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse addContacts(String accessToken, AddContactsRequest request) throws ConstantContactServiceException {

		ContactsResponse contactsResponse = null;
		try {
				contactsResponse = Component.fromJSON(MockedServerResponses.addContactsBulkActivitiesData, ContactsResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

    @Override
	public ContactsResponse addContacts(String accessToken, MultipartBody multipartRequest)
            throws ConstantContactServiceException {

	    
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse removeContactsFromLists(String accessToken, RemoveContactsRequest request) throws ConstantContactServiceException {
		ContactsResponse contactsResponse = null;
		try {
				contactsResponse = Component.fromJSON(MockedServerResponses.removeContactsFromListsBulkActivitiesData, ContactsResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contactsResponse;
	}

    @Override
    public ContactsResponse removeContactsFromLists(String accessToken, MultipartBody multipartRequest)
            throws ConstantContactServiceException {

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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse clearLists(String accessToken, ClearListsRequest request) throws ConstantContactServiceException {
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactsResponse exportContacts(String accessToken, ExportContactsRequest request) throws ConstantContactServiceException {
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public List<SummaryReport> getSummaryReport(String accessToken) throws ConstantContactServiceException {
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param status The status, as seen in {@link com.constantcontact.components.activities.contacts.types.BulkActivityStatus}
	 * @param type The type, as seen in {@link com.constantcontact.components.activities.contacts.types.BulkActivityType}
	 * @param id The id
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public List<DetailedStatusReport> getDetailedStatusReport(String accessToken, String status, String type, String id) throws ConstantContactServiceException {

		List<DetailedStatusReport> detailedStatusReports = null;

		String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES;
		try {
				detailedStatusReports = Component.listFromJSON(MockedServerResponses.getDetailedStatusReportBulkActivitiesData, DetailedStatusReport.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return detailedStatusReports;
	}

	/**
	 * Default constructor.
	 */
	public BulkActivitiesServiceTest() {
		super();
	}
}
