package com.constantcontact.test;

import java.util.Formatter;
import java.util.List;

import org.apache.http.HttpStatus;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.constantcontact.ConstantContact;
import com.constantcontact.auth.CtcOAuth2;
import com.constantcontact.auth.ICtcOAuth2;
import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.contacts.Contact.Status;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.services.ContactService;
import com.constantcontact.services.IContactService;
import com.constantcontact.services.IListService;
import com.constantcontact.services.ListService;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.IRestClient;
import com.constantcontact.util.RestClient;

/**
 * Unit test class
 * 
 * @author ConstantContact
 *
 */
public class CtctUnitTest {
	private static final String TEST_EMAIL = "johndoe@constantcontact.com";
	private final String contact1 = "{\"id\":1,\"status\":\"ACTIVE\",\"fax\":\"\",\"addresses\":[{\"line1\":\"\",\"line2\":\"\",\"line3\":\"\",\"city\":\"\",\"address_type\":\"PERSONAL\",\"state_code\":\"\",\"country_code\":\"\",\"postal_code\":\"\",\"sub_postal_code\":\"\"},{\"line1\":\"\",\"line2\":\"\",\"line3\":\"\",\"city\":\"\",\"address_type\":\"BUSINESS\",\"state_code\":\"\",\"country_code\":\"\",\"postal_code\":\"\",\"sub_postal_code\":\"\"}],\"notes\":[],\"confirmed\":false,\"lists\":[{\"id\":1,\"status\":\"ACTIVE\"},{\"id\":3,\"status\":\"ACTIVE\"}],\"source\":\"\",\"email_addresses\":[{\"status\":\"ACTIVE\",\"confirm_status\":\"NO_CONFIRMATION_REQUIRED\",\"opt_in_source\":\"ACTION_BY_OWNER\",\"opt_in_date\":\"2013-01-22T11:00:05.189Z\",\"opt_out_date\":\"1969-12-31T19:00:00.000Z\",\"email_address\":\"johndoe@constantcontact.com\"}],\"prefix_name\":\"\",\"first_name\":\"Taras\",\"middle_name\":\"\",\"last_name\":\"Khoma\",\"job_title\":\"\",\"company_name\":\"\",\"home_phone\":\"\",\"work_phone\":\"\",\"cell_phone\":\"\",\"custom_fields\":[],\"source_details\":\"\"}";
    private final String contact2 = "{\"id\":2,\"status\":\"ACTIVE\",\"fax\":\"555-0000\",\"addresses\":[{\"line1\":\"line1\",\"line2\":\"line2\",\"line3\":\"line3\",\"city\":\"city1\",\"address_type\":\"PERSONAL\",\"state_code\":\"AL\",\"country_code\":\"us\",\"postal_code\":\"12345\",\"sub_postal_code\":\"010\"},{\"line1\":\"\",\"line2\":\"\",\"line3\":\"\",\"city\":\"\",\"address_type\":\"BUSINESS\",\"state_code\":\"\",\"country_code\":\"\",\"postal_code\":\"\",\"sub_postal_code\":\"\"}],\"notes\":[],\"confirmed\":false,\"lists\":[{\"id\":1,\"status\":\"ACTIVE\"}],\"source\":\"API\",\"email_addresses\":[{\"status\":\"ACTIVE\",\"confirm_status\":\"NO_CONFIRMATION_REQUIRED\",\"opt_in_source\":\"ACTION_BY_OWNER\",\"opt_in_date\":\"2012-12-13T08:43:04.974Z\",\"opt_out_date\":\"1969-12-31T19:00:00.000Z\",\"email_address\":\"test1@yahoo.com\"}],\"prefix_name\":\"pre1\",\"first_name\":\"first1\",\"middle_name\":\"middle1\",\"last_name\":\"last1\",\"job_title\":\"job1\",\"department_name\":\"\",\"company_name\":\"company1\",\"custom_fields\":[{\"name\":\"CustomField1\",\"value\":\"custom field1\"}],\"source_details\":\"7a3ae237-cbd1-4aaf-8194-721abede7cdb\",\"source_details\":false,\"action_by\":\"ACTION_BY_OWNER\"}";
    private final String contact3 = "{\"id\":3,\"status\":\"ACTIVE\",\"fax\":\"555-0000\",\"addresses\":[{\"line1\":\"line1\",\"line2\":\"line2\",\"line3\":\"line3\",\"city\":\"city2\",\"address_type\":\"PERSONAL\",\"state_code\":\"\",\"country_code\":\"us\",\"postal_code\":\"12345\",\"sub_postal_code\":\"020\"},{\"line1\":\"\",\"line2\":\"\",\"line3\":\"\",\"city\":\"\",\"address_type\":\"BUSINESS\",\"state_code\":\"\",\"country_code\":\"\",\"postal_code\":\"\",\"sub_postal_code\":\"\"}],\"notes\":[],\"confirmed\":false,\"lists\":[{\"id\":1,\"status\":\"ACTIVE\"}],\"source\":\"API\",\"email_addresses\":[{\"status\":\"ACTIVE\",\"confirm_status\":\"NO_CONFIRMATION_REQUIRED\",\"opt_in_source\":\"ACTION_BY_OWNER\",\"opt_in_date\":\"2012-12-18T10:49:58.279Z\",\"opt_out_date\":\"2012-12-18T06:14:25.920Z\",\"email_address\":\"test2@yahoo.com\"}],\"prefix_name\":\"pre2\",\"first_name\":\"first2\",\"middle_name\":\"middle2\",\"last_name\":\"last2\",\"job_title\":\"job2\",\"department_name\":\"\",\"company_name\":\"company2\",\"custom_fields\":[],\"source_details\":\"7a3ae237-cbd1-4aaf-8194-721abede7cdb\",\"source_details\":false,\"action_by\":\"ACTION_BY_OWNER\"}";
    private final String list1 = "{\"id\":1,\"status\":\"ACTIVE\"}";
    private final String list2 = "{\"id\":2,\"status\":\"ACTIVE\"}";
    private final String list3 = "{\"id\":3,\"status\":\"ACTIVE\"}";
    
