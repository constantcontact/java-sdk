package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.contacts.IContactService;

/**
 * Constant Contact Contacts unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactContactsTest {

  private ConstantContactFactoryMock constantContactFactoryMock;
  private IContactService contactServiceMock;

  private ConstantContactFactory constantContactFactory;
  private IContactService contactService;

  @Before
  public void beforeTests() {
    constantContactFactoryMock = Mockito.spy(new ConstantContactFactoryMock("", ""));
    contactServiceMock = constantContactFactoryMock.createContactService();

    constantContactFactory = Mockito.spy(new ConstantContactFactory("", ""));
    contactService = constantContactFactory.createContactService();
  }

  /**
   * Tests the add contact functionality
   */
  @Test
  public void addContactTest() {
    Contact contact = mock(Contact.class);

    try {
      Contact resultContact = new Contact();
      resultContact = contactServiceMock.addContact(contact, true);
      verify(contactServiceMock).addContact(contact, true);

      assertNotNull(resultContact);

      resultContact = contactServiceMock.addContact(contact, false);
      verify(contactServiceMock).addContact(contact, false);

      assertNotNull(resultContact);

    } catch (ConstantContactServiceException e) {
      System.out.println(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests the getContact method from ConstantContact.class
   */
  @Test
  public void getContactTest() {

    try {
      Contact resultContact = new Contact();

      resultContact = contactServiceMock.getContact(anyString());
      verify(contactServiceMock).getContact(anyString());

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
  public void getContactByEmailTest() {

    try {

      ResultSet resultSet = mock(ResultSet.class);

      resultSet = contactServiceMock.getContactByEmail(anyString());
      verify(contactServiceMock).getContactByEmail(anyString());

      assertNotNull(resultSet);

    } catch (ConstantContactServiceException e) {
      System.out.println(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests the functionality of the updateContact method and the results of the update
   */
  @Test
  public void updateContactTest() {

    try {

      Contact contact = contactServiceMock.getContact(anyString());

      Contact resultContact = contactServiceMock.updateContact(contact, true);
      verify(contactServiceMock).updateContact(contact, true);

      assertNotNull(resultContact);

      resultContact = contactServiceMock.updateContact(contact, false);
      verify(contactServiceMock).updateContact(contact, false);

      assertNotNull(resultContact);

    } catch (ConstantContactServiceException e) {
      System.out.println(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests that the updateContact method throws the proper exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void updateContactExceptionTest() {

    try {

      Contact contact = null;

      Contact resultContact = contactServiceMock.updateContact(contact, true);
      verify(contactServiceMock).updateContact(contact, true);

    } catch (ConstantContactServiceException e) {
      System.out.println(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests that the updateContact method throws the proper exception
   *
   * @throws ConstantContactServiceException
   */
  @Test(expected = ConstantContactServiceException.class)
  public void updateContactServerExceptionTest() throws ConstantContactServiceException {

    Contact contact = new Contact();
    contact.setId("1");

    Contact resultContact = contactService.updateContact(contact, true);

  }

  /**
   * Tests the functionality of the deleteContact method and the possibility of opting a contact back in
   */
  @Test
  public void deleteContactTest() {
    String contactId = "1";

    try {

      Boolean deleted = contactServiceMock.deleteContact(contactId);
      verify(contactServiceMock).deleteContact(anyString());

      assertTrue(deleted.toString(), deleted);

    } catch (ConstantContactServiceException e) {
      System.out.println(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests that the deleteContact method throws the proper exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void deleteExceptionTest() {
    String contactId = "0";
    try {

      Boolean deleted = contactServiceMock.deleteContact(contactId);
      verify(contactServiceMock).deleteContact(anyString());

    } catch (ConstantContactServiceException e) {
      System.out.println(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests that the deleteContact method throws the proper exception
   *
   * @throws ConstantContactServiceException
   */
  @Test(expected = ConstantContactServiceException.class)
  public void deleteServiceExceptionTest() throws ConstantContactServiceException {
    String contactId = "1";

    Boolean deleted = contactService.deleteContact(contactId);
  }

  /**
   * Tests the get contacts functionality
   */
  @Test
  public void getContactsTest() {
    ResultSet contactResultSet = mock(ResultSet.class);
    try {

      contactResultSet = contactServiceMock.getContacts(10, null, Contact.Status.ACTIVE);
      verify(contactServiceMock).getContacts(anyInt(), anyString(), eq(Contact.Status.ACTIVE));

      assertNotNull(contactResultSet);

    } catch (ConstantContactServiceException e) {
      System.out.print(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests that the getContacts method throws the proper exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void getContactsExceptionTest() {
    ResultSet contactResultSet = mock(ResultSet.class);
    try {

      contactResultSet = contactServiceMock.getContacts(10, null, Contact.Status.VISITOR);
      verify(contactServiceMock).getContacts(anyInt(), anyString(), eq(Contact.Status.VISITOR));

    } catch (ConstantContactServiceException e) {
      System.out.print(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests that the getContacts method throws the proper exception
   *
   * @throws ConstantContactServiceException
   */
  @Test(expected = ConstantContactServiceException.class)
  public void getContactsServiceExceptionTest() throws ConstantContactServiceException {
    ResultSet contactResultSet = new ResultSet<String>();

    contactResultSet = contactService.getContacts(10, null, Contact.Status.ACTIVE);
  }

  /**
   * Tests the get paginated contacts functionality
   */
  @Test
  public void getPaginatedContactsTest() {
    ResultSet contactResultSet = mock(ResultSet.class);
    final Pagination pagination = new Pagination();
    pagination.setNextLink("should/be/a/valid/link");

    try {

      contactResultSet = contactServiceMock.getContacts(pagination);
      verify(contactServiceMock).getContacts(pagination);

      assertNotNull(contactResultSet);

    } catch (ConstantContactServiceException e) {
      System.out.print(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests the get paginated contacts functionality
   */
  @Test(expected = IllegalArgumentException.class)
  public void getPaginatedContatsIllegalArgumentExceptionTest() {
    ResultSet contactResultSet = mock(ResultSet.class);
    final Pagination pagination = null;

    try {

      contactResultSet = contactServiceMock.getContacts(pagination);
      verify(contactServiceMock).getContacts(pagination);

      assertNotNull(contactResultSet);

    } catch (ConstantContactServiceException e) {
      System.out.print(e.getErrorInfo());
      e.printStackTrace();
    }
  }

  /**
   * Tests the deleteContactFromLists method from ConstantContact.class
   */
  @Test
  public void deleteContactFromListsTest() {

    String contactId = "1";
    try {

      Boolean deleted = contactServiceMock.deleteContactFromLists(contactId);
      verify(contactServiceMock).deleteContactFromLists(contactId);

      assertTrue(deleted);

    } catch (ConstantContactServiceException e) {
      e.printStackTrace();
    }
  }

}