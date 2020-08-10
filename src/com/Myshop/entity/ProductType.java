package com.Myshop.entity;

import java.io.Serializable;

public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ptId;
	private String ptName;
	private String ptDescription;
	public int getPtId() {
		return ptId;
	}
	public void setPtId(int ptId) {
		this.ptId = ptId;
	}
	public String getPtName() {
		return ptName;
	}
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	public String getPtDescription() {
		return ptDescription;
	}
	public void setPtDescription(String ptDescription) {
		this.ptDescription = ptDescription;
	}
	@Override
	public String toString() {
		return "ProductType [ptId=" + ptId + ", ptName=" + ptName + ", ptDescription=" + ptDescription + "]";
	}
	
	
	
	
	

}
