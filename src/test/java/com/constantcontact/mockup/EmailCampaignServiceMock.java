package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.EmailCampaignService;

/**
 * Service Layer Implementation for the Email Campaign operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignServiceMock extends EmailCampaignService {

	/**
	 * Gets all the Email Campaigns.<br/>
	 * Implements the get Campaigns operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param limit The limit
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the Email Campaigns modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<EmailCampaignResponse> getCampaigns(String accessToken, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<EmailCampaignResponse> campaigns = null;
		try {
				campaigns = Component.resultSetFromJSON(MockedServerResponses.getCampaignsEmailCampaignServiceData, EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return campaigns;
	}
	/**
	 * Gets a single Email Campaign.<br/>
	 * Implements the get Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId Id of the Email Campaign to get
	 * @return An {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public EmailCampaignResponse getCampaign(String accessToken, String campaignId) throws ConstantContactServiceException {
		EmailCampaignResponse campaign = null;
		try {
				campaign = Component.fromJSON(MockedServerResponses.getCampaignEmailCampaignServiceData, EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return campaign;
	}

	/**
	 * Adds a single Email Campaign.<br/>
	 * Implements the add Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaign The Email Campaign to add
	 * @return An {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public EmailCampaignResponse addCampaign(String accessToken, EmailCampaignRequest emailCampaign) throws ConstantContactServiceException {
		EmailCampaignResponse newEmailCampaign = null;
		try {
				newEmailCampaign = Component.fromJSON(MockedServerResponses.addCampaignEmailCampaignServiceData, EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newEmailCampaign;
	}

	/**
	 * Updates a single Email Campaign.<br/>
	 * Implements the update Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaign The Email Campaign to update; match is done by id on server-side
	 * @return An {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public EmailCampaignResponse updateCampaign(String accessToken, EmailCampaignRequest emailCampaign) throws ConstantContactServiceException {
		EmailCampaignResponse updateEmailCampaign = null;
		try {
				updateEmailCampaign = Component.fromJSON(MockedServerResponses.updateCampaignEmailCampaignServiceData, EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updateEmailCampaign;
	}

	/**
	 * Deletes a single Email Campaign.<br/>
	 * Implements the delete Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId Id of the Email Campaign to delete
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public boolean deleteCampaign(String accessToken, String emailCampaignId) throws ConstantContactServiceException {
        return MockedServerResponses.deleteCampaignEmailCampaignServiceData;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignServiceMock() {
		super();
	}
}
