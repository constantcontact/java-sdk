package com.constantcontact.services.accounts;

import java.util.List;

import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.accounts.VerifiedEmailAddress.Status;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.IBaseService;

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
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param status The status, as seen in {@link Status}
	 * @return A list of {@link VerifiedEmailAddress} containing values returned from the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */
	public List<VerifiedEmailAddress> getVerifiedEmailAddresses(String accessToken, String status) throws ConstantContactServiceException;
}
