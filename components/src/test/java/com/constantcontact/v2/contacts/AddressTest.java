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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
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

    @Test
    public void expectThatSerializing_WillRetainValues() {
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

        Address out = SerializationUtils.roundtrip(address);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        Address address1 = new Address();
        address1.setId(ID);
        address1.setLine1(LINE1);
        address1.setLine2(LINE2);
        address1.setLine3(LINE3);
        address1.setCity(CITY);
        address1.setState(STATE);
        address1.setStateCode(STATE_CODE);
        address1.setCountryCode(COUNTRY_CODE);
        address1.setAddressType(ADDRESS_TYPE);
        address1.setPostalCode(POSTAL_CODE);
        address1.setSubPostalCode(POSTAL_SUB_CODE);
        Address address2 = new Address();
        address2.setId(ID);
        address2.setLine1(LINE1);
        address2.setLine2(LINE2);
        address2.setLine3(LINE3);
        address2.setCity(CITY);
        address2.setState(STATE);
        address2.setStateCode(STATE_CODE);
        address2.setCountryCode(COUNTRY_CODE);
        address2.setAddressType(ADDRESS_TYPE);
        address2.setPostalCode(POSTAL_CODE);
        address2.setSubPostalCode(POSTAL_SUB_CODE);

        int hash1 = address1.hashCode();
        int hash2 = address2.hashCode();

        assertThat(address1.equals(address2), is(true));
        assertThat(hash1 == hash2, is(true));
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
