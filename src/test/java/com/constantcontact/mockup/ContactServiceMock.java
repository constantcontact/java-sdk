package com.constantcontact.mockup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.contacts.ContactService;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Contact operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactServiceMock extends ContactService {

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
	 * Gets the contacts for the current user.<br/>
	 * Implements the get Contacts operation of the Contacts API by calling the
	 * ConstantContact server side.
	 * 
	 * @param limit
	 *            Limit.
	 * @param modifiedSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the contacts modified since the supplied
	 *            date. <br/>
	 *            If you want to bypass this filter set modifiedSinceTimestamp
	 *            to null.
	 * @param status
	 *            The status of contacts to return.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of {@link com.constantcontact.components.contacts.Contact}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public ResultSet<Contact> getContacts(Integer limit,
			String modifiedSinceTimestamp, Contact.Status status)
			throws ConstantContactServiceException {

		if (status != null
				&& (status.equals(Contact.Status.VISITOR) || status
						.equals(Contact.Status.NON_SUBSCRIBER))) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorStatus()
					+ " ACTIVE, OPTOUT, REMOVED, UNCONFIRMED.");
		}

		ResultSet<Contact> contacts = null;

		try {
			contacts = Component.resultSetFromJSON(
					MockedServerResponses.getContactsContactServicesData,
					Contact.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contacts;
	}

	/**
	 * Gets a single contact for the current user, based on the contact id.<br/>
	 * Implements the get Contact operation of the Contacts API by calling the
	 * ConstantContact server side.
	 * 
	 * @param contactId
	 *            Unique contact id.
	 * @return Returns a {@link com.constantcontact.components.contacts.Contact}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public Contact getContact(String contactId)
			throws ConstantContactServiceException {
		Contact contact = null;
		try {
			contact = Component.fromJSON(
					MockedServerResponses.getContactContactServicesData,
					Contact.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contact;
	}

	/**
	 * Gets one or more contacts for the current user, based on the contact
	 * email address.<br/>
	 * Implements the get Contact By Email operation of the Contacts API by
	 * calling the ConstantContact server side.
	 * 
	 * @param email
	 *            Contact email address to search for.
	 * @return Returns a
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of {@link com.constantcontact.components.contacts.Contact}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public ResultSet<Contact> getContactByEmail(String email)
			throws ConstantContactServiceException {

		String encodedEmail = null;

		try {
			encodedEmail = URLEncoder.encode(email, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException(ex);
		}

		ResultSet<Contact> contacts = null;
		try {
			contacts = Component.resultSetFromJSON(
					MockedServerResponses.getContactByEmailContactServicesData,
					Contact.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return contacts;
	}

	/**
	 * Adds a single contact for the current user.<br/>
	 * Implements the add Contact operation of the Contacts API by calling the
	 * ConstantContact server side.
	 * 
	 * @param contact
	 *            {@link com.constantcontact.components.contacts.Contact} to
	 *            add.
	 * @return Returns the newly created
	 *         {@link com.constantcontact.components.contacts.Contact}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public Contact addContact(Contact contact,
			Boolean actionByVisitor) throws ConstantContactServiceException {
		Contact newContact = null;
		try {
			newContact = Component.fromJSON(
					MockedServerResponses.addContactContactServicesData,
					Contact.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newContact;
	}

	/**
	 * Deletes a single contact for the current user, based on the contact id.<br/>
	 * Implements the delete Contact operation of the Contacts API by calling
	 * the ConstantContact server side.
	 * 
	 * @param contactId
	 *            Unique contact id of the contact to delete.
	 * @return Returns true if operation succeeded; an exception is thrown
	 *         otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteContact(String contactId)
			throws ConstantContactServiceException {
		try {
			int nContactId = Integer.parseInt(contactId);
			if (nContactId < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorContactOrId());
		}
		return MockedServerResponses.deleteContactContactServicesData;
	}

	/**
	 * Deletes a single contact from all the lists belonging the current user,
	 * based on the contact id.<br/>
	 * The actual contact entity is not deleted using this call.<br>
	 * Implements the delete Contact From Lists (all lists) operation of the
	 * Contacts API by calling the ConstantContact server side.
	 * 
	 * @param contactId
	 *            Contact id to be removed from all the lists.
	 * @return Returns true if operation succeeded; an exception is thrown
	 *         otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteContactFromLists(String contactId)
			throws ConstantContactServiceException {
		try {
			int nContactId = Integer.parseInt(contactId);
			if (nContactId < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorContactOrId());
		}
		return MockedServerResponses.deleteContactFromListsContactServicesData;
	}

	/**
	 * Deletes a single contact from a single list belonging the current user,
	 * based on the contact id and the list id.<br/>
	 * The actual contact entity is not deleted using this call.<br>
	 * Implements the delete Contact From List (a specific list) operation of
	 * the Contacts API by calling the ConstantContact server side.
	 * 
	 * @param contactId
	 *            Contact id to be removed.
	 * @param listId
	 *            ContactList to remove the contact from.
	 * @return Returns true if operation succeeded; an exception is thrown
	 *         otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteContactFromList(String contactId,
			String listId) throws ConstantContactServiceException {
		try {
			int nContactId = Integer.parseInt(contactId);
			if (nContactId < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorContactOrId());
		}
		try {
			int nListId = Integer.parseInt(listId);
			if (nListId < 1) {
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorListOrId());
		}
		return MockedServerResponses.deleteContactFromListContactServicesData;
	}

	/**
	 * Updates a single contact for the current user, based on the contact id.<br/>
	 * Implements the update Contact operation of the Contacts API by calling
	 * the ConstantContact server side.<br/>
	 * A specific contact is identified by its internal id.
	 *
	 * @param contact
	 *            {@link com.constantcontact.components.contacts.Contact} to be
	 *            updated.
	 * @return Returns the updated
	 *         {@link com.constantcontact.components.contacts.Contact}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public Contact updateContact(Contact contact,
			Boolean actionByVisitor) throws ConstantContactServiceException {
		if (contact == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorContactOrId());
		}
		if (contact.getId() == null || !(contact.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		Contact updateContact = null;
		try {
			updateContact = Component.fromJSON(
					MockedServerResponses.updateContactContactServisesData,
					Contact.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updateContact;
	}

	/**
	 * Default constructor.
	 */
	public ContactServiceMock(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
