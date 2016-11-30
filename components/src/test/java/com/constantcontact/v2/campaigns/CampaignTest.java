package com.constantcontact.v2.campaigns;

import com.constantcontact.v2.tracking.TrackingSummary;
import com.constantcontact.v2.tracking.TrackingSummaryTest;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author woogienoogie
 */
public class CampaignTest {
    private static final String ID = "123ABC";

    private static final Date DATE = new Date(0);

    private static final String CONTENT = "This is email content";

    private static final String CONTENT_FORMAT = "HTML_AND_TEXT";

    private static final String FROM_EMAIL = "null@dev.net";

    private static final String FROM_NAME = "Me!";

    private static final String NAME = "My Campaign";

    private static final String REPLY_EMAIL = "null@dev.net";

    private static final String GREETING_NAME = "Bob";

    private static final String GREETING_SALUTATIONS = "Hi there";

    private static final String GREETING_STRING = "Hello";

    private static final String VWP_TEXT = "Having trouble with stuff";

    private static final String VWP_LINK = "Clicky here";

    private static final boolean VWP_ENABLED = true;

    private static final String TEXT_CONTENT = "This is text content";

    private static final String SUBJECT = "READ ME";

    private static final String TEMPLATE_TYPE = "Special";

    private static final String STYLESHEET = "css go here";

    private static final CampaignStatus STATUS = CampaignStatus.SENT;

    private static final String URL = "http://constantcontact.com";

    private static final boolean PR_ENABLED = true;

    private static final String PR_TEXT = "This is a reminder of permission";

    private static final ClickThroughDetail[] CLICK_THROUGH_DETAILS = new ClickThroughDetail[]{ClickThroughDetailTest.createClickThroughDetail()};

    private static final SentToContactList[] SENT_TO_CONTACT_LISTS = new SentToContactList[]{SentToContactListTest.createSentToContactList()};

    private static final TrackingSummary TRACKING_SUMMARY = TrackingSummaryTest.createTrackingSummary();

    @Test
    public void expectThatGettingAndSettingValues_WillReturnSame() {
        Campaign campaign = new Campaign();

        campaign.setId(ID);
        campaign.setCreatedDate(DATE);
        campaign.setModifiedDate(DATE);
        campaign.setLastRunDate(DATE);
        campaign.setNextRunDate(DATE);
        campaign.setClickThroughDetails(CLICK_THROUGH_DETAILS);
        campaign.setEmailContent(CONTENT);
        campaign.setEmailContentFormat(CONTENT_FORMAT);
        campaign.setFromEmail(FROM_EMAIL);
        campaign.setFromName(FROM_NAME);
        campaign.setName(NAME);
        campaign.setReplyToEmail(REPLY_EMAIL);
        campaign.setGreetingName(GREETING_NAME);
        campaign.setGreetingSalutations(GREETING_SALUTATIONS);
        campaign.setGreetingString(GREETING_STRING);
        campaign.setSentToContactLists(SENT_TO_CONTACT_LISTS);
        campaign.setViewAsWebPageText(VWP_TEXT);
        campaign.setViewAsWebpageEnabled(VWP_ENABLED);
        campaign.setViewAsWebPageLinkText(VWP_LINK);
        campaign.setTrackingSummary(TRACKING_SUMMARY);
        campaign.setTextContent(TEXT_CONTENT);
        campaign.setSubject(SUBJECT);
        campaign.setTemplateType(TEMPLATE_TYPE);
        campaign.setStyleSheet(STYLESHEET);
        campaign.setStatus(STATUS);
        campaign.setPermalinkUrl(URL);
        campaign.setPermissionReminderEnabled(PR_ENABLED);
        campaign.setPermissionReminderText(PR_TEXT);

        runAssertions(campaign);
    }

