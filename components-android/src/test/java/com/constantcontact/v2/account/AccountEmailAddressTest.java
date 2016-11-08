package com.constantcontact.v2.account;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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

    private void runAssertations(AccountEmailAddress accountEmailAddress) {
        assertThat(accountEmailAddress.getEmailAddress(), is(EMAIL));
        assertThat(accountEmailAddress.getStatus(), is(STATUS));
    }
}
