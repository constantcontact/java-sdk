/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.contacts;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
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

    @Test
    public void testEqualsAndHash() {
        Contact contact1 = new Contact();
        contact1.setId(ID);
        contact1.setCreatedDate(DATE);
        contact1.setInsertDate(DATE);
        contact1.setModifiedDate(DATE);
        contact1.setLastUpdateDate(DATE);
        contact1.setCellPhone(PHONE_CELL);
        contact1.setWorkPhone(PHONE_WORK);
        contact1.setFax(PHONE_FAX);
        contact1.setHomePhone(PHONE_HOME);
        contact1.setFirstName(FIRST_NAME);
        contact1.setLastName(LAST_NAME);
        contact1.setCompanyName(COMPANY);
        contact1.setJobTitle(JOB_TITLE);
        contact1.setDepartmentName(DEPARTMENT);
        contact1.setSourceDetails(SOURCE_DETAILS);
        contact1.setSource(SOURCE);
        contact1.setPrefixName(PREFIX);
        contact1.setStatus(STATUS);
        contact1.setAddresses(ADDRESSES);
        contact1.setContactLists(CONTACT_LISTS);
        contact1.setEmailAddresses(EMAIL_ADDRESSES);
        contact1.setNotes(NOTES);
        contact1.setCustomFields(CUSTOM_FIELDS);
        Contact contact2 = new Contact();
        contact2.setId(ID);
        contact2.setCreatedDate(DATE);
        contact2.setInsertDate(DATE);
        contact2.setModifiedDate(DATE);
        contact2.setLastUpdateDate(DATE);
        contact2.setCellPhone(PHONE_CELL);
        contact2.setWorkPhone(PHONE_WORK);
        contact2.setFax(PHONE_FAX);
        contact2.setHomePhone(PHONE_HOME);
        contact2.setFirstName(FIRST_NAME);
        contact2.setLastName(LAST_NAME);
        contact2.setCompanyName(COMPANY);
        contact2.setJobTitle(JOB_TITLE);
        contact2.setDepartmentName(DEPARTMENT);
        contact2.setSourceDetails(SOURCE_DETAILS);
        contact2.setSource(SOURCE);
        contact2.setPrefixName(PREFIX);
        contact2.setStatus(STATUS);
        contact2.setAddresses(ADDRESSES);
        contact2.setContactLists(CONTACT_LISTS);
        contact2.setEmailAddresses(EMAIL_ADDRESSES);
        contact2.setNotes(NOTES);
        contact2.setCustomFields(CUSTOM_FIELDS);

        int hash1 = contact1.hashCode();
        int hash2 = contact2.hashCode();

        assertThat(contact1.equals(contact2), is(true));
        assertThat(hash1 == hash2, is(true));
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
