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
public class EmailAddressTest {
    private static final String ID = "123ABC";

    private static final String EMAIL = "null@dev.net";

    private static final ConfirmStatus CONFIRM_STATUS = ConfirmStatus.CONFIRMED;

    private static final Date DATE = new Date(0);

    private static final OptInSource OPT_IN_SOURCE = OptInSource.ACTION_BY_VISITOR;

    private static final ContactStatus STATUS = ContactStatus.ACTIVE;

    static EmailAddress createEmailAddress() {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setId(ID);
        emailAddress.setEmailAddress(EMAIL);
        emailAddress.setConfirmStatus(CONFIRM_STATUS);
        emailAddress.setOptInDate(DATE);
        emailAddress.setOptInSource(OPT_IN_SOURCE);
        emailAddress.setOptOutDate(DATE);
        emailAddress.setStatus(STATUS);
        return emailAddress;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        EmailAddress emailAddress = new EmailAddress();

        emailAddress.setId(ID);
        emailAddress.setEmailAddress(EMAIL);
        emailAddress.setConfirmStatus(CONFIRM_STATUS);
        emailAddress.setOptInDate(DATE);
        emailAddress.setOptInSource(OPT_IN_SOURCE);
        emailAddress.setOptOutDate(DATE);
        emailAddress.setStatus(STATUS);

        runAssertions(emailAddress);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setId(ID);
        emailAddress.setEmailAddress(EMAIL);
        emailAddress.setConfirmStatus(CONFIRM_STATUS);
        emailAddress.setOptInDate(DATE);
        emailAddress.setOptInSource(OPT_IN_SOURCE);
        emailAddress.setOptOutDate(DATE);
        emailAddress.setStatus(STATUS);

        EmailAddress out = SerializationUtils.roundtrip(emailAddress);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        EmailAddress emailAddress1 = new EmailAddress();
        emailAddress1.setId(ID);
        emailAddress1.setEmailAddress(EMAIL);
        emailAddress1.setConfirmStatus(CONFIRM_STATUS);
        emailAddress1.setOptInDate(DATE);
        emailAddress1.setOptInSource(OPT_IN_SOURCE);
        emailAddress1.setOptOutDate(DATE);
        emailAddress1.setStatus(STATUS);
        EmailAddress emailAddress2 = new EmailAddress();
        emailAddress2.setId(ID);
        emailAddress2.setEmailAddress(EMAIL);
        emailAddress2.setConfirmStatus(CONFIRM_STATUS);
        emailAddress2.setOptInDate(DATE);
        emailAddress2.setOptInSource(OPT_IN_SOURCE);
        emailAddress2.setOptOutDate(DATE);
        emailAddress2.setStatus(STATUS);

        int hash1 = emailAddress1.hashCode();
        int hash2 = emailAddress2.hashCode();

        assertThat(emailAddress1.equals(emailAddress2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(EmailAddress emailAddress) {
        assertThat(emailAddress.getId(), is(ID));
        assertThat(emailAddress.getEmailAddress(), is(EMAIL));
        assertThat(emailAddress.getConfirmStatus(), is(CONFIRM_STATUS));
        assertThat(emailAddress.getOptInDate(), is(DATE));
        assertThat(emailAddress.getOptInSource(), is(OPT_IN_SOURCE));
        assertThat(emailAddress.getOptOutDate(), is(DATE));
        assertThat(emailAddress.getStatus(), is(STATUS));
    }
}
