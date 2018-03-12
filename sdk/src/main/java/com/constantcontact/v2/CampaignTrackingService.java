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
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

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
    Call<TrackingSummary> getTrackingSummary(@Path("campaignId") String campaignId);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged BounceReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/bounces")
    Call<Paged<BounceReport>> getBounceReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged BounceReports
     * @see            Paged
     */
    @GET
    Call<Paged<BounceReport>> getBounceReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ClickReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/clicks")
    Call<Paged<ClickReport>> getClickReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

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
    Call<Paged<ClickReport>> getClickReports(@Path("campaignId") String campaignId, @Path("linkId") String linkId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ClickReports
     * @see            Paged
     */
    @GET
    Call<Paged<ClickReport>> getClickReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ForwardReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/forwards")
    Call<Paged<ForwardReport>> getForwardReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ForwardReports
     * @see            Paged
     */
    @GET
    Call<Paged<ForwardReport>> getForwardReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OpenReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/opens")
    Call<Paged<OpenReport>> getOpenReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OpenReports
     * @see            Paged
     */
    @GET
    Call<Paged<OpenReport>> getOpenReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged SendReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/sends")
    Call<Paged<SendReport>> getSendReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET
    Call<Paged<SendReport>> getSendReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OptOutReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/unsubscribes")
    Call<Paged<OptOutReport>> getOptOutReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OptOutReports
     * @see            Paged
     */
    @GET
    Call<Paged<OptOutReport>> getOptOutReports(@Url String nextLink);

    /**
     * Get a {@link Paged} collection of {@link BaseTrackingReport} from a {@link Campaign}
     *
     * @param campaignId        The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged BaseTrackingReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking")
    Call<Paged<BaseTrackingReport>> getAllReports(@Path("campaignId") String campaignId, @Query("created_since") QueryDate createdSinceDate,
                                                  @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BaseTrackingReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET
    Call<Paged<BaseTrackingReport>> getAllReports(@Url String nextLink);
}
