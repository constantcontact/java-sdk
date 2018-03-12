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

package com.constantcontact.v2.account;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class AccountEmailAddressTest {
    private static final String EMAIL = "null@dev.net";

    private static final AccountEmailAddressStatus STATUS = AccountEmailAddressStatus.CONFIRMED;

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        AccountEmailAddress accountEmailAddress = new AccountEmailAddress();

        accountEmailAddress.setEmailAddress(EMAIL);
        accountEmailAddress.setStatus(STATUS);

        runAssertations(accountEmailAddress);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        AccountEmailAddress accountEmailAddress = new AccountEmailAddress();
        accountEmailAddress.setEmailAddress(EMAIL);
        accountEmailAddress.setStatus(STATUS);

        AccountEmailAddress out = SerializationUtils.roundtrip(accountEmailAddress);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        AccountEmailAddress accountEmailAddress1 = new AccountEmailAddress();
        accountEmailAddress1.setEmailAddress(EMAIL);
        accountEmailAddress1.setStatus(STATUS);
        AccountEmailAddress accountEmailAddress2 = new AccountEmailAddress();
        accountEmailAddress2.setEmailAddress(EMAIL);
        accountEmailAddress2.setStatus(STATUS);

        int hash1 = accountEmailAddress1.hashCode();
        int hash2 = accountEmailAddress2.hashCode();

        assertThat(accountEmailAddress1.equals(accountEmailAddress2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    private void runAssertations(AccountEmailAddress accountEmailAddress) {
        assertThat(accountEmailAddress.getEmailAddress(), is(EMAIL));
        assertThat(accountEmailAddress.getStatus(), is(STATUS));
    }
}
