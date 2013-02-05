package com.constantcontact.services;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.apache.http.HttpStatus;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * Performs all actions pertaining to the Contacts Collection.
 * 
 * @author ConstantContact
 *
 */
public class ContactService extends BaseService implements IContactService {
	/**
	 * Get an aray of contacts.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param offset Offset.
	 * @param limit Limit.
	 * @return Returns a list of contacts.
	 */
	@Override
	public List<Contact> getContacts(String accessToken, Integer offset, Integer limit) {
		List<Contact> contacts = new ArrayList<Contact>();
		// Construct access URL
		String url = paginateUrl(Config.Endpoints.BASE_URL + Config.Endpoints.CONTACTS, offset, limit);
		// Get REST response
		CUrlResponse response = getRestClient().get(url, accessToken);
		if (response.hasData()) {
			contacts = Component.listFromJSON(response.getBody(), Contact.class);
		}
		return contacts;
	}

	/**
	 * Get contact details for a specific contact.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId Unique contact id.
	 * @return Returns a contact.
	 */
	@Override
	public Contact getContact(String accessToken, int contactId) {
		Contact contact = null;
		Formatter formatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.CONTACT, contactId);
		CUrlResponse response = getRestClient().get(url, accessToken);
		if (response.hasData()) {
			contact = Component.fromJSON(response.getBody(), Contact.class);
		}
		return contact;
	}

	/**
	 * Get contacts with a specified email addresses.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param email Contact email address to search for.
	 * @return Returns a list of contacts.
	 */
	@Override
	public List<Contact> getContactByEmail(String accessToken, String email) {
		List<Contact> contacts = new ArrayList<Contact>();
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.CONTACTS + "?email=" + email;
		CUrlResponse response = getRestClient().get(url, accessToken);
		if (response.hasData()) {
			contacts = Component.listFromJSON(response.getBody(), Contact.class);
		}
		return contacts;
	}

	@Override
	public Contact addContact(String accessToken, Contact contact) {
		Contact newContact = null;
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.CONTACTS;
		String json = contact.toJSON();
		CUrlResponse response = getRestClient().post(url, accessToken, json);
		if (response.hasData()) {
			newContact = Component.fromJSON(response.getBody(), Contact.class);
		}
		return newContact;
	}

	@Override
	public boolean deleteContact(String accessToken, int contactId) {
		Formatter formatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.CONTACT, contactId);
		CUrlResponse response = getRestClient().delete(url, accessToken);
		return !response.isError() && response.getStatusCode() == HttpStatus.SC_NO_CONTENT;
	}

	@Override
	public boolean deleteContactFromLists(String accessToken, int contactId) {
		Formatter formatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.CONTACT_LISTS, contactId);
		CUrlResponse response = getRestClient().delete(url, accessToken);
		return !response.isError() && response.getStatusCode() == HttpStatus.SC_NO_CONTENT;
	}

	@Override
	public boolean deleteContactFromList(String accessToken, int contactId, int listId) {
		Formatter formatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.CONTACT_LIST, contactId, listId);
		CUrlResponse response = getRestClient().delete(url, accessToken);
		return !response.isError() && response.getStatusCode() == HttpStatus.SC_NO_CONTENT;
	}

	@Override
	public Contact updateContact(String accessToken, Contact contact) {
		Contact updateContact = null;
		Formatter formatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.CONTACT, contact.getId());
		String json = contact.toJSON();
		CUrlResponse response = getRestClient().put(url, accessToken, json);
		if (response.hasData()) {
			updateContact = Component.fromJSON(response.getBody(), Contact.class);
		}
		return updateContact;
	}

}
