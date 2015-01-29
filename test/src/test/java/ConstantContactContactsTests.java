import com.constantcontact.ConstantContact;
import com.constantcontact.components.contacts.Contact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import customerMockData.ContactInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Constant Contact Contacts unit test class.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactContactsTests {

    private ConstantContact constantContact;
    private String apiKey;
    private String accessToken;

    @Before
    /**
     * Sets the apy key and the access token
     * Instantiates the ConstantContact object that contains tested methods
     *
     */
    public void setKeys()
    {
        this.apiKey = System.getProperty("apiKey");
        this.accessToken = System.getProperty("accessToken");
        constantContact = new ConstantContact(apiKey,accessToken);
    }

    @Test
    /**
     * Tests the addContact method and verifies if the result has the same fields as the provided contact
     *
     */
    public void contactsTest(){

        //add contact
        Contact result = addContactTest();

        //get contacts and see if the previously added contact is retrieved
        getContactsTest(result);

        //update contact
        updateContactTest(result.getId());

        //delete contact
        deleteContactTest(result.getId());
    }

    /**
     * Tests the add contact functionality
     * @return The added contact
     *
     */
    private Contact addContactTest() {
        ContactInfo contactInfo = new ContactInfo();
        Contact result = null;
        try {
            result = constantContact.addContact(contactInfo.getTestContact(),true);
            getContactTest(result.getId());

            assertEquals("The retrieved contact first name(" + result.getFirstName() + ") is different from the first name provided(" +
                    contactInfo.getTestContact().getFirstName() + ")", result.getFirstName(), contactInfo.getTestContact().getFirstName());
            assertEquals("The retrieved contact cell phone(" + result.getCellPhone() + ") is different from the cell phone provided(" +
                    contactInfo.getTestContact().getCellPhone() + ")", result.getCellPhone(), contactInfo.getTestContact().getCellPhone());
            assertEquals("The retrieved contact company name(" + result.getCompanyName() + ") is different from the company name provided(" +
                    contactInfo.getTestContact().getCompanyName() + ")", result.getCompanyName(), contactInfo.getTestContact().getCompanyName());
            assertEquals("The retrieved contact fax number(" + result.getFax() + ") is different from the fax number provided(" +
                    contactInfo.getTestContact().getFax() + ")", result.getFax(), contactInfo.getTestContact().getFax());
            assertEquals("The retrieved work phone(" + result.getWorkPhone() + ") is different from the work phone provided(" +
                    contactInfo.getTestContact().getWorkPhone()+")", result.getHomePhone(), contactInfo.getTestContact().getHomePhone());
            assertEquals("The retrieved contact job title(" + result.getJobTitle() + ") is different from the job title provided(" +
                    contactInfo.getTestContact().getJobTitle() + ")", result.getJobTitle(), contactInfo.getTestContact().getJobTitle());
            assertEquals("The retrieved contact middle name(" + result.getMiddleName() + ") is different from the middle name provided(" +
                    contactInfo.getTestContact().getMiddleName() + ")", result.getMiddleName(), contactInfo.getTestContact().getMiddleName());
            assertEquals("The retrieved contact prefix name(" + result.getPrefixName() + ") is different from the prefix name provided(" +
                    contactInfo.getTestContact().getPrefixName() + ")", result.getPrefixName(), contactInfo.getTestContact().getPrefixName());
            assertEquals("The retrieved contact source(" + result.getSource() + ") is different from the source provided(" +
                    contactInfo.getTestContact().getSource() + ")", result.getSource(), contactInfo.getTestContact().getSource());
            assertEquals("The retrieved work phone(" + result.getWorkPhone() + " is different from the work phone provided(" +
                    contactInfo.getTestContact().getWorkPhone()+")", result.getWorkPhone(), contactInfo.getTestContact().getWorkPhone());
        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Tests the getContact method for the contact added previously and verifies if it has the same field values
     * @param contactId The id of the contact added before, provided for the getContact method
     *
     */
    private void getContactTest(String contactId){
        ContactInfo contactInfo = new ContactInfo();
        Contact result = null;
        try {
            result = constantContact.getContact(contactId);
        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
        assertEquals("The retrieved contact first name(" + result.getFirstName() + ") is different from the first name provided(" +
                        contactInfo.getTestContact().getFirstName() + ")", result.getFirstName(), contactInfo.getTestContact().getFirstName());
        assertEquals("The retrieved contact cell phone is different from the cell phone provided",
                result.getCellPhone(), contactInfo.getTestContact().getCellPhone());
        assertEquals("The retrieved contact company name is different from the company name provided",
                result.getCompanyName(), contactInfo.getTestContact().getCompanyName());
        assertNotEquals("The retrieved contact created date is different from the created date provided",
                result.getCreatedDate(), contactInfo.getTestContact().getCreatedDate());
        assertEquals("The retrieved contact fax number is different from the fax number provided",
                result.getFax(), contactInfo.getTestContact().getFax());
        assertEquals("The retrieved work phone: " + result.getWorkPhone() + " is different from the work phone provided " +
                        contactInfo.getTestContact().getWorkPhone(), result.getWorkPhone(), contactInfo.getTestContact().getWorkPhone());
        assertEquals("The retrieved contact job title(" + result.getJobTitle() + ") is different from the job title provided(" +
                        contactInfo.getTestContact().getJobTitle() + ")", result.getJobTitle(), contactInfo.getTestContact().getJobTitle());
        assertEquals("The retrieved contact middle name(" + result.getMiddleName() + ") is different from the middle name provided(" +
                        contactInfo.getTestContact().getMiddleName() + ")", result.getMiddleName(), contactInfo.getTestContact().getMiddleName());
        assertEquals("The retrieved contact prefix name is different from the prefix name provided",
                result.getPrefixName(), contactInfo.getTestContact().getPrefixName());
        assertEquals("The retrieved contact source is different from the source provided",
                result.getSource(), contactInfo.getTestContact().getSource());
        assertEquals("The retrieved work phone: " + result.getWorkPhone() + " is different from the work phone provided " +
                        contactInfo.getTestContact().getWorkPhone(),
                result.getWorkPhone(), contactInfo.getTestContact().getWorkPhone());
    }

    /**
     * Tests the functionality of the updateContact method and the results of the update
     * @param contactId This is the contact id of the contact to update (the one added before)
     *
     */
    private void updateContactTest(String contactId){
        ContactInfo contactInfo = new ContactInfo();
        Contact contactToUpdate = null;
        Contact result = null;
        try {
            contactToUpdate = constantContact.getContact(contactId);
            contactToUpdate.setCellPhone("55-11-22");
            result = constantContact.updateContact(contactToUpdate);

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
        assertEquals("The retrieved contact first name is different from the first name provided",
                result.getFirstName(), contactInfo.getTestContact().getFirstName());
        assertNotEquals("The retrieved contact cell phone is different from the cell phone provided",
                result.getCellPhone(), contactInfo.getTestContact().getCellPhone());
        assertEquals("The retrieved contact company name is different from the company name provided",
                result.getCompanyName(), contactInfo.getTestContact().getCompanyName());
        assertNotEquals("The retrieved contact created date is different from the created date provided",
                result.getCreatedDate(), contactInfo.getTestContact().getCreatedDate());
        assertEquals("The retrieved contact fax number is different from the fax number provided",
                result.getFax(), contactInfo.getTestContact().getFax());
        assertEquals("The retrieved work phone: " + result.getWorkPhone() + " is different from the work phone provided " +
                        contactInfo.getTestContact().getWorkPhone(),
                result.getWorkPhone(), contactInfo.getTestContact().getWorkPhone());
        assertEquals("The retrieved contact job title is different from the job title provided",
                result.getJobTitle(), contactInfo.getTestContact().getJobTitle());
        assertEquals("The retrieved contact middle name is different from the middle name provided",
                result.getMiddleName(), contactInfo.getTestContact().getMiddleName());
        assertEquals("The retrieved contact prefix name is different from the prefix name provided",
                result.getPrefixName(), contactInfo.getTestContact().getPrefixName());
        assertEquals("The retrieved contact source is different from the source provided",
                result.getSource(), contactInfo.getTestContact().getSource());
        assertEquals("The retrieved work phone: " + result.getWorkPhone() + " is different from the work phone provided " +
                        contactInfo.getTestContact().getWorkPhone(),
                result.getWorkPhone(), contactInfo.getTestContact().getWorkPhone());
    }

    /**
     * Tests the functionality of the deleteContact method and the possibility of opting a contact back in
     * @param contactId This is the id of the contact to be deleted
     *
     */
    private void deleteContactTest(String contactId){

        try {
            constantContact.deleteContact(contactId);
            assertEquals("The contact was not removed.", constantContact.getContact(contactId).getStatus(), Contact.Status.OPTOUT.toString());

        } catch (ConstantContactServiceException e) {
            System.out.println(e.getErrorInfo());
            e.printStackTrace();
        }
    }

    /**
     * Tests the get contacts functionality
     * @param contact A contact object used to verify the consistency of the retrieved data
     */
    private void getContactsTest(Contact contact){
        ResultSet<Contact> contactResultSet = null;
        try {
            contactResultSet = constantContact.getContacts(2, null, Contact.Status.ACTIVE);
            for(int i = 0 ; i<contactResultSet.size() ; i++){
                if(contactResultSet.get(i).getId().equals(contact.getId())){
                    assertEquals("The retrieved contact first name is different from the first name provided",
                            contactResultSet.get(i).getFirstName(), contact.getFirstName());
                    assertEquals("The retrieved contact cell phone " + contactResultSet.get(i).getCellPhone() + " is different from the cell phone provided " + contact.getCellPhone(),
                            contactResultSet.get(i).getCellPhone(), contact.getCellPhone());
                    assertEquals("The retrieved contact company name is different from the company name provided",
                            contactResultSet.get(i).getCompanyName(), contact.getCompanyName());
                    assertNotEquals("The retrieved contact created date is different from the created date provided",
                            contactResultSet.get(i).getCreatedDate(), contact.getCreatedDate());
                    assertEquals("The retrieved contact fax number is different from the fax number provided",
                            contactResultSet.get(i).getFax(), contact.getFax());
                    assertEquals("The retrieved work phone: " + contactResultSet.get(i).getWorkPhone() + " is different from the work phone provided " +
                                    contact.getWorkPhone(),
                            contactResultSet.get(i).getWorkPhone(), contact.getWorkPhone());
                    assertEquals("The retrieved contact job title is different from the job title provided",
                            contactResultSet.get(i).getJobTitle(), contact.getJobTitle());
                    assertEquals("The retrieved contact middle name is different from the middle name provided",
                            contactResultSet.get(i).getMiddleName(), contact.getMiddleName());
                    assertEquals("The retrieved contact prefix name is different from the prefix name provided",
                            contactResultSet.get(i).getPrefixName(), contact.getPrefixName());
                    assertEquals("The retrieved contact source is different from the source provided",
                            contactResultSet.get(i).getSource(), contact.getSource());
                    assertEquals("The retrieved work phone: " + contactResultSet.get(i).getWorkPhone() + " is different from the work phone provided " +
                                    contact.getWorkPhone(),
                            contactResultSet.get(i).getWorkPhone(), contact.getWorkPhone());
                }
            }
        } catch (ConstantContactServiceException e) {
            e.getErrorInfo();
            e.printStackTrace();
        }
    }

}