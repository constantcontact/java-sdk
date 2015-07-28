package com.constantcontact.services.emailcampaigns.test;

import com.constantcontact.components.emailcampaigns.test.EmailCampaignPreview;
import com.constantcontact.components.emailcampaigns.test.EmailCampaignTest;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for {@link EmailCampaignTestService} class in Constant Contact.<br/>
 *
 * @author ConstantContact
 */
public interface IEmailCampaignTestService extends IBaseService {


    /**
     * Implements the get Email Campaign Preview operation of the Email Campaign Test API by calling the ConstantContact server side.
     *
     * @param emailCampaignId The id field in Email Campaign
     * @return An {@link EmailCampaignPreview} containing the preview - values returned by the server side - on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public EmailCampaignPreview getEmailCampaignPreview(String emailCampaignId) throws ConstantContactServiceException;

    /**
     * Implements the Test Sending Email Campaign operation of the Email Campaign Test API by calling the ConstantContact server side.
     *
     * @param emailCampaignId
     * @param emailCampaignTest The {@link EmailCampaignTest} object containing the test contents
     * @return An {@link EmailCampaignTest} containing the test contents - values returned by the server side - on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException
     */
    public EmailCampaignTest testEmailCampaign(String emailCampaignId, EmailCampaignTest emailCampaignTest) throws ConstantContactServiceException;
}
