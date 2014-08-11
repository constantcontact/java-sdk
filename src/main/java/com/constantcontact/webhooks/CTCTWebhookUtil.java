package com.constantcontact.webhooks;

import com.constantcontact.components.Component;
import com.constantcontact.exceptions.ConstantContactException;
import com.constantcontact.util.Config;
import com.constantcontact.webhooks.helper.WebHookValidator;
import com.constantcontact.webhooks.model.BillingChangeNotification;

import java.security.NoSuchAlgorithmException;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class CTCTWebhookUtil {

    private String clientSecret;

    public CTCTWebhookUtil(String clientSecret) {
        this.setClientSecret(clientSecret);
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * Get Billing Change Notification.<br/>
     *
     * @param xCtctHmacSHA256 The value in the x-ctct-hmac-sha256 header.
     * @param bodyMessage The body message from the POST received from ConstantContact in Webhook callback.
     * @return The {@link com.constantcontact.webhooks.model.BillingChangeNotification} object corresponding to bodyMessage in case of success; an
     * exception is thrown otherwise.
     * @throws java.security.NoSuchAlgorithmException Thrown when the encryption algorithm used for validation is not available. Should not happen.
     * <br/>
     * @throws com.constantcontact.exceptions.ConstantContactException Thrown when :
     * <ul>
     * <li>message encryption does not correspond with x-ctct-hmac-sha256 header value;</li>
     * <li>or an error is raised when parsing the bodyMessage.</li>
     * </ul>
     * <p/>
     * Error message is taken from one of the members of {@link com.constantcontact.util.Config.Errors}
     */

    public BillingChangeNotification getBillingChangeNotification(String xCtctHmacSHA256, String bodyMessage) throws
            ConstantContactException, NoSuchAlgorithmException {
        if (isValidWebhook(xCtctHmacSHA256, bodyMessage)) {
            return Component.fromJSON(bodyMessage, BillingChangeNotification.class);
        } else {
            throw new ConstantContactException(Config.Errors.INVALID_WEBHOOK);
        }
    }

    /**
     * Validates a Webhook message.<br/>
     *
     * @param xCtctHmacSHA256 The value in the x-ctct-hmac-sha256 header.
     * @param bodyMessage The body message from the POST received from ConstantContact in Webhook callback.
     * @return true if in case of success; false if the Webhook is invalid.
     * @throws NoSuchAlgorithmException Thrown when the encryption algorithm used for validation is not available. Should not happen. <br/>
     * @throws ConstantContactException Thrown when: message encryption does not correspond with x-ctct-hmac-sha256 header value. <br/>
     * Error message is taken from one of the members of {@link com.constantcontact.util.Config.Errors}
     */
    public boolean isValidWebhook(String xCtctHmacSHA256, String bodyMessage) throws ConstantContactException, NoSuchAlgorithmException {
        if (getClientSecret() == null) {
            throw new ConstantContactException(Config.Errors.NO_CLIENT_SECRET);
        }
        return new WebHookValidator(xCtctHmacSHA256, bodyMessage, getClientSecret()).isValid();
    }

}
