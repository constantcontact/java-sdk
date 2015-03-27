package com.constantcontact.services.emailcampaigns.schedule;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * Service Layer Implementation for the Email Campaign Schedule operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignScheduleService extends BaseService implements IEmailCampaignScheduleService {

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
	 * Gets an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule. <br/>
	 * Implements the get Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return The Email Campaign Schedule containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignSchedule getSchedule(String campaignId, String scheduleId) throws ConstantContactServiceException {
		
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		EmailCampaignSchedule schedule = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsSchedulesId(), campaignId, scheduleId));
			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				schedule = Component.fromJSON(response.getBody(), EmailCampaignSchedule.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return schedule;
	}

	/**
	 * Updates an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule . <br/>
	 * Implements the update Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @param emailCampaignSchedule The Email Campaign Schedule to update
	 * @return The Email Campaign Schedule when updated with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignSchedule updateSchedule(String campaignId, String scheduleId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.instance().getErrorEmailCampaignScheduleNull());
		}
		
		EmailCampaignSchedule updatedEmailCampaignSchedule = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsSchedulesId(), campaignId, scheduleId));
			String json = emailCampaignSchedule.toJSON();
			RawApiResponse response = getRestClient().put(url, json);
			if (response.hasData()) {
				updatedEmailCampaignSchedule = Component.fromJSON(response.getBody(), EmailCampaignSchedule.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updatedEmailCampaignSchedule;
	}

	/**
	 * Deletes an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule. <br/>
	 * Implements the delete Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return true when deleted with success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public boolean deleteSchedule(String campaignId, String scheduleId) throws ConstantContactServiceException {
		
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsSchedulesId(), campaignId, scheduleId));
			RawApiResponse response = getRestClient().delete(url);
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
	 * Gets all Email Campaign Schedules , based on the id of the Email Campaign. <br/>
	 * Implements the get Schedules (ALL schedules in a campaign) operation of the Email Campaign Schedule API by calling the ConstantContact server side. Get
	 * all Schedules based on campaignId.
	 * 
	 * @param campaignId The id of the email campaign
	 * @return A {@link List} of {@link EmailCampaignSchedule} when found with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public List<EmailCampaignSchedule> getSchedules(String campaignId) throws ConstantContactServiceException {
		
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		
		List<EmailCampaignSchedule> schedules = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsSchedulesIdAll(), campaignId));
			RawApiResponse response = getRestClient().get(url);

			if (response.hasData()) {
				schedules = Component.listFromJSON(response.getBody(), EmailCampaignSchedule.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
			return schedules;
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
	}

	/**
	 * Adds an Email Campaign Schedule based on the id of the Email Campaign. <br/>
	 * Implements the add Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param emailCampaignSchedule The Email Campaign Schedule to add
	 * @return The Email Campaign Schedule when added with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignSchedule addSchedule(String campaignId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {
		
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.instance().getErrorEmailCampaignScheduleNull());
		}
		
		EmailCampaignSchedule newSchedule = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getEmailCampaignsSchedulesIdAll(), campaignId));
			String json = emailCampaignSchedule.toJSON();
			RawApiResponse response = getRestClient().post(url, json);
			if (response.hasData()) {
				newSchedule = Component.fromJSON(response.getBody(), EmailCampaignSchedule.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newSchedule;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignScheduleService(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
