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

import com.constantcontact.v2.campaigns.*;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

/**
 * Retrofit interface for Campaign and Campaign Schedule calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/email-campaigns/email-campaign-api-index.html">Using Email Campaigns</a>
 * on the Constant Contact Developer Website
 *
 */
public interface CampaignService {
    /**
     * The maximum page size for tracking queries.
     */
    int MAX_PAGE_LIMIT = 50;

    /**
     * The default page size for tracking queries.
     */
    int DEFAULT_PAGE_LIMIT = 50;

    /**
     * Get a {@link Campaign}
     *
     * @param campaignId    ID of the campaign
     * @param updateSummary Set to true to ask the server to get the newest tracking info
     * @return              an Observable that emits a Campaign
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}")
    Observable<Campaign> getCampaign(@Path("campaignId") String campaignId, @Query("updateSummary") boolean updateSummary);

    /**
     * Get a {@link Paged} collection of {@link Campaign}
     *
     * @param limit  Size of page to return (1-500)
     * @param status {@link CampaignStatus} to filter by
     * @return       an Observable that emits Paged Campaigns
     */
    @GET("v2/emailmarketing/campaigns")
    Observable<Paged<Campaign>> getCampaigns(@Query("limit") int limit, @Query("status") CampaignStatus status);

    /**
     * Get a {@link Paged} collection of {@link Campaign}
     *
     * @param limit  Size of page to return (1-500)
     * @param date   Date to specify retrieval of campaigns that have been modified since then, in ISO-8601 format
     * @param status {@link CampaignStatus} to filter by
     * @return       an Observable that emits Paged Campaigns
     */
    @GET("v2/emailmarketing/campaigns")
    Observable<Paged<Campaign>> getCampaigns(@Query("limit") int limit, @Query("modified_since") QueryDate date,
                                             @Query("status") CampaignStatus status);

    /**
     * Get a {@link Paged} collection of {@link Campaign}
     *
     * @param nextLink Next link that comes from a previous campaign collection call
     * @return         an Observable that emits Paged Campaigns
     */
    @GET
    Observable<Paged<Campaign>> getCampaigns(@Url String nextLink);

    /**
     * Create a {@link Campaign}
     *
     * @param campaign Campaign
     * @return         an Observable that emits a Campaign
     */
    @POST("v2/emailmarketing/campaigns")
    Observable<Campaign> createCampaign(@Body Campaign campaign);

    /**
     * Update a {@link Campaign}
     *
     * @param campaign   Campaign
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a Campaign
     */
    @PUT("v2/emailmarketing/campaigns/{campaignId}")
    Observable<Campaign> updateCampaign(@Body Campaign campaign, @Path("campaignId") String campaignId);

    /**
     * Delete a {@link Campaign}
     * <p>
     * (Note: the campaign will still exist in the account, and can be restored from the website.)
     *
     * @param campaignId String - ID of the Campaign
     * @return           an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("v2/emailmarketing/campaigns/{campaignId}")
    Observable<Response<Void>> deleteCampaign(@Path("campaignId") String campaignId);

    /**
     * Send a {@link TestSend} of a {@link Campaign}
     *
     * @param testSend   TestSend
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a TestSend
     */
    @POST("v2/emailmarketing/campaigns/{campaignId}/tests")
    Observable<TestSend> sendTestCampaign(@Body TestSend testSend, @Path("campaignId") String campaignId);

    /**
     * Generate a {@link CampaignPreview} of a {@link Campaign}
     *
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a CampaignPreview
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/preview")
    Observable<CampaignPreview> getCampaignPreview(@Path("campaignId") String campaignId);

    /**
     * Create a {@link CampaignSchedule} for a {@link Campaign}
     *
     * @param campaignSchedule CampaignSchedule
     * @param campaignId       ID of the campaign
     * @return                 an Observable that emits a CampaignSchedule
     */
    @POST("v2/emailmarketing/campaigns/{campaignId}/schedules")
    Observable<CampaignSchedule> scheduleCampaign(@Body CampaignSchedule campaignSchedule, @Path("campaignId") String campaignId);

    /**
     * Get a List of current {@link CampaignSchedule} of a {@link Campaign}
     * <p>
     * (Note: Only scheduled campaigns will have schedules, no historical schedules currently exist)
     *
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a List of CampaignSchedules
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/schedules")
    Observable<List<CampaignSchedule>> getCampaignSchedules(@Path("campaignId") String campaignId);

    /**
     * Get the information of a specific {@link CampaignSchedule}
     *
     * @param campaignId ID of the Campaign
     * @param scheduleId ID of the CampaignSchedule
     * @return           an Observable that emits a CampaignSchedule
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/schedules/{scheduleId}")
    Observable<CampaignSchedule> getCampaignSchedule(@Path("campaignId") String campaignId, @Path("scheduleId") String scheduleId);

    /**
     * Update a {@link CampaignSchedule}
     *
     * @param campaignId ID of the Campaign
     * @param scheduleId ID of the CampaignSchedule
     * @return           an Observable that emits a CampaignSchedule
     */
    @PUT("v2/emailmarketing/campaigns/{campaignId}/schedules/{scheduleId}")
    Observable<CampaignSchedule> updateCampaignSchedule(@Path("campaignId") String campaignId, @Path("scheduleId") String scheduleId);

    /**
     * Delete a {@link CampaignSchedule} (i.e. Unschedule the campaign)
     *
     * @param campaignId ID of the Campaign
     * @param scheduleId ID of the CampaignSchedule
     * @return           an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("v2/emailmarketing/campaigns/{campaignId}/schedules/{scheduleId}")
    Observable<Response<Void>> deleteCampaignSchedule(@Path("campaignId") String campaignId, @Path("scheduleId") String scheduleId);
}
