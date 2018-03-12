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
public class AccountSummaryInformationTest {
    private static final String EMAIL = "null@dev.net";

    private static final String FIRST_NAME = "Max";

    private static final String LAST_NAME = "Power";

    private static final String STATE_CODE = "ND";

    private static final String COUNTRY_CODE = "US";

    private static final String COMPANY_LOGO = "http://news.constantcontact.com/sites/constantcontact.newshq.businesswire" +
                                               ".com/files/imagecache/logo_listview_thumb/logo/image/constantcontact_tagline_600.png";

    private static final String ORGANIZATION_NAME = "Nucular Power Plant";

    private static final String PHONE = "111-222-3333";

    private static final String TIME_ZONE = "EST";

    private static final String WEBSITE = "http://constantcontact.com";

    private static final AccountAddress[] ACCOUNT_ADDRESSES = new AccountAddress[]{AccountAddressTest.createAccountAddress()};

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        AccountSummaryInformation accountSummaryInformation = new AccountSummaryInformation();

        accountSummaryInformation.setEmail(EMAIL);
        accountSummaryInformation.setFirstName(FIRST_NAME);
        accountSummaryInformation.setLastName(LAST_NAME);
        accountSummaryInformation.setStateCode(STATE_CODE);
        accountSummaryInformation.setCountryCode(COUNTRY_CODE);
        accountSummaryInformation.setCompanyLogo(COMPANY_LOGO);
        accountSummaryInformation.setOrganizationName(ORGANIZATION_NAME);
        accountSummaryInformation.setPhone(PHONE);
        accountSummaryInformation.setTimeZone(TIME_ZONE);
        accountSummaryInformation.setWebsite(WEBSITE);
        accountSummaryInformation.setOrganizationAddresses(ACCOUNT_ADDRESSES);

        runAssertions(accountSummaryInformation);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        AccountSummaryInformation accountSummaryInformation = new AccountSummaryInformation();
        accountSummaryInformation.setEmail(EMAIL);
        accountSummaryInformation.setFirstName(FIRST_NAME);
        accountSummaryInformation.setLastName(LAST_NAME);
        accountSummaryInformation.setStateCode(STATE_CODE);
        accountSummaryInformation.setCountryCode(COUNTRY_CODE);
        accountSummaryInformation.setCompanyLogo(COMPANY_LOGO);
        accountSummaryInformation.setOrganizationName(ORGANIZATION_NAME);
        accountSummaryInformation.setPhone(PHONE);
        accountSummaryInformation.setTimeZone(TIME_ZONE);
        accountSummaryInformation.setWebsite(WEBSITE);
        accountSummaryInformation.setOrganizationAddresses(ACCOUNT_ADDRESSES);

        AccountSummaryInformation out = SerializationUtils.roundtrip(accountSummaryInformation);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        AccountSummaryInformation accountSummaryInformation1 = new AccountSummaryInformation();
        accountSummaryInformation1.setEmail(EMAIL);
        accountSummaryInformation1.setFirstName(FIRST_NAME);
        accountSummaryInformation1.setLastName(LAST_NAME);
        accountSummaryInformation1.setStateCode(STATE_CODE);
        accountSummaryInformation1.setCountryCode(COUNTRY_CODE);
        accountSummaryInformation1.setCompanyLogo(COMPANY_LOGO);
        accountSummaryInformation1.setOrganizationName(ORGANIZATION_NAME);
        accountSummaryInformation1.setPhone(PHONE);
        accountSummaryInformation1.setTimeZone(TIME_ZONE);
        accountSummaryInformation1.setWebsite(WEBSITE);
        accountSummaryInformation1.setOrganizationAddresses(ACCOUNT_ADDRESSES);
        AccountSummaryInformation accountSummaryInformation2 = new AccountSummaryInformation();
        accountSummaryInformation2.setEmail(EMAIL);
        accountSummaryInformation2.setFirstName(FIRST_NAME);
        accountSummaryInformation2.setLastName(LAST_NAME);
        accountSummaryInformation2.setStateCode(STATE_CODE);
        accountSummaryInformation2.setCountryCode(COUNTRY_CODE);
        accountSummaryInformation2.setCompanyLogo(COMPANY_LOGO);
        accountSummaryInformation2.setOrganizationName(ORGANIZATION_NAME);
        accountSummaryInformation2.setPhone(PHONE);
        accountSummaryInformation2.setTimeZone(TIME_ZONE);
        accountSummaryInformation2.setWebsite(WEBSITE);
        accountSummaryInformation2.setOrganizationAddresses(ACCOUNT_ADDRESSES);

        int hash1 = accountSummaryInformation1.hashCode();
        int hash2 = accountSummaryInformation2.hashCode();

        assertThat(accountSummaryInformation1.equals(accountSummaryInformation2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    private void runAssertions(AccountSummaryInformation accountSummaryInformation) {
        assertThat(accountSummaryInformation.getEmail(), is(EMAIL));
        assertThat(accountSummaryInformation.getFirstName(), is(FIRST_NAME));
        assertThat(accountSummaryInformation.getLastName(), is(LAST_NAME));
        assertThat(accountSummaryInformation.getStateCode(), is(STATE_CODE));
        assertThat(accountSummaryInformation.getCountryCode(), is(COUNTRY_CODE));
        assertThat(accountSummaryInformation.getCompanyLogo(), is(COMPANY_LOGO));
        assertThat(accountSummaryInformation.getOrganizationName(), is(ORGANIZATION_NAME));
        assertThat(accountSummaryInformation.getPhone(), is(PHONE));
        assertThat(accountSummaryInformation.getTimeZone(), is(TIME_ZONE));
        assertThat(accountSummaryInformation.getWebsite(), is(WEBSITE));
        AccountAddressTest.runAssertations(accountSummaryInformation.getOrganizationAddresses()[0]);
    }
}
