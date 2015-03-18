package com.constantcontact.services.contacts.tracking;

import com.constantcontact.components.Component;
import com.constantcontact.components.contacts.tracking.TrackingContactsBase;
import com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce;
import com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick;
import com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward;
import com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryByCampaignReport;
import com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport;
import com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend;
import com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.util.List;

/**
 * Service Layer Implementation for the Contact Tracking operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingService extends BaseService implements IContactTrackingService {

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

	public ContactTrackingSummaryReport getSummary(String accessToken, String contactId, String createdSinceTimestamp) throws ConstantContactServiceException {
		ContactTrackingSummaryReport summary = null;
		try {
			String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.Endpoints.CONTACTS_TRACKING_REPORTS_SUMMARY, contactId));
			
			if (createdSinceTimestamp != null) {
				url = appendParam(url,"created_since", createdSinceTimestamp);
			}
			
			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				summary = Component.fromJSON(response.getBody(), ContactTrackingSummaryReport.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return summary;
	}
	
	/**
     * Implements the get Summary By Campaign operation of the Contact Tracking API by calling the ConstantContact server side.
     * 
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contactId The id of the contact.
     * @return The List of {@link ContactTrackingSummaryReport} containing data returned by the server on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public List<ContactTrackingSummaryByCampaignReport> getSummaryByCampaign(String accessToken, String contactId) throws ConstantContactServiceException{
    
        List<ContactTrackingSummaryByCampaignReport> summary = null;
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_REPORTS_BY_CAMPAIGN_SUMMARY, contactId));
            
            String url = sb.toString();

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                summary = Component.listFromJSON(response.getBody(), ContactTrackingSummaryByCampaignReport.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return summary;
    }
	
	/**
     * Implements the get All Activity Types operation of the Contact Tracking API by calling the ConstantContact server side.
     * 
     * @param accessToken Constant Contact OAuth2 access token.
     * @param contactId The id of the contact.
     * @param limit The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
     *         It will return only the clicks performed since the supplied date. <br/>
     *         If you want to bypass this filter, set createdSinceTimestamp to null.
     * @return The {@link ResultSet} of {@link TrackingContactsBase} containing data returned by the server on success; <br/>
     *         An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<? extends TrackingContactsBase> getActivities(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException{
        ResultSet<? extends TrackingContactsBase> activities = null;
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_ALL, contactId));
            
            if (limit != null) {
                sb.append("?limit=").append(limit);
            }
            
            if (createdSinceTimestamp != null) {
                sb.append(limit != null ? "&" : "?");
                sb.append("created_since=").append(createdSinceTimestamp);
            }
            
            String url = sb.toString();

            CUrlResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                activities = Component.resultSetFromJSON(response.getBody(), TrackingContactsBase.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return activities;
    }

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

	public ResultSet<ContactTrackingBounce> getBounces(String accessToken, String contactId, Integer limit) throws ConstantContactServiceException {

		ResultSet<ContactTrackingBounce> bounces = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_BOUNCES, contactId));
			
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				bounces = Component.resultSetFromJSON(response.getBody(), ContactTrackingBounce.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return bounces;
	}

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

	public ResultSet<ContactTrackingClick> getClicks(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingClick> clicks = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_CLICKS, contactId));
			
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
						
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				clicks = Component.resultSetFromJSON(response.getBody(), ContactTrackingClick.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return clicks;
	}
	/**
	 * Implements the get Forwards operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the clicks performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingForward} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ResultSet<ContactTrackingForward> getForwards(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingForward> forwards = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_FORWARDS, contactId));
			
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				forwards = Component.resultSetFromJSON(response.getBody(), ContactTrackingForward.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return forwards;
	}
		
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

	public ResultSet<ContactTrackingOpen> getOpens(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingOpen> opens = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_OPENS, contactId));
			
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				opens = Component.resultSetFromJSON(response.getBody(), ContactTrackingOpen.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return opens;
	}
	
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

	public ResultSet<ContactTrackingSend> getSends(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingSend> sends = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_SENDS, contactId));
			
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				sends = Component.resultSetFromJSON(response.getBody(), ContactTrackingSend.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return sends;
	}
	
	
	/**
	 * Implements the get Unsubscribes operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param limit The limit.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the unsubcribes performed since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link ResultSet} of {@link ContactTrackingUnsubscribe} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

	public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingUnsubscribe> unsubscribes = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Config.instance().getBaseUrl()).append(String.format(Config.Endpoints.CONTACTS_TRACKING_UNSUBSCRIBES, contactId));
			
			if (limit != null) {
				sb.append("?limit=").append(limit);
			}
			
			if (createdSinceTimestamp != null) {
				sb.append(limit != null ? "&" : "?");
				sb.append("created_since=").append(createdSinceTimestamp);
			}
			
			String url = sb.toString();

			CUrlResponse response = getRestClient().get(url, accessToken);

			if (response.hasData()) {
				unsubscribes = Component.resultSetFromJSON(response.getBody(), ContactTrackingUnsubscribe.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return unsubscribes;
	}
	
	/**
	 * Default constructor.
	 */
	public ContactTrackingService() {
		super();
	}
}
