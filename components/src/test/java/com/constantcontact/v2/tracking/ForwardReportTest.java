package com.constantcontact.v2.tracking;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
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

    @Test
    public void expectThatSerializing_WillRetainValues() {
        ForwardReport forwardReport = new ForwardReport();
        forwardReport.setEmailAddress(EMAIL);
        forwardReport.setActivityType(TYPE);
        forwardReport.setContactId(CONTACT_ID);
        forwardReport.setCampaignId(CAMPAIGN_ID);
        forwardReport.setForwardDate(DATE);

        ForwardReport out = SerializationUtils.roundtrip(forwardReport);

        runAssertions(out);
    }

    @Test
    public void testEqualsAndHash() {
        ForwardReport forwardReport1 = new ForwardReport();
        forwardReport1.setEmailAddress(EMAIL);
        forwardReport1.setActivityType(TYPE);
        forwardReport1.setContactId(CONTACT_ID);
        forwardReport1.setCampaignId(CAMPAIGN_ID);
        forwardReport1.setForwardDate(DATE);
        ForwardReport forwardReport2 = new ForwardReport();
        forwardReport2.setEmailAddress(EMAIL);
        forwardReport2.setActivityType(TYPE);
        forwardReport2.setContactId(CONTACT_ID);
        forwardReport2.setCampaignId(CAMPAIGN_ID);
        forwardReport2.setForwardDate(DATE);

        int hash1 = forwardReport1.hashCode();
        int hash2 = forwardReport2.hashCode();

        assertThat(forwardReport1.equals(forwardReport2), is(true));
        assertThat(hash1 == hash2, is(true));
    }

    static void runAssertions(ForwardReport forwardReport) {
        assertThat(forwardReport.getEmailAddress(), is(EMAIL));
        assertThat(forwardReport.getActivityType(), is(TYPE));
        assertThat(forwardReport.getContactId(), is(CONTACT_ID));
        assertThat(forwardReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(forwardReport.getForwardDate(), is(DATE));
    }
}
