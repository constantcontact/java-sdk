package com.constantcontact.v2.tracking;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
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
