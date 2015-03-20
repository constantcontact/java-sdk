package com.constantcontact.util;

import com.constantcontact.ConstantContact;

public class SdkVersion {

	private static SdkVersion instance;
	
    /**
     * SDK Version
     */
	private String ctctSdkVersion;
	
	/**
	 * @return the ctctSdkVersion
	 */
	public String getCtctSdkVersion() {
		return ctctSdkVersion;
	}

	/**
	 * @param ctctSdkVersion the ctctSdkVersion to set
	 */
	public void setCtctSdkVersion(String ctctSdkVersion) {
		this.ctctSdkVersion = ctctSdkVersion;
	}


    public static SdkVersion instance() {
        if (instance == null) {
            instance = new SdkVersion();
        }
        return instance;
    }
    
	private SdkVersion() {
		Package aPackage = ConstantContact.class.getPackage();
        ctctSdkVersion = aPackage.getImplementationVersion();
	}
	
}
