package com.constantcontact.demo;

import com.constantcontact.ConstantContact;

public class GlobalConfig {

	private String mAccessToken;
	private ConstantContact mConstantContact;
	
	private static final class SingletonHolder {
		private static final GlobalConfig INSTANCE = new GlobalConfig();
	}
	
	/**
	 * The Singleton getter method for GlobalConfig.
	 * 
	 * @return The instance of GlobalConfig class.
	 */
	public static final GlobalConfig getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public String getAccessToken() {
		return mAccessToken;
	}

	public void setAccessToken(String mAccessToken) {
		this.mAccessToken = mAccessToken;
	}
	
	public void setConstantContactService(ConstantContact mConstantContact) {
		this.mConstantContact = mConstantContact;
	}	
	public ConstantContact getConstantContactService() {
		return mConstantContact;
	}
}
