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

package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class SentToContactListTest {
    private static final String ID = "123";

    static SentToContactList createSentToContactList() {
        SentToContactList sentToContactList = new SentToContactList();
        sentToContactList.setId(ID);
        return sentToContactList;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        SentToContactList sentToContactList = new SentToContactList();

        sentToContactList.setId(ID);

        runAssertions(sentToContactList);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        SentToContactList sentToContactList = new SentToContactList();
        sentToContactList.setId(ID);

        SentToContactList out = SerializationUtils.roundtrip(sentToContactList);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        SentToContactList sentToContactList1 = new SentToContactList();
        sentToContactList1.setId(ID);
        SentToContactList sentToContactList2 = new SentToContactList();
        sentToContactList2.setId(ID);

        int hash1 = sentToContactList1.hashCode();
        int hash2 = sentToContactList2.hashCode();

        assertThat(sentToContactList1.equals(sentToContactList2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(SentToContactList sentToContactList) {
        assertThat(sentToContactList.getId(), is(ID));
    }
}
