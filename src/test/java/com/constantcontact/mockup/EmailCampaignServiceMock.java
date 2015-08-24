package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.EmailCampaignService;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Email Campaign operations in Constant
 * Contact.
 *
 * @author ConstantContact
 *
 */
public class EmailCampaignServiceMock extends EmailCampaignService {

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
	 * Gets all the Email Campaigns.<br/>
	 * Implements the get Campaigns operation of the Email Campaign API by
	 * calling the ConstantContact server side.
	 * @param limit
	 *            The limit
	 * @param modifiedSinceTimestamp
	 *            This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
	 *            It will return only the Email Campaigns modified since the
	 *            supplied date. <br/>
	 *            If you want to bypass this filter set modifiedSinceTimestamp
	 *            to null.
	 * @return A
	 *         {@link com.constantcontact.components.generic.response.ResultSet}
	 *         of
	 *         {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

    @Override
    public ResultSet<EmailCampaignResponse> getCampaigns(Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
        ResultSet<EmailCampaignResponse> campaigns = null;
        try {
            campaigns = Component.resultSetFromJSON(
                    MockedServerResponses.getCampaignsEmailCampaignServiceData,
                    EmailCampaignResponse.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return campaigns;
    }

    /**
     * Gets all the Email Campaigns.<br/>
     * Implements the get Campaigns operation of the Email Campaign API by calling the ConstantContact server side.
     *
     * @param pagination A {@link com.constantcontact.components.generic.response.Pagination} instance containing the link to the next page of results.
     *                   An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<EmailCampaignResponse> getCampaigns(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        ResultSet<EmailCampaignResponse> campaigns = null;
        try {
            campaigns = Component.resultSetFromJSON(
                    MockedServerResponses.getCampaignsEmailCampaignServiceData,
                    EmailCampaignResponse.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return campaigns;
    }

	/**
	 * Gets a single Email Campaign.<br/>
	 * Implements the get Campaign operation of the Email Campaign API by
	 * calling the ConstantContact server side.
	 *
	 * @param campaignId
	 *            Id of the Email Campaign to get
	 * @return An
	 *         {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EmailCampaignResponse getCampaign(
			String campaignId) throws ConstantContactServiceException {
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		EmailCampaignResponse campaign = null;
		try {
			campaign = Component.fromJSON(
					MockedServerResponses.getCampaignEmailCampaignServiceData,
					EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return campaign;
	}

	/**
	 * Adds a single Email Campaign.<br/>
	 * Implements the add Campaign operation of the Email Campaign API by
	 * calling the ConstantContact server side.
	 * @param emailCampaign
	 *            The Email Campaign to add
	 * @return An
	 *         {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EmailCampaignResponse addCampaign(
			EmailCampaignRequest emailCampaign)
			throws ConstantContactServiceException {

		if (emailCampaign == null) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		EmailCampaignResponse newEmailCampaign = null;
		try {
			newEmailCampaign = Component.fromJSON(
					MockedServerResponses.addCampaignEmailCampaignServiceData,
					EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newEmailCampaign;
	}

	/**
	 * Updates a single Email Campaign.<br/>
	 * Implements the update Campaign operation of the Email Campaign API by
	 * calling the ConstantContact server side.
	 * @param emailCampaign
	 *            The Email Campaign to update; match is done by id on
	 *            server-side
	 * @return An
	 *         {@link com.constantcontact.components.emailcampaigns.EmailCampaignResponse}
	 *         containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EmailCampaignResponse updateCampaign(
			EmailCampaignRequest emailCampaign)
			throws ConstantContactServiceException {

		if (emailCampaign == null || !(emailCampaign.getId().length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		EmailCampaignResponse updateEmailCampaign = null;
		try {
			updateEmailCampaign = Component
					.fromJSON(
                            MockedServerResponses.updateCampaignEmailCampaignServiceData,
                            EmailCampaignResponse.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updateEmailCampaign;
	}

	/**
	 * Deletes a single Email Campaign.<br/>
	 * Implements the delete Campaign operation of the Email Campaign API by
	 * calling the ConstantContact server side.
	 *
	 * @param emailCampaignId
	 *            Id of the Email Campaign to delete
	 * @return true on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteCampaign(String emailCampaignId)
			throws ConstantContactServiceException {
		return MockedServerResponses.deleteCampaignEmailCampaignServiceData;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignServiceMock(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
