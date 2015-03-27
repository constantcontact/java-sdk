package com.constantcontact.services.accounts;

import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.accounts.VerifiedEmailAddress.Status;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

import java.util.List;

/**
 * Interface for class {@link AccountService} in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public interface IAccountService extends IBaseService {

	/**
	 * Get Verified Email Addresses call.<br>
	 * Implements the Get Verified Email Addresses operation from the Accounts API by calling the ConstantContact server side.
	 * 
	 * @param status The status, as seen in {@link Status}
	 * @return A list of {@link VerifiedEmailAddress} containing values returned from the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public List<VerifiedEmailAddress> getVerifiedEmailAddresses(String status) throws ConstantContactServiceException;

    /**
     * Get Account Summary Info call.<br/>
     * Implements the Get Account Summary Info operation from the Accounts API by calling the ConstantContact server side.
     *
     * @param accessToken Constant Contact OAuth2 access token.
     * @return A {@link AccountInfo} containing values returned from the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public AccountInfo getAccountInfo() throws ConstantContactServiceException;

    /**
     * Updates the Account Info.<br/>
     * Implements the update Account Info operation of the Account Summary Info API by calling the ConstantContact server side.
     *
     * @param accountInfo The account information.
     * @return An {@link AccountInfo} containing data as returned by the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    public AccountInfo updateAccountInfo(AccountInfo accountInfo) throws ConstantContactServiceException;
}
