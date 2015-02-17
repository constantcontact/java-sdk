package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.contactlists.ContactListService;
import java.util.List;

/**
 * Service Layer Implementation for the Contact Lists operations in Constant Contact.
 * 
 * @author ConstantContact
 */
public class ContactListServiceMock extends ContactListService {

	/**
	 * Implements the Get lists for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the lists modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return Returns a list of {@link com.constantcontact.components.contacts.ContactList} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public List<ContactList> getLists(String accessToken, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		List<ContactList> lists = null;
		try {
				lists = Component.listFromJSON(MockedServerResponses.getListsContactListData, ContactList.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return lists;
	}

	/**
	 * Implements the add list for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param list The {@link com.constantcontact.components.contacts.ContactList} that was added, when successful.
	 * @return Returns the newly created list containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactList addList(String accessToken, ContactList list) throws ConstantContactServiceException {
		ContactList newList = null;
		try {
				newList = Component.fromJSON(MockedServerResponses.addListContactListData, ContactList.class);
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
	 * @return The {@link com.constantcontact.components.contacts.ContactList} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactList getList(String accessToken, String listId) throws ConstantContactServiceException {
		ContactList list = null;
		try {
				list = Component.fromJSON(MockedServerResponses.getListContactListData, ContactList.class);
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
     * @return The {@link com.constantcontact.components.contacts.ContactList} containing values as returned by the server on success; <br/>
     *         An exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

     @Override
    public ContactList updateList(String accessToken, ContactList list) throws ConstantContactServiceException {

        ContactList resultingList = null;
            try {
                resultingList = Component.fromJSON(MockedServerResponses.updateListContactListData, ContactList.class);
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
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.Contact} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<Contact> getContactsFromList(String accessToken, String listId, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<Contact> contacts = null;
		try {
				contacts = Component.resultSetFromJSON(MockedServerResponses.getContactsFromListContactListData, Contact.class);
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
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public boolean deleteList(String accessToken, String listId) throws ConstantContactServiceException {
        return MockedServerResponses.deleteListContactListData;
	}

	/**
	 * Default constructor.
	 */
	public ContactListServiceMock() {
		super();
	}
}
