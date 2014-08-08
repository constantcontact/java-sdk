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

    private String ctctHttpHeader;
    private String body;
    private String sharedSecret;

    public WebHookValidator(String xCtctHmacSHA256, String body, String sharedSecret) {
        this.ctctHttpHeader = xCtctHmacSHA256;
        this.body = body;
        this.sharedSecret = sharedSecret;
    }


    public boolean validatePackage() throws NoSuchAlgorithmException {
        Mac macGenerator = Mac.getInstance("HmacSHA256");
        SecretKeySpec encryptedKey = new SecretKeySpec(sharedSecret.getBytes(), "SHA-256");
        try {
            macGenerator.init(encryptedKey);
        } catch (InvalidKeyException e) {
            throw new IllegalStateException("Cannot initialize Mac Generator", e);
        }
        byte[] output = macGenerator.doFinal(body.getBytes());
        System.out.println(Base64.encodeBase64String(output));
        return Base64.encodeBase64String(output).compareToIgnoreCase(ctctHttpHeader) == 0;
    }
}
