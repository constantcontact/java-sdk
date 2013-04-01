package com.constantcontact.services.accounts;

import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.components.accounts.VerifiedEmailAddress;
import com.constantcontact.components.accounts.VerifiedEmailAddress.Status;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

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
	@Override
	public List<VerifiedEmailAddress> getVerifiedEmailAddresses(String accessToken, String status) throws ConstantContactServiceException {
		List<VerifiedEmailAddress> addresses = new ArrayList<VerifiedEmailAddress>();
		try {

			String url = appendParam(Config.Endpoints.BASE_URL + String.format(Config.Endpoints.VERIFIEDEMAILADDRESSES), "status", status);
			// Get REST response
			CUrlResponse response = getRestClient().get(url, accessToken);
			if (response.hasData()) {
				addresses = Component.listFromJSON(response.getBody(), VerifiedEmailAddress.class);
			}
			if (response.isError()) {
				ConstantContactServiceException constantContactException = new ConstantContactServiceException(
						ConstantContactServiceException.RESPONSE_ERR_SERVICE);
				response.getInfo().add(new CUrlRequestError("url", url));
				constantContactException.setErrorInfo(response.getInfo());
				throw constantContactException;
			}
		} catch (ConstantContactServiceException e) {
			throw new ConstantContactServiceException(e);
		} catch (Exception e) {
			throw new ConstantContactServiceException(e);
		}
		return addresses;
	}

	/**
	 * Default constructor.
	 */
	public AccountService() {
		super();
	}
}
