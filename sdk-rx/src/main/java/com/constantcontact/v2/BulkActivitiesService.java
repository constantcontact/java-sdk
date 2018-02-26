package com.constantcontact.v2;

import com.constantcontact.v2.bulkactivities.ActivityStatus;
import com.constantcontact.v2.bulkactivities.AddContacts;
import com.sun.istack.internal.NotNull;
import retrofit2.http.*;

import rx.Observable;

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
    Observable<ActivityStatus> addContacts(@Body AddContacts contacts);

    /**
     * Get the {@link ActivityStatus}
     *
     * @param activityId ID of bulk activity
     * @return            an Observable that emits ActivityStatus
     */
    @GET("v2/activities/{activityId}")
    Observable<ActivityStatus> getActivityStatus(@NotNull @Path("activityId") String activityId);
}
