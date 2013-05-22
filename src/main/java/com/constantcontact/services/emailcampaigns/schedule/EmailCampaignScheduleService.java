package com.constantcontact.services.emailcampaigns.schedule;

import java.net.HttpURLConnection;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Email Campaign Schedule operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class EmailCampaignScheduleService extends BaseService implements IEmailCampaignScheduleService {

	/**
	 * Gets an Email Campaign Schedule based on the id of the Email Campaign and the id of the schedule. <br/>
	 * Implements the get Schedule operation of the Email Campaign Schedule API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @param scheduleId The id of the schedule
	 * @return The Email Campaign Schedule containing data as returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignSchedule getSchedule(String accessToken, String campaignId, String scheduleId) throws ConstantContactServiceException {
		EmailCampaignSchedule schedule = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EMAILCAMPAIGNS_SCHEDULES_ID, campaignId, scheduleId));
			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				schedule = Component.fromJSON(response.getBody(), EmailCampaignSchedule.class);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignSchedule updateSchedule(String accessToken, String campaignId, String scheduleId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {

		EmailCampaignSchedule updatedEmailCampaignSchedule = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EMAILCAMPAIGNS_SCHEDULES_ID, campaignId, scheduleId));
			String json = emailCampaignSchedule.toJSON();
			CUrlResponse response = getRestClient().put(url, accessToken, json);
			if (response.hasData()) {
				updatedEmailCampaignSchedule = Component.fromJSON(response.getBody(), EmailCampaignSchedule.class);
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
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public boolean deleteSchedule(String accessToken, String campaignId, String scheduleId) throws ConstantContactServiceException {
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EMAILCAMPAIGNS_SCHEDULES_ID, campaignId, scheduleId));
			CUrlResponse response = getRestClient().delete(url, accessToken);
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @return A {@link List} of {@link EmailCampaignSchedule} when found with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public List<EmailCampaignSchedule> getSchedules(String accessToken, String campaignId) throws ConstantContactServiceException {
		List<EmailCampaignSchedule> schedules = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EMAILCAMPAIGNS_SCHEDULES_ID_ALL, campaignId));
			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				schedules = Component.listFromJSON(response.getBody(), EmailCampaignSchedule.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param campaignId The id of the email campaign
	 * @param emailCampaignSchedule The Email Campaign Schedule to add
	 * @return The Email Campaign Schedule when added with success, containing data as returned by the server; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public EmailCampaignSchedule addSchedule(String accessToken, String campaignId, EmailCampaignSchedule emailCampaignSchedule)
			throws ConstantContactServiceException {
		EmailCampaignSchedule newSchedule = null;
		try {
			String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, String.format(Config.Endpoints.EMAILCAMPAIGNS_SCHEDULES_ID_ALL, campaignId));
			String json = emailCampaignSchedule.toJSON();
			CUrlResponse response = getRestClient().post(url, accessToken, json);
			if (response.hasData()) {
				newSchedule = Component.fromJSON(response.getBody(), EmailCampaignSchedule.class);
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
		return newSchedule;
	}

	/**
	 * Default constructor.
	 */
	public EmailCampaignScheduleService() {
		super();
	}
}
