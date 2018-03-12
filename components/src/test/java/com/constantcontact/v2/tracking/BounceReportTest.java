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
public class BounceReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_BOUNCE;

    private static final BounceCode CODE = BounceCode.B;

    private static final Date DATE = new Date(0);

    private static final String DESCRIPTION = "Bounced";

    private static final String MESSAGE = "It bounced bro";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        BounceReport bounceReport = new BounceReport();

        bounceReport.setEmailAddress(EMAIL);
        bounceReport.setActivityType(TYPE);
        bounceReport.setCampaignId(CAMPAIGN_ID);
        bounceReport.setContactId(CONTACT_ID);
        bounceReport.setBounceCode(CODE);
        bounceReport.setBounceDate(DATE);
        bounceReport.setBounceDescription(DESCRIPTION);
        bounceReport.setBounceMessage(MESSAGE);

        runAssertions(bounceReport);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        BounceReport bounceReport = new BounceReport();
        bounceReport.setEmailAddress(EMAIL);
        bounceReport.setActivityType(TYPE);
        bounceReport.setCampaignId(CAMPAIGN_ID);
        bounceReport.setContactId(CONTACT_ID);
        bounceReport.setBounceCode(CODE);
        bounceReport.setBounceDate(DATE);
        bounceReport.setBounceDescription(DESCRIPTION);
        bounceReport.setBounceMessage(MESSAGE);

        BounceReport out = SerializationUtils.roundtrip(bounceReport);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        BounceReport bounceReport1 = new BounceReport();
        bounceReport1.setEmailAddress(EMAIL);
        bounceReport1.setActivityType(TYPE);
        bounceReport1.setCampaignId(CAMPAIGN_ID);
        bounceReport1.setContactId(CONTACT_ID);
        bounceReport1.setBounceCode(CODE);
        bounceReport1.setBounceDate(DATE);
        bounceReport1.setBounceDescription(DESCRIPTION);
        bounceReport1.setBounceMessage(MESSAGE);
        BounceReport bounceReport2 = new BounceReport();
        bounceReport2.setEmailAddress(EMAIL);
        bounceReport2.setActivityType(TYPE);
        bounceReport2.setCampaignId(CAMPAIGN_ID);
        bounceReport2.setContactId(CONTACT_ID);
        bounceReport2.setBounceCode(CODE);
        bounceReport2.setBounceDate(DATE);
        bounceReport2.setBounceDescription(DESCRIPTION);
        bounceReport2.setBounceMessage(MESSAGE);

        int hash1 = bounceReport1.hashCode();
        int hash2 = bounceReport2.hashCode();

        assertThat(bounceReport1.equals(bounceReport2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(BounceReport bounceReport) {
        assertThat(bounceReport.getEmailAddress(), is(EMAIL));
        assertThat(bounceReport.getActivityType(), is(TYPE));
        assertThat(bounceReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(bounceReport.getContactId(), is(CONTACT_ID));
        assertThat(bounceReport.getBounceCode(), is(CODE));
        assertThat(bounceReport.getBounceDate(), is(DATE));
        assertThat(bounceReport.getBounceDescription(), is(DESCRIPTION));
        assertThat(bounceReport.getBounceMessage(), is(MESSAGE));
    }
}
