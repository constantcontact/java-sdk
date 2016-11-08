package com.constantcontact.v2;

import com.constantcontact.v2.campaigns.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

/**
 * Retrofit interface for Campaign and Campaign Schedule calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/email-campaigns/email-campaign-api-index.html">Using Email Campaigns</a>
 * on the Constant Contact Developer Website
 *
 * @author woogienoogie
 */
public interface CampaignService {
    /**
     * Get a {@link Campaign}
     *
     * @param campaignId    ID of the campaign
     * @param updateSummary Set to true to ask the server to get the newest tracking info
     * @return              an Observable that emits a Campaign
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}")
    Call<Campaign> getCampaign(@Path("campaignId") String campaignId, @Query("updateSummary") boolean updateSummary);

    /**
     * Get a {@link Paged} collection of {@link Campaign}
     *
     * @param limit  Size of page to return (1-500)
     * @param status {@link CampaignStatus} to filter by
     * @return       an Observable that emits Paged Campaigns
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns")
    Call<Paged<Campaign>> getCampaigns(@Query("limit") int limit, @Query("status") CampaignStatus status);

    /**
     * Get a {@link Paged} collection of {@link Campaign}
     *
     * @param limit  Size of page to return (1-500)
     * @param date   Date to specify retrieval of campaigns that have been modified since then, in ISO-8601 format
     * @param status {@link CampaignStatus} to filter by
     * @return       an Observable that emits Paged Campaigns
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns")
    Call<Paged<Campaign>> getCampaigns(@Query("limit") int limit, @Query("modified_since") String date, @Query("status") CampaignStatus status);

    /**
     * Get a {@link Paged} collection of {@link Campaign}
     *
     * @param nextLink Next link that comes from a previous campaign collection call
     * @return         an Observable that emits Paged Campaigns
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns?next={next}")
    Call<Paged<Campaign>> getCampaigns(@Path("next") String nextLink);

    /**
     * Create a {@link Campaign}
     *
     * @param campaign Campaign
     * @return         an Observable that emits a Campaign
     */
    @POST("com.constantcontact.v2/emailmarketing/campaigns")
    Call<Campaign> createCampaign(@Body Campaign campaign);

    /**
     * Update a {@link Campaign}
     *
     * @param campaign   Campaign
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a Campaign
     */
    @PUT("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}")
    Call<Campaign> updateCampaign(@Body Campaign campaign, @Path("campaignId") String campaignId);

    /**
     * Delete a {@link Campaign}
     * <p>
     * (Note: the campaign will still exist in the account, and can be restored from the website.)
     *
     * @param campaignId String - ID of the Campaign
     * @return           an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}")
    Call<Response> deleteCampaign(@Path("campaignId") String campaignId);

    /**
     * Send a {@link TestSend} of a {@link Campaign}
     *
     * @param testSend   TestSend
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a TestSend
     */
    @POST("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/tests")
    Call<TestSend> sendTestCampaign(@Body TestSend testSend, @Path("campaignId") String campaignId);

    /**
     * Generate a {@link CampaignPreview} of a {@link Campaign}
     *
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a CampaignPreview
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/preview")
    Call<CampaignPreview> getCampaignPreview(@Path("campaignId") String campaignId);

    /**
     * Create a {@link CampaignSchedule} for a {@link Campaign}
     *
     * @param campaignSchedule CampaignSchedule
     * @param campaignId       ID of the campaign
     * @return                 an Observable that emits a CampaignSchedule
     */
    @POST("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/schedules")
    Call<CampaignSchedule> scheduleCampaign(@Body CampaignSchedule campaignSchedule, @Path("campaignId") String campaignId);

    /**
     * Get a List of current {@link CampaignSchedule} of a {@link Campaign}
     * <p>
     * (Note: Only scheduled campaigns will have schedules, no historical schedules currently exist)
     *
     * @param campaignId ID of the Campaign
     * @return           an Observable that emits a List of CampaignSchedules
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/schedules")
    Call<List<CampaignSchedule>> getCampaignSchedules(@Path("campaignId") String campaignId);

    /**
     * Get the information of a specific {@link CampaignSchedule}
     *
     * @param campaignId ID of the Campaign
     * @param scheduleId ID of the CampaignSchedule
     * @return           an Observable that emits a CampaignSchedule
     */
    @GET("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/schedules/{scheduleId}")
    Call<CampaignSchedule> getCampaignSchedule(@Path("campaignId") String campaignId, @Path("scheduleId") String scheduleId);

    /**
     * Update a {@link CampaignSchedule}
     *
     * @param campaignId ID of the Campaign
     * @param scheduleId ID of the CampaignSchedule
     * @return           an Observable that emits a CampaignSchedule
     */
    @PUT("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/schedules/{scheduleId}")
    Call<CampaignSchedule> updateCampaignSchedule(@Path("campaignId") String campaignId, @Path("scheduleId") String scheduleId);

    /**
     * Delete a {@link CampaignSchedule} (i.e. Unschedule the campaign)
     *
     * @param campaignId ID of the Campaign
     * @param scheduleId ID of the CampaignSchedule
     * @return           an Observable that emits a {@link retrofit2.Response}
     */
    @DELETE("com.constantcontact.v2/emailmarketing/campaigns/{campaignId}/schedules/{scheduleId}")
    Call<Response> deleteCampaignSchedule(@Path("campaignId") String campaignId, @Path("scheduleId") String scheduleId);
}
