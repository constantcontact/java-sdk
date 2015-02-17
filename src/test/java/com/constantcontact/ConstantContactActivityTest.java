package com.constantcontact;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.activities.contacts.request.*;
import com.constantcontact.components.activities.contacts.response.ContactsResponse;
import com.constantcontact.components.activities.contacts.response.DetailedStatusReport;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.BulkActivitiesServiceMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

/**
 * Constant Contact Bulk Activity unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactActivityTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setBulkActivitiesService(new BulkActivitiesServiceMock());
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
            //import contacts
            contactsResponse = constantContact.addBulkContacts(addContactsRequest);
            verify(constantContact).addBulkContacts(addContactsRequest);

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
            //import contacts
            contactsResponse = constantContact.addBulkContacts(addContactsRequest);
            verify(constantContact).addBulkContacts(addContactsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
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

            contactsResponse = constantContact.removeBulkContactsFromLists(removeContactsRequest);
            verify(constantContact).removeBulkContactsFromLists(removeContactsRequest);

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

            contactsResponse = constantContact.removeBulkContactsFromLists(removeContactsRequest);
            verify(constantContact).removeBulkContactsFromLists(removeContactsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
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

            contactsResponse = constantContact.exportBulkContacts(exportContactsRequest);
            verify(constantContact).exportBulkContacts(exportContactsRequest);

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

            contactsResponse = constantContact.exportBulkContacts(exportContactsRequest);
            verify(constantContact).exportBulkContacts(exportContactsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
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

            contactsResponse = constantContact.clearBulkContactsLists(clearListsRequest);
            verify(constantContact).clearBulkContactsLists(clearListsRequest);

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

            contactsResponse = constantContact.clearBulkContactsLists(clearListsRequest);
            verify(constantContact).clearBulkContactsLists(clearListsRequest);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
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
            ArrayList arrayList = new ArrayList();
            arrayList.add("1");

            contactsResponse = constantContact.addBulkContactsMultipart(file.getName(), file, arrayList);
            verify(constantContact).addBulkContactsMultipart(file.getName(), file, arrayList);

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

            //File file = mock(File.class);

            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("1");
            ContactsResponse contactsResponse = constantContact.removeBulkContactsFromListsMultipart(file.getName(), file, arrayList);
            verify(constantContact).removeBulkContactsFromListsMultipart(file.getName(), file, arrayList);

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

            summaryReportList = constantContact.getBulkSummaryReport();
            verify(constantContact).getBulkSummaryReport();

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

            List<DetailedStatusReport> detailedStatusReportList = new ArrayList<DetailedStatusReport>();

            detailedStatusReportList = constantContact.getBulkDetailedStatusReport(status, type, id);
            verify(constantContact).getBulkDetailedStatusReport(status, type, id);

            assertNotNull(detailedStatusReportList);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }
}
