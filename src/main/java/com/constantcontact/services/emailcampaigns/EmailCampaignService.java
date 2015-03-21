package com.constantcontact.services.emailcampaigns;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.EmailCampaignRequest;
import com.constantcontact.components.emailcampaigns.EmailCampaignResponse;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.net.HttpURLConnection;

/**
 * Service Layer Implementation for the Email Campaign operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignService extends BaseService implements IEmailCampaignService {

	/**
	 * Gets all the Email Campaigns.<br/>
	 * Implements the get Campaigns operation of the Email Campaign API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param limit The limit
	 * @param modifiedSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the Email Campaigns modified since the supplied date. <br/>
	 * 		   If you want to bypass this filter set modifiedSinceTimestamp to null.
	 * @return A {@link ResultSet} of {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ResultSet<EmailCampaignResponse> getCampaigns(String accessToken, Integer limit, String modifiedSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<EmailCampaignResponse> campaigns = null;
		try {
			String url = paginateUrl(String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getEmailCampaigns()), limit);
			
			if(modifiedSinceTimestamp != null)
				url = appendParam(url, "modified_since", modifiedSinceTimestamp);
			
			RawApiResponse response = getRestClient().get(url, accessToken);
			
			if (response.hasData()) {
				campaigns = Component.resultSetFromJSON(response.getBody(), EmailCampaignResponse.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return An {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignResponse getCampaign(String accessToken, String campaignId) throws ConstantContactServiceException {
		EmailCampaignResponse campaign = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsId(), campaignId));
			
			RawApiResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				campaign = Component.fromJSON(response.getBody(), EmailCampaignResponse.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return An {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignResponse addCampaign(String accessToken, EmailCampaignRequest emailCampaign) throws ConstantContactServiceException {
		EmailCampaignResponse newEmailCampaign = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getEmailCampaigns());
			String json = emailCampaign.toJSON();
			
			RawApiResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				newEmailCampaign = Component.fromJSON(response.getBody(), EmailCampaignResponse.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @return An {@link EmailCampaignResponse} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignResponse updateCampaign(String accessToken, EmailCampaignRequest emailCampaign) throws ConstantContactServiceException {
		EmailCampaignResponse updateEmailCampaign = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsId(), emailCampaign.getId()));
			String json = emailCampaign.toJSON();

			RawApiResponse response = getRestClient().put(url, accessToken, json);
			if (response.hasData()) {
				updateEmailCampaign = Component.fromJSON(response.getBody(), EmailCampaignResponse.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public boolean deleteCampaign(String accessToken, String emailCampaignId) throws ConstantContactServiceException {
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsId(), emailCampaignId));
			
			RawApiResponse response = getRestClient().delete(url, accessToken);
			
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
			return response.getStatusCode() == HttpURLConnection.HTTP_NO_CONTENT;
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignService() {
		super();
	}
}
