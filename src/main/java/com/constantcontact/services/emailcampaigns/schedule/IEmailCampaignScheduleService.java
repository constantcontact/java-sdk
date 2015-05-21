package com.constantcontact.services.emailcampaigns.schedule;

import java.util.List;

import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for the {@link EmailCampaignScheduleService} class in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IEmailCampaignScheduleService extends IBaseService {

	/**
	 * Implements the get Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return The Email Campaign Schedule containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public EmailCampaignSchedule getSchedule(String campaignId, String scheduleId) throws ConstantContactServiceException;

	/**
	 * Implements the update Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @param emailCampaignSchedule The Email Campaign Schedule to update
	 * @return The Email Campaign Schedule containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public EmailCampaignSchedule updateSchedule(String campaignId, String scheduleId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException;

	/**
	 * Implements the delete Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return true when deleted with success; an exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public boolean deleteSchedule(String campaignId, String scheduleId) throws ConstantContactServiceException;

	/**
	 * Implements the get Schedules (ALL schedules in a campaign) operation of the Email Campaign Schedule API by calling the ConstantContact server side. Get
	 * all Schedules based on campaignId.
	 * 
	 * @param campaignId The id of the email campaign
	 * @return A {@link List} of {@link EmailCampaignSchedule} containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public List<EmailCampaignSchedule> getSchedules(String campaignId) throws ConstantContactServiceException;

	/**
	 * Implements the add Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param campaignId The id of the email campaign
	 * @param emailCampaignSchedule The Email Campaign Schedule to add
	 * @return The Email Campaign Schedule containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public EmailCampaignSchedule addSchedule(String campaignId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException;

}
