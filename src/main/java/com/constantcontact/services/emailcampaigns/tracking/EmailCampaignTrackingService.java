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
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

/**
 * Service Layer Implementation for the Email Campaign Tracking operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignTrackingService extends BaseService implements IEmailCampaignTrackingService {

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
	 * Gets the Email Campaign Tracking Summary for a single Email Campaign based on its id.<br/>
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
	public EmailCampaignTrackingSummary getSummary(String emailCampaignId, String createdSinceTimestamp) throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		EmailCampaignTrackingSummary summary = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsTrackingReportsSummary(), emailCampaignId));
			
			if (createdSinceTimestamp != null) {
				url = appendParam(url,"created_since", createdSinceTimestamp);
			}			
			
			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				summary = Component.fromJSON(response.getBody(), EmailCampaignTrackingSummary.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingBounce> getBounces(String emailCampaignId, Integer limit) throws ConstantContactServiceException {
		
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingBounce> bounces = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingBounces(), emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				bounces = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingBounce.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingClick} containing the clicks - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingClick> getClicks(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingClicks(), emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				clicks = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingClick.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingForward> getForwards(String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {
		
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingForward> forwards = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingForwards(), emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				forwards = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingForward.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingOpen> getOpens(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingOpen> opens = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingOpens(), emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				opens = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingOpen.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingSend> getSends(String emailCampaignId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingSend> sends = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingSends(), emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				sends = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingSend.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	 * @param emailCampaignId The id field in Email Campaign
	 * @param limit The limit
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {
		
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingUnsubscribe> unsubscribes = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingUnsubscribes(), emailCampaignId));
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}

			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}

			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				unsubscribes = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingUnsubscribe.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
			throws ConstantContactServiceException {
		
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getEmailCampaignsTrackingClicksByLink(), emailCampaignId, linkId));

			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				clicks = Component.resultSetFromJSON(response.getBody(), EmailCampaignTrackingClick.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
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
	public EmailCampaignTrackingService(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApikey(apiKey);
	}
}