    @Test
    public void expectThatSerializing_WillRetainValues() {
        Campaign campaign = new Campaign();
        campaign.setId(ID);
        campaign.setCreatedDate(DATE);
        campaign.setModifiedDate(DATE);
        campaign.setLastRunDate(DATE);
        campaign.setNextRunDate(DATE);
        campaign.setClickThroughDetails(CLICK_THROUGH_DETAILS);
        campaign.setEmailContent(CONTENT);
        campaign.setEmailContentFormat(CONTENT_FORMAT);
        campaign.setFromEmail(FROM_EMAIL);
        campaign.setFromName(FROM_NAME);
        campaign.setName(NAME);
        campaign.setReplyToEmail(REPLY_EMAIL);
        campaign.setGreetingName(GREETING_NAME);
        campaign.setGreetingSalutations(GREETING_SALUTATIONS);
        campaign.setGreetingString(GREETING_STRING);
        campaign.setSentToContactLists(SENT_TO_CONTACT_LISTS);
        campaign.setViewAsWebPageText(VWP_TEXT);
        campaign.setViewAsWebpageEnabled(VWP_ENABLED);
        campaign.setViewAsWebPageLinkText(VWP_LINK);
        campaign.setTrackingSummary(TRACKING_SUMMARY);
        campaign.setTextContent(TEXT_CONTENT);
        campaign.setSubject(SUBJECT);
        campaign.setTemplateType(TEMPLATE_TYPE);
        campaign.setStyleSheet(STYLESHEET);
        campaign.setStatus(STATUS);
        campaign.setPermalinkUrl(URL);
        campaign.setPermissionReminderEnabled(PR_ENABLED);
        campaign.setPermissionReminderText(PR_TEXT);

        Campaign out = SerializationUtils.roundtrip(campaign);

        runAssertions(out);
    }

    private void runAssertions(Campaign campaign) {
        assertThat(campaign.getId(), is(ID));
        assertThat(campaign.getCreatedDate(), is(DATE));
        assertThat(campaign.getModifiedDate(), is(DATE));
        assertThat(campaign.getLastRunDate(), is(DATE));
        assertThat(campaign.getNextRunDate(), is(DATE));
        ClickThroughDetailTest.runAssertions(campaign.getClickThroughDetails()[0]);
        assertThat(campaign.getEmailContent(), is(CONTENT));
        assertThat(campaign.getEmailContentFormat(), is(CONTENT_FORMAT));
        assertThat(campaign.getFromEmail(), is(FROM_EMAIL));
        assertThat(campaign.getFromName(), is(FROM_NAME));
        assertThat(campaign.getName(), is(NAME));
        assertThat(campaign.getReplyToEmail(), is(REPLY_EMAIL));
        assertThat(campaign.getGreetingName(), is(GREETING_NAME));
        assertThat(campaign.getGreetingSalutations(), is(GREETING_SALUTATIONS));
        assertThat(campaign.getGreetingString(), is(GREETING_STRING));
        SentToContactListTest.runAssertions(campaign.getSentToContactLists()[0]);
        assertThat(campaign.getViewAsWebPageText(), is(VWP_TEXT));
        assertThat(campaign.isViewAsWebpageEnabled(), is(VWP_ENABLED));
        assertThat(campaign.getViewAsWebPageLinkText(), is(VWP_LINK));
        TrackingSummaryTest.runAssertions(campaign.getTrackingSummary());
        assertThat(campaign.getTemplateType(), is(TEMPLATE_TYPE));
        assertThat(campaign.getTextContent(), is(TEXT_CONTENT));
        assertThat(campaign.getStyleSheet(), is(STYLESHEET));
        assertThat(campaign.getStatus(), is(STATUS));
        assertThat(campaign.getPermalinkUrl(), is(URL));
        assertThat(campaign.isPermissionReminderEnabled(), is(PR_ENABLED));
        assertThat(campaign.getPermissionReminderText(), is(PR_TEXT));
        assertThat(campaign.getSubject(), is(SUBJECT));
    }
}
