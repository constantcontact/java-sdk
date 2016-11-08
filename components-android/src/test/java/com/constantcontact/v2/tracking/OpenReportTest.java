package com.constantcontact.v2.tracking;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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

    static void runAssertions(OpenReport openReport) {
        assertThat(openReport.getEmailAddress(), is(EMAIL));
        assertThat(openReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(openReport.getContactId(), is(CONTACT_ID));
        assertThat(openReport.getActivityType(), is(TYPE));
        assertThat(openReport.getOpenDate(), is(DATE));
    }
}
