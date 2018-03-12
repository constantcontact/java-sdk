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

import com.constantcontact.v2.campaigns.Campaign;
import com.constantcontact.v2.tracking.*;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Retrofit interface for Email Campaign tracking calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/campaign-tracking/email-campaign-tracking-.html">Tracking Email Campaign Results</a>
 * on the Constant Contact Developer Website
 *
 */
public interface CampaignTrackingService {
    /**
     * The maximum page size for tracking queries.
     */
    int MAX_PAGE_LIMIT = 500;

    /**
     * The default page size for tracking queries.
     */
    int DEFAULT_PAGE_LIMIT = 500;

    /**
     * Get the {@link TrackingSummary} of a {@link Campaign}
     *
     * @param campaignId The Campaign ID
     * @return           an Observable that emits a TrackingSummary
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/reports/summary?updateSummary=true")
    Observable<TrackingSummary> getTrackingSummary(@Path("campaignId") String campaignId);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged BounceReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/bounces")
    Observable<Paged<BounceReport>> getBounceReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate,
                                                     @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged BounceReports
     * @see            Paged
     */
    @GET
    Observable<Paged<BounceReport>> getBounceReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ClickReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/clicks")
    Observable<Paged<ClickReport>> getClickReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate,
                                                   @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a specific URL in a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param linkId           The url_uid found in the click_through_details of a Campaign
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ClickReports
     * @see                    Campaign
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/clicks/{linkId}")
    Observable<Paged<ClickReport>> getClickReports(@Path("campaignId") String campaignId, @Path("linkId") String linkId,
                                                   @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ClickReports
     * @see            Paged
     */
    @GET
    Observable<Paged<ClickReport>> getClickReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ForwardReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/forwards")
    Observable<Paged<ForwardReport>> getForwardReports(@Path("campaignId") String campaignId,
                                                       @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ForwardReports
     * @see            Paged
     */
    @GET
    Observable<Paged<ForwardReport>> getForwardReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OpenReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/opens")
    Observable<Paged<OpenReport>> getOpenReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate,
                                                 @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OpenReports
     * @see            Paged
     */
    @GET
    Observable<Paged<OpenReport>> getOpenReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged SendReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/sends")
    Observable<Paged<SendReport>> getSendReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate,
                                                 @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET
    Observable<Paged<SendReport>> getSendReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OptOutReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/unsubscribes")
    Observable<Paged<OptOutReport>> getOptOutReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate,
                                                     @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OptOutReports
     * @see            Paged
     */
    @GET
    Observable<Paged<OptOutReport>> getOptOutReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link BaseTrackingReport} from a {@link Campaign}
     *
     * @param campaignId        The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged BaseTrackingReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking")
    Observable<Paged<BaseTrackingReport>> getAllReports(@Path("campaignId") String campaignId, @Query("created_since") String
            createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BaseTrackingReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET
    Observable<Paged<BaseTrackingReport>> getAllReports(@Url String nextLink);
}
