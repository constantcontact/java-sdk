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
public class ContactListTest {
    private static final String ID = "123ABC";

    private static final int COUNT = 10;

    private static final Date DATE = new Date(0);

    private static final String NAME = "General Interest";

    private static final ContactListStatus STATUS = ContactListStatus.ACTIVE;

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ContactList contactList = new ContactList();

        contactList.setId(ID);
        contactList.setContactCount(COUNT);
        contactList.setCreatedDate(DATE);
        contactList.setModifiedDate(DATE);
        contactList.setName(NAME);
        contactList.setStatus(STATUS);

        runAssertions(contactList);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ContactList contactList = new ContactList();
        contactList.setId(ID);
        contactList.setContactCount(COUNT);
        contactList.setCreatedDate(DATE);
        contactList.setModifiedDate(DATE);
        contactList.setName(NAME);
        contactList.setStatus(STATUS);

        ContactList out = SerializationUtils.roundtrip(contactList);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        ContactList contactList1 = new ContactList();
        contactList1.setId(ID);
        contactList1.setContactCount(COUNT);
        contactList1.setCreatedDate(DATE);
        contactList1.setModifiedDate(DATE);
        contactList1.setName(NAME);
        contactList1.setStatus(STATUS);
        ContactList contactList2 = new ContactList();
        contactList2.setId(ID);
        contactList2.setContactCount(COUNT);
        contactList2.setCreatedDate(DATE);
        contactList2.setModifiedDate(DATE);
        contactList2.setName(NAME);
        contactList2.setStatus(STATUS);

        int hash1 = contactList1.hashCode();
        int hash2 = contactList2.hashCode();

        assertThat(contactList1.equals(contactList2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(ContactList contactList) {
        assertThat(contactList.getId(), is(ID));
        assertThat(contactList.getContactCount(), is(COUNT));
        assertThat(contactList.getCreatedDate(), is(DATE));
        assertThat(contactList.getModifiedDate(), is(DATE));
        assertThat(contactList.getName(), is(NAME));
        assertThat(contactList.getStatus(), is(STATUS));
    }
}
