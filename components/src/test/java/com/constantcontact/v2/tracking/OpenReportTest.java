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
public class OpenReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_OPEN;

    private static final Date DATE = new Date(0);

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        OpenReport openReport = new OpenReport();

        openReport.setEmailAddress(EMAIL);
        openReport.setCampaignId(CAMPAIGN_ID);
        openReport.setContactId(CONTACT_ID);
        openReport.setActivityType(TYPE);
        openReport.setOpenDate(DATE);

        runAssertions(openReport);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        OpenReport openReport = new OpenReport();
        openReport.setEmailAddress(EMAIL);
        openReport.setCampaignId(CAMPAIGN_ID);
        openReport.setContactId(CONTACT_ID);
        openReport.setActivityType(TYPE);
        openReport.setOpenDate(DATE);

        OpenReport out = SerializationUtils.roundtrip(openReport);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        OpenReport openReport1 = new OpenReport();
        openReport1.setEmailAddress(EMAIL);
        openReport1.setCampaignId(CAMPAIGN_ID);
        openReport1.setContactId(CONTACT_ID);
        openReport1.setActivityType(TYPE);
        openReport1.setOpenDate(DATE);
        OpenReport openReport2 = new OpenReport();
        openReport2.setEmailAddress(EMAIL);
        openReport2.setCampaignId(CAMPAIGN_ID);
        openReport2.setContactId(CONTACT_ID);
        openReport2.setActivityType(TYPE);
        openReport2.setOpenDate(DATE);

        int hash1 = openReport1.hashCode();
        int hash2 = openReport2.hashCode();

        assertThat(openReport1.equals(openReport2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(OpenReport openReport) {
        assertThat(openReport.getEmailAddress(), is(EMAIL));
        assertThat(openReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(openReport.getContactId(), is(CONTACT_ID));
        assertThat(openReport.getActivityType(), is(TYPE));
        assertThat(openReport.getOpenDate(), is(DATE));
    }
}
