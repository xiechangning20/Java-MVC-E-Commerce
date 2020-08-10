package com.Myshop.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int uId;
	private String uName;
	private String uPassword;
	private String uEmail;
	private int uRole;
	private String uCode;
	private int uStatus;
	
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	
	public int getuRole() {
		return uRole;
	}
	public void setuRole(int uRole) {
		this.uRole = uRole;
	}
	public String getuCode() {
		return uCode;
	}
	public void setuCode(String uCode) {
		this.uCode = uCode;
	}
	public int getuStatus() {
		return uStatus;
	}
	public void setuStatus(int uStatus) {
		this.uStatus = uStatus;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPassword=" + uPassword + ", uEmail=" + uEmail + ", uRole=" + uRole + ", uCode=" + uCode + ", uStatus=" + uStatus + "]";
	}
	
	
	
	
	

}