    @Test
    public void getTokenTest() {
    	ICtcOAuth2 mockOauth = buildAuthMock();
    	String token = mockOauth.getAccessToken();
    	Assert.assertEquals("access_token", token);
    }
    
	@Test
	public void addContactTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		CUrlResponse resp = new CUrlResponse();
		resp.setBody(contact1);
		IRestClient mockRest = buildRestMockForPost(mockAuth, resp);
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockAuth);
		Contact addContact = target.addContact(new Contact());
		Assert.assertNotNull(addContact);
		Assert.assertNotNull(addContact.getEmailAddresses());
		Assert.assertEquals(1, addContact.getEmailAddresses().size());
		Assert.assertEquals(TEST_EMAIL, addContact.getEmailAddresses().get(0).getEmailAddress());
	}
	
	@Test
	public void addListTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		CUrlResponse resp = new CUrlResponse();
		resp.setBody(list1);
		IRestClient mockRest = buildRestMockForPost(mockAuth, resp);
		
		IListService listService = new ListService();
		listService.setRestClient(mockRest);
		ConstantContact target = new ConstantContact();
		target.setListService(listService);
		target.setOAuth(mockAuth);
		ContactList list = target.addList(new ContactList());
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.getId());
		Assert.assertEquals(Status.ACTIVE, list.getStatus());
	}
	
	@Test
	public void deleteContactFromListsTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		IRestClient mockRest = buildRestMockForDelete(mockAuth);
		
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockAuth);
		
		Contact contact = new Contact();
		contact.setId(1);
		boolean res = target.deleteContactFromLists(contact);
		Assert.assertTrue(res);
	}
	
	@Test
	public void deleteContactFromListTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		IRestClient mockRest = buildRestMockForDelete(mockAuth);
		
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockAuth);
		
		Contact contact = new Contact();
		contact.setId(1);
		ContactList contactList = new ContactList();
		contactList.setId(1);
		boolean res = target.deleteContactFromList(contact, contactList);
		Assert.assertTrue(res);
	}
	
	@Test
	public void deleteContactTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		IRestClient mockRest = buildRestMockForDelete(mockAuth);

		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockAuth);
		
		boolean res = target.deleteContact(1);
		Assert.assertTrue(res);
	}
	
	@Test
	public void getContactByEmailTest() {
		ICtcOAuth2 mockOauth = buildAuthMock();
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.CONTACTS + "?email=" + TEST_EMAIL;
		CUrlResponse resp = new CUrlResponse();
		resp.setBody("[" + contact1 + "]");
		IRestClient mockRest = buildRestMockForGet(mockOauth, url, resp);
		
		
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockOauth);
		
		List<Contact> contact = target.getContactByEmail(TEST_EMAIL);
		Assert.assertNotNull(contact);
		Assert.assertEquals(1, contact.size());
		Assert.assertEquals(TEST_EMAIL, contact.get(0).getEmailAddresses().get(0).getEmailAddress());
		
	}
	
	@Test
	public void getContactsFromListTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		CUrlResponse resp = new CUrlResponse();
		Formatter formatter = new Formatter();
		resp.setBody(formatter.format("[%1$s, %2$s, %3$s]", list1, list2, list3).toString());
		int listId = 1;
		Formatter urlFormatter = new Formatter();
        String url = Config.Endpoints.BASE_URL + urlFormatter.format(Config.Endpoints.LIST_CONTACTS, listId);
		IRestClient mockRest = buildRestMockForGet(mockAuth, url, resp);
		
		IListService listService = new ListService();
		listService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setListService(listService);
		target.setOAuth(mockAuth);
		
		ContactList contactList = new ContactList();
		contactList.setId(1);
		List<Contact> list = target.getContactsFromList(contactList);
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());

	}
	
	@Test
	public void getContactsTest() {
		ICtcOAuth2 mockOauth = buildAuthMock();
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.CONTACTS;
		CUrlResponse resp = new CUrlResponse();
		resp.setBody("[" + contact1 + "," + contact2 + "," + contact3 + "]");
		
		IRestClient mockRest = buildRestMockForGet(mockOauth, url, resp);
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockOauth);
		
		List<Contact> contacts = target.getContacts();
		Assert.assertNotNull(contacts);
	}
	
	@Test
	public void getContactTest() {
		ICtcOAuth2 mockOauth = buildAuthMock();
		Formatter formatter = new Formatter();
		int contactId = 1;
		String url = Config.Endpoints.BASE_URL + formatter.format(Config.Endpoints.CONTACT, contactId);
		CUrlResponse resp = new CUrlResponse();
		resp.setBody(contact1);
		IRestClient mockRest = buildRestMockForGet(mockOauth, url, resp);
		
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockOauth);
		
		Contact contact = target.getContact(1);
		Assert.assertNotNull(contact);
		Assert.assertNotNull(contact.getEmailAddresses());
		Assert.assertEquals(1, contact.getEmailAddresses().size());
		Assert.assertEquals(TEST_EMAIL, contact.getEmailAddresses().get(0).getEmailAddress());
	}
	
	@Test
	public void getListsTest(){
		ICtcOAuth2 mockAuth = buildAuthMock();
		CUrlResponse resp = new CUrlResponse();
		Formatter formatter = new Formatter();
		resp.setBody(formatter.format("[%1$s, %2$s, %3$s]", list1, list2, list3).toString());
		String url = Config.Endpoints.BASE_URL + Config.Endpoints.LISTS;
		IRestClient mockRest = buildRestMockForGet(mockAuth, url, resp);
		
		IListService listService = new ListService();
		listService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setListService(listService);
		target.setOAuth(mockAuth);
		
		List<ContactList> lists = target.getLists();
		Assert.assertNotNull(lists);
		Assert.assertEquals(3, lists.size());
	}
	
	@Test
	public void getListTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		CUrlResponse resp = new CUrlResponse();
		resp.setBody(list1);
		int listId = 1;
		Formatter urlFormatter = new Formatter();
		String url = Config.Endpoints.BASE_URL + urlFormatter.format(Config.Endpoints.LIST, listId);
		IRestClient mockRest = buildRestMockForGet(mockAuth, url, resp);
		
		IListService listService = new ListService();
		listService.setRestClient(mockRest);
		
		ConstantContact target = new ConstantContact();
		target.setListService(listService);
		target.setOAuth(mockAuth);
		
		ContactList list = target.getList(listId);
		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.getId());
		Assert.assertEquals(Status.ACTIVE, list.getStatus());
	}  
	
	@Test
	public void updateContactTest() {
		ICtcOAuth2 mockAuth = buildAuthMock();
		CUrlResponse resp = new CUrlResponse();
		resp.setBody(contact1);
		IRestClient mockRest = buildRestMockForPut(mockAuth, resp);
		IContactService contactService = new ContactService();
		contactService.setRestClient(mockRest);
		ConstantContact target = new ConstantContact();
		target.setContactService(contactService);
		target.setOAuth(mockAuth);
		Contact updateContact = target.updateContact(new Contact());
		Assert.assertNotNull(updateContact);
		Assert.assertNotNull(updateContact.getEmailAddresses());
		Assert.assertEquals(1, updateContact.getEmailAddresses().size());
		Assert.assertEquals(TEST_EMAIL, updateContact.getEmailAddresses().get(0).getEmailAddress());
	}
	
	private IRestClient buildRestMockForGet(ICtcOAuth2 mockOauth, String url, CUrlResponse resp) {
		IRestClient mockRest = EasyMock.createMock(IRestClient.class);
		EasyMock.expect(mockRest.get(url, mockOauth.getAccessToken())).andReturn(resp);
		EasyMock.replay(mockRest);
		return mockRest;
	}

	private IRestClient buildRestMockForPost(ICtcOAuth2 mockAuth, CUrlResponse resp) {
		IRestClient mockRest = EasyMock.createMock(IRestClient.class);
		EasyMock.expect(mockRest.post(EasyMock.anyObject(String.class), EasyMock.eq(mockAuth.getAccessToken()), EasyMock.anyObject(String.class))).andReturn(resp);
		EasyMock.replay(mockRest);
		return mockRest;
	}
	
	private IRestClient buildRestMockForPut(ICtcOAuth2 mockAuth, CUrlResponse resp) {
		IRestClient mockRest = EasyMock.createMock(IRestClient.class);
		EasyMock.expect(mockRest.put(EasyMock.anyObject(String.class), EasyMock.eq(mockAuth.getAccessToken()), EasyMock.anyObject(String.class))).andReturn(resp);
		EasyMock.replay(mockRest);
		return mockRest;
	}
	
	private ICtcOAuth2 buildAuthMock() {
		ICtcOAuth2 mockOauth = EasyMock.createMock(ICtcOAuth2.class);
		EasyMock.expect(mockOauth.getAccessToken()).andReturn("access_token").anyTimes();
		EasyMock.replay(mockOauth);
		return mockOauth;
	}
	
	private IRestClient buildRestMockForDelete(ICtcOAuth2 mockAuth) {
		CUrlResponse response = new CUrlResponse();
		response.setStatusCode(HttpStatus.SC_NO_CONTENT);
		IRestClient mockRest = EasyMock.createMock(IRestClient.class);
		EasyMock.expect(mockRest.delete(EasyMock.anyObject(String.class), EasyMock.eq(mockAuth.getAccessToken()))).andReturn(response);
		EasyMock.replay(mockRest);
		return mockRest;
	}
}
