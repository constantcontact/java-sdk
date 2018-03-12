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
public class SendReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_SEND;

    private static final Date DATE = new Date(0);

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        SendReport sendReport = new SendReport();

        sendReport.setEmailAddress(EMAIL);
        sendReport.setCampaignId(CAMPAIGN_ID);
        sendReport.setContactId(CONTACT_ID);
        sendReport.setActivityType(TYPE);
        sendReport.setSendDate(DATE);

        runAssertions(sendReport);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        SendReport sendReport = new SendReport();
        sendReport.setEmailAddress(EMAIL);
        sendReport.setCampaignId(CAMPAIGN_ID);
        sendReport.setContactId(CONTACT_ID);
        sendReport.setActivityType(TYPE);
        sendReport.setSendDate(DATE);

        SendReport out = SerializationUtils.roundtrip(sendReport);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        SendReport sendReport1 = new SendReport();
        sendReport1.setEmailAddress(EMAIL);
        sendReport1.setCampaignId(CAMPAIGN_ID);
        sendReport1.setContactId(CONTACT_ID);
        sendReport1.setActivityType(TYPE);
        sendReport1.setSendDate(DATE);
        SendReport sendReport2 = new SendReport();
        sendReport2.setEmailAddress(EMAIL);
        sendReport2.setCampaignId(CAMPAIGN_ID);
        sendReport2.setContactId(CONTACT_ID);
        sendReport2.setActivityType(TYPE);
        sendReport2.setSendDate(DATE);

        int hash1 = sendReport1.hashCode();
        int hash2 = sendReport2.hashCode();

        assertThat(sendReport1.equals(sendReport2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(SendReport sendReport) {
        assertThat(sendReport.getEmailAddress(), is(EMAIL));
        assertThat(sendReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(sendReport.getContactId(), is(CONTACT_ID));
        assertThat(sendReport.getActivityType(), is(TYPE));
        assertThat(sendReport.getSendDate(), is(DATE));
    }
}
