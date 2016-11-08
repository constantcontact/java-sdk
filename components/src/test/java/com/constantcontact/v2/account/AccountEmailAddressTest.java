package com.constantcontact.v2.account;

import org.apache.commons.lang3.SerializationUtils;
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

    @Test
    public void expectThatSerializing_WillRetainValues() {
        AccountEmailAddress accountEmailAddress = new AccountEmailAddress();
        accountEmailAddress.setEmailAddress(EMAIL);
        accountEmailAddress.setStatus(STATUS);

        AccountEmailAddress out = SerializationUtils.roundtrip(accountEmailAddress);

        runAssertations(out);
    }

    private void runAssertations(AccountEmailAddress accountEmailAddress) {
        assertThat(accountEmailAddress.getEmailAddress(), is(EMAIL));
        assertThat(accountEmailAddress.getStatus(), is(STATUS));
    }
}
