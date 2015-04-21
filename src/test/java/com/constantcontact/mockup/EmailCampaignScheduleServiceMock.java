package com.constantcontact.mockup;

import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.schedule.EmailCampaignScheduleService;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Email Campaign Schedule operations in
 * Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignScheduleServiceMock extends
		EmailCampaignScheduleService {

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
	 * Gets an Email Campaign Schedule based on the id of the Email Campaign and
	 * the id of the schedule. <br/>
	 * Implements the get Schedule operation of the Email Campaign Schedule API
	 * by calling the ConstantContact server side.
	 * 
	 * @param campaignId
	 *            The id of the email campaign
	 * @param scheduleId
	 *            The id of the schedule
	 * @return The Email Campaign Schedule containing data as returned by the
	 *         server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EmailCampaignSchedule getSchedule(
			String campaignId, String scheduleId)
			throws ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}

		EmailCampaignSchedule schedule = null;
		try {
			schedule = Component
					.fromJSON(
							MockedServerResponses.getScheduleEmailCampaignScheduleServicesData,
							EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return schedule;
	}

	/**
	 * Updates an Email Campaign Schedule based on the id of the Email Campaign
	 * and the id of the schedule . <br/>
	 * Implements the update Schedule operation of the Email Campaign Schedule
	 * API by calling the ConstantContact server side.
	 * 
	 * @param campaignId
	 *            The id of the email campaign
	 * @param scheduleId
	 *            The id of the schedule
	 * @param emailCampaignSchedule
	 *            The Email Campaign Schedule to update
	 * @return The Email Campaign Schedule when updated with success, containing
	 *         data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EmailCampaignSchedule updateSchedule(
			String campaignId, String scheduleId,
			EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEmailCampaignScheduleNull());
		}

		EmailCampaignSchedule updatedEmailCampaignSchedule = null;
		try {
			updatedEmailCampaignSchedule = Component
					.fromJSON(
							MockedServerResponses.updateScheduleEmailCampaignScheduleServicesData,
							EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updatedEmailCampaignSchedule;
	}

	/**
	 * Deletes an Email Campaign Schedule based on the id of the Email Campaign
	 * and the id of the schedule. <br/>
	 * Implements the delete Schedule operation of the Email Campaign Schedule
	 * API by calling the ConstantContact server side.
	 * 
	 * @param campaignId
	 *            The id of the email campaign
	 * @param scheduleId
	 *            The id of the schedule
	 * @return true when deleted with success; an exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public boolean deleteSchedule(String campaignId,
			String scheduleId) throws ConstantContactServiceException {
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (scheduleId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		return MockedServerResponses.deleteScheduleEmailCampaignScheduleServicesData;
	}

	/**
	 * Gets all Email Campaign Schedules , based on the id of the Email
	 * Campaign. <br/>
	 * Implements the get Schedules (ALL schedules in a campaign) operation of
	 * the Email Campaign Schedule API by calling the ConstantContact server
	 * side. Get all Schedules based on campaignId.
	 * @param campaignId
	 *            The id of the email campaign
	 * @return A {@link java.util.List} of
	 *         {@link com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule}
	 *         when found with success, containing data as returned by the
	 *         server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public List<EmailCampaignSchedule> getSchedules(
			String campaignId) throws ConstantContactServiceException {
		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		List<EmailCampaignSchedule> schedules = null;
		try {
			schedules = Component
					.listFromJSON(
							MockedServerResponses.getSchedulesEmailCampaignScheduleServicesData,
							EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return schedules;
	}

	/**
	 * Adds an Email Campaign Schedule based on the id of the Email Campaign. <br/>
	 * Implements the add Schedule operation of the Email Campaign Schedule API
	 * by calling the ConstantContact server side.
	 * 
	 * @param campaignId
	 *            The id of the email campaign
	 * @param emailCampaignSchedule
	 *            The Email Campaign Schedule to add
	 * @return The Email Campaign Schedule when added with success, containing
	 *         data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException
	 *             When something went wrong in the Constant Contact flow or an
	 *             error is returned from server.
	 */

	@Override
	public EmailCampaignSchedule addSchedule(
			String campaignId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {

		if (campaignId == null || !(campaignId.length() > 0)) {
			throw new IllegalArgumentException(Config.instance().getErrorId());
		}
		if (emailCampaignSchedule == null) {
			throw new IllegalArgumentException(Config.instance()
					.getErrorEmailCampaignScheduleNull());
		}

		EmailCampaignSchedule newSchedule = null;
		try {
			newSchedule = Component
					.fromJSON(
							MockedServerResponses.addScheduleEmailCampaignScheduleServicesData,
							EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newSchedule;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignScheduleServiceMock(String accessToken, String apiKey) {
		super(accessToken, apiKey);
		this.setAccessToken(accessToken);
		this.setApiKey(apiKey);
	}
}
