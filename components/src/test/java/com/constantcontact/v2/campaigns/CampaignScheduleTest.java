package com.constantcontact.v2.campaigns;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
