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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class ContactListMetaDataTest {
    private static final String ID = "123ABC";

    private static final ContactListStatus STATUS = ContactListStatus.ACTIVE;

    static ContactListMetaData createContactListMetaData() {
        ContactListMetaData contactListMetaData = new ContactListMetaData();
        contactListMetaData.setId(ID);
        contactListMetaData.setStatus(STATUS);
        return contactListMetaData;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ContactListMetaData contactListMetaData = new ContactListMetaData();

        contactListMetaData.setId(ID);
        contactListMetaData.setStatus(STATUS);

        runAssertions(contactListMetaData);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ContactListMetaData contactListMetaData = new ContactListMetaData();
        contactListMetaData.setId(ID);
        contactListMetaData.setStatus(STATUS);

        ContactListMetaData out = SerializationUtils.roundtrip(contactListMetaData);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        ContactListMetaData contactListMetaData1 = new ContactListMetaData();
        contactListMetaData1.setId(ID);
        contactListMetaData1.setStatus(STATUS);
        ContactListMetaData contactListMetaData2 = new ContactListMetaData();
        contactListMetaData2.setId(ID);
        contactListMetaData2.setStatus(STATUS);

        int hash1 = contactListMetaData1.hashCode();
        int hash2 = contactListMetaData2.hashCode();

        assertThat(contactListMetaData1.equals(contactListMetaData2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(ContactListMetaData contactListMetaData) {
        assertThat(contactListMetaData.getId(), is(ID));
        assertThat(contactListMetaData.getStatus(), is(STATUS));
    }
}
