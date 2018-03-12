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
public class OptOutReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_UNSUBSCRIBE;

    private static final Date DATE = new Date(0);

    private static final String REASON = "Because";

    private static final UnsubscribeSource SOURCE = UnsubscribeSource.ACTION_BY_CUSTOMER;

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        OptOutReport optOutReport = new OptOutReport();

        optOutReport.setEmailAddress(EMAIL);
        optOutReport.setActivityType(TYPE);
        optOutReport.setCampaignId(CAMPAIGN_ID);
        optOutReport.setContactId(CONTACT_ID);
        optOutReport.setUnsubscribeDate(DATE);
        optOutReport.setUnsubscribeReason(REASON);
        optOutReport.setUnsubscribeSource(SOURCE);

        runAssertions(optOutReport);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        OptOutReport optOutReport = new OptOutReport();
        optOutReport.setEmailAddress(EMAIL);
        optOutReport.setActivityType(TYPE);
        optOutReport.setCampaignId(CAMPAIGN_ID);
        optOutReport.setContactId(CONTACT_ID);
        optOutReport.setUnsubscribeDate(DATE);
        optOutReport.setUnsubscribeReason(REASON);
        optOutReport.setUnsubscribeSource(SOURCE);

        OptOutReport out = SerializationUtils.roundtrip(optOutReport);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        OptOutReport optOutReport1 = new OptOutReport();
        optOutReport1.setEmailAddress(EMAIL);
        optOutReport1.setActivityType(TYPE);
        optOutReport1.setCampaignId(CAMPAIGN_ID);
        optOutReport1.setContactId(CONTACT_ID);
        optOutReport1.setUnsubscribeDate(DATE);
        optOutReport1.setUnsubscribeReason(REASON);
        optOutReport1.setUnsubscribeSource(SOURCE);
        OptOutReport optOutReport2 = new OptOutReport();
        optOutReport2.setEmailAddress(EMAIL);
        optOutReport2.setActivityType(TYPE);
        optOutReport2.setCampaignId(CAMPAIGN_ID);
        optOutReport2.setContactId(CONTACT_ID);
        optOutReport2.setUnsubscribeDate(DATE);
        optOutReport2.setUnsubscribeReason(REASON);
        optOutReport2.setUnsubscribeSource(SOURCE);

        int hash1 = optOutReport1.hashCode();
        int hash2 = optOutReport2.hashCode();

        assertThat(optOutReport1.equals(optOutReport2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(OptOutReport optOutReport) {
        assertThat(optOutReport.getEmailAddress(), is(EMAIL));
        assertThat(optOutReport.getActivityType(), is(TYPE));
        assertThat(optOutReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(optOutReport.getContactId(), is(CONTACT_ID));
        assertThat(optOutReport.getUnsubscribeDate(), is(DATE));
        assertThat(optOutReport.getUnsubscribeReason(), is(REASON));
        assertThat(optOutReport.getUnsubscribeSource(), is(SOURCE));
    }
}
