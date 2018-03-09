package com.constantcontact.v2;

import com.constantcontact.v2.bulkactivities.ActivityStatus;
import com.constantcontact.v2.bulkactivities.AddContacts;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
     * @param contacts the set of contacts to import and the contact lists to add them to
     * @return the result of adding the contacts
     */
    @POST("v2/activities/addcontacts")
    Observable<ActivityStatus> addContacts(@Body AddContacts contacts);

    /**
     * Get the {@link ActivityStatus}
     *
     * @param activityId ID of bulk activity
     * @return an Observable that emits ActivityStatus
     */
    @GET("v2/activities/{activityId}")
    Observable<ActivityStatus> getActivityStatus(@Path("activityId") String activityId);
}
