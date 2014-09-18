package com.constantcontact.util;

import com.constantcontact.exceptions.service.ConstantContactServiceException;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class ConstantContactExceptionFactory {


    public static ConstantContactServiceException createServiceException(CUrlResponse response, String url)
    {
        ConstantContactServiceException constantContactException = new ConstantContactServiceException(
                ConstantContactServiceException.RESPONSE_ERR_SERVICE);

        response.getInfo().add(new CUrlRequestError("url", url));
        constantContactException.setErrorInfo(response.getInfo());
        constantContactException.setHttpStatusCode(response.getStatusCode());

        return constantContactException;
    }
}
