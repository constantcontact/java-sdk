package mockup;

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
import com.constantcontact.services.contacts.tracking.ContactTrackingService;

import java.util.List;

/**
 * Service Layer Implementation for the Contact Tracking operations in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class ContactTrackingServiceTest extends ContactTrackingService {

	/**
	 * Implements the get Summary operation of the Contact Tracking API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param contactId The id of the contact.
	 * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/> 
	 * 		   It will return only the summary since the supplied date. <br/>
	 * 		   If you want to bypass this filter, set createdSinceTimestamp to null.
	 * @return The {@link com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ContactTrackingSummaryReport getSummary(String accessToken, String contactId, String createdSinceTimestamp) throws ConstantContactServiceException {
		ContactTrackingSummaryReport summary = null;
		try {
				summary = Component.fromJSON(MockedServerResponses.getSummaryContactTrackingServicesData, ContactTrackingSummaryReport.class);
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
     * @return The List of {@link com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport} containing data returned by the server on success; <br/>
     *         An exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    @Override
    public List<ContactTrackingSummaryByCampaignReport> getSummaryByCampaign(String accessToken, String contactId) throws ConstantContactServiceException{
    
        List<ContactTrackingSummaryByCampaignReport> summary = null;
        
        try {
                summary = Component.listFromJSON(MockedServerResponses.getSummaryByCampaignContactTrackingServicesData, ContactTrackingSummaryByCampaignReport.class);
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
     * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.TrackingContactsBase} containing data returned by the server on success; <br/>
     *         An exception is thrown otherwise.
     * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    @Override
    public ResultSet<? extends TrackingContactsBase> getActivities(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException{
        ResultSet<? extends TrackingContactsBase> activities = null;
        
        try {
                activities = Component.resultSetFromJSON(MockedServerResponses.getActivitiesContactTrackingServicesData, TrackingContactsBase.class);
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
	 * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<ContactTrackingBounce> getBounces(String accessToken, String contactId, Integer limit) throws ConstantContactServiceException {

		ResultSet<ContactTrackingBounce> bounces = null;
		try {
				bounces = Component.resultSetFromJSON(MockedServerResponses.getBouncesContactTrackingServicesData, ContactTrackingBounce.class);
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
	 * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<ContactTrackingClick> getClicks(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingClick> clicks = null;
		try {
				clicks = Component.resultSetFromJSON(MockedServerResponses.getClicksContactTrackingServicesData, ContactTrackingClick.class);
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
	 * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<ContactTrackingForward> getForwards(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingForward> forwards = null;
		try {
				forwards = Component.resultSetFromJSON(MockedServerResponses.getForwardsContactTrackingServicesData, ContactTrackingForward.class);
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
	 * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<ContactTrackingOpen> getOpens(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingOpen> opens = null;
		try {
				opens = Component.resultSetFromJSON(MockedServerResponses.getOpensContactTrackingServicesData, ContactTrackingOpen.class);
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
	 * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<ContactTrackingSend> getSends(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingSend> sends = null;
		try {
				sends = Component.resultSetFromJSON(MockedServerResponses.getSendsContactTrackingServicesData, ContactTrackingSend.class);
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
	 * @return The {@link com.constantcontact.components.generic.response.ResultSet} of {@link com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe} containing data returned by the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(String accessToken, String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
		ResultSet<ContactTrackingUnsubscribe> unsubscribes = null;
		try {
				unsubscribes = Component.resultSetFromJSON(MockedServerResponses.getUnsubscribesContactTrackingServicesData, ContactTrackingUnsubscribe.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return unsubscribes;
	}
	
	/**
	 * Default constructor.
	 */
	public ContactTrackingServiceTest() {
		super();
	}
}
