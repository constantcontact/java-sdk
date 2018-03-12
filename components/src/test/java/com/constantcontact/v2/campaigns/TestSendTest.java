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
public class TestSendTest {
    private static final String[] EMAILS = new String[]{"null@dev.net"};

    private static final EmailFormat FROMAT = EmailFormat.HTML_AND_TEXT;

    private static final String PERSONAL_MESSAGE = "hi";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        TestSend testSend = new TestSend();

        testSend.setEmailAddresses(EMAILS);
        testSend.setFormat(FROMAT);
        testSend.setPersonalMessage(PERSONAL_MESSAGE);

        runAssertions(testSend);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        TestSend testSend = new TestSend();
        testSend.setEmailAddresses(EMAILS);
        testSend.setFormat(FROMAT);
        testSend.setPersonalMessage(PERSONAL_MESSAGE);

        TestSend out = SerializationUtils.roundtrip(testSend);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        TestSend testSend1 = new TestSend();
        testSend1.setEmailAddresses(EMAILS);
        testSend1.setFormat(FROMAT);
        testSend1.setPersonalMessage(PERSONAL_MESSAGE);
        TestSend testSend2 = new TestSend();
        testSend2.setEmailAddresses(EMAILS);
        testSend2.setFormat(FROMAT);
        testSend2.setPersonalMessage(PERSONAL_MESSAGE);

        int hash1 = testSend1.hashCode();
        int hash2 = testSend2.hashCode();

        assertThat(testSend1.equals(testSend2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    private void runAssertions(TestSend testSend) {
        assertThat(testSend.getEmailAddresses(), is(EMAILS));
        assertThat(testSend.getFormat(), is(FROMAT));
        assertThat(testSend.getPersonalMessage(), is(PERSONAL_MESSAGE));
    }
}
