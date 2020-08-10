package com.Myshop.entity;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int aId;
	private int uId;
	private String aReceiver;
	private String aPhone;
	private String aAddress;
	private int isDefault = 0;  //0 for non default
	
	
	public Address(){}
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getaReceiver() {
		return aReceiver;
	}
	public void setaReceiver(String aReceiver) {
		this.aReceiver = aReceiver;
	}
	public String getaPhone() {
		return aPhone;
	}
	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}
	public String getaAddress() {
		return aAddress;
	}
	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	
	@Override
	public String toString() {
		return "Address [aId=" + aId + ", uId=" + uId + ", aReceiver=" + aReceiver + ", aPhone=" + aPhone
				+ ", aAddress=" + aAddress + ", isDefault=" + isDefault + "]";
	}
	
	
	
	

}
