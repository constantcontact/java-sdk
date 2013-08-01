package com.constantcontact.services.contactlists;

import java.util.List;

import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for {@link ContactListService} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IContactListService extends IBaseService {

	/**
	 * Implements the Get lists for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * 
	 * @return Returns a list of {@link ContactList} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	List<ContactList> getLists(String accessToken, String modifiedSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the add list for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param list The {@link ContactList} that was added, when successful.
	 * @return Returns the newly created list containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	ContactList addList(String accessToken, ContactList list) throws ConstantContactServiceException;

	/**
	 * Implements the get individual list for an account operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id.
	 * @return The {@link ContactList} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	ContactList getList(String accessToken, String listId) throws ConstantContactServiceException;

	/**
	 * Implements the Get contacts from an individual list operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId List id to retrieve contacts for.
	 * @param limit Maximum number of contacts to retrieve. Default is 50.
	 * @return Returns a list of {@link Contact} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<Contact> getContactsFromList(String accessToken, String listId, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException;
	
	/**
	 * Implements the Get contacts from an individual list operation by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param pagination {@link Pagination} object that contains the link to the next set of contacts.
	 * @return Returns a list of {@link Contact} containing values as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	
	ResultSet<Contact> getContactsFromListAtPage(String accessToken, Pagination pagination, String modifiedSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the delete ContactList operation of the Contact Lists API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param listId Unique contact id of the contact to delete.
	 * @return Returns true if operation succeeded; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public boolean deleteList(String accessToken, String listId) throws ConstantContactServiceException;
}
