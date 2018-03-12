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

package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class MessageFooterTest {
    private static final String LINE1 = "742 Evergreen Terrace";

    private static final String LINE2 = "Apt B2";

    private static final String LINE3 = "One More Line";

    private static final String CITY = "Springfield";

    private static final String STATE = "North Dakota";

    private static final String POSTAL_CODE = "58501";

    private static final String COUNTRY = "US";

    private static final String ORGANIZATION = "Nucular Power Plant";

    private static final boolean INCLUDE_FORWARD = true;

    private static final boolean INCLUDE_SUBSCRIBE = true;

    private static final String FORWARD_TEXT = "Forwarding";

    private static final String SUBSCRIBE_TEXT = "Sub";

    private static final String INTERNATIONAL_STATE = "Wat";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        MessageFooter messageFooter = new MessageFooter();

        messageFooter.setAddressLine1(LINE1);
        messageFooter.setAddressLine2(LINE2);
        messageFooter.setAddressLine3(LINE3);
        messageFooter.setCity(CITY);
        messageFooter.setState(STATE);
        messageFooter.setPostalCode(POSTAL_CODE);
        messageFooter.setCountry(COUNTRY);
        messageFooter.setOrganizationName(ORGANIZATION);
        messageFooter.setIncludeForwardEmail(INCLUDE_FORWARD);
        messageFooter.setIncludeSubscribeLink(INCLUDE_SUBSCRIBE);
        messageFooter.setForwardEmailLinkText(FORWARD_TEXT);
        messageFooter.setSubscribeLinkText(SUBSCRIBE_TEXT);
        messageFooter.setInternationalState(INTERNATIONAL_STATE);

        runAssertions(messageFooter);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        MessageFooter messageFooter = new MessageFooter();
        messageFooter.setAddressLine1(LINE1);
        messageFooter.setAddressLine2(LINE2);
        messageFooter.setAddressLine3(LINE3);
        messageFooter.setCity(CITY);
        messageFooter.setState(STATE);
        messageFooter.setPostalCode(POSTAL_CODE);
        messageFooter.setCountry(COUNTRY);
        messageFooter.setOrganizationName(ORGANIZATION);
        messageFooter.setIncludeForwardEmail(INCLUDE_FORWARD);
        messageFooter.setIncludeSubscribeLink(INCLUDE_SUBSCRIBE);
        messageFooter.setForwardEmailLinkText(FORWARD_TEXT);
        messageFooter.setSubscribeLinkText(SUBSCRIBE_TEXT);
        messageFooter.setInternationalState(INTERNATIONAL_STATE);

        MessageFooter out = SerializationUtils.roundtrip(messageFooter);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        MessageFooter messageFooter1 = new MessageFooter();
        messageFooter1.setAddressLine1(LINE1);
        messageFooter1.setAddressLine2(LINE2);
        messageFooter1.setAddressLine3(LINE3);
        messageFooter1.setCity(CITY);
        messageFooter1.setState(STATE);
        messageFooter1.setPostalCode(POSTAL_CODE);
        messageFooter1.setCountry(COUNTRY);
        messageFooter1.setOrganizationName(ORGANIZATION);
        messageFooter1.setIncludeForwardEmail(INCLUDE_FORWARD);
        messageFooter1.setIncludeSubscribeLink(INCLUDE_SUBSCRIBE);
        messageFooter1.setForwardEmailLinkText(FORWARD_TEXT);
        messageFooter1.setSubscribeLinkText(SUBSCRIBE_TEXT);
        messageFooter1.setInternationalState(INTERNATIONAL_STATE);
        MessageFooter messageFooter2 = new MessageFooter();
        messageFooter2.setAddressLine1(LINE1);
        messageFooter2.setAddressLine2(LINE2);
        messageFooter2.setAddressLine3(LINE3);
        messageFooter2.setCity(CITY);
        messageFooter2.setState(STATE);
        messageFooter2.setPostalCode(POSTAL_CODE);
        messageFooter2.setCountry(COUNTRY);
        messageFooter2.setOrganizationName(ORGANIZATION);
        messageFooter2.setIncludeForwardEmail(INCLUDE_FORWARD);
        messageFooter2.setIncludeSubscribeLink(INCLUDE_SUBSCRIBE);
        messageFooter2.setForwardEmailLinkText(FORWARD_TEXT);
        messageFooter2.setSubscribeLinkText(SUBSCRIBE_TEXT);
        messageFooter2.setInternationalState(INTERNATIONAL_STATE);

        int hash1 = messageFooter1.hashCode();
        int hash2 = messageFooter2.hashCode();

        assertThat(messageFooter1.equals(messageFooter2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    private void runAssertions(MessageFooter messageFooter) {
        assertThat(messageFooter.getAddressLine1(), is(LINE1));
        assertThat(messageFooter.getAddressLine2(), is(LINE2));
        assertThat(messageFooter.getAddressLine3(), is(LINE3));
        assertThat(messageFooter.getCity(), is(CITY));
        assertThat(messageFooter.getState(), is(STATE));
        assertThat(messageFooter.getPostalCode(), is(POSTAL_CODE));
        assertThat(messageFooter.getCountry(), is(COUNTRY));
        assertThat(messageFooter.getOrganizationName(), is(ORGANIZATION));
        assertThat(messageFooter.getIsIncludeForwardEmail(), is(INCLUDE_FORWARD));
        assertThat(messageFooter.getIsIncludeSubscribeLink(), is(INCLUDE_SUBSCRIBE));
        assertThat(messageFooter.getForwardEmailLinkText(), is(FORWARD_TEXT));
        assertThat(messageFooter.getSubscribeLinkText(), is(SUBSCRIBE_TEXT));
        assertThat(messageFooter.getInternationalState(), is(INTERNATIONAL_STATE));
    }
}
