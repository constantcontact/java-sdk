package com.constantcontact.v2.tracking;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ForwardReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_FORWARD;

    private static final Date DATE = new Date(0);

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ForwardReport forwardReport = new ForwardReport();

        forwardReport.setEmailAddress(EMAIL);
        forwardReport.setActivityType(TYPE);
        forwardReport.setContactId(CONTACT_ID);
        forwardReport.setCampaignId(CAMPAIGN_ID);
        forwardReport.setForwardDate(DATE);

        runAssertions(forwardReport);
    }

    static void runAssertions(ForwardReport forwardReport) {
        assertThat(forwardReport.getEmailAddress(), is(EMAIL));
        assertThat(forwardReport.getActivityType(), is(TYPE));
        assertThat(forwardReport.getContactId(), is(CONTACT_ID));
        assertThat(forwardReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(forwardReport.getForwardDate(), is(DATE));
    }
}
