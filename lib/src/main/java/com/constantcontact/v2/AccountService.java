package com.constantcontact.v2;

import com.constantcontact.v2.account.AccountEmailAddress;
import com.constantcontact.v2.account.AccountSummaryInformation;
import retrofit2.Call;
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
    Call<AccountSummaryInformation> getAccountSummaryInformation();

    /**
     * Update the {@link AccountSummaryInformation}
     *
     * @param summaryInfo AccountSummaryInformation
     * @return            an Observable that emits AccountSummaryInformation
     */
    @PUT("v2/account/info")
    Call<AccountSummaryInformation> updateAccountSummaryInformation(@Body AccountSummaryInformation summaryInfo);

    /**
     * Get a list of {@link AccountEmailAddress} for the account
     *
     * @return an Observable that emits a List of AccountEmailAddress
     */
    @GET("v2/account/verifiedemailaddresses")
    Call<List<AccountEmailAddress>> getAccountEmailAddresses();

    /**
     * Create a new {@link AccountEmailAddress}. This will also prompt a verification
     * email to be sent to the specified address.
     *
     * @param emailAddress AccountEmailAddress
     * @return             an Observable that emits a List of AccountEmailAddress
     */
    @POST("v2/account/verifiedemailaddresses")
    Call<List<AccountEmailAddress>> createAccountEmailAddress(@Body AccountEmailAddress emailAddress);
}
