package com.constantcontact.util.http;

public class MultipartBody {

    private byte[] bodyAsBytes;
    
    /**
     * Builds via {@link MultipartBuilder}
     */
    protected MultipartBody(byte[] body){
        bodyAsBytes = body;
    }
    
    public byte[] getBytes(){
        return bodyAsBytes;
    }
    
    public String toString(){
        return bodyAsBytes.toString();
    }
    
}
