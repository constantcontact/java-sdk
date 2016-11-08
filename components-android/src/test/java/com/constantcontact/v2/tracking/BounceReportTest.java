package com.constantcontact.v2.tracking;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
