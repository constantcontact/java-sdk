import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import customerMockData.ContactInfo;
import customerMockData.ContactListInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Constant Contact contact lists unit test class.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactListsTest {

    private ConstantContact constantContact;
    private String apiKey;
    private String accessToken;

    @Before
    /**
     * Sets the apy key and the access token
     * Instantiates the ConstantContact object that contains tested methods
     *
     */
    public void setKeys() {
        this.apiKey = System.getProperty("apiKey");
        this.accessToken = System.getProperty("accessToken");
        constantContact= new ConstantContact(apiKey,accessToken);
    }

    @Test
    /**
     * Tests the methods regarding the contact lists
     *
     */
    public void listsTest() {
        ContactList contactListResult = null;
        ContactListInfo contactListInfo = new ContactListInfo();
        try {
            //add list
            contactListResult = constantContact.addList(contactListInfo.getContactList());

            //get list
            contactListResult = getListTest(contactListResult);

            //get lists
            getListsTest(contactListResult);

            //add contact to list
            Contact contact = addContactToListTest(contactListResult);

            contactListResult = getListTest(contactListResult);

            assertEquals("The number of contacts(" + contactListResult.getContactCount() + ") in the list is not the expected one (1)", contactListResult.getContactCount(),1);

            //delete list
            constantContact.deleteContactFromList(contact.getId(), contactListResult.getId());

            contactListResult = getListTest(contactListResult);

            assertEquals("The number of contacts(" + contactListResult.getContactCount() + ") in the list is not the expected one (0)", contactListResult.getContactCount(),0);

            //update list
            updateListTest(contactListResult);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the get lists functionality
     * @param contactList The contact list used to verify if the retrieved data contains what it should
     *
     */
    public void getListsTest(ContactList contactList){
        List<ContactList> contactLists = new ArrayList<ContactList>();
        try {
            contactLists = constantContact.getLists(null);

            for(ContactList contactListI: contactLists){
                if(contactList.getId().equals(contactListI.getId())){
                    assertEquals("The contact list name is not the expected one", contactList.getName(), contactListI.getName());
                }
            }
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the get contact list functionality
     * @param contactList The contact list to get, used to verify if the retrieved data contains what it should be
     * @return The retrieved contact list
     *
     */
    public ContactList getListTest(ContactList contactList){
        ContactList contactListResult = null;
        try {
            contactListResult = constantContact.getList(contactList.getId());

            assertEquals("The name of the retrieved contact list("+contactListResult.getName()+") is different than expected("+contactList.getName()+
                    ")", contactListResult.getName(), contactList.getName());
            assertEquals("The status of the retrieved contact list("+contactListResult.getStatus()+") is different than expected("+contactList.getStatus()+
                    ")", contactListResult.getStatus(), contactList.getStatus());

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
        return contactListResult;
    }

    /**
     * Tests the update contact list functionality
     * @param contactList The contact list to be updated
     *
     */
    private void updateListTest(ContactList contactList){
        contactList.setStatus("HIDDEN");
        ContactListInfo contactListInfo = new ContactListInfo();
        try {
            ContactList contactListResult = constantContact.updateList(contactList);

            assertNotEquals("The contact list status does not have the expected value", contactListResult.getStatus(), contactListInfo.getContactList().getStatus());
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the add contact to list functionality
     * @param contactList The contact list where the contact should be added
     * @return The added contact
     *
     */
    private Contact addContactToListTest(ContactList contactList){
        ContactInfo contactInfo = new ContactInfo();

        Contact contact= contactInfo.getTestContact();

        List<ContactList> contactLists = new ArrayList<ContactList>();
        contactLists.add(contactList);

        contact.setLists(contactLists);

        Contact resultContact = null;

        try {
            resultContact = constantContact.addContact(contact);

            assertEquals("The contact list id from the contact(" + contactInfo.getTestContact().getLists().get(0).getId() +
                    ") is different than the expected one(" + resultContact.getLists().get(0).getId() + ")", contactInfo.getTestContact().getLists().get(0).getId(), resultContact.getLists().get(0).getId());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
        return resultContact;
    }
}
