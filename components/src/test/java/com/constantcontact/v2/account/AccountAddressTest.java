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
public class AccountAddressTest {
    private static final String LINE1 = "742 Evergreen Terrace";

    private static final String LINE2 = "Apt B2";

    private static final String LINE3 = "One More Line";

    private static final String CITY = "Springfield";

    private static final String STATE = "North Dakota";

    private static final String STATE_CODE = "ND";

    private static final String POSTAL_CODE = "58501";

    static AccountAddress createAccountAddress() {
        AccountAddress accountAddress = new AccountAddress();
        accountAddress.setLine1(LINE1);
        accountAddress.setLine2(LINE2);
        accountAddress.setLine3(LINE3);
        accountAddress.setCity(CITY);
        accountAddress.setState(STATE);
        accountAddress.setStateCode(STATE_CODE);
        accountAddress.setPostalCode(POSTAL_CODE);
        return accountAddress;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        AccountAddress accountAddress = new AccountAddress();

        accountAddress.setLine1(LINE1);
        accountAddress.setLine2(LINE2);
        accountAddress.setLine3(LINE3);
        accountAddress.setCity(CITY);
        accountAddress.setState(STATE);
        accountAddress.setStateCode(STATE_CODE);
        accountAddress.setPostalCode(POSTAL_CODE);

        runAssertations(accountAddress);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        AccountAddress accountAddress = new AccountAddress();
        accountAddress.setLine1(LINE1);
        accountAddress.setLine2(LINE2);
        accountAddress.setLine3(LINE3);
        accountAddress.setCity(CITY);
        accountAddress.setState(STATE);
        accountAddress.setStateCode(STATE_CODE);
        accountAddress.setPostalCode(POSTAL_CODE);

        AccountAddress out = SerializationUtils.roundtrip(accountAddress);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        AccountAddress accountAddress1 = new AccountAddress();
        accountAddress1.setLine1(LINE1);
        accountAddress1.setLine2(LINE2);
        accountAddress1.setLine3(LINE3);
        accountAddress1.setCity(CITY);
        accountAddress1.setState(STATE);
        accountAddress1.setStateCode(STATE_CODE);
        accountAddress1.setPostalCode(POSTAL_CODE);
        AccountAddress accountAddress2 = new AccountAddress();
        accountAddress2.setLine1(LINE1);
        accountAddress2.setLine2(LINE2);
        accountAddress2.setLine3(LINE3);
        accountAddress2.setCity(CITY);
        accountAddress2.setState(STATE);
        accountAddress2.setStateCode(STATE_CODE);
        accountAddress2.setPostalCode(POSTAL_CODE);

        int hash1 = accountAddress1.hashCode();
        int hash2 = accountAddress2.hashCode();

        assertThat(accountAddress1.equals(accountAddress2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(AccountAddress accountAddress) {
        assertThat(accountAddress.getLine1(), is(LINE1));
        assertThat(accountAddress.getLine2(), is(LINE2));
        assertThat(accountAddress.getLine3(), is(LINE3));
        assertThat(accountAddress.getCity(), is(CITY));
        assertThat(accountAddress.getState(), is(STATE));
        assertThat(accountAddress.getStateCode(), is(STATE_CODE));
        assertThat(accountAddress.getPostalCode(), is(POSTAL_CODE));
    }
}
