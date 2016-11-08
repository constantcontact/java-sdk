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

    private void runAssertions(CampaignSchedule campaignSchedule) {
        assertThat(campaignSchedule.getId(), is(ID));
        assertThat(campaignSchedule.getScheduledDate(), is(DATE));
    }
}
