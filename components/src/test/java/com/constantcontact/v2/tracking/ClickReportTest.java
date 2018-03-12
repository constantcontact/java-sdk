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

package com.constantcontact.v2.tracking;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class ClickReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_CLICK;

    private static final Date DATE = new Date(0);

    private static final String LINK_ID = "123ABC";

    private static final String LINK_URI = "http://constantcontact.com";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ClickReport clickReport = new ClickReport();

        clickReport.setEmailAddress(EMAIL);
        clickReport.setCampaignId(CAMPAIGN_ID);
        clickReport.setContactId(CONTACT_ID);
        clickReport.setActivityType(TYPE);
        clickReport.setClickDate(DATE);
        clickReport.setLinkId(LINK_ID);
        clickReport.setLinkUri(LINK_URI);

        runAssertions(clickReport);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ClickReport clickReport = new ClickReport();
        clickReport.setEmailAddress(EMAIL);
        clickReport.setCampaignId(CAMPAIGN_ID);
        clickReport.setContactId(CONTACT_ID);
        clickReport.setActivityType(TYPE);
        clickReport.setClickDate(DATE);
        clickReport.setLinkId(LINK_ID);
        clickReport.setLinkUri(LINK_URI);

        ClickReport out = SerializationUtils.roundtrip(clickReport);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        ClickReport clickReport1 = new ClickReport();
        clickReport1.setEmailAddress(EMAIL);
        clickReport1.setCampaignId(CAMPAIGN_ID);
        clickReport1.setContactId(CONTACT_ID);
        clickReport1.setActivityType(TYPE);
        clickReport1.setClickDate(DATE);
        clickReport1.setLinkId(LINK_ID);
        clickReport1.setLinkUri(LINK_URI);
        ClickReport clickReport2 = new ClickReport();
        clickReport2.setEmailAddress(EMAIL);
        clickReport2.setCampaignId(CAMPAIGN_ID);
        clickReport2.setContactId(CONTACT_ID);
        clickReport2.setActivityType(TYPE);
        clickReport2.setClickDate(DATE);
        clickReport2.setLinkId(LINK_ID);
        clickReport2.setLinkUri(LINK_URI);

        int hash1 = clickReport1.hashCode();
        int hash2 = clickReport2.hashCode();

        assertThat(clickReport1.equals(clickReport2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(ClickReport clickReport) {
        assertThat(clickReport.getEmailAddress(), is(EMAIL));
        assertThat(clickReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(clickReport.getContactId(), is(CONTACT_ID));
        assertThat(clickReport.getActivityType(), is(TYPE));
        assertThat(clickReport.getClickDate(), is(DATE));
        assertThat(clickReport.getLinkId(), is(LINK_ID));
        assertThat(clickReport.getLinkUri(), is(LINK_URI));
    }
}
