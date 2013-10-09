package com.constantcontact.services.library;

import com.constantcontact.components.Component;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.services.base.BaseService;
import com.constantcontact.util.CUrlRequestError;
import com.constantcontact.util.CUrlResponse;
import com.constantcontact.util.Config;

public class MyLibraryService extends BaseService implements IMyLibraryService {

    /**
     * Retrieves the information for the MyLibrary product for this account
     * 
     * @param accessToken
     *            The Access Token for your user
     * @throws {@link ConstantContactServiceException} When something went wrong
     *         in the Constant Contact flow or an error is returned from server.
     * @return The {@link MyLibrarySummary} Data
     */
    public MyLibrarySummary getLibraryInfo(String accessToken) throws ConstantContactServiceException {

        MyLibrarySummary summary = null;

        String url = String.format("%1$s%2$s", Config.Endpoints.BASE_URL, Config.Endpoints.LIBRARY_INFO);
        CUrlResponse response = getRestClient().get(url, accessToken);

        if (response.hasData()) {
            try {
                summary = Component.fromJSON(response.getBody(), MyLibrarySummary.class);
            }
            catch (ConstantContactComponentException e) {
                throw new ConstantContactServiceException(e);
            }
        }
        if (response.isError()) {
            ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                    ConstantContactServiceException.RESPONSE_ERR_SERVICE);
            response.getInfo().add(new CUrlRequestError("url", url));
            constantContactException.setErrorInfo(response.getInfo());
            throw constantContactException;
        }
        
        return summary;

    }

}
