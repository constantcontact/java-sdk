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

import com.constantcontact.v2.account.AccountEmailAddress;
import com.constantcontact.v2.account.AccountSummaryInformation;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import java.util.List;

/**
 * Retrofit interface for Account calls against the Constant Contact API.
 *
 */
public interface AccountService {
    /**
     * Get the {@link AccountSummaryInformation} of the account
     *
     * @return an Observable that emits AccountSummaryInformation
     */
    @GET("v2/account/info")
    Observable<AccountSummaryInformation> getAccountSummaryInformation();

    /**
     * Update the {@link AccountSummaryInformation}
     *
     * @param summaryInfo AccountSummaryInformation
     * @return            an Observable that emits AccountSummaryInformation
     */
    @PUT("v2/account/info")
    Observable<AccountSummaryInformation> updateAccountSummaryInformation(@Body AccountSummaryInformation summaryInfo);

    /**
     * Get a list of {@link AccountEmailAddress} for the account
     *
     * @return an Observable that emits a List of AccountEmailAddress
     */
    @GET("v2/account/verifiedemailaddresses")
    Observable<List<AccountEmailAddress>> getAccountEmailAddresses();

    /**
     * Create a new {@link AccountEmailAddress}. This will also prompt a verification
     * email to be sent to the specified address.
     *
     * @param emailAddress AccountEmailAddress
     * @return             an Observable that emits a List of AccountEmailAddress
     */
    @POST("v2/account/verifiedemailaddresses")
    Observable<List<AccountEmailAddress>> createAccountEmailAddress(@Body AccountEmailAddress emailAddress);
}
