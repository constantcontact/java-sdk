package com.constantcontact.services.emailcampaigns.tracking;

import com.constantcontact.components.emailcampaigns.tracking.bounces.EmailCampaignTrackingBounce;
import com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick;
import com.constantcontact.components.emailcampaigns.tracking.forwards.EmailCampaignTrackingForward;
import com.constantcontact.components.emailcampaigns.tracking.opens.EmailCampaignTrackingOpen;
import com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary;
import com.constantcontact.components.emailcampaigns.tracking.sends.EmailCampaignTrackingSend;
import com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for {@link EmailCampaignTrackingService} class in Constant Contact.<br/>
 * 
 * @author ConstantContact
 * 
 */
public interface IEmailCampaignTrackingService extends IBaseService {

	/**
	 * Implements the get Summary operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @return An {@link EmailCampaignTrackingSummary} containing the summary - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public EmailCampaignTrackingSummary getSummary(String accessToken, String emailCampaignId) throws ConstantContactServiceException;

	/**
	 * Implements the get Bounces operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingBounce> getBounces(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException;

	/**
	 * Implements the get Clicks operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingClick> getClicks(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException;

	/**
	 * Implements the get Forwards operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingForward> getForwards(String accessToken, String emailCampaignId, Integer limit)
			throws ConstantContactServiceException;

	/**
	 * Implements the get Opens operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingOpen> getOpens(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException;

	/**
	 * Implements the get Sends operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingSend> getSends(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException;

	/**
	 * Implements the get Unsubscribes operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(String accessToken, String emailCampaignId, Integer limit)
			throws ConstantContactServiceException;

	/**
	 * Implements the get Clicks By Link Id operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param linkId The link id
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks for the given link id - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingClick> getClicksByLinkId(String accessToken, String emailCampaignId, String linkId, Integer limit)
			throws ConstantContactServiceException;
}
