package mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.tracking.bounces.EmailCampaignTrackingBounce;
import com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick;
import com.constantcontact.components.emailcampaigns.tracking.forwards.EmailCampaignTrackingForward;
import com.constantcontact.components.emailcampaigns.tracking.opens.EmailCampaignTrackingOpen;
import com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary;
import com.constantcontact.components.emailcampaigns.tracking.sends.EmailCampaignTrackingSend;
import com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.tracking.EmailCampaignTrackingService;

/**
 * Service Layer Implementation for the Email Campaign Tracking operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignTrackingServiceTest extends EmailCampaignTrackingService {

	/**
	 * Gets the Email Campaign Tracking Summary for a single Email Campaign based on its id.<br/>
	 * Implements the get Summary operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the summary since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return An {@link com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary} containing the summary - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public EmailCampaignTrackingSummary getSummary(String accessToken, String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException {

		EmailCampaignTrackingSummary summary = null;
		try {
				summary = Component.fromJSON(MockedServerResponses.getSummaryEmailCampaignTrackingServiceData, EmailCampaignTrackingSummary.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return summary;
	}

	/**
	 * Gets the Email Campaign Tracking Bounces based on the id of the email campaign.<br/>
	 * Implements the get Bounces operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.bounces.EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingBounce> getBounces(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingBounce> bounces = null;
		try {
				bounces = Component.resultSetFromJSON(MockedServerResponses.getBouncesEmailCampaignTrackingServiceData, EmailCampaignTrackingBounce.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return bounces;
	}

	/**
	 * Gets the Email Campaign Tracking Clicks based on the id of the email campaign.<br/>
	 * Implements the get Clicks operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick} containing the clicks - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingClick> getClicks(String accessToken, String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {

		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
				clicks = Component.resultSetFromJSON(MockedServerResponses.getClicksEmailCampaignTrackingServiceData, EmailCampaignTrackingClick.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return clicks;
	}

	/**
	 * Gets the Email Campaign Tracking Forwards based on the id of the email campaign.<br/>
	 * Implements the get Forwards operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.forwards.EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingForward> getForwards(String accessToken, String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingForward> forwards = null;
		try {
				forwards = Component.resultSetFromJSON(MockedServerResponses.getForwardsEmailCampaignTrackingServicesData, EmailCampaignTrackingForward.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return forwards;
	}

	/**
	 * Gets the Email Campaign Tracking Opens based on the id of the email campaign.<br/>
	 * Implements the get Opens operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.opens.EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingOpen> getOpens(String accessToken, String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingOpen> opens = null;
		try {
				opens = Component.resultSetFromJSON(MockedServerResponses.getOpensEmailCampaignTrackingServicesData, EmailCampaignTrackingOpen.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return opens;
	}

	/**
	 * Gets the Email Campaign Tracking Sends based on the id of the email campaign.<br/>
	 * Implements the get Sends operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.sends.EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingSend> getSends(String accessToken, String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingSend> sends = null;
		try {
				sends = Component.resultSetFromJSON(MockedServerResponses.getSendsEmailCampaignTrackingServicesData, EmailCampaignTrackingSend.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return sends;
	}

	/**
	 * Gets the Email Campaign Tracking Unsubscribes based on the id of the email campaign.<br/>
	 * Implements the get Unsubscribes operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 *
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(String accessToken, String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingUnsubscribe> unsubscribes = null;
		try {
				unsubscribes = Component.resultSetFromJSON(MockedServerResponses.getUnsubscribesEmailCampaignTrackingServicesData, EmailCampaignTrackingUnsubscribe.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return unsubscribes;
	}

	/**
	 * Gets the Email Campaign Tracking Clicks based on the id of the email campaign.<br/>
	 * Implements the get Clicks By Link Id operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @param linkId The link id
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick} containing the clicks for the given link id - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
    @Override
	public ResultSet<EmailCampaignTrackingClick> getClicksByLinkId(String accessToken, String emailCampaignId, String linkId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
				clicks = Component.resultSetFromJSON(MockedServerResponses.getClicksEmailCampaignTrackingServiceData, EmailCampaignTrackingClick.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return clicks;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingServiceTest() {
		super();
	}
}
