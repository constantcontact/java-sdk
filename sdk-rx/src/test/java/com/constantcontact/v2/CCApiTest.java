package com.constantcontact.v2;

import com.constantcontact.v2.campaigns.Campaign;
import com.constantcontact.v2.campaigns.SentToContactList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import retrofit2.Response;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.UUID;

public class CCApiTest {

    private static final String EMOTICONS_STRING = "😉😉";
    private static final String ALL_ASCII = "All Ascii";
    private static final String SENT_TO = "1566174080";
    private static final String EMAIL_CONTENT = "<!DOCTYPE HTML><html><body>nothing</body></html>";
    private static final String EMAIL_ADDR = "maria.davila@endurance.com";
    private static final String TEXT_CONTENT = "Hello there";
    private static final String FROM_NAME = "Constant Contact";
    private static final String apiKey = "mariKey";
    private static final String token = "mariToken";
    private static final CCApi2 ccapi = new CCApi2(apiKey, token);

    //@Test
    public void testEmoticons() throws Exception{

        Campaign campaign = createCampaign();
        // test emoticons in the subject string
        setStringPropertyValue(campaign, "subject", EMOTICONS_STRING);
        Campaign created = sendCampaign(campaign);
        cleanupCampaign(created.getId());
        // put the emoticons in textContent property. Clean up previous property
        campaign = createCampaign();
        setStringPropertyValue(campaign, "subject", ALL_ASCII);
        setStringPropertyValue(campaign, "name", EMOTICONS_STRING + UUID.randomUUID().toString());
        created = sendCampaign(campaign);
        cleanupCampaign(created.getId());
    }

    private Campaign createCampaign() throws Exception{

        Campaign campaign = new Campaign();
        campaign.setName(UUID.randomUUID().toString());
        campaign.setFromName(FROM_NAME);
        SentToContactList sentTo = new SentToContactList();
        sentTo.setId(SENT_TO);
        campaign.setSentToContactLists(new SentToContactList[] {sentTo});
        campaign.setSubject(EMOTICONS_STRING);
        campaign.setEmailContent(EMAIL_CONTENT);
        campaign.setReplyToEmail(EMAIL_ADDR);
        campaign.setTextContent(TEXT_CONTENT);
        campaign.setFromEmail(EMAIL_ADDR);
        return campaign;
    }

    private void setStringPropertyValue(Campaign campaign, String attrName, String attrValue) throws Exception{
        PropertyDescriptor descriptor = new PropertyDescriptor(attrName, Campaign.class);
        descriptor.getWriteMethod().invoke(campaign, attrValue);
    }

    private void testStringPropertyValue(Campaign campaign, String attrName, String attrValue) throws Exception {
        PropertyDescriptor descriptor = new PropertyDescriptor(attrName, Campaign.class);
        assertEquals((String)descriptor.getReadMethod().invoke(campaign), attrValue);
    }

    private Campaign sendCampaign(Campaign campaign) {
        Observable<Campaign> observable = ccapi.getCampaignService()
                .createCampaign(campaign);
        // synchronous subscriber, will wait until the observer calls onCompleted()
        TestSubscriber<Campaign> testSubscriber = new TestSubscriber<>();
        observable.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        List<Campaign> created = testSubscriber.getOnNextEvents();
        // return the campaign
        return created.get(0);
    }

    private void cleanupCampaign(String id) {
        Observable<Response<Void>> observable = ccapi.getCampaignService()
                .deleteCampaign(id);
        // synchronous subscriber, will wait until the observer calls onCompleted()
        TestSubscriber<Response<Void>> testSubscriber = new TestSubscriber<>();
        observable.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
    }

}
