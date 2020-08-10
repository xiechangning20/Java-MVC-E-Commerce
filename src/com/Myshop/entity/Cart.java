package com.Myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cId;
	private int pId;//ID for product;
	private int uId;//ID for user;
	private Product product;
	private int cNum;//number of products;
	private BigDecimal cTotal; //price
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public BigDecimal getcTotal() {
		return product.getpPrice().multiply(new BigDecimal(cNum));
	}
	public void setcTotal(BigDecimal cTotal) {
		this.cTotal = cTotal;
	}
	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", pId=" + pId + ", uId=" + uId + ", cNum=" + cNum + ", cTotal=" + cTotal + "]";
	}
	
	
	
	

}
