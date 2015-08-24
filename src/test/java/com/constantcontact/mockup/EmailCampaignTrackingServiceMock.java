package com.constantcontact.mockup;

import com.constantcontact.components.Component;
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
import com.constantcontact.services.emailcampaigns.tracking.EmailCampaignTrackingService;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Email Campaign Tracking operations in
 * Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignTrackingServiceMock extends
		EmailCampaignTrackingService {

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
	
	/**
	 * Gets the Email Campaign Tracking Summary for a single Email Campaign
	 * based on its id.<br/>
	 * Implements the get Summary operation of the Email Campaign Tracking API
	 * by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the summary since the supplied date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return An
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.reports.summary.EmailCampaignTrackingSummary}
	 *         containing the summary - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public EmailCampaignTrackingSummary getSummary(
			String emailCampaignId, String createdSinceTimestamp)
			throws ConstantContactServiceException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		EmailCampaignTrackingSummary summary = null;
		try {
			summary = Component
					.fromJSON(
							MockedServerResponses.getSummaryEmailCampaignTrackingServiceData,
							EmailCampaignTrackingSummary.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return summary;
	}

	/**
	 * Gets the Email Campaign Tracking Bounces based on the id of the email
	 * campaign.<br/>
	 * Implements the get Bounces operation of the Email Campaign Tracking API
	 * by calling the ConstantContact server side.
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param limit
	 *            The limit
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.bounces.EmailCampaignTrackingBounce}
	 *         containing the bounces - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingBounce> getBounces(String emailCampaignId, Integer limit)
			throws ConstantContactServiceException {
		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		ResultSet<EmailCampaignTrackingBounce> bounces = null;
		try {
			bounces = Component
					.resultSetFromJSON(
							MockedServerResponses.getBouncesEmailCampaignTrackingServiceData,
							EmailCampaignTrackingBounce.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return bounces;
	}

    /**
     * Implements the get Bounces operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link com.constantcontact.components.generic.response.Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingBounce} containing the bounces - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingBounce> getBounces(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignTrackingBounce> bounces = null;
        try {
            bounces = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getBouncesEmailCampaignTrackingServiceData,
                            EmailCampaignTrackingBounce.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return bounces;
    }

	/**
	 * Gets the Email Campaign Tracking Clicks based on the id of the email
	 * campaign.<br/>
	 * Implements the get Clicks operation of the Email Campaign Tracking API by
	 * calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param limit
	 *            The limit
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the clicks performed since the supplied
	 *            date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick}
	 *         containing the clicks - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingClick> getClicks(
			String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
			clicks = Component
					.resultSetFromJSON(
							MockedServerResponses.getClicksEmailCampaignTrackingServiceData,
							EmailCampaignTrackingClick.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return clicks;
	}

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
    public ResultSet<EmailCampaignTrackingClick> getClicks(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignTrackingClick> clicks = null;
        try {
            clicks = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getClicksEmailCampaignTrackingServiceData,
                            EmailCampaignTrackingClick.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return clicks;
    }

	/**
	 * Gets the Email Campaign Tracking Forwards based on the id of the email
	 * campaign.<br/>
	 * Implements the get Forwards operation of the Email Campaign Tracking API
	 * by calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param limit
	 *            The limit
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the forwards performed since the supplied
	 *            date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.forwards.EmailCampaignTrackingForward}
	 *         containing the forwards - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingForward> getForwards(String emailCampaignId, Integer limit,
			String createdSinceTimestamp)
			throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		ResultSet<EmailCampaignTrackingForward> forwards = null;
		try {
			forwards = Component
					.resultSetFromJSON(
							MockedServerResponses.getForwardsEmailCampaignTrackingServicesData,
							EmailCampaignTrackingForward.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return forwards;
	}

    /**
     * Implements the get Forwards operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingForward} containing the forwards - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingForward> getForwards(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignTrackingForward> forwards = null;
        try {
            forwards = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getForwardsEmailCampaignTrackingServicesData,
                            EmailCampaignTrackingForward.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return forwards;
    }

	/**
	 * Gets the Email Campaign Tracking Opens based on the id of the email
	 * campaign.<br/>
	 * Implements the get Opens operation of the Email Campaign Tracking API by
	 * calling the ConstantContact server side.
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param limit
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the opens performed since the supplied
	 *            date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.opens.EmailCampaignTrackingOpen}
	 *         containing the opens - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingOpen> getOpens(
			String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		ResultSet<EmailCampaignTrackingOpen> opens = null;
		try {
			opens = Component
					.resultSetFromJSON(
							MockedServerResponses.getOpensEmailCampaignTrackingServicesData,
							EmailCampaignTrackingOpen.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return opens;
	}

    /**
     * Implements the get Opens operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingOpen} containing the opens - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingOpen> getOpens(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignTrackingOpen> opens = null;
        try {
            opens = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getOpensEmailCampaignTrackingServicesData,
                            EmailCampaignTrackingOpen.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return opens;
    }

	/**
	 * Gets the Email Campaign Tracking Sends based on the id of the email
	 * campaign.<br/>
	 * Implements the get Sends operation of the Email Campaign Tracking API by
	 * calling the ConstantContact server side.
	 * 
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param limit
	 *            The limit
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the sends performed since the supplied
	 *            date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.sends.EmailCampaignTrackingSend}
	 *         containing the sends - values returned by the server side - on
	 *         success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingSend> getSends(
			String emailCampaignId, Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		ResultSet<EmailCampaignTrackingSend> sends = null;
		try {
			sends = Component
					.resultSetFromJSON(
                            MockedServerResponses.getSendsEmailCampaignTrackingServicesData,
                            EmailCampaignTrackingSend.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return sends;
	}

    /**
     * Implements Sends operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingSend} containing the sends - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingSend> getSends(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignTrackingSend> sends = null;
        try {
            sends = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getSendsEmailCampaignTrackingServicesData,
                            EmailCampaignTrackingSend.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return sends;
    }

	/**
	 * Gets the Email Campaign Tracking Unsubscribes based on the id of the
	 * email campaign.<br/>
	 * Implements the get Unsubscribes operation of the Email Campaign Tracking
	 * API by calling the ConstantContact server side.
	 *
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param limit
	 *            The limit
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the unsubscribes performed since the
	 *            supplied date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.unsubscribes.EmailCampaignTrackingUnsubscribe}
	 *         containing the unsubscribes - values returned by the server side
	 *         - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(
			String emailCampaignId, Integer limit,
			String createdSinceTimestamp)
			throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		ResultSet<EmailCampaignTrackingUnsubscribe> unsubscribes = null;
		try {
			unsubscribes = Component
					.resultSetFromJSON(
							MockedServerResponses.getUnsubscribesEmailCampaignTrackingServicesData,
							EmailCampaignTrackingUnsubscribe.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return unsubscribes;
	}

    /**
     * Implements the get Unsubscribes operation of the Email Campaign Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @return A {@link ResultSet} of {@link EmailCampaignTrackingUnsubscribe} containing the unsubscribes - values returned by the server side - on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignTrackingUnsubscribe> getUnsubscribes(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignTrackingUnsubscribe> unsubscribes = null;
        try {
            unsubscribes = Component
                    .resultSetFromJSON(
                            MockedServerResponses.getUnsubscribesEmailCampaignTrackingServicesData,
                            EmailCampaignTrackingUnsubscribe.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return unsubscribes;
    }

	/**
	 * Gets the Email Campaign Tracking Clicks based on the id of the email
	 * campaign.<br/>
	 * Implements the get Clicks By Link Id operation of the Email Campaign
	 * Tracking API by calling the ConstantContact server side.
	 * @param emailCampaignId
	 *            The id field in Email Campaign
	 * @param linkId
	 *            The link id
	 * @param limit
	 *            The limit
	 * @param createdSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the clicks performed since the supplied
	 *            date. <br/>
	 *            If you want to bypass this filter, set createdSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.tracking.clicks.EmailCampaignTrackingClick}
	 *         containing the clicks for the given link id - values returned by
	 *         the server side - on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */
	@Override
	public ResultSet<EmailCampaignTrackingClick> getClicksByLinkId(String emailCampaignId, String linkId,
			Integer limit, String createdSinceTimestamp)
			throws ConstantContactServiceException {

		if (emailCampaignId == null || !(emailCampaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		ResultSet<EmailCampaignTrackingClick> clicks = null;
		try {
			clicks = Component
					.resultSetFromJSON(
							MockedServerResponses.getClicksEmailCampaignTrackingServiceData,
							EmailCampaignTrackingClick.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return clicks;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignTrackingServiceMock(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
