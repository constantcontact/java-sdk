package com.constantcontact.v2.account;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
