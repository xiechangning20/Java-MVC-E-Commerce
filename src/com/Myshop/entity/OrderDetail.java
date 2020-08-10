package com.Myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int odId;
	private int pId;
	private String oId;
	private BigDecimal odTotal;
	private int odNum;
	private Product product;
	
	
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getOdId() {
		return odId;
	}
	public void setOdId(int odId) {
		this.odId = odId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public BigDecimal getOdTotal() {
		return odTotal;
	}
	public void setOdTotal(BigDecimal odTotal) {
		this.odTotal = odTotal;
	}
	public int getOdNum() {
		return odNum;
	}
	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}
	@Override
	public String toString() {
		return "OrderDetail [odId=" + odId + ", pId=" + pId + ", oId=" + oId + ", odTotal=" + odTotal + ", odNum="
				+ odNum + "]";
	}
	
	

}
