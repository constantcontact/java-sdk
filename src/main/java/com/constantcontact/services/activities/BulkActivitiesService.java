package com.constantcontact.services.activities;

import java.util.List;

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
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.http.MultipartBody;

/**
 * Service Layer Implementation for the Bulk Activities in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class BulkActivitiesService extends BaseService implements IBulkActivitiesService {

	/**
	 * Add a large number of contacts in a single batch operation.<br>
	 * Implements the bulk add Contacts operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse addContacts(String accessToken, AddContactsRequest request) throws ConstantContactServiceException {

		ContactsResponse contactsResponse = null;
		try {
			String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES_ADD_CONTACTS;
			String json = request.toJSON();
			CUrlResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
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
		return contactsResponse;
	}

	public ContactsResponse addContacts(String accessToken, MultipartBody multipartRequest)
            throws ConstantContactServiceException {
	    
	    ContactsResponse contactsResponse = null;
        try {
            String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES_ADD_CONTACTS;
            CUrlResponse response = getRestClient().postMultipart(url, accessToken, multipartRequest);
            if (response.hasData()) {
                contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
            }

            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
            }
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse removeContactsFromLists(String accessToken, RemoveContactsRequest request) throws ConstantContactServiceException {
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES_REMOVE_FROM_LISTS;
			String json = request.toJSON();
			CUrlResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
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
		return contactsResponse;
	}

    public ContactsResponse removeContactsFromLists(String accessToken, MultipartBody multipartRequest)
            throws ConstantContactServiceException {

        ContactsResponse contactsResponse = null;
        try {
            String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES_REMOVE_FROM_LISTS;
            CUrlResponse response = getRestClient().postMultipart(url, accessToken, multipartRequest);
            if (response.hasData()) {
                contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
            }
            if (response.isError()) {
                ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                        ConstantContactServiceException.RESPONSE_ERR_SERVICE);
                response.getInfo().add(new CUrlRequestError("url", url));
                constantContactException.setErrorInfo(response.getInfo());
                throw constantContactException;
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse clearLists(String accessToken, ClearListsRequest request) throws ConstantContactServiceException {
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES_CLEAR_LISTS;
			String json = request.toJSON();
			CUrlResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
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
		return contactsResponse;
	}

	/**
	 * Implements the bulk export Contacts operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param request The request
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactsResponse exportContacts(String accessToken, ExportContactsRequest request) throws ConstantContactServiceException {
		ContactsResponse contactsResponse = null;
		try {
			String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES_EXPORT_CONTACTS;
			String json = request.toJSON();
			CUrlResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				contactsResponse = Component.fromJSON(response.getBody(), ContactsResponse.class);
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
		return contactsResponse;
	}

	/**
	 * Implements the bulk get Summary Report operation by calling the ConstantContact server side.
	 *
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param status The status, as seen in {@link BulkActivityStatus}
	 * @param type The type, as seen in {@link BulkActivityType}
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public List<SummaryReport> getSummaryReport(String accessToken, String status, String type) throws ConstantContactServiceException {
		List<SummaryReport> activitiesResponse = null;
		try {
			String url = Config.Endpoints.BASE_URL + Config.Endpoints.ACTIVITIES;
			if (status != null && status.length() > 0) {
				url = appendParam(url, "status", status);
			}
			if (type != null && type.length() > 0) {
				url = appendParam(url, "type", type);
			}


			CUrlResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				activitiesResponse = Component.listFromJSON(response.getBody(), SummaryReport.class);
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
		return activitiesResponse;
	}

	/**
	 * Implements the bulk get Detailed Status Report operation by calling the ConstantContact server side.
	 *
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param id The id
	 * @return A response containing the values returned from the server for the requested operation on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public DetailedStatusReport getDetailedStatusReport(String accessToken, String id) throws
																						ConstantContactServiceException {

		DetailedStatusReport statusReport = null;

		String url = Config.Endpoints.BASE_URL + String.format(Config.Endpoints.ACTIVITY,id);
		try {
			CUrlResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				statusReport = Component.fromJSON(response.getBody(), DetailedStatusReport.class);
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
		return statusReport;
	}

	/**
	 * Default constructor.
	 */
	public BulkActivitiesService() {
		super();
	}
}
