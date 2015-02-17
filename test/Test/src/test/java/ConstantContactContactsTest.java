import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import mockup.ContactServiceTest;
import org.junit.*;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Constant Contact Contacts unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactContactsTest {

    private ConstantContact constantContact;

    @Before
    public void beforeTests(){

        constantContact = Mockito.spy(new ConstantContact("",""));
        constantContact.setContactService(new ContactServiceTest());

    }

    /**
     * Tests the add contact functionality
     *
     */
    @Test
    public void addContactTest() {
        Contact contact = mock(Contact.class);

        try {
            Contact resultContact = new Contact();
            resultContact = constantContact.addContact(contact,true);
            verify(constantContact).addContact(contact, true);

            assertNotNull(resultContact);

            resultContact = constantContact.addContact(contact);
            verify(constantContact).addContact(contact);

            assertNotNull(resultContact);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContact method from ConstantContact.class
     *
     */
    @Test
    public void getContactTest(){

        try {
            Contact resultContact = new Contact();

            resultContact = constantContact.getContact(anyString());
            verify(constantContact).getContact(anyString());

            assertNotNull(resultContact);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the getContactByEmail method from ConstantContact.class
     */
    @Test
    public void getContactByEmailTest(){

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getContactByEmail(anyString());
            verify(constantContact).getContactByEmail(anyString());

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the functionality of the updateContact method and the results of the update
     *
     */
    @Test
    public void updateContactTest(){

        try {

            Contact contact = constantContact.getContact(anyString());

            Contact resultContact = constantContact.updateContact(contact, true);
            verify(constantContact).updateContact(contact, true);

            assertNotNull(resultContact);

            resultContact = constantContact.updateContact(contact);
            verify(constantContact).updateContact(contact);

            assertNotNull(resultContact);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateContact method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateContactExceptionTest(){

        try {

            Contact contact = null;

            Contact resultContact = constantContact.updateContact(contact, true);
            verify(constantContact).updateContact(contact, true);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the functionality of the deleteContact method and the possibility of opting a contact back in
     *
     */
    @Test
    public void deleteContactTest(){
        String contactId = "1";
        Contact contact = new Contact();
        contact.setId(contactId);

        try {

            Boolean deleted = constantContact.deleteContact(contactId);
            verify(constantContact).deleteContact(anyString());

            assertTrue(deleted.toString(), deleted);

            deleted = constantContact.deleteContact(contact);
            verify(constantContact).deleteContact(contact);

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests that the deleteContact method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteExceptionTest(){
        String contactId = "0";
        try {

            Boolean deleted = constantContact.deleteContact(contactId);
            verify(constantContact).deleteContact(anyString());

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the get contacts functionality
     */
    @Test
    public void getContactsTest(){
        ResultSet contactResultSet = mock(ResultSet.class);
        try {

            contactResultSet = constantContact.getContacts(10, null, Contact.Status.ACTIVE);
            verify(constantContact).getContacts(anyInt(), anyString(), eq(Contact.Status.ACTIVE));

            assertNotNull(contactResultSet);

//            ResultSet resultContactspagination = constantContact.getContacts(contactResultSet.getMeta().getPagination());
//
//            assertNotNull(resultContactspagination);

        } catch (ConstantContactServiceException e) {
            System.out.print(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getContacts method throws the proper exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void getContactsExceptionTest(){
        ResultSet contactResultSet = mock(ResultSet.class);
        try {

            contactResultSet = constantContact.getContacts(10, null, Contact.Status.VISITOR);
            verify(constantContact).getContacts(anyInt(), anyString(), eq(Contact.Status.VISITOR));

        } catch (ConstantContactServiceException e) {
            System.out.print(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteContactFromLists method from ConstantContact.class
     */
    @Test
    public void deleteContactFromListsTest(){
        Contact contact = mock(Contact.class);
        String contactId = "1";
        try {
            Boolean deleted = constantContact.deleteContactFromLists(contact);
            verify(constantContact).deleteContactFromLists(contact);

            assertTrue(deleted);

            deleted = constantContact.deleteContactFromLists(contactId);
            verify(constantContact).deleteContactFromLists(anyString());

            assertTrue(deleted);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deleteContactFromLists method from ConstantContact.class
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteContactFromListsExceptionTest(){
        Contact contact = null;
        try {
            Boolean deleted = constantContact.deleteContactFromLists(contact);
            verify(constantContact).deleteContactFromLists(contact);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

}