package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.contactlists.IContactListService;
import com.constantcontact.services.contacts.IContactService;


/**
 * Constant Contact contact lists unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactListsTest {

	private ConstantContactFactoryMock constantContactFactory;
    private IContactListService contactListService;
    private IContactService contactService;
    
    @Before
    public void beforeTests(){
    	constantContactFactory = Mockito.spy(new ConstantContactFactoryMock("",""));
    	contactListService = constantContactFactory.createContactListService();
    	contactService = constantContactFactory.createContactService();
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
            ContactList resultContactList = contactListService.addList(contactList);
            verify(contactListService).addList(contactList);

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

            contactLists = contactListService.getLists(null);
            verify(contactListService).getLists(null);

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

            contactListResult = contactListService.getList(contactListId);
            verify(contactListService).getList(contactListId);

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

            contactListResult = contactListService.getList(contactListId);
            verify(contactListService).getList(contactListId);

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

            ContactList contactList = contactListService.getList(contactListId);

            ContactList restultContactList = contactListService.updateList(contactList);
            verify(contactListService).updateList(contactList);

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

            ContactList contactList = contactListService.getList(contactListId);

            ContactList restultContactList = contactListService.updateList(contactList);
            verify(contactListService).updateList(contactList);

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
    	ContactList contactList = new ContactList();
        String listId = "1";
        contactList.setId(listId);

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactListService.getContactsFromList(listId, 1, null);
            verify(contactListService).getContactsFromList(listId, 1, null);


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
        ContactList contactList = mock(ContactList.class);
        String listId = null;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactListService.getContactsFromList(listId, 1, null);
            verify(contactListService).getContactsFromList(listId, 1, null);

            resultSet = contactListService.getContactsFromList(listId, null, null);
            verify(contactListService).getContactsFromList(listId, null, null);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactsFromList method from ConstantContact.class
     *
     */
    @Test
    public void getContactsFromListPaginated(){
        ContactList contactList = new ContactList();
        String listId = "1";
        contactList.setId(listId);
        Pagination pagination = new Pagination();
        pagination.setNextLink("link");

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactListService.getContactsFromList(pagination);
            verify(contactListService).getContactsFromList(pagination);


        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContactsFromList method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactsFromListPaginatedExcetion(){
        ContactList contactList = mock(ContactList.class);
        String listId = null;
        Pagination pagination = null;

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = contactListService.getContactsFromList(pagination);
            verify(contactListService).getContactsFromList(pagination);

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

            Contact resultContact = contactService.addContact(contact, true);
            verify(contactService).addContact(contact, true);

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

        try {
            boolean deleted = contactService.deleteContactFromList(contactId, listId);
            verify(contactService).deleteContactFromList(contactId, listId);

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
            boolean deleted = contactService.deleteContactFromList(contactId, listId);
            verify(contactService).deleteContactFromList(contactId, listId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

}
