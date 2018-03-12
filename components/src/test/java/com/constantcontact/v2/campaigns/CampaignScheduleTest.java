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

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class CampaignScheduleTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        CampaignSchedule campaignSchedule = new CampaignSchedule();

        campaignSchedule.setId(ID);
        campaignSchedule.setScheduledDate(DATE);

        runAssertions(campaignSchedule);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        CampaignSchedule campaignSchedule = new CampaignSchedule();
        campaignSchedule.setId(ID);
        campaignSchedule.setScheduledDate(DATE);

        CampaignSchedule out = SerializationUtils.roundtrip(campaignSchedule);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        CampaignSchedule campaignSchedule1 = new CampaignSchedule();
        campaignSchedule1.setId(ID);
        campaignSchedule1.setScheduledDate(DATE);
        CampaignSchedule campaignSchedule2 = new CampaignSchedule();
        campaignSchedule2.setId(ID);
        campaignSchedule2.setScheduledDate(DATE);

        int hash1 = campaignSchedule1.hashCode();
        int hash2 = campaignSchedule2.hashCode();

        assertThat(campaignSchedule1.equals(campaignSchedule2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    private void runAssertions(CampaignSchedule campaignSchedule) {
        assertThat(campaignSchedule.getId(), is(ID));
        assertThat(campaignSchedule.getScheduledDate(), is(DATE));
    }
}
