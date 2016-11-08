package com.constantcontact.v2.tracking;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class ClickReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_CLICK;

    private static final Date DATE = new Date(0);

    private static final String LINK_ID = "123ABC";

    private static final String LINK_URI = "http://constantcontact.com";

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        ClickReport clickReport = new ClickReport();

        clickReport.setEmailAddress(EMAIL);
        clickReport.setCampaignId(CAMPAIGN_ID);
        clickReport.setContactId(CONTACT_ID);
        clickReport.setActivityType(TYPE);
        clickReport.setClickDate(DATE);
        clickReport.setLinkId(LINK_ID);
        clickReport.setLinkUri(LINK_URI);

        runAssertions(clickReport);
    }

    static void runAssertions(ClickReport clickReport) {
        assertThat(clickReport.getEmailAddress(), is(EMAIL));
        assertThat(clickReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(clickReport.getContactId(), is(CONTACT_ID));
        assertThat(clickReport.getActivityType(), is(TYPE));
        assertThat(clickReport.getClickDate(), is(DATE));
        assertThat(clickReport.getLinkId(), is(LINK_ID));
        assertThat(clickReport.getLinkUri(), is(LINK_URI));
    }
}
