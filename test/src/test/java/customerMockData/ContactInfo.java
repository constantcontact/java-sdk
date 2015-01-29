package customerMockData;

import com.constantcontact.components.contacts.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Data used to test the contact functionality.<br/>
 *
 * @author ConstantContact
 */
public class ContactInfo
{
    private Contact testContact;

    /**
     * Custom constructor that sets the fields of the Contact object
     * used to test the contact related functionality
     *
     */
    public ContactInfo() {

        Contact newContact = new Contact();
        newContact.setStatus("ACTIVE");
        newContact.setFax("555-1212");
        newContact.setConfirmed(false);
        newContact.setSource("API");
        newContact.setPrefixName("Mr.");
        newContact.setFirstName("John");
        newContact.setMiddleName("S");
        newContact.setLastName("Smith");
        newContact.setJobTitle("Software Engineer");
        newContact.setCompanyName("Constant Contact");
        newContact.setHomePhone("555-1212");
        newContact.setWorkPhone("555-1213");
        newContact.setCellPhone("555-1214");
        newContact.setSourceDetails("69f9d72b-0a5e-479d-b844-722b1da9595f");

        List<Address> addList = new ArrayList<Address>();
        Address contactAddress = new Address();
        contactAddress.setCity("Waltham");
        contactAddress.setLine1("1601 Trapelo Rd");
        contactAddress.setLine2("Suite 329");
        contactAddress.setLine3("Line 3");
        contactAddress.setAddressType("PERSONAL");
        contactAddress.setState("Massachusetts");
        contactAddress.setStateCode("MA");
        contactAddress.setCountryCode("us");
        contactAddress.setPostalCode("01720");
        contactAddress.setSubPostalCode("7885");
        addList.add(contactAddress);

        newContact.setAddresses(addList);

        List<CustomField> customFieldsList = new ArrayList<CustomField>();
        CustomField c1 = new CustomField();
        c1.setName("CustomField1");
        c1.setValue("3/28/2011 11:09 AM EDT");
        CustomField c2 = new CustomField();
        c2.setName("CustomField2");
        c2.setValue("Site owner");
        customFieldsList.add(c1);
        customFieldsList.add(c2);

        newContact.setCustomFields(customFieldsList);

        List<EmailAddress> emailAddList = new ArrayList<EmailAddress>();
        EmailAddress emailAdd =  new EmailAddress();
        emailAdd.setStatus("ACTIVE");
        emailAdd.setConfirmStatus("NO_CONFIRMATION_REQUIRED");
        emailAdd.setEmailAddress("john"+(new Date()).getTime()+"smith@gmail.com");
        emailAddList.add(emailAdd);

        newContact.setEmailAddresses(emailAddList);

        List<Note> notesList = new ArrayList<Note>();
        Note note = new Note();
        note.setId("1");
        note.setNote("Here are some cool notes to add");
        note.setCreatedDate("2012-12-03T17:09:22.702Z");
        notesList.add(note);
        newContact.setNotes(notesList);
        newContact.setNotes(notesList);
        List<ContactList> contactList = new ArrayList<ContactList>();
        ContactList cList = new ContactList();
        cList.setId("1");
        cList.setStatus("ACTIVE");
        contactList.add(cList);

        newContact.setLists(contactList);

        this.testContact = newContact;
    }

    /**
     * Gets the contact details
     * @return The Contact object
     */
    public Contact getTestContact() {
        return testContact;
    }

    /**
     * Sets the contact details
     * @param testContact The Contact object to be set
     */
    public void setTestContact(Contact testContact) {
        this.testContact = testContact;
    }
}
