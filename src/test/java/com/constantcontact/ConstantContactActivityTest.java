package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.activities.contacts.request.AddContactsRequest;
import com.constantcontact.components.activities.contacts.request.ClearListsRequest;
import com.constantcontact.components.activities.contacts.request.ExportContactsRequest;
import com.constantcontact.components.activities.contacts.request.RemoveContactsRequest;
import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.components.activities.contacts.response.DetailedStatusReport;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.activities.IBulkActivitiesService;
import com.constantcontact.util.http.MultipartBody;
import com.constantcontact.util.http.MultipartBuilder;

/**
 * Constant Contact Bulk Activity unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactActivityTest {

    private ConstantContactFactoryMock constantContactFactoryMock;
    private IBulkActivitiesService bulkActivitiesServiceMock;

    private ConstantContactFactory constantContactFactory;
    private IBulkActivitiesService bulkActivitiesService;
    
    @Before
    public void beforeTests(){
    	constantContactFactoryMock = Mockito.spy(new ConstantContactFactoryMock("",""));
    	bulkActivitiesServiceMock = constantContactFactoryMock.createBulkActivitiesService();
    	
    	constantContactFactory = Mockito.spy(new ConstantContactFactory("",""));
    	bulkActivitiesService = constantContactFactory.createBulkActivitiesService();
    }

     /**
      * Tests the add bulk contacts functionality
      *
      */
     @Test
     public void addBulkContactsTest() {

        try {
            AddContactsRequest addContactsRequest = mock(AddContactsRequest.class);

            ContactsResponse contactsResponse = new ContactsResponse();
 
            contactsResponse = bulkActivitiesServiceMock.addContacts(addContactsRequest);
            verify(bulkActivitiesServiceMock).addContacts(addContactsRequest);

            assertNotNull(contactsResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the addBulkContacts method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addBulkContactsExceptionTest() {

        try {
            AddContactsRequest addContactsRequest = null;

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.addContacts(addContactsRequest);
            verify(bulkActivitiesServiceMock).addContacts(addContactsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }
    
    /**
     * Tests that the addBulkContacts method throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void addBulkContactsServiceExceptionTest() throws ConstantContactServiceException {

            AddContactsRequest addContactsRequest = new AddContactsRequest();

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesService.addContacts(addContactsRequest);
    }

    /**
     * Tests the remove bulk contacts functionality
     *
     */
    @Test
    public void removeBulkContactsTest() {
        RemoveContactsRequest removeContactsRequest = mock(RemoveContactsRequest.class);

        try {

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.removeContactsFromLists(removeContactsRequest);
            verify(bulkActivitiesServiceMock).removeContactsFromLists(removeContactsRequest);

            assertNotNull(contactsResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the removeBulkContactsFromLists methods throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void removeBulkContactsExceptionTest() {
        RemoveContactsRequest removeContactsRequest = null;

        try {

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.removeContactsFromLists(removeContactsRequest);
            verify(bulkActivitiesServiceMock).removeContactsFromLists(removeContactsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests that the removeBulkContactsFromLists methods throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void removeBulkContactsCommunicationExceptionTest() throws ConstantContactServiceException {
        	RemoveContactsRequest removeContactsRequest = new RemoveContactsRequest();

        	ContactsResponse contactsResponse = new ContactsResponse();

        	contactsResponse = bulkActivitiesService.removeContactsFromLists(removeContactsRequest);
    }

    /**
     * Tests the export bulk contacts functionality (export to a CVS file)
     *
     */
    @Test
    public void exportToCVSTest() {
        ExportContactsRequest exportContactsRequest = mock(ExportContactsRequest.class);
        try {

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.exportContacts(exportContactsRequest);
            verify(bulkActivitiesServiceMock).exportContacts(exportContactsRequest);

            assertNotNull(contactsResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the exportBulkContacts method throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void exportToCVSExceptionTest() {
        ExportContactsRequest exportContactsRequest = null;
        try {

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.exportContacts(exportContactsRequest);
            verify(bulkActivitiesServiceMock).exportContacts(exportContactsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests that the exportBulkContacts method throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void exportToCVSServerExceptionTest() throws ConstantContactServiceException {
        ExportContactsRequest exportContactsRequest = new ExportContactsRequest();

        ContactsResponse contactsResponse = new ContactsResponse();

        contactsResponse = bulkActivitiesService.exportContacts(exportContactsRequest);
    }

    /**
     * Tests the clear bulk contacts functionality
     *
     */
    @Test
    public void clearBulkContactsTest() {
        ClearListsRequest clearListsRequest = mock(ClearListsRequest.class);

        try {

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.clearLists(clearListsRequest);
            verify(bulkActivitiesServiceMock).clearLists(clearListsRequest);

            assertNotNull(contactsResponse);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the clearBulkContactsLists methods throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void clearBulkContactsExceptionTest() {
        ClearListsRequest clearListsRequest = null;

        try {

            ContactsResponse contactsResponse = new ContactsResponse();

            contactsResponse = bulkActivitiesServiceMock.clearLists(clearListsRequest);
            verify(bulkActivitiesServiceMock).clearLists(clearListsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests that the clearBulkContactsLists methods throws the proper exception
     * @throws ConstantContactServiceException 
     *
     */
    @Test(expected = ConstantContactServiceException.class)
    public void clearBulkContactsServerExceptionTest() throws ConstantContactServiceException {
        ClearListsRequest clearListsRequest = new ClearListsRequest();

        ContactsResponse contactsResponse = new ContactsResponse();

        contactsResponse = bulkActivitiesService.clearLists(clearListsRequest);
    }

    /**
     * Tests the add bulk contacts multipart functionality
     */
    @Test
    public void addContactsMultipartTest(){

        try {

            File file = new File("test.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write("test");
            output.close();


            ContactsResponse contactsResponse = mock(ContactsResponse.class);
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("1");

    	    Map<String,String> textParts = new HashMap<String,String>();
    	    StringBuilder lists = new StringBuilder();
    
    	    lists.append(arrayList.remove(0));
    	    for (String list : arrayList){
    	        lists.append(",");
    	        lists.append(list);
    	    }
    
    	    textParts.put("lists", lists.toString());
    
    	    InputStream fileStream = new FileInputStream(file);
    
    	    MultipartBody request = MultipartBuilder.buildMultipartBody(textParts, file.getName(), fileStream);
            
            contactsResponse = bulkActivitiesServiceMock.addContacts(request);
            verify(bulkActivitiesServiceMock).addContacts(request);

            assertNotNull(contactsResponse);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the remove bulk contacts multipart functionality
     */
    @Test
    public void removeContactsMultipart(){

        try {

            File file = new File("test.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write("test");
            output.close();

            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("1");

  
	        Map<String, String> textParts = new HashMap<String, String>();
	        StringBuilder lists = new StringBuilder();
	  
	        lists.append(arrayList.remove(0));
	        for (String list : arrayList) {
	            lists.append(",");
	            lists.append(list);
	        }
	  
	        textParts.put("lists", lists.toString());
	  
	        InputStream fileStream = new FileInputStream(file);
	  
	        MultipartBody request = MultipartBuilder.buildMultipartBody(textParts, file.getName(), fileStream);
  
            ContactsResponse contactsResponse = bulkActivitiesServiceMock.removeContactsFromLists(request);
            verify(bulkActivitiesServiceMock).removeContactsFromLists(request);

            assertNotNull(contactsResponse);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getBulkSummaryReport method from ConstantContact.class
     */
    @Test
    public void getSummaryReportTest(){

        try {

            List<SummaryReport> summaryReportList = new ArrayList<SummaryReport>();

            summaryReportList = bulkActivitiesServiceMock.getSummaryReport();
            verify(bulkActivitiesServiceMock).getSummaryReport();

            assertNotNull(summaryReportList);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the getBulkDetailedStatusReport method from ConstantContact.class
     */
    @Test
    public void getBulkDetailedStatusReportTest(){
        String status = "status";
        String type = "type";
        String id = "id";

        try {

            DetailedStatusReport detailedStatusReport;

            detailedStatusReport = bulkActivitiesServiceMock.getDetailedStatusReport(id);
            verify(bulkActivitiesServiceMock).getDetailedStatusReport(id);

            assertNotNull(detailedStatusReport);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
