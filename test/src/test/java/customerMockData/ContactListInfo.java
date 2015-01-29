package customerMockData;

import com.constantcontact.components.contacts.ContactList;

import java.util.Date;
import java.util.Random;

/**
 * Data used to test the contact list functionality.<br/>
 *
 * @author ConstantContact
 */
public class ContactListInfo {

    private ContactList contactList;

    /**
     * Custom constructor that sets the fields of the ContactList object
     * used to test the contact list related functionality
     *
     */
    public  ContactListInfo(){

        ContactList contactList = new ContactList();
        contactList.setName("Test list "+(new Date()).toString());
        contactList.setStatus("ACTIVE");

        this.contactList = contactList;
    }

    /**
     * Gets the contact list
     * @return The ContactList object
     */
    public ContactList getContactList() {
        return contactList;
    }

    /**
     * Sets the contact list
     * @param contactList The ContactList object to be set
     */
    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }
}
