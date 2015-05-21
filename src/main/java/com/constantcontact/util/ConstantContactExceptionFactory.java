package com.constantcontact.util;

import com.constantcontact.exceptions.service.ConstantContactServiceException;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class ConstantContactExceptionFactory {


    public static ConstantContactServiceException createServiceException(RawApiResponse response, String url)
    {
        ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                ConstantContactServiceException.RESPONSE_ERR_SERVICE);

        response.getRawApiRequestError().add(new RawApiRequestError("url", url));
        constantContactException.setErrorInfo(response.getRawApiRequestError());
        constantContactException.setHttpStatusCode(response.getStatusCode());

        return constantContactException;
    }
}
