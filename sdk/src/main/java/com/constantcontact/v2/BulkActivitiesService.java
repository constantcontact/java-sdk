package com.constantcontact.v2;

import com.constantcontact.v2.bulkactivities.*;
import com.sun.istack.internal.NotNull;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Retrofit interface for Bulk Activity calls against the Constant Contact API.
 * <p>
 * See <a href="http://developer.constantcontact.com/docs/bulk_activities_api/using-bulk-activities.html">Using the Bulk Activity Endpoints</a>
 * on the Constant Contact Developer Website
 */
public interface BulkActivitiesService {
    /**
     * {@link AddContacts} to the account
     *
     * @return the result of adding the contacts
     */
    @POST("v2/activities/addcontacts")
    Call<ActivityStatus> addContacts(@Body AddContacts contacts);

    /**
     * Get the {@link ActivityStatus}
     *
     * @param activityId ID of bulk activity
     * @return            a Call that returns ActivityStatus
     */
    @GET("v2/activities/{activityId}")
    Call<ActivityStatus> getActivityStatus(@NotNull @Path("activityId") String activityId);
}
