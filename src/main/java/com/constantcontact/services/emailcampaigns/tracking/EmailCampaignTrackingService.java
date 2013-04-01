package com.constantcontact.services.emailcampaigns.tracking;

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
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Email Campaign Tracking operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignTrackingService extends BaseService implements IEmailCampaignTrackingService {

	/**
	 * Gets the Email Campaign Tracking Summary for a single Email Campaign based on its id.<br/>
	 * Implements the get Summary operation of the Email Campaign Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param emailCampaignId The id field in Email Campaign
	 * @return An {@link EmailCampaignTrackingSummary} containing the summary - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public EmailCampaignTrackingSummary getSummary(String accessToken, String emailCampaignId) throws ConstantContactServiceException {

		EmailCampaignTrackingSummary summary = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_REPORTS_SUMMARY, emailCampaignId));
			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				summary = Component.fromJSON(response.getBody(), EmailCampaignTrackingSummary.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingBounce> getBounces(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingBounce> bounces = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_BOUNCES, emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				bounces = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingBounce.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingClick> getClicks(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException {

		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_CLICKS, emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				clicks = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingClick.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingForward> getForwards(String accessToken, String emailCampaignId, Integer limit)
			throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingForward> forwards = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_FORWARDS, emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				forwards = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingForward.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingOpen> getOpens(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingOpen> opens = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_OPENS, emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				opens = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingOpen.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingSend> getSends(String accessToken, String emailCampaignId, Integer limit) throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingSend> sends = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_SENDS, emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				sends = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingSend.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(String accessToken, String emailCampaignId, Integer limit)
			throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingUnsubscribe> unsubscribes = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_UNSUBSCRIBES, emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				unsubscribes = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingUnsubscribe.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks for the given link id - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingClick> getClicksByLinkId(String accessToken, String emailCampaignId, String linkId, Integer limit)
			throws ConstantContactServiceException {
		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.Endpoints.BASE_URL).append(String.format(Config.Endpoints.EMAILCAMPAIGNS_TRACKING_CLICKS_BY_LINK, emailCampaignId, linkId));

			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				clicks = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingClick.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return clicks;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingService() {
		super();
	}
}
