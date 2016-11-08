package com.constantcontact.v2;

import com.constantcontact.v2.account.AccountEmailAddress;
import com.constantcontact.v2.account.AccountSummaryInformation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import rx.Observable;

import java.util.List;

/**
 * Retrofit interface for Account calls against the Constant Contact API.
 *
 * @author woogienoogie
 */
public interface AccountService {
    /**
     * Get the {@link AccountSummaryInformation} of the account
     *
     * @return an Observable that emits AccountSummaryInformation
     */
    @GET("com.constantcontact.v2/account/info")
    Observable<AccountSummaryInformation> getAccountSummaryInformation();

    /**
     * Update the {@link AccountSummaryInformation}
     *
     * @param summaryInfo AccountSummaryInformation
     * @return            an Observable that emits AccountSummaryInformation
     */
    @PUT("com.constantcontact.v2/account/info")
    Observable<AccountSummaryInformation> updateAccountSummaryInformation(@Body AccountSummaryInformation summaryInfo);

    /**
     * Get a list of {@link AccountEmailAddress} for the account
     *
     * @return an Observable that emits a List of AccountEmailAddress
     */
    @GET("com.constantcontact.v2/account/verifiedemailaddresses")
    Observable<List<AccountEmailAddress>> getAccountEmailAddresses();

    /**
     * Create a new {@link AccountEmailAddress}. This will also prompt a verification
     * email to be sent to the specified address.
     *
     * @param emailAddress AccountEmailAddress
     * @return             an Observable that emits a List of AccountEmailAddress
     */
    @POST("com.constantcontact.v2/account/verifiedemailaddresses")
    Observable<List<AccountEmailAddress>> createAccountEmailAddress(@Body AccountEmailAddress emailAddress);
}
