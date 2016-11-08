package com.constantcontact.v2.contacts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class AddressTest {
    private static final String ID = "123ABC";

    private static final String LINE1 = "742 Evergreen Terrace";

    private static final String LINE2 = "Apt B2";

    private static final String LINE3 = "One More Line";

    private static final String CITY = "Springfield";

    private static final String STATE = "North Dakota";

    private static final String STATE_CODE = "ND";

    private static final String COUNTRY_CODE = "US";

    private static final AddressType ADDRESS_TYPE = AddressType.PERSONAL;

    private static final String POSTAL_CODE = "58501";

    private static final String POSTAL_SUB_CODE = "1111";

    static Address createAddress() {
        Address address = new Address();
        address.setId(ID);
        address.setLine1(LINE1);
        address.setLine2(LINE2);
        address.setLine3(LINE3);
        address.setCity(CITY);
        address.setState(STATE);
        address.setStateCode(STATE_CODE);
        address.setCountryCode(COUNTRY_CODE);
        address.setAddressType(ADDRESS_TYPE);
        address.setPostalCode(POSTAL_CODE);
        address.setSubPostalCode(POSTAL_SUB_CODE);
        return address;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Address address = new Address();

        address.setId(ID);
        address.setLine1(LINE1);
        address.setLine2(LINE2);
        address.setLine3(LINE3);
        address.setCity(CITY);
        address.setState(STATE);
        address.setStateCode(STATE_CODE);
        address.setCountryCode(COUNTRY_CODE);
        address.setAddressType(ADDRESS_TYPE);
        address.setPostalCode(POSTAL_CODE);
        address.setSubPostalCode(POSTAL_SUB_CODE);

        runAssertions(address);
    }

    static void runAssertions(Address address) {
        assertThat(address.getId(), is(ID));
        assertThat(address.getLine1(), is(LINE1));
        assertThat(address.getLine2(), is(LINE2));
        assertThat(address.getLine3(), is(LINE3));
        assertThat(address.getCity(), is(CITY));
        assertThat(address.getState(), is(STATE));
        assertThat(address.getStateCode(), is(STATE_CODE));
        assertThat(address.getCountryCode(), is(COUNTRY_CODE));
        assertThat(address.getAddressType(), is(ADDRESS_TYPE));
        assertThat(address.getPostalCode(), is(POSTAL_CODE));
        assertThat(address.getSubPostalCode(), is(POSTAL_SUB_CODE));
    }
}
