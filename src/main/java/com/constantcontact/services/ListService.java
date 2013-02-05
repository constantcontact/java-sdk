package com.constantcontact.services;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * Performs all actions pertaining to the Lists Collection.
 * 
 * @author ConstantContact
 */
public class ListService extends BaseService implements IListService {
	/**
	 * Get lists within an account.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @return Returns a list of contact list.
	 */
	@Override
	public List<ContactList> getLists(String accessToken) {
		List<ContactList> lists = new ArrayList<ContactList>();
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.LISTS;
		CUrlResponse response = getRestClient().get(url, accessToken);
		if (response.hasData()) {
			lists = Component.listFromJSON(response.getBody(), ContactList.class);
		}
		return lists;
	}

	/**
	 * Add a new list.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param list Contact list.
	 * @return Returns the newly created list.
	 */
	@Override
	public ContactList addList(String accessToken, ContactList list) {
		ContactList newList = null;
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.LISTS;
		String json = list.toJSON();
		CUrlResponse response = getRestClient().post(url, accessToken, json);
		if (response.hasData()) {
			newList = Component.fromJSON(response.getBody(), ContactList.class);
		}
		return newList;
	}

	/**
	 * Get an individual contact list.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id.
	 * @return Returns a contact list.
	 */
	@Override
	public ContactList getList(String accessToken, int listId) {
		ContactList list = null;
		Formatter formatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.LIST, listId);
		CUrlResponse resposne = getRestClient().get(url, accessToken);
		if (resposne.hasData()) {
			list = Component.fromJSON(resposne.getBody(), ContactList.class);
		}
		return list;
	}

	/**
	 * Get all contacts from an individual list.
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id to retrieve contacts for.
	 * @return Returns a list of contacts.
	 */
	@Override
	public List<Contact> getContactsFromList(String accessToken, int listId) {
		List<Contact> contacts = new ArrayList<Contact>();
		Formatter formatter = new Formatter();
        String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.LIST_CONTACTS, listId);
        CUrlResponse response = getRestClient().get(url, accessToken);
        if (response.hasData()) {
            contacts = Component.listFromJSON(response.getBody(), Contact.class);
        }
        return contacts;
	}
}
