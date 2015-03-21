package com.constantcontact.services.contactlists;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Service Layer Implementation for the Contact Lists operations in Constant Contact.
 * 
 * @author ConstantContact
 */
public class ContactListService extends BaseService implements IContactListService {

	/**
	 * Implements the Get lists for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the lists modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return Returns a list of {@link ContactList} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public List<ContactList> getLists(String accessToken, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		List<ContactList> lists = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLists());
						
			if(modifiedSinceTimestamp != null)
				url = appendParam(url, "modified_since", modifiedSinceTimestamp);
			
			RawApiResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				lists = Component.listFromJSON(response.getBody(), ContactList.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return lists;
	}

	/**
	 * Implements the add list for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param list The {@link ContactList} that was added, when successful.
	 * @return Returns the newly created list containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactList addList(String accessToken, ContactList list) throws ConstantContactServiceException {
		ContactList newList = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getLists());
			
			String json = list.toJSON();
			RawApiResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				newList = Component.fromJSON(response.getBody(), ContactList.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newList;
	}

	/**
	 * Implements the get individual list for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id.
	 * @return The {@link ContactList} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ContactList getList(String accessToken, String listId) throws ConstantContactServiceException {
		ContactList list = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getList(), listId));
			
			RawApiResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				list = Component.fromJSON(response.getBody(), ContactList.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return list;
	}
	
	 /**
     * Updates a Contact List identified by its List Id 
     * 
     * @param accessToken Constant Contact OAuth2 access token.
     * @param list The List to update
     * @return The {@link ContactList} containing values as returned by the server on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ContactList updateList(String accessToken, ContactList list) throws ConstantContactServiceException {

        ContactList resultingList = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getList(), list.getId()));

            String json = list.toJSON();
            
            RawApiResponse response = getRestClient().put(url, accessToken, json);
            
            if (response.hasData()) {
                resultingList = Component.fromJSON(response.getBody(), ContactList.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return resultingList;
    }

	/**
	 * Implements the Get all contacts from an individual list operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id to retrieve contacts for.
	 * @param limit Maximum number of contacts to retrieve. Default is 50.
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 * 	  	It will return only the contacts modified since the supplied date. <br/>
	 * 		If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ResultSet<Contact> getContactsFromList(String accessToken, String listId, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<Contact> contacts = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getListContacts(), listId));
			url = paginateUrl(url, limit);
			
			if (modifiedSinceTimestamp != null) {
		        url = appendParam(url, "modified_since", modifiedSinceTimestamp);
		      }
			
			RawApiResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				contacts = Component.resultSetFromJSON(response.getBody(), Contact.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contacts;
	}
		
	/**
	 * Deletes a single contact list based on contact list unique identifier.<br/>
	 * Implements the delete ContactList operation of the Contact Lists API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId Unique contact list id of the contact list to delete.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */	

	public boolean deleteList(String accessToken, String listId) throws ConstantContactServiceException {
		try {
			String url = String.format("%1$s%2$s",Config.instance().getBaseUrl(), String.format(Config.instance().getList(), listId));
			
			RawApiResponse response = getRestClient().delete(url, accessToken);
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
			return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 * Default constructor.
	 */
	public ContactListService() {
		super();
	}
}
