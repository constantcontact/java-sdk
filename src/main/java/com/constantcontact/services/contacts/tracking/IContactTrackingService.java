package com.constantcontact.services.contacts.tracking;

import com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce;
import com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick;
import com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward;
import com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport;
import com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend;
import com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

/**
 * Interface for the {@link ContactTrackingService} in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IContactTrackingService extends IBaseService {

	/**
	 * Implements the get Summary operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the summary since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ContactTrackingSummaryReport} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ContactTrackingSummaryReport getSummary(String accessToken, String contactId, String createdSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the get Bounces operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @return The {@link ResultSet} of {@link ContactTrackingBounce} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<ContactTrackingBounce> getBounces(String accessToken, String contactId, Integer limit) throws ConstantContactServiceException;

	/**
	 * Implements the get Clicks operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingClick} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<ContactTrackingClick> getClicks(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the get Forwards operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the forwards performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingForward} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<ContactTrackingForward> getForwards(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the get Opens operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the opens performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingOpen} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<ContactTrackingOpen> getOpens(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the get Sends operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the sends performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingSend} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<ContactTrackingSend> getSends(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;

	/**
	 * Implements the get Unsubscribes operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubscribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingUnsubscribe} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException;
}
