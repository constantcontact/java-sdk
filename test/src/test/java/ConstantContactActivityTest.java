import com.constantcontact.ConstantContact;
import com.constantcontact.components.activities.contacts.request.*;
import com.constantcontact.components.activities.contacts.response.SummaryReport;
import com.constantcontact.components.contacts.ContactList;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import customerMockData.ActivitiesInfo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Constant Contact Bulk Activity unit test class.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactActivityTest {

    ConstantContact constantContact;
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
        constantContact = new ConstantContact(apiKey, accessToken);
    }

    @Test
    /**
     * Tests all bulk activity methods in Constant Contact
     *
     */
    public void bulkContactsTests() {
        ActivitiesInfo activitiesInfo = new ActivitiesInfo();

        AddContactsRequest addContactsRequest = activitiesInfo.getAddContactsRequest();
        try {

            List<String> lists = new ArrayList<String>();
            lists.add(getActivityListId());

            addContactsRequest.setLists(lists);

            //import contacts
            constantContact.addBulkContacts(addContactsRequest);

            //remove contacts
            removeBulkContacts(lists, addContactsRequest);

            //export contacts to cvs
            exportToCVS(lists, addContactsRequest);

            //add contacts multipart
            //addContactsMultipart(lists);

            //clear contacts list
            clearBulkContacts(lists);

            //activity status report
            List<SummaryReport> summaryReportList = constantContact.getBulkSummaryReport();

            assertFalse("The summary report should contain at least 5 activities", summaryReportList.size()<5);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Gets the Id of the Activity Test list
     * @return The Activity Test list Id
     *
     */
    public String getActivityListId() {
        String resultId = null;
        try {
            ContactList contactList = new ContactList();
            contactList.setName("Activity Test");
            contactList.setStatus("ACTIVE");
            ContactList result = constantContact.addList(contactList);
            resultId = result.getId();
        } catch (ConstantContactServiceException e) {
            List<ContactList> contactLists = new ArrayList<ContactList>();
            try {
                contactLists = constantContact.getLists(null);
                for (ContactList contactList : contactLists) {
                    if (contactList.getName().equals("Activity Test")) {
                        resultId = contactList.getId();
                    }
                }
            } catch (ConstantContactServiceException e1) {
                e1.printStackTrace();
            }
        }
        return resultId;
    }

    /**
     * Tests the removeBulkContactsFromLists method
     * @param lists The Ids of the contact lists from which bulk contacts are removed
     * @param addContactsRequest The AddContactRequest object that contains contacts to be removed from the lists
     *
     */
    private void removeBulkContacts(List<String> lists, AddContactsRequest addContactsRequest) {
        RemoveContactsRequest removeContactsRequest = new RemoveContactsRequest();
        removeContactsRequest.setLists(lists);

        List<ContactDataLightValue> contactDataLightValues = new ArrayList<ContactDataLightValue>();
        for (ContactData contactData : addContactsRequest.getImportData()) {
            ContactDataLightValue contactDataLightValue = new ContactDataLightValue();
            contactDataLightValue.setEmailAddresses(contactData.getEmailAddresses());
            contactDataLightValues.add(contactDataLightValue);
        }
        removeContactsRequest.setImportData(contactDataLightValues);

        try {
            constantContact.removeBulkContactsFromLists(removeContactsRequest);

            for(String listId : lists){
                ContactList list = constantContact.getList(listId);
                assertEquals("The list shouldn't contain any contacts", list.getContactCount(), 0);
            }
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the exportBulkContacts method
     * @param lists The Ids of the contact lists from which bulk contacts are exported
     * @param addContactsRequest The AddContactRequest object that contains contacts to be exported from the lists
     *
     */
    private void exportToCVS(List<String> lists, AddContactsRequest addContactsRequest) {
        ExportContactsRequest exportContactsRequest = new ExportContactsRequest();
        exportContactsRequest.setLists(lists);
        exportContactsRequest.setColumnNames(addContactsRequest.getColumnNames());
        exportContactsRequest.setFileType(ExportContactsRequest.FILE_TYPE_CSV);
        exportContactsRequest.setSortBy(ExportContactsRequest.SORT_BY_EMAIL_ADDRESS);
        try {
            constantContact.exportBulkContacts(exportContactsRequest);
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the clearBulkContactsLists method
     * @param lists The Ids of the contact lists from which bulk contacts are cleared
     *
     */
    private void clearBulkContacts(List<String> lists) {
        ClearListsRequest clearListsRequest = new ClearListsRequest();
        clearListsRequest.setLists(lists);

        try {
           constantContact.clearBulkContactsLists(clearListsRequest);

            for(String listId : lists){
                ContactList list = constantContact.getList(listId);
                assertEquals("The list shouldn't contain any contacts", list.getContactCount(), 0);
            }
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the add contacts multipart functionality
     * @param lists The Ids of the contact lists from which bulk contacts are added
     */
    private void addContactsMultipart(List<String> lists){

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("contacts.txt");
            writer.println("EMAIL FIRST NAME");
            writer.println("john.doe@constantcontact.com John");
            writer.println("jane.doe@constantcontact.com Jane");
            writer.close();

            File file = new File("contacts.txt");

            ArrayList<String> arrayList = new ArrayList<String>(lists);

            constantContact.addBulkContactsMultipart(file.getName(), file, arrayList);

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
}
