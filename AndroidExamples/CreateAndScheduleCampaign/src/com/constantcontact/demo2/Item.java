package com.constantcontact.demo2;

public class Item {
	
	private String mId;
	private String mDiplayText;
	
	public String getId() {
		return mId;
	}
	public void setId(String id) {
		mId = id;
	}
	public String getDiplayText() {
		return mDiplayText;
	}
	public void setDiplayText(String diplayText) {
		mDiplayText = diplayText;
	}
	
	@Override
	public String toString() {
		return mDiplayText;
	}
	

}
