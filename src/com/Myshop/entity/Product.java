package com.Myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int pId;
	private int ptId; //ID for product type
	private String pName;
	private BigDecimal pPrice;
	private Date pDate;
	private int pAvailability; //0 means no stock 1means yes
	private int pStar; //based on review
	private String pDescription;
	private String pImage; //url for product image
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getPtId() {
		return ptId;
	}
	public void setPtId(int ptId) {
		this.ptId = ptId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public BigDecimal getpPrice() {
		return pPrice;
	}
	public void setpPrice(BigDecimal pPrice) {
		this.pPrice = pPrice;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public int getpAvailability() {
		return pAvailability;
	}
	public void setpAvailability(int pAvailability) {
		this.pAvailability = pAvailability;
	}
	public int getpStar() {
		return pStar;
	}
	public void setpStar(int pStar) {
		this.pStar = pStar;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", ptId=" + ptId + ", pName=" + pName + ", pPrice=" + pPrice + ", pDate=" + pDate
				+ ", pAvailability=" + pAvailability + ", pStar=" + pStar + ", pDescription=" + pDescription
				+ ", pImage=" + pImage + "]";
	}
	
	
	
	
	
	
}
