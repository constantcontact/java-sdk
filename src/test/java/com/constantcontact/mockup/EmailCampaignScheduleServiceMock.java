package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.emailcampaigns.schedule.EmailCampaignScheduleService;

import java.util.List;

/**
 * Service Layer Implementation for the Email Campaign Schedule operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignScheduleServiceMock extends EmailCampaignScheduleService {

	/**
	 * Gets an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule. <br/>
	 * Implements the get Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return The Email Campaign Schedule containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public EmailCampaignSchedule getSchedule(String accessToken, String campaignId, String scheduleId) throws ConstantContactServiceException {
		EmailCampaignSchedule schedule = null;
		try {
				schedule = Component.fromJSON(MockedServerResponses.getScheduleEmailCampaignScheduleServicesData, EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return schedule;
	}

	/**
	 * Updates an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule . <br/>
	 * Implements the update Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @param emailCampaignSchedule The Email Campaign Schedule to update
	 * @return The Email Campaign Schedule when updated with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public EmailCampaignSchedule updateSchedule(String accessToken, String campaignId, String scheduleId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {

		EmailCampaignSchedule updatedEmailCampaignSchedule = null;
		try {
				updatedEmailCampaignSchedule = Component.fromJSON(MockedServerResponses.updateScheduleEmailCampaignScheduleServicesData, EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return updatedEmailCampaignSchedule;
	}

	/**
	 * Deletes an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule. <br/>
	 * Implements the delete Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return true when deleted with success; an exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public boolean deleteSchedule(String accessToken, String campaignId, String scheduleId) throws ConstantContactServiceException {
        return MockedServerResponses.deleteScheduleEmailCampaignScheduleServicesData;
	}

	/**
	 * Gets all Email Campaign Schedules , based on the id of the Email Campaign. <br/>
	 * Implements the get Schedules (ALL schedules in a campaign) operation of the Email Campaign Schedule API by calling the ConstantContact server side. Get
	 * all Schedules based on campaignId.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @return A {@link java.util.List} of {@link com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule} when found with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public List<EmailCampaignSchedule> getSchedules(String accessToken, String campaignId) throws ConstantContactServiceException {
		List<EmailCampaignSchedule> schedules = null;
		try {
				schedules = Component.listFromJSON(MockedServerResponses.getSchedulesEmailCampaignScheduleServicesData, EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
        return schedules;
	}

	/**
	 * Adds an Email Campaign Schedule based on the id of the Email Campaign. <br/>
	 * Implements the add Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @param emailCampaignSchedule The Email Campaign Schedule to add
	 * @return The Email Campaign Schedule when added with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public EmailCampaignSchedule addSchedule(String accessToken, String campaignId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {
		EmailCampaignSchedule newSchedule = null;
		try {
				newSchedule = Component.fromJSON(MockedServerResponses.addScheduleEmailCampaignScheduleServicesData, EmailCampaignSchedule.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return newSchedule;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignScheduleServiceMock() {
		super();
	}
}
