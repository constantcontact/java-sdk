package com.constantcontact;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ContactListServiceMock;
import com.constantcontact.mockup.ContactServiceMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;


/**
 * Constant Contact contact lists unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactListsTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setListService(new ContactListServiceMock());
        constantContact.setContactService(new ContactServiceMock());
    }

    @Test
    /**
     * Tests the methods regarding the contact lists
     *
     */
    public void addListTest() {
        ContactList contactList = mock(ContactList.class);
        try {
            //add list
            ContactList resultContactList = constantContact.addList(contactList);
            verify(constantContact).addList(contactList);

            assertNotNull(resultContactList);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the get lists functionality
     *
     */
    @Test
    public void getListsTest(){

        try {

            List<ContactList> contactLists = new ArrayList<ContactList>();

            contactLists = constantContact.getLists(null);
            verify(constantContact).getLists(null);

            assertNotNull(contactLists);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the get contact list functionality
     *
     */
    @Test
    public void getListTest(){
        String contactListId = "1";

        try {

            ContactList contactListResult = new ContactList();

            contactListResult = constantContact.getList(contactListId);
            verify(constantContact).getList(contactListId);

            assertNotNull(contactListResult);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getList method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getListExceptionTest(){
        String contactListId = null;

        try {

            ContactList contactListResult = new ContactList();

            contactListResult = constantContact.getList(contactListId);
            verify(constantContact).getList(contactListId);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the update contact list functionality
     *
     */
    @Test
    public void updateListTest(){
        String contactListId = "1";

        try {

            ContactList contactList = constantContact.getList(contactListId);

            ContactList restultContactList = constantContact.updateList(contactList);
            verify(constantContact).updateList(contactList);

            assertNotNull(restultContactList);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateList method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateListExceptionTest(){
        String contactListId = null;

        try {

            ContactList contactList = constantContact.getList(contactListId);

            ContactList restultContactList = constantContact.updateList(contactList);
            verify(constantContact).updateList(contactList);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactsFromList method from ConstantContact.class
     *
     */
    @Test
    public void getContactsFromList(){
        ContactList contactList = mock(ContactList.class);
        String listId = "1";

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getContactsFromList(contactList);
            verify(constantContact).getContactsFromList(contactList);

            assertNotNull(resultSet);

            resultSet = constantContact.getContactsFromList(contactList, 1, null);
            verify(constantContact).getContactsFromList(contactList, 1, null);

            assertNotNull(resultSet);

            resultSet = constantContact.getContactsFromList(listId);
            verify(constantContact).getContactsFromList(listId);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactsFromList method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactsFromExceptionList(){
        ContactList contactList = null;
        String listId = null;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getContactsFromList(contactList);
            verify(constantContact).getContactsFromList(contactList);

            resultSet = constantContact.getContactsFromList(contactList, 1, null);
            verify(constantContact).getContactsFromList(contactList, 1, null);

            resultSet = constantContact.getContactsFromList(listId);
            verify(constantContact).getContactsFromList(listId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the add contact to list functionality
     *
     */
    @Test
    public void addContactToListTest(){

        Contact contact= mock(Contact.class);

        try {

            Contact resultContact = constantContact.addContact(contact, true);
            verify(constantContact).addContact(contact, true);

            assertNotNull(resultContact);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteContactFromList method from ConstantContact.class
     */
    @Test
    public void deleteContactFromListTest(){
        String contactId = "1";
        String listId = "1";

        Contact contact = new Contact();
        contact.setId(contactId);

        ContactList contactList = new ContactList();
        contactList.setId(listId);

        try {
            boolean deleted = constantContact.deleteContactFromList(contactId, listId);
            verify(constantContact).deleteContactFromList(contactId, listId);

            assertTrue(deleted);

            deleted = constantContact.deleteContactFromList(contact, contactList);
            verify(constantContact).deleteContactFromList(contact, contactList);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the deleteContactFromList method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteContactFromListExceptionTest(){
        String contactId = null;
        String listId = null;

        try {
            boolean deleted = constantContact.deleteContactFromList(contactId, listId);
            verify(constantContact).deleteContactFromList(contactId, listId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

}
