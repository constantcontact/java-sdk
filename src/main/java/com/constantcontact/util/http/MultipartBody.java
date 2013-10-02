package com.constantcontact.util.http;

public class MultipartBody {

    private byte[] bodyAsBytes;
    
    /**
     * Builds via {@link MultipartBuilder}
     */
    protected MultipartBody(byte[] body){
        bodyAsBytes = body;
    }
    
    /**
     * Returns the message body as an array of bytes
     * @return
     */
    public byte[] getBytes(){
        return bodyAsBytes;
    }
    
    /**
     * For debugging; returns the byte array as a string.
     */
    public String toString(){
        return bodyAsBytes.toString();
    }
    
}
