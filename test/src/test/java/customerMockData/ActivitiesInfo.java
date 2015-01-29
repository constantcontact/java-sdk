package customerMockData;

import com.constantcontact.components.activities.contacts.request.AddContactsRequest;
import com.constantcontact.components.activities.contacts.request.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Data used to test the activity functionality.<br/>
 *
 * @author ConstantContact
 */
public class ActivitiesInfo {

    private AddContactsRequest addContactsRequest;

    /**
     * Custom constructor that sets the fields of the AddContactRequest object
     * used to test the activity functionality
     *
     */
    public ActivitiesInfo(){
        addContactsRequest = new AddContactsRequest();
        List<String> lists = new ArrayList<String>();
        lists.add("13");
        addContactsRequest.setLists(lists);
        List<String> columnNames = new ArrayList<String>();
        columnNames.add("EMAIL");
        columnNames.add("FIRST NAME");
        addContactsRequest.setColumnNames(columnNames);
        List<ContactData> contactDataList = new ArrayList<ContactData>();

        ContactData contactData = new ContactData();
        List<String> emailAddresses = new ArrayList<String>();
        emailAddresses.add("john.doe@constantcontact.com");
        contactData.setEmailAddresses(emailAddresses);
        contactData.setFirstName("John");

        contactDataList.add(contactData);

        contactData = new ContactData();
        emailAddresses = new ArrayList<String>();
        emailAddresses.add("jane.doe@constantcontact.com");
        contactData.setEmailAddresses(emailAddresses);
        contactData.setFirstName("Jane");

        contactDataList.add(contactData);

        addContactsRequest.setImportData(contactDataList);
    }

    /**
     * Gets the add contact request
     * @return The AddContactRequest object
     *
     */
    public AddContactsRequest getAddContactsRequest() {
        return addContactsRequest;
    }

    /**
     * Sets the add contact request
     * @param addContactsRequest The AddContactRequest object
     */
    public void setAddContactsRequest(AddContactsRequest addContactsRequest) {
        this.addContactsRequest = addContactsRequest;
    }



}
