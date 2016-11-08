package com.constantcontact.v2.contacts;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ContactTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    private static final String PHONE_CELL = "111-111-1111";

    private static final String PHONE_WORK = "222-222-2222";

    private static final String PHONE_FAX = "333-333-3333";

    private static final String PHONE_HOME = "444-444-4444";

    private static final String FIRST_NAME = "Max";

    private static final String LAST_NAME = "Power";

    private static final String COMPANY = "Nucular Power Plant";

    private static final String JOB_TITLE = "Safety Inspector";

    private static final String DEPARTMENT = "Sector G";

    private static final String SOURCE_DETAILS = "Nowhere";

    private static final String SOURCE = "None";

    private static final String PREFIX = "Dr";

    private static final ContactStatus STATUS = ContactStatus.ACTIVE;

    private static final Address[] ADDRESSES = new Address[]{AddressTest.createAddress()};

    private static final ContactListMetaData[] CONTACT_LISTS = new ContactListMetaData[]{ContactListMetaDataTest
                                                                                                 .createContactListMetaData()};

    private static final CustomField[] CUSTOM_FIELDS = new CustomField[]{CustomFieldTest.createCustomField()};

    private static final EmailAddress[] EMAIL_ADDRESSES = new EmailAddress[]{EmailAddressTest.createEmailAddress()};

    private static final Note[] NOTES = new Note[]{NoteTest.createNote()};

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Contact contact = new Contact();

        contact.setId(ID);
        contact.setCreatedDate(DATE);
        contact.setInsertDate(DATE);
        contact.setModifiedDate(DATE);
        contact.setLastUpdateDate(DATE);
        contact.setCellPhone(PHONE_CELL);
        contact.setWorkPhone(PHONE_WORK);
        contact.setFax(PHONE_FAX);
        contact.setHomePhone(PHONE_HOME);
        contact.setFirstName(FIRST_NAME);
        contact.setLastName(LAST_NAME);
        contact.setCompanyName(COMPANY);
        contact.setJobTitle(JOB_TITLE);
        contact.setDepartmentName(DEPARTMENT);
        contact.setSourceDetails(SOURCE_DETAILS);
        contact.setSource(SOURCE);
        contact.setPrefixName(PREFIX);
        contact.setStatus(STATUS);
        contact.setAddresses(ADDRESSES);
        contact.setContactLists(CONTACT_LISTS);
        contact.setEmailAddresses(EMAIL_ADDRESSES);
        contact.setNotes(NOTES);
        contact.setCustomFields(CUSTOM_FIELDS);

        runAssertions(contact);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Contact contact = new Contact();
        contact.setId(ID);
        contact.setCreatedDate(DATE);
        contact.setInsertDate(DATE);
        contact.setModifiedDate(DATE);
        contact.setLastUpdateDate(DATE);
        contact.setCellPhone(PHONE_CELL);
        contact.setWorkPhone(PHONE_WORK);
        contact.setFax(PHONE_FAX);
        contact.setHomePhone(PHONE_HOME);
        contact.setFirstName(FIRST_NAME);
        contact.setLastName(LAST_NAME);
        contact.setCompanyName(COMPANY);
        contact.setJobTitle(JOB_TITLE);
        contact.setDepartmentName(DEPARTMENT);
        contact.setSourceDetails(SOURCE_DETAILS);
        contact.setSource(SOURCE);
        contact.setPrefixName(PREFIX);
        contact.setStatus(STATUS);
        contact.setAddresses(ADDRESSES);
        contact.setContactLists(CONTACT_LISTS);
        contact.setEmailAddresses(EMAIL_ADDRESSES);
        contact.setNotes(NOTES);
        contact.setCustomFields(CUSTOM_FIELDS);

        Contact out = SerializationUtils.roundtrip(contact);

        runAssertions(out);
    }

    private void runAssertions(Contact contact) {
        assertThat(contact.getId(), is(ID));
        assertThat(contact.getCreatedDate(), is(DATE));
        assertThat(contact.getInsertDate(), is(DATE));
        assertThat(contact.getModifiedDate(), is(DATE));
        assertThat(contact.getLastUpdateDate(), is(DATE));
        assertThat(contact.getCellPhone(), is(PHONE_CELL));
        assertThat(contact.getWorkPhone(), is(PHONE_WORK));
        assertThat(contact.getFax(), is(PHONE_FAX));
        assertThat(contact.getHomePhone(), is(PHONE_HOME));
        assertThat(contact.getFirstName(), is(FIRST_NAME));
        assertThat(contact.getLastName(), is(LAST_NAME));
        assertThat(contact.getCompanyName(), is(COMPANY));
        assertThat(contact.getJobTitle(), is(JOB_TITLE));
        assertThat(contact.getDepartmentName(), is(DEPARTMENT));
        assertThat(contact.getSourceDetails(), is(SOURCE_DETAILS));
        assertThat(contact.getSource(), is(SOURCE));
        assertThat(contact.getPrefixName(), is(PREFIX));
        assertThat(contact.getStatus(), is(STATUS));
        AddressTest.runAssertions(contact.getAddresses()[0]);
        ContactListMetaDataTest.runAssertions(contact.getContactLists()[0]);
        EmailAddressTest.runAssertions(contact.getEmailAddresses()[0]);
        NoteTest.runAssertions(contact.getNotes()[0]);
        CustomFieldTest.runAssertions(contact.getCustomFields()[0]);
    }
}
