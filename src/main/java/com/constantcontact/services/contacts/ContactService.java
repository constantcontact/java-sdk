package com.constantcontact.services.contacts;

import java.net.HttpURLConnection;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Contact operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactService extends BaseService implements IContactService {

	/**
	 * Gets the contacts for the current user.<br/>
	 * Implements the get Contacts operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param offset Offset.
	 * @param limit Limit.
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the contacts modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ResultSet<Contact> getContacts(String accessToken, Integer offset, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<Contact> contacts = null;
		try {
			// Construct access URL
			String url = paginateUrl(String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.CONTACTS), offset, limit);
			
			if(modifiedSinceTimestamp != null)
				url = appendParam(url, "modified_since", modifiedSinceTimestamp);
			
			// Get REST response
			CUrlResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				contacts = Component.resultSetFromJSON(response.getBody(), Contact.class);
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
		return contacts;
	}

	/**
	 * Gets a single contact for the current user, based on the contact id.<br/>
	 * Implements the get Contact operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Unique contact id.
	 * @return Returns a {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public Contact getContact(String accessToken, String contactId) throws ConstantContactServiceException {
		Contact contact = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.CONTACT, contactId));
			
			CUrlResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				contact = Component.fromJSON(response.getBody(), Contact.class);
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
		return contact;
	}

	/**
	 * Gets one or more contacts for the current user, based on the contact email address.<br/>
	 * Implements the get Contact By Email operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param email Contact email address to search for.
	 * @return Returns a {@link ResultSet} of {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ResultSet<Contact> getContactByEmail(String accessToken, String email) throws ConstantContactServiceException {
		ResultSet<Contact> contacts = null;
		try {
			String url = String.format("%1$s%2$s?email=%3$s", Config.Endpoints.BASE_URL, Config.Endpoints.CONTACTS, email);
			
			CUrlResponse response = getRestClient().get(url, accessToken);
			
			if (response.hasData()) {
				contacts = Component.resultSetFromJSON(response.getBody(), Contact.class);
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
		return contacts;
	}

	/**
	 * Adds a single contact for the current user.<br/>
	 * Implements the add Contact operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contact {@link Contact} to add.
	 * @return Returns the newly created {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public Contact addContact(String accessToken, Contact contact, Boolean actionByVisitor) throws ConstantContactServiceException {
		Contact newContact = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.CONTACTS);
			String json = contact.toJSON();
			
			//TODO append action by visitor
			
			CUrlResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				newContact = Component.fromJSON(response.getBody(), Contact.class);
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
		return newContact;
	}

	/**
	 * Deletes a single contact for the current user, based on the contact id.<br/>
	 * Implements the delete Contact operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Unique contact id of the contact to delete.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public boolean deleteContact(String accessToken, String contactId) throws ConstantContactServiceException {
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.CONTACT, contactId));
			
			CUrlResponse response = getRestClient().delete(url, accessToken);
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
			return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 * Deletes a single contact from all the lists belonging the current user, based on the contact id.<br/>
	 * The actual contact entity is not deleted using this call.<br>
	 * Implements the delete Contact From Lists (all lists) operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Contact id to be removed from all the lists.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public boolean deleteContactFromLists(String accessToken, String contactId) throws ConstantContactServiceException {
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.CONTACT_LISTS, contactId));
			CUrlResponse response = getRestClient().delete(url, accessToken);
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
			return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 * Deletes a single contact from a single list belonging the current user, based on the contact id and the list id.<br/>
	 * The actual contact entity is not deleted using this call.<br>
	 * Implements the delete Contact From List (a specific list) operation of the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Contact id to be removed.
	 * @param listId ContactList to remove the contact from.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public boolean deleteContactFromList(String accessToken, String contactId, String listId) throws ConstantContactServiceException {
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.CONTACT_LIST, contactId, listId));

			CUrlResponse response = getRestClient().delete(url, accessToken);
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
			return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 * Updates a single contact for the current user, based on the contact id.<br/>
	 * Implements the update Contact operation of the Contacts API by calling the ConstantContact server side.<br/>
	 * A specific contact is identified by its internal id.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contact {@link Contact} to be updated.
	 * @return Returns the updated {@link Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public Contact updateContact(String accessToken, Contact contact, Boolean actionByVisitor) throws ConstantContactServiceException {
		Contact updateContact = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.CONTACT, contact.getId()));
			String json = contact.toJSON();
			
			//TODO url append action by visitor
			
			CUrlResponse response = getRestClient().put(url, accessToken, json);
			if (response.hasData()) {
				updateContact = Component.fromJSON(response.getBody(), Contact.class);
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
		return updateContact;
	}

	/**
	 * Default constructor.
	 */
	public ContactService() {
		super();
	}
}
