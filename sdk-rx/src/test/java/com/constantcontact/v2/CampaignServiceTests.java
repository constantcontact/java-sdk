package com.constantcontact.v2;

import com.constantcontact.v2.campaigns.Campaign;
import com.constantcontact.v2.campaigns.SentToContactList;
import com.constantcontact.v2.converter.jackson.JacksonConverterFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.QueueDispatcher;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.TestCase.assertTrue;

public class CampaignServiceTests {

    private MockWebServer mockWebServer;
    private static final TestSubscriber<Campaign> subscriber = new TestSubscriber<>();
    private static CCApi2 ccapi2;

    private static final String EMOTICONS_STRING = "😉😉 \\u0200 Hello";
    private static final String CONTENT_WITH_EMOTICONS = "<!DOCTYPE HTML><html><body>nothing😉😉</body></html>";
    // some default values to use when creating the campaign
    private static final String ALL_ASCII = "All Ascii";
    private static final String SENT_TO = "1566174080";
    private static final String EMAIL_CONTENT = "<!DOCTYPE HTML><html><body>nothing</body></html>";
    private static final String EMAIL_ADDR = "maria.davila@endurance.com";
    private static final String TEXT_CONTENT = "Hello there";
    private static final String FROM_NAME = "Constant Contact";
    private static final String apiKey = "mariKey";
    private static final String token = "mariToken";

    @Test
    public void testRequestSerialization() throws Exception{
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        DefaultOkHttpClientBuilderFactory okHttpClientBuilderFactory = new DefaultOkHttpClientBuilderFactory();
        OkHttpClient client = okHttpClientBuilderFactory.create("apiKey", "token").build();

        DefaultRetrofitBuilderFactory retrofitBuilderFactory = new DefaultRetrofitBuilderFactory(client);
        /*
        Retrofit retrofit = retrofitBuilderFactory.create()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mockWebServer.url("https://api.constantcontact.com/"))
                .build();
                */
        HttpUrl httpUrl = mockWebServer.url("/");

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                .baseUrl(mockWebServer.url("/"))
                .build();

      //  Retrofit retrofit = retrofitBuilderFactory.create(httpUrl.toString()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
       // ccapi2 = new CCApi2(retrofit);
        final QueueDispatcher dispatcher = new QueueDispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request)
                    throws InterruptedException {
                /*
                ObjectMapper mapper = new ObjectMapper();
                String bodyString = request.getBody().toString();
                System.out.println("Length of received string: " + bodyString.length());
                System.out.println("Calculation of substring length: " + (bodyString.length() - (bodyString.indexOf('{'))));
                bodyString = bodyString.substring(bodyString.indexOf('{'), bodyString.length() - (bodyString.indexOf('{')));
                System.out.println("Request Received: "+ bodyString);
                try {
                    Campaign campaign = mapper.readValue(bodyString, Campaign.class);
                    if (!validateCampaignFields(campaign)) {
                        return new MockResponse().setBody("").setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
                    }
                    return new MockResponse().setBody(bodyString)
                            .setResponseCode(HttpURLConnection.HTTP_OK);
                }
                catch (Exception ex) {
                    return new MockResponse().setBody(ex.getMessage()).setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
                } */
                return new MockResponse().setBody(request.getBody().toString())
                        .setResponseCode(HttpURLConnection.HTTP_OK);
            }

            private boolean validateCampaignFields(Campaign campaign) {
                return validateString(campaign.getSubject()) &&
                        validateString(campaign.getName());
            }

            private boolean validateString(String value) {
                String patternString = "[\u0000-\u00FF]*";
                Pattern pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(value);
                return matcher.matches();
            }
        };
        mockWebServer.setDispatcher(dispatcher);

        CampaignService campaignService = retrofit.create(CampaignService.class);
        Campaign campaign = createCampaign();
        Observable<Campaign> observable = campaignService.createCampaign(campaign);
        TestSubscriber<Campaign> testSubscriber = new TestSubscriber<>();
        observable.subscribe(testSubscriber);
        List<Campaign> created = testSubscriber.getOnNextEvents();
        RecordedRequest request = mockWebServer.takeRequest();
        System.out.println("Request body: " + request.getBody().toString());
        //assertTrue(created.size() == 1);
        mockWebServer.shutdown();
    }

    private Campaign createCampaign() throws Exception{

        Campaign campaign = new Campaign();
        campaign.setName(UUID.randomUUID().toString());
        campaign.setFromName(FROM_NAME);
        SentToContactList sentTo = new SentToContactList();
        sentTo.setId(SENT_TO);
        campaign.setSentToContactLists(new SentToContactList[] {sentTo});
        campaign.setSubject(ALL_ASCII);
        campaign.setEmailContent(EMAIL_CONTENT);
        campaign.setReplyToEmail(EMAIL_ADDR);
        campaign.setTextContent(TEXT_CONTENT);
        campaign.setFromEmail(EMAIL_ADDR);
        return campaign;
    }

}
