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

package com.constantcontact.v2.bulkactivities;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class AddressTest {
    private static final String CITY = "Wilmingtonshireville";

    private static final String COUNTRY_CODE = "1";

    private static final String LINE_1 = "123 Oldgravelroad Ave";

    private static final String LINE_2 = "Apt 726";

    private static final String POSTAL_CODE = "00001";

    private static final String STATE_CODE = "NH";

    static Address createAddress() {
        Address address = new Address();
        address.setCity(CITY);
        address.setCountryCode(COUNTRY_CODE);
        address.setLine1(LINE_1);
        address.setLine2(LINE_2);
        address.setPostalCode(POSTAL_CODE);
        address.setStateCode(STATE_CODE);
        return address;
    }

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Address address = new Address();
        address.setCity(CITY);
        address.setCountryCode(COUNTRY_CODE);
        address.setLine1(LINE_1);
        address.setLine2(LINE_2);
        address.setPostalCode(POSTAL_CODE);
        address.setStateCode(STATE_CODE);

        runAssertations(address);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Address address = new Address();
        address.setCity(CITY);
        address.setCountryCode(COUNTRY_CODE);
        address.setLine1(LINE_1);
        address.setLine2(LINE_2);
        address.setPostalCode(POSTAL_CODE);
        address.setStateCode(STATE_CODE);

        Address out = SerializationUtils.roundtrip(address);

        runAssertations(out);
    }

    @Test
    public void testEqualsAndHash() {
        Address address1 = new Address();
        address1.setCity(CITY);
        address1.setCountryCode(COUNTRY_CODE);
        address1.setLine1(LINE_1);
        address1.setLine2(LINE_2);
        address1.setPostalCode(POSTAL_CODE);
        address1.setStateCode(STATE_CODE);

        Address address2 = new Address();
        address2.setCity(CITY);
        address2.setCountryCode(COUNTRY_CODE);
        address2.setLine1(LINE_1);
        address2.setLine2(LINE_2);
        address2.setPostalCode(POSTAL_CODE);
        address2.setStateCode(STATE_CODE);

        int hash1 = address1.hashCode();
        int hash2 = address2.hashCode();

        assertThat(address1.equals(address2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertations(Address address) {
        assertThat(address.getCity(), is(CITY));
        assertThat(address.getCountryCode(), is(COUNTRY_CODE));
        assertThat(address.getLine1(), is(LINE_1));
        assertThat(address.getLine2(), is(LINE_2));
        assertThat(address.getPostalCode(), is(POSTAL_CODE));
        assertThat(address.getStateCode(), is(STATE_CODE));
    }
}
