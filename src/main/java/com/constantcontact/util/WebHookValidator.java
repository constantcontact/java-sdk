package com.constantcontact.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class WebHookValidator {

    /**
     * The x-ctct-hmac-sha256 header value
     */
    private String ctctHttpHeader;

    /**
     * The body message containg the JSON message
     */
    private String body;

    /**
     * The client secret provided by ConstantContact
     */
    private String sharedSecret;


    public WebHookValidator(String xCtctHmacSHA256, String body, String sharedSecret) {
        this.ctctHttpHeader = xCtctHmacSHA256;
        this.body = body;
        this.sharedSecret = sharedSecret;
    }

    /**
     * To verify that the request came from Constant Contact, compute the HMAC digest and compare it to the value in the x-ctct-hmac-sha256 header.
     * If they match, you can be sure that the webhook was sent by Constant Contact and the message has not been compromised.
     *
     * @return true if webhook is valid; false otherwise.
     *
     * @throws NoSuchAlgorithmException Thrown when the encryption algorithm used for validation is not available. (Should not happen.) <br/>
     */

    public boolean isValid() throws NoSuchAlgorithmException {
        Mac macGenerator = Mac.getInstance("HmacSHA256");
        SecretKeySpec encryptedKey = new SecretKeySpec(sharedSecret.getBytes(), "SHA-256");
        try {
            macGenerator.init(encryptedKey);
        } catch (InvalidKeyException e) {
            throw new IllegalStateException("Cannot initialize Mac Generator", e);
        }
        byte[] output = macGenerator.doFinal(body.getBytes());
        return Base64.encodeBase64String(output).compareToIgnoreCase(ctctHttpHeader) == 0;
    }
}
