package com.constantcontact.services.emailcampaigns;

import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for {@link EmailCampaignService} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IEmailCampaignService extends IBaseService {

	/**
	 * Gets all the Email Campaigns.<br/>
	 * Implements the get Campaigns operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param limit The limit
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. It will return only the Email Campaigns modified since the supplied date.
	 * @return A {@link ResultSet} of {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	ResultSet<EmailCampaignResponse> getCampaigns(String accessToken, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException;
	
	/**
	 * Gets a single Email Campaign.<br/>
	 * Implements the get Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId Id of the Email Campaign to get
	 * @return An {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	EmailCampaignResponse getCampaign(String accessToken, String campaignId) throws ConstantContactServiceException;

	/**
	 * Adds a single Email Campaign.<br/>
	 * Implements the add Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaign The Email Campaign to add
	 * @return An {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	EmailCampaignResponse addCampaign(String accessToken, EmailCampaignRequest emailCampaign) throws ConstantContactServiceException;

	/**
	 * Updates a single Email Campaign.<br/>
	 * Implements the update Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaign The Email Campaign to update; match is done by id on server-side
	 * @return An {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	EmailCampaignResponse updateCampaign(String accessToken, EmailCampaignRequest emailCampaign) throws ConstantContactServiceException;

	/**
	 * Deletes a single Email Campaign.<br/>
	 * Implements the delete Campaign operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId Id of the Email Campaign to delete
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	boolean deleteCampaign(String accessToken, String emailCampaignId) throws ConstantContactServiceException;
}
