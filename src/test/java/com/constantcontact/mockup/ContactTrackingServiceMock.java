package com.constantcontact.mockup;

import java.util.List;

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
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.contacts.tracking.ContactTrackingService;
import com.constantcontact.util.Config;

/**
 * Service Layer Implementation for the Contact Tracking operations in Constant
 * Contact.
 *
 * @author ConstantContact
 */
public class ContactTrackingServiceMock extends ContactTrackingService {

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
   * Implements the get Summary operation of the Contact Tracking API by
   * calling the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the summary since the supplied date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ContactTrackingSummaryReport getSummary(String contactId, String createdSinceTimestamp)
      throws ConstantContactServiceException {
    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }
    ContactTrackingSummaryReport summary = null;
    try {
      summary = Component
          .fromJSON(
              MockedServerResponses.getSummaryContactTrackingServicesData,
              ContactTrackingSummaryReport.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return summary;
  }

  /**
   * Implements the get Summary By Campaign operation of the Contact Tracking
   * API by calling the ConstantContact server side.
   *
   * @param contactId The id of the contact.
   *
   * @return The List of
   * {@link com.constantcontact.components.contacts.tracking.reports.summary.ContactTrackingSummaryReport}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */
  @Override
  public List<ContactTrackingSummaryByCampaignReport> getSummaryByCampaign(String contactId)
      throws ConstantContactServiceException {
    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }
    List<ContactTrackingSummaryByCampaignReport> summary = null;

    try {
      summary = Component
          .listFromJSON(
              MockedServerResponses.getSummaryByCampaignContactTrackingServicesData,
              ContactTrackingSummaryByCampaignReport.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return summary;
  }

  /**
   * Implements the get All Activity Types operation of the Contact Tracking
   * API by calling the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param limit                 The limit.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the clicks performed since the supplied
   *                              date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.TrackingContactsBase}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */
  @Override
  public ResultSet<? extends TrackingContactsBase> getActivities(String contactId, Integer limit, String createdSinceTimestamp)
      throws ConstantContactServiceException {
    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }

    ResultSet<? extends TrackingContactsBase> activities = null;

    try {
      activities = Component
          .resultSetFromJSON(
              MockedServerResponses.getActivitiesContactTrackingServicesData,
              TrackingContactsBase.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return activities;
  }

  /**
   * Implements the get All Activity Types operation of the Contact Tracking
   * API by calling the ConstantContact server side.
   *
   * @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.TrackingContactsBase}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<? extends TrackingContactsBase> getActivities(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<? extends TrackingContactsBase> activities = null;

    try {
      activities = Component
          .resultSetFromJSON(
              MockedServerResponses.getActivitiesContactTrackingServicesData,
              TrackingContactsBase.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return activities;
  }

  /**
   * Implements the get Bounces operation of the Contact Tracking API by
   * calling the ConstantContact server side.
   *
   * @param contactId The id of the contact.
   * @param limit     The limit.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.bounces.ContactTrackingBounce}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<ContactTrackingBounce> getBounces(
      String contactId, Integer limit)
      throws ConstantContactServiceException {
    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }
    ResultSet<ContactTrackingBounce> bounces = null;
    try {
      bounces = Component
          .resultSetFromJSON(
              MockedServerResponses.getBouncesContactTrackingServicesData,
              ContactTrackingBounce.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return bounces;
  }

  /**
   * Implements the get Bounces operation of the Contact Tracking API by calling the ConstantContact server side.
   *
   * @param pagination @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The {@link ResultSet} of {@link TrackingContactsBase} containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */
  public ResultSet<? extends TrackingContactsBase> getBounces(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<ContactTrackingBounce> bounces = null;
    try {
      bounces = Component
          .resultSetFromJSON(
              MockedServerResponses.getBouncesContactTrackingServicesData,
              ContactTrackingBounce.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return bounces;
  }


  /**
   * Implements the get Clicks operation of the Contact Tracking API by
   * calling the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param limit                 The limit.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the clicks performed since the supplied
   *                              date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.clicks.ContactTrackingClick}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<ContactTrackingClick> getClicks(
      String contactId, Integer limit, String createdSinceTimestamp)
      throws ConstantContactServiceException {
    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }
    ResultSet<ContactTrackingClick> clicks = null;
    try {
      clicks = Component.resultSetFromJSON(
          MockedServerResponses.getClicksContactTrackingServicesData,
          ContactTrackingClick.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return clicks;
  }

  /**
   * Implements the get Clicks operation of the Contact Tracking API by calling the ConstantContact server side.
   *
   * @param pagination @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The {@link ResultSet} of {@link ContactTrackingClick} containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public ResultSet<ContactTrackingClick> getClicks(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<ContactTrackingClick> clicks = null;
    try {
      clicks = Component.resultSetFromJSON(
          MockedServerResponses.getClicksContactTrackingServicesData,
          ContactTrackingClick.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return clicks;
  }

  /**
   * Implements the get Forwards operation of the Contact Tracking API by
   * calling the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param limit                 The limit.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the clicks performed since the supplied
   *                              date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.forwards.ContactTrackingForward}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<ContactTrackingForward> getForwards(
      String contactId, Integer limit, String createdSinceTimestamp)
      throws ConstantContactServiceException {

    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }

    ResultSet<ContactTrackingForward> forwards = null;
    try {
      forwards = Component
          .resultSetFromJSON(
              MockedServerResponses.getForwardsContactTrackingServicesData,
              ContactTrackingForward.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return forwards;
  }

  /**
   * Implements the get Forwards operation of the Contact Tracking API by calling the ConstantContact server side.
   *
   * @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The {@link ResultSet} of {@link ContactTrackingForward} containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public ResultSet<ContactTrackingForward> getForwards(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<ContactTrackingForward> forwards = null;
    try {
      forwards = Component
          .resultSetFromJSON(
              MockedServerResponses.getForwardsContactTrackingServicesData,
              ContactTrackingForward.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return forwards;
  }


  /**
   * Implements the get Opens operation of the Contact Tracking API by calling
   * the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param limit                 The limit.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the opens performed since the supplied
   *                              date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.opens.ContactTrackingOpen}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<ContactTrackingOpen> getOpens(
      String contactId, Integer limit, String createdSinceTimestamp)
      throws ConstantContactServiceException {

    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }

    ResultSet<ContactTrackingOpen> opens = null;
    try {
      opens = Component.resultSetFromJSON(
          MockedServerResponses.getOpensContactTrackingServicesData,
          ContactTrackingOpen.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return opens;
  }

  /**
   * Implements the get Opens operation of the Contact Tracking API by calling the ConstantContact server side.
   *
   * @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The {@link ResultSet} of {@link ContactTrackingOpen} containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public ResultSet<ContactTrackingOpen> getOpens(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<ContactTrackingOpen> opens = null;
    try {
      opens = Component.resultSetFromJSON(
          MockedServerResponses.getOpensContactTrackingServicesData,
          ContactTrackingOpen.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return opens;
  }

  /**
   * Implements the get Sends operation of the Contact Tracking API by calling
   * the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param limit                 The limit.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the sends performed since the supplied
   *                              date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.sends.ContactTrackingSend}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<ContactTrackingSend> getSends(
      String contactId, Integer limit, String createdSinceTimestamp)
      throws ConstantContactServiceException {

    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }

    ResultSet<ContactTrackingSend> sends = null;
    try {
      sends = Component.resultSetFromJSON(
          MockedServerResponses.getSendsContactTrackingServicesData,
          ContactTrackingSend.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return sends;
  }

  /**
   * Implements the get Sends operation of the Contact Tracking API by calling the ConstantContact server side.
   *
   * @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The {@link ResultSet} of {@link ContactTrackingSend} containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */

  public ResultSet<ContactTrackingSend> getSends(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<ContactTrackingSend> sends = null;
    try {
      sends = Component.resultSetFromJSON(
          MockedServerResponses.getSendsContactTrackingServicesData,
          ContactTrackingSend.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return sends;
  }


  /**
   * Implements the get Unsubscribes operation of the Contact Tracking API by
   * calling the ConstantContact server side.
   *
   * @param contactId             The id of the contact.
   * @param limit                 The limit.
   * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
   *                              It will return only the unsubcribes performed since the
   *                              supplied date. <br/>
   *                              If you want to bypass this filter, set createdSinceTimestamp
   *                              to null.
   *
   * @return The
   * {@link com.constantcontact.components.generic.response.ResultSet}
   * of
   * {@link com.constantcontact.components.contacts.tracking.unsubscribes.ContactTrackingUnsubscribe}
   * containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws com.constantcontact.exceptions.service.ConstantContactServiceException When something went wrong in the Constant Contact flow or an
   *                                                                                error is returned from server.
   */

  @Override
  public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
    if (contactId == null || !(contactId.length() > 0)) {
      throw new IllegalArgumentException(Config.instance().getErrorId());
    }

    ResultSet<ContactTrackingUnsubscribe> unsubscribes = null;
    try {
      unsubscribes = Component
          .resultSetFromJSON(
              MockedServerResponses.getUnsubscribesContactTrackingServicesData,
              ContactTrackingUnsubscribe.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return unsubscribes;
  }

  /**
   * Implements the get Unsubscribes operation of the Contact Tracking API by calling the ConstantContact server side.
   *
   * @param pagination A {@link Pagination} instance containing the link to the next page of results.
   *
   * @return The {@link ResultSet} of {@link ContactTrackingUnsubscribe} containing data returned by the server on success; <br/>
   * An exception is thrown otherwise.
   *
   * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
   */
  public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(Pagination pagination) throws ConstantContactServiceException {
    if (pagination == null || pagination.getNextLink() == null) {
      throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
    }

    ResultSet<ContactTrackingUnsubscribe> unsubscribes = null;
    try {
      unsubscribes = Component
          .resultSetFromJSON(
              MockedServerResponses.getUnsubscribesContactTrackingServicesData,
              ContactTrackingUnsubscribe.class);
    } catch (Exception e) {
      throw new ConstantContactServiceException(e);
    }
    return unsubscribes;
  }

  /**
   * Default constructor.
   */
  public ContactTrackingServiceMock(String accessToken, String apiKey) {
    super(accessToken, apiKey);
    this.setAccessToken(accessToken);
    this.setApiKey(apiKey);
  }
}
