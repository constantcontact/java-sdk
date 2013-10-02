package com.constantcontact.util.http;

public class MultipartBody {

    private byte[] bodyAsBytes;
    
    /**
     * Builds via {@link MultipartBuilder}
     */
    protected MultipartBody(byte[] body){
        bodyAsBytes = body;
    }
    
    public String toString(){
        return bodyAsBytes.toString();
    }
    
}
