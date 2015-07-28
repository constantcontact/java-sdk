package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.test.EmailCampaignPreview;
import com.constantcontact.components.emailcampaigns.test.EmailCampaignTest;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.test.EmailCampaignTestService;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Email Campaign operations in Constant
 * Contact.
 *
 * @author ConstantContact
 */
public class EmailCampaignTestServiceMock extends EmailCampaignTestService {

    private String accessToken;
    private String apiKey;

    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return the apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @param apiKey the apiKey to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public EmailCampaignPreview getEmailCampaignPreview(String emailCampaignId) throws ConstantContactServiceException {

        if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        EmailCampaignPreview emailCampaignPreview = null;
        try {
            emailCampaignPreview = Component.fromJSON(MockedServerResponses.getEmailCampaignPreviewData, EmailCampaignPreview.class);

        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return emailCampaignPreview;
    }

    @Override
    public EmailCampaignTest testEmailCampaign(String emailCampaignId, EmailCampaignTest emailCampaignTest) throws ConstantContactServiceException {

        if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        if (emailCampaignTest == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEmailCampaignTestNull());
        }

        EmailCampaignTest emailCampaignTestResponse = null;
        try {
            emailCampaignTestResponse = Component.fromJSON(MockedServerResponses.testEmailCampaignData, EmailCampaignTest.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return emailCampaignTestResponse;
    }

    /**
     * Default constructor.
     */
    public EmailCampaignTestServiceMock(String accessToken, String apiKey) {
        super(accessToken, apiKey);
        this.setAccessToken(accessToken);
        this.setApiKey(apiKey);
    }
}
