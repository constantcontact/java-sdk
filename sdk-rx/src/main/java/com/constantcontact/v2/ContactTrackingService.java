/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2;

import com.constantcontact.v2.contacts.Contact;
import com.constantcontact.v2.tracking.*;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Retrofit interface for Email Contact tracking calls against the Constant Contact API.
 * <p>
 * See <a href="https://developer.constantcontact.com/docs/contact-tracking/contact-tracking-all-activities-api.html">Tracking Contact Results</a>
 * on the Constant Contact Developer Website
 *
 */
public interface ContactTrackingService {
    /**
     * The maximum page size for tracking queries.
     */
    int MAX_PAGE_LIMIT = 500;

    /**
     * The default page size for tracking queries.
     */
    int DEFAULT_PAGE_LIMIT = 500;

    /**
     * Get the {@link TrackingSummary} of a {@link Contact}
     *
     * @param contactId The Contact ID
     * @return           an Observable that emits a TrackingSummary
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/reports/summary?updateSummary=true")
    Observable<TrackingSummary> getTrackingSummary(@Path("contactId") String contactId);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged BounceReports
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/bounces")
    Observable<Paged<BounceReport>> getBounceReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged BounceReports
     * @see            Paged
     */
    @GET
    Observable<Paged<BounceReport>> getBounceReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ClickReports
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/clicks")
    Observable<Paged<ClickReport>> getClickReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a specific URL in a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param linkId           The url_uid found in the click_through_details of a Contact
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ClickReports
     * @see                    Contact
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/clicks/{linkId}")
    Observable<Paged<ClickReport>> getClickReports(@Path("contactId") String contactId, @Path("linkId") String linkId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ClickReports
     * @see            Paged
     */
    @GET
    Observable<Paged<ClickReport>> getClickReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ForwardReports
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/forwards")
    Observable<Paged<ForwardReport>> getForwardReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ForwardReports
     * @see            Paged
     */
    @GET
    Observable<Paged<ForwardReport>> getForwardReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OpenReports
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/opens")
    Observable<Paged<OpenReport>> getOpenReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OpenReports
     * @see            Paged
     */
    @GET
    Observable<Paged<OpenReport>> getOpenReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged SendReports
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/sends")
    Observable<Paged<SendReport>> getSendReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET
    Observable<Paged<SendReport>> getSendReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OptOutReports
     */
    @GET("v2/emailmarketing/contacts/{contactId}/tracking/unsubscribes")
    Observable<Paged<OptOutReport>> getOptOutReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OptOutReports
     * @see            Paged
     */
    @GET
    Observable<Paged<OptOutReport>> getOptOutReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link BaseTrackingReport} from a {@link Contact}
     *
     * @param contactId        The Contact ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged BaseTrackingReports
     */
    @GET("v2/contacts/{contactId}/tracking")
    Observable<Paged<BaseTrackingReport>> getAllReports(@Path("contactId") String contactId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BaseTrackingReport} from a {@link Contact} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET
    Observable<Paged<BaseTrackingReport>> getAllReports(@Url String nextLink);
}
