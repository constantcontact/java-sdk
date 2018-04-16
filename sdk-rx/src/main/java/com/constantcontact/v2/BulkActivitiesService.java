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

import com.constantcontact.v2.bulkactivities.Activity;
import com.constantcontact.v2.bulkactivities.AddContacts;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
     * @param contacts the set of contacts to import and the contact lists to add them to
     * @return the result of adding the contacts
     */
    @POST("v2/activities/addcontacts")
    Observable<Activity> addContacts(@Body AddContacts contacts);

    /**
     * Get the {@link Activity}
     *
     * @param activityId ID of bulk activity
     * @return an Observable that emits Activity
     */
    @GET("v2/activities/{activityId}")
    Observable<Activity> getActivityStatus(@Path("activityId") String activityId);
}
