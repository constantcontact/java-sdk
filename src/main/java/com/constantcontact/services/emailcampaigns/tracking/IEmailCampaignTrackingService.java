package com.constantcontact.services.emailcampaigns.tracking;

import com.constantcontact.components.emailcampaigns.tracking.bounces.EmailCampaignTrackingBounce;
import com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick;
import com.constantcontact.components.emailcampaigns.tracking.forwards.EmailCampaignTrackingForward;
import com.constantcontact.components.emailcampaigns.tracking.opens.EmailCampaignTrackingOpen;
import com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary;
import com.constantcontact.components.emailcampaigns.tracking.sends.EmailCampaignTrackingSend;
import com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe;
import com.constantcontact.components.generic.response.Pagination;
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the summary since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return An {@link EmailCampaignTrackingSummary} containing the summary - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public EmailCampaignTrackingSummary getSummary(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the get Bounces operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 *
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingBounce> getBounces(String emailCampaignId, Integer limit) throws ConstantContactServiceException;

    /**
     * Implements the get Bounces operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingBounce> getBounces(Pagination pagination) throws ConstantContactServiceException;

	/**
	 * Implements the get Clicks operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingClick> getClicks(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

    /**
     * Implements the get Clicks operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * 		   It will return only the clicks performed since the supplied date. <br/>
     * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingClick> getClicks(Pagination pagination) throws ConstantContactServiceException;

	/**
	 * Implements the get Forwards operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 

	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingForward> getForwards(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

    /**
     * Implements the get Forwards operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingForward> getForwards(Pagination pagination) throws ConstantContactServiceException;

	/**
	 * Implements the get Opens operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingOpen> getOpens(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

    /**
     * Implements the get Opens operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingOpen> getOpens(Pagination pagination) throws ConstantContactServiceException;

	/**
	 * Implements the get Sends operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingSend> getSends(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

    /**
     * Implements the get Sends operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingSend> getSends(Pagination pagination) throws ConstantContactServiceException;

	/**
	 * Implements the get Unsubscribes operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

    /**
     * Implements the get Unsubscribes operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(Pagination pagination) throws ConstantContactServiceException;

	/**
	 * Implements the get Clicks By Link Id operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId The id field in Email Campaign
	 * @param linkId The link id
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks for the given link id - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingClick> getClicksByLinkId(String emailCampaignId, String linkId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException;
}
