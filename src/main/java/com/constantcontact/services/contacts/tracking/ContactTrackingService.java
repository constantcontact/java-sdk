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
import com.constantcontact.components.generic.response.Pagination;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Service Layer Implementation for the Contact Tracking operations in Constant Contact.
 *
 * @author ConstantContact
 */
public class ContactTrackingService extends BaseService implements IContactTrackingService {

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
     * Implements the get Summary operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the summary since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ContactTrackingSummaryReport} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ContactTrackingSummaryReport getSummary(String contactId, String createdSinceTimestamp) throws ConstantContactServiceException {

        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        ContactTrackingSummaryReport summary = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), String.format(Config.instance().getContactsTrackingReportsSummary(), contactId));

            if (createdSinceTimestamp != null) {
                url = appendParam(url, "created_since", createdSinceTimestamp);
            }

            RawApiResponse response = getRestClient().get(url);

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
     * @param contactId The id of the contact.
     *
     * @return The List of {@link ContactTrackingSummaryReport} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public List<ContactTrackingSummaryByCampaignReport> getSummaryByCampaign(String contactId) throws ConstantContactServiceException {

        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        List<ContactTrackingSummaryByCampaignReport> summary = null;

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingReportsByCampaignSummary(), contactId));

            String url = sb.toString();

            RawApiResponse response = getRestClient().get(url);

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
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the clicks performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link TrackingContactsBase} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<? extends TrackingContactsBase> getActivities(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        return getActivities(contactId, limit, createdSinceTimestamp, null);
    }

    /**
     * Implements the get All Activity Types operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *
     * @return The {@link ResultSet} of {@link TrackingContactsBase} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public ResultSet<? extends TrackingContactsBase> getActivities(Pagination pagination) throws ConstantContactServiceException {
        if (pagination == null || pagination.getNextLink() == null) {
            throw new IllegalArgumentException(Config.instance().getErrorPaginationNull());
        }

        return getActivities(null, null, null, pagination);
    }

    /**
     * Implements the get Bounces operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId The id of the contact.
     * @param limit     The limit.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingBounce} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingBounce> getBounces(String contactId, Integer limit) throws ConstantContactServiceException {

        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        return getBounces(contactId, limit, null);
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

        return getBounces(null, null, pagination);
    }

    /**
     * Implements the get Clicks operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the clicks performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingClick} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingClick> getClicks(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        return getClicks(contactId, limit, createdSinceTimestamp);
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

        return getClicks(null, null, null, pagination);
    }

    /**
     * Implements the get Forwards operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the clicks performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingForward} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingForward> getForwards(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {

        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        return getForwards(contactId, limit, createdSinceTimestamp, null);
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

        return getForwards(null, null, null, pagination);
    }

    /**
     * Implements the get Opens operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the opens performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingOpen} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingOpen> getOpens(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }
        return getOpens(contactId, limit, createdSinceTimestamp, null);
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

        return getOpens(null, null, null, pagination);
    }

    /**
     * Implements the get Sends operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the sends performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingSend} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingSend> getSends(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }
        return getSends(contactId, limit, createdSinceTimestamp, null);
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

        return getSends(null, null, null, pagination);
    }

    /**
     * Implements the get Unsubscribes operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the unsubcribes performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingUnsubscribe} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(String contactId, Integer limit, String createdSinceTimestamp) throws ConstantContactServiceException {
        if (contactId == null || !(contactId.length() > 0)) {
            throw new IllegalArgumentException(Config.instance().getErrorId());
        }

        return getUnsubscribes(contactId, limit, createdSinceTimestamp, null);
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

        return getUnsubscribes(null, null, null, pagination);
    }

    /**
     * Private method used the get Activity Types operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the clicks performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     * @param pagination            @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *
     * @return The {@link ResultSet} of {@link TrackingContactsBase} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    private ResultSet<? extends TrackingContactsBase> getActivities(String contactId, Integer limit, String createdSinceTimestamp, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<? extends TrackingContactsBase> activities = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingAll(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
                url = appendParam(url, "created_since", createdSinceTimestamp);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
     * Private method to get Bounces operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId  The id of the contact.
     * @param limit      The limit.
     * @param pagination @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingBounce} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    private ResultSet<ContactTrackingBounce> getBounces(String contactId, Integer limit, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<ContactTrackingBounce> bounces = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingBounces(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
     * Private method to get Clicks operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the clicks performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     * @param pagination            @param pagination A {@link Pagination} instance containing the link to the next page of results.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingClick} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    private ResultSet<ContactTrackingClick> getClicks(String contactId, Integer limit, String createdSinceTimestamp, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<ContactTrackingClick> clicks = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingClicks(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
                url = appendParam(url, "created_since", createdSinceTimestamp);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
     * Private method to get Forwards operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the clicks performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingForward} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    private ResultSet<ContactTrackingForward> getForwards(String contactId, Integer limit, String createdSinceTimestamp, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<ContactTrackingForward> forwards = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingForwards(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
                url = appendParam(url, "created_since", createdSinceTimestamp);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the opens performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingOpen} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    private ResultSet<ContactTrackingOpen> getOpens(String contactId, Integer limit, String createdSinceTimestamp, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<ContactTrackingOpen> opens = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingOpens(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
                url = appendParam(url, "created_since", createdSinceTimestamp);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
     * Private method to get Sends operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the sends performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingSend} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    private ResultSet<ContactTrackingSend> getSends(String contactId, Integer limit, String createdSinceTimestamp, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<ContactTrackingSend> sends = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingSends(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
                url = appendParam(url, "created_since", createdSinceTimestamp);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
     * Private method to get Unsubscribes operation of the Contact Tracking API by calling the ConstantContact server side.
     *
     * @param contactId             The id of the contact.
     * @param limit                 The limit.
     * @param createdSinceTimestamp This time stamp is an ISO-8601 ordinal date supporting offset. <br/>
     *                              It will return only the unsubcribes performed since the supplied date. <br/>
     *                              If you want to bypass this filter, set createdSinceTimestamp to null.
     * @param pagination            A {@link Pagination} instance containing the link to the next page of results.
     *
     * @return The {@link ResultSet} of {@link ContactTrackingUnsubscribe} containing data returned by the server on success; <br/>
     * An exception is thrown otherwise.
     *
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */

    public ResultSet<ContactTrackingUnsubscribe> getUnsubscribes(String contactId, Integer limit, String createdSinceTimestamp, Pagination pagination) throws ConstantContactServiceException {
        ResultSet<ContactTrackingUnsubscribe> unsubscribes = null;
        String url;

        if (pagination == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.instance().getBaseUrl()).append(String.format(Config.instance().getContactsTrackingUnsubscribes(), contactId));
            url = sb.toString();

            try {
                url = appendParam(url, "limit", limit.toString());
                url = appendParam(url, "created_since", createdSinceTimestamp);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = paginateUrl(Config.instance().getBaseUrl(), pagination.getNextLink(), null);
        }

        try {
            RawApiResponse response = getRestClient().get(url);

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
    public ContactTrackingService(String accessToken, String apiKey) {
        super(accessToken, apiKey);
        this.setAccessToken(accessToken);
        this.setApiKey(apiKey);
    }
}
