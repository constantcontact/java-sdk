package com.constantcontact;

import java.util.List;

import com.constantcontact.auth.CtcOAuth2;
import com.constantcontact.auth.ICtcOAuth2;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.services.ContactService;
import com.constantcontact.services.IContactService;
import com.constantcontact.services.IListService;
import com.constantcontact.services.ListService;
import com.constantcontact.util.Config;

/**
 * Main class meant to be used by users to access Constant Contact API functionality.
 * 
 * @author ConstantContact
 */
public class ConstantContact {
	private String accessToken;
	private ICtcOAuth2 oAuth;
	private IContactService contactService;
	private IListService listService;

	/**
	 * Class constructor.
	 */
	public ConstantContact() {
		this.oAuth = new CtcOAuth2();
		this.contactService = new ContactService();
		this.listService = new ListService();
	}
	
	/**
	 * Get the access token.
	 * @return The access token.
	 */
	public String getAccessToken() {
		if (accessToken == null || accessToken.trim().length() == 0) {
			accessToken = this.oAuth.getAccessToken();
		}
		return accessToken;
	}
	
	/**
	 * Get the authorization class.
	 * @return The authorization class.
	 */
	public ICtcOAuth2 getOAuth() {
		return oAuth;
	}
	
	/**
	 * Set the authorization class.
	 * @param oAuth The authorization class.
	 */
	public void setOAuth(ICtcOAuth2 oAuth) {
		this.oAuth = oAuth;
	}
	
	/**
	 * Get the Contact service.
	 * @return The Contact service.
	 */
	public IContactService getContactService() {
		return contactService;
	}
	
	/**
	 * Set the Contact service.
	 * @param contactService The Contact service.
	 */
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}

	/**
	 * Get the List service.
	 * @return The List service.
	 */
	public IListService getListService() {
		return listService;
	}
	
	/**
	 * Set the List service.
	 * @param listService The List service.
	 */
	public void setListService(IListService listService) {
		this.listService = listService;
	}

	/**
	 * Get a set of contacts.
	 * @param offset Denotes the starting number for the result set.
	 * @param limit Denotes the number of results per set, limited to 50.
	 * @return Returns a list of contacts.
	 */
	public List<Contact> getContacts(Integer offset, Integer limit) {
		return contactService.getContacts(this.getAccessToken(), offset, limit);
	}
	
	/**
	 * Get a set of contacts.
	 * @return A list of contacts.
	 */
	public List<Contact> getContacts() {
		return contactService.getContacts(this.getAccessToken(), null, null);
	}
	
	/**
	 * Get an individual contact.
	 * @param contactId Id of the contact to retrieve.
	 * @return Returns a contact.
	 */
	public Contact getContact(int contactId) {
		return contactService.getContact(this.getAccessToken(), contactId);
	}
	
	/**
	 * Get contacts with a specified email address.
	 * @param email Contact email address to search for.
	 * @return Returns a list of contacts.
	 */
	public List<Contact> getContactByEmail(String email) {
		return contactService.getContactByEmail(this.getAccessToken(), email);
	}

	/**
	 * Add a new contact to an account.
	 * @param contact Contact to add.
	 * @return Returns the newly created contact.
	 */
	public Contact addContact(Contact contact) {
		return contactService.addContact(this.getAccessToken(), contact);
	}
	
	/**
	 * Sets an individual contact to 'REMOVED' status.
	 * @param contact Contact to remove.
	 * @return Returns true if operation succeeded.
	 * @throws IllegalArgumentException for contact id equal or less than 0.
	 */
	public boolean deleteContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
		}
		return deleteContact(contact.getId());
	}
	
	/**
	 * Sets an individual contact to 'REMOVED' status.
	 * @param contactId Contact id.
	 * @return Returns true if operation succeeded.
	 * @throws IllegalArgumentException for contact id equal or less than 0.
	 */
    public boolean deleteContact(int contactId) {
        if (contactId < 1) {
            throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
        }
        return contactService.deleteContact(this.getAccessToken(), contactId);
    }

    /**
     * Delete a contact from all contact lists.
     * @param contactId Contact id.
     * @return Returns true if operation succeeded.
     * @throws IllegalArgumentException for contact id equal or less than 0.
     */
    public boolean deleteContactFromLists(int contactId)
    {
        if (contactId < 1) {
            throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
        }
        return contactService.deleteContactFromLists(this.getAccessToken(), contactId);
    }

    /**
     * Delete a contact from all contact lists.
     * @param contact Contact object.
     * @return Returns true if operation succeeded.
     * @throws IllegalArgumentException for empty contact.
     */
    public boolean deleteContactFromLists(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
        }
        return contactService.deleteContactFromLists(this.getAccessToken(), contact.getId());
    }

    /**
     * Delete a contact from all contact lists.
     * @param contact Contact object.
     * @param list List object
     * @return Returns true if operation succeeded.
     * @throws IllegalArgumentException for empty contact or empty list.
     */
    public boolean deleteContactFromList(Contact contact, ContactList list) {
        if (contact == null) {
            throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
        }
        if (list == null) {
            throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
        }
        return contactService.deleteContactFromList(this.getAccessToken(), contact.getId(), list.getId());
    }

    /**
     * Delete a contact from all contact lists.
     * @param contactId Contact id.
     * @param listId List id.
     * @return Returns true if operation succeeded.
     * @throws IllegalArgumentException for contact id equal or less than 0 or listId equal or less than 0.
     */
    public boolean deleteContactFromList(int contactId, int listId) {
        if (contactId < 1) {
            throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
        }
        if (listId < 1) {
            throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
        }

        return contactService.deleteContactFromList(this.getAccessToken(), contactId, listId);
    }

    /**
     * Update an individual contact.
     * @param contact Contact to update.
     * @return Returns the updated contact.
     * @throws IllegalArgumentException for empty contact.
     */
    public Contact updateContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException(Config.Errors.CONTACT_OR_ID);
        }
        return contactService.updateContact(this.getAccessToken(), contact);
    }

    /**
     * Get lists.
     * @return Returns the list of lists where contact belong to.
     */
    public List<ContactList> getLists() {
        return listService.getLists(this.getAccessToken());
    }

    /**
     * Get an individual list.
     * @param listId Id of the list to retrieve.
     * @return Returns contact list.
     * @throws IllegalArgumentException where for list id equal or less than 0. 
     */
    public ContactList getList(int listId) {
        if (listId < 1) {
            throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
        }
        return listService.getList(this.getAccessToken(), listId);
    }

    /**
     * Add a new list to an account.
     * @param list List to add.
     * @return Returns the newly created list.
     */
    public ContactList addList(ContactList list) {
        return listService.addList(this.getAccessToken(), list);
    }

    /**
     * Get contact that belong to a specific list.
     * @param list Contact list object.
     * @return Returns the list of contacts.
     * @throws IllegalArgumentException for empty list.
     */
    public List<Contact> getContactsFromList(ContactList list) {
        if (list == null) {
            throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
        }
        return listService.getContactsFromList(this.getAccessToken(), list.getId());
    }

    /**
     * Get contact that belong to a specific list.
     * @param listId Contact list id.
     * @return Returns a list of contacts.
     * @throws IllegalArgumentException for list id less or equal than 0.
     */
    public List<Contact> getContactsFromList(int listId) {
        if (listId < 1) {
            throw new IllegalArgumentException(Config.Errors.LIST_OR_ID);
        }
        return listService.getContactsFromList(this.getAccessToken(), listId);
    }
}
