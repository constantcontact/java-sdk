package com.constantcontact.v2.tracking;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class SendReportTest {
    private static final String EMAIL = "null@dev.net";

    private static final String CAMPAIGN_ID = "123ABC";

    private static final String CONTACT_ID = "789XYZ";

    private static final TrackingReportType TYPE = TrackingReportType.EMAIL_SEND;

    private static final Date DATE = new Date(0);

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        SendReport sendReport = new SendReport();

        sendReport.setEmailAddress(EMAIL);
        sendReport.setCampaignId(CAMPAIGN_ID);
        sendReport.setContactId(CONTACT_ID);
        sendReport.setActivityType(TYPE);
        sendReport.setSendDate(DATE);

        runAssertions(sendReport);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        SendReport sendReport = new SendReport();
        sendReport.setEmailAddress(EMAIL);
        sendReport.setCampaignId(CAMPAIGN_ID);
        sendReport.setContactId(CONTACT_ID);
        sendReport.setActivityType(TYPE);
        sendReport.setSendDate(DATE);

        SendReport out = SerializationUtils.roundtrip(sendReport);

        runAssertions(out);
    }

    static void runAssertions(SendReport sendReport) {
        assertThat(sendReport.getEmailAddress(), is(EMAIL));
        assertThat(sendReport.getCampaignId(), is(CAMPAIGN_ID));
        assertThat(sendReport.getContactId(), is(CONTACT_ID));
        assertThat(sendReport.getActivityType(), is(TYPE));
        assertThat(sendReport.getSendDate(), is(DATE));
    }
}
