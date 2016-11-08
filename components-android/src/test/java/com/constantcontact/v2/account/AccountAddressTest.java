package com.constantcontact.v2.account;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
