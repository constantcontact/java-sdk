package com.constantcontact.mockup;

import com.constantcontact.components.Component;
import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.accounts.VerifiedEmailAddress.Status;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.accounts.AccountService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer implementation for Account actions in Constant Contact.
 * 
 * @author ConstantContact
 */
public class AccountServiceMock extends AccountService {

	/**
	 * Get Verified Email Addresses call.<br/>
	 * Implements the Get Verified Email Addresses operation from the Accounts API by calling the ConstantContact server side.
	 * 
	 * @param accessToken Constant Contact OAuth2 access token.
	 * @param status The status, as seen in {@link Status}
	 * @return A list of {@link VerifiedEmailAddress} containing values returned from the server on success; <br/>
	 *         An exception is thrown otherwise.
	 * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
	 */

    @Override
	public List<VerifiedEmailAddress> getVerifiedEmailAddresses(String accessToken, String status) throws ConstantContactServiceException {
		List<VerifiedEmailAddress> addresses = new ArrayList<VerifiedEmailAddress>();
		try {
				addresses = Component.listFromJSON(MockedServerResponses.getAccountVerifiedEmailAddressesData, VerifiedEmailAddress.class);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return addresses;
	}

    /**
     * Get Account Summary Info call.<br/>
     * Implements the Get Account Summary Info operation from the Accounts API by calling the ConstantContact server side.
     *
     * @param accessToken Constant Contact OAuth2 access token.
     *
     * @return A {@link AccountInfo} containing values returned from the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    @Override
    public AccountInfo getAccountInfo(String accessToken) throws ConstantContactServiceException {
        AccountInfo accountInfo = null;
        try {
                accountInfo = Component.fromJSON(MockedServerResponses.getAccountInfoData, AccountInfo.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return accountInfo;
    }

    /**
     * Updates the Account Info.<br/>
     * Implements the update Account Info operation of the Account Summary Info API by calling the ConstantContact server side.
     *
     * @param accessToken Constant Contact OAuth2 access token.
     * @param accountInfo The account information.
     * @return An {@link AccountInfo} containing data as returned by the server on success; <br/>
     * An exception is thrown otherwise.
     * @throws ConstantContactServiceException When something went wrong in the Constant Contact flow or an error is returned from server.
     */
    @Override
    public AccountInfo updateAccountInfo(String accessToken, AccountInfo accountInfo) throws ConstantContactServiceException {
        AccountInfo updatedAccountInfo = null;
        try {
                updatedAccountInfo = Component.fromJSON(MockedServerResponses.updateAccountInfoData, AccountInfo.class);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return updatedAccountInfo;
    }

    /**
	 * Default constructor.
	 */
	public AccountServiceMock() {
		super();
	}
}
