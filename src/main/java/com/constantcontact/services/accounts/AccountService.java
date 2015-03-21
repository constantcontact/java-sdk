package com.constantcontact.services.accounts;

import com.constantcontact.components.Component;
import com.constantcontact.components.accounts.AccountInfo;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.accounts.VerifiedEmailAddress.Status;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.RawApiResponse;
import com.constantcontact.util.Config;
import com.constantcontact.util.ConstantContactExceptionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer implementation for Account actions in Constant Contact.
 * 
 * @author ConstantContact
 */
public class AccountService extends BaseService implements IAccountService {

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

	public List<VerifiedEmailAddress> getVerifiedEmailAddresses(String accessToken, String status) throws ConstantContactServiceException {
		List<VerifiedEmailAddress> addresses = new ArrayList<VerifiedEmailAddress>();
		try {

			String url = appendParam(Config.instance().getBaseUrl() + String.format(Config.instance().getVerifiedEmailAddresses()), "status", status);
			// Get REST response
			RawApiResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				addresses = Component.listFromJSON(response.getBody(), VerifiedEmailAddress.class);
			}
			if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
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
    public AccountInfo getAccountInfo(String accessToken) throws ConstantContactServiceException {
        AccountInfo accountInfo = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getAccountInfo());

            RawApiResponse response = getRestClient().get(url, accessToken);

            if (response.hasData()) {
                accountInfo = Component.fromJSON(response.getBody(), AccountInfo.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
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
    public AccountInfo updateAccountInfo(String accessToken, AccountInfo accountInfo) throws ConstantContactServiceException {
        AccountInfo updatedAccountInfo = null;
        try {
            String url = String.format("%1$s%2$s", Config.instance().getBaseUrl(), Config.instance().getAccountInfo());
            String json = accountInfo.toJSON();

            RawApiResponse response = getRestClient().put(url, accessToken, json);
            if (response.hasData()) {
                updatedAccountInfo = Component.fromJSON(response.getBody(), AccountInfo.class);
            }
            if (response.isError()) {
                throw ConstantContactExceptionFactory.createServiceException(response, url);
            }
        } catch (ConstantContactServiceException e) {
            throw new ConstantContactServiceException(e);
        } catch (Exception e) {
            throw new ConstantContactServiceException(e);
        }
        return updatedAccountInfo;
    }

    /**
	 * Default constructor.
	 */
	public AccountService() {
		super();
	}
}
