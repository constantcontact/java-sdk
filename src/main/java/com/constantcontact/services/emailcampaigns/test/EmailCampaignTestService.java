package com.constantcontact.services.emailcampaigns.test;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.test.EmailCampaignPreview;
import com.constantcontact.components.emailcampaigns.test.EmailCampaignTest;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;
import com.constantcontact.util.RawApiResponse;

/**
 * Service Layer Implementation for the Email Campaign Test operations in Constant Contact.
 *
 * @author ConstantContact
 */
public class EmailCampaignTestService extends BaseService implements IEmailCampaignTestService {

    private String accessToken;
    private String apikey;

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
     * @return the apikey
     */
    public String getApikey() {
        return apikey;
    }

    /**
     * @param apikey the apikey to set
     */
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }


    /**
     * Gets the Email Campaign Preview for a single Email Campaign based on its id.<br/>
     * Implements the get Email Campaign Preview operation of the Email Campaign Test API by calling the ConstantContact server side.
     *
     * @param emailCampaignId The id field in Email Campaign
     * @return An {@link EmailCampaignPreview} containing the preview - values returned by the server side - on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public EmailCampaignPreview getEmailCampaignPreview(String emailCampaignId) throws ConstantContactServiceException {

        if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        EmailCampaignPreview emailCampaignPreview = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsPreview(), emailCampaignId));

            RawApiResponse response = getRestClient().get(url);

            if (response.hasData()) {
                emailCampaignPreview = Component.fromJSON(response.getBody(), EmailCampaignPreview.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return emailCampaignPreview;
    }

    /**
     * Tests a Email Campaign based on its id.<br/>
     * Implements the Test Sending Email Campaign operation of the Email Campaign Test API by calling the ConstantContact server side.
     *
     * @param emailCampaignId
     * @param emailCampaignTest The {@link EmailCampaignTest} object containing the test contents
     * @return An {@link EmailCampaignTest} containing the test contents - values returned by the server side - on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException
     */
    public EmailCampaignTest testEmailCampaign(String emailCampaignId, EmailCampaignTest emailCampaignTest) throws ConstantContactServiceException {

        if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        if (emailCampaignTest == null) {
            throw new IllegalArgumentException(Config.instance().getErrorEmailCampaignTestNull());
        }

        EmailCampaignTest emailCampaignTestResponse = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsTests(), emailCampaignId));
            String json = emailCampaignTest.toJSON();
            RawApiResponse response = getRestClient().post(url, json);

            if (response.hasData()) {
                emailCampaignTestResponse = Component.fromJSON(response.getBody(), EmailCampaignTest.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return emailCampaignTestResponse;
    }

    /**
     * Default constructor.
     */
    public EmailCampaignTestService(String accessToken, String apiKey) {
        super(accessToken, apiKey);
        this.setAccessToken(accessToken);
        this.setApikey(apiKey);
    }
}
