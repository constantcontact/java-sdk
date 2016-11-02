package com.constantcontact.v2;

import com.constantcontact.v2.campaigns.Campaign;
import com.constantcontact.v2.tracking.BounceReport;
import com.constantcontact.v2.tracking.ClickReport;
import com.constantcontact.v2.tracking.ForwardReport;
import com.constantcontact.v2.tracking.OpenReport;
import com.constantcontact.v2.tracking.OptOutReport;
import com.constantcontact.v2.tracking.SendReport;
import com.constantcontact.v2.tracking.TrackingSummary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit interface for Email Campaign tracking calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/campaign-tracking/email-campaign-tracking-.html">Tracking Email Campaign Results</a>
 * on the Constant Contact Developer Website
 *
 * @author woogienoogie
 */
public interface TrackingService {
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
    Call<Paged<BounceReport>> getBounceReports(@Path("campaignId") String campaignId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link BounceReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged BounceReports
     * @see            Paged
     */
    @GET("{path}")
    Call<Paged<BounceReport>> getBounceReports(@Path("path") String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ClickReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/clicks")
    Call<Paged<ClickReport>> getClickReports(@Path("campaignId") String campaignId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

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
    Call<Paged<ClickReport>> getClickReports(@Path("campaignId") String campaignId, @Path("linkId") String linkId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ClickReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ClickReports
     * @see            Paged
     */
    @GET("{path}")
    Call<Paged<ClickReport>> getClickReports(@Path("path") String nextLink);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged ForwardReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/forwards")
    Call<Paged<ForwardReport>> getForwardReports(@Path("campaignId") String campaignId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link ForwardReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged ForwardReports
     * @see            Paged
     */
    @GET("{path}")
    Call<Paged<ForwardReport>> getForwardReports(@Path("path") String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OpenReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/opens")
    Call<Paged<OpenReport>> getOpenReports(@Path("campaignId") String campaignId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OpenReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OpenReports
     * @see            Paged
     */
    @GET("{path}")
    Call<Paged<OpenReport>> getOpenReports(@Path("path") String nextLink);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged SendReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/sends")
    Call<Paged<SendReport>> getSendReports(@Path("campaignId") String campaignId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link SendReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged SendReports
     * @see            Paged
     */
    @GET("{path}")
    Call<Paged<SendReport>> getSendReports(@Path("path") String nextLink);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Campaign}
     *
     * @param campaignId       The Campaign ID
     * @param createdSinceDate Date to specify retrieval of reports that have been created since then, in ISO-8601 format
     * @param limit            Page size to return (1 - 500)
     * @return                 an Observable that emits Paged OptOutReports
     */
    @GET("v2/emailmarketing/campaigns/{campaignId}/tracking/unsubscribes")
    Call<Paged<OptOutReport>> getOptOutReports(@Path("campaignId") String campaignId, @Query("created_since") String createdSinceDate, @Query("limit") int limit);

    /**
     * Get a {@link Paged} collection of {@link OptOutReport} from a {@link Campaign} from a previous call's
     * next link.
     *
     * @param nextLink Value of the path found in the meta of the original call
     * @return         an Observable that emits Paged OptOutReports
     * @see            Paged
     */
    @GET("{path}")
    Call<Paged<OptOutReport>> getOptOutReports(@Path("path") String nextLink);
}
