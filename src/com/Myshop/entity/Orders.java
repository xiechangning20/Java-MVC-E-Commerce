package com.Myshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String oId;
	private int uId;
	private int aId;
	private Address address;
	private BigDecimal oTotal;// 
	private Date oTime;
	private int oStatus; /*0 for not paid,2 for paid but not sent,
	3 for sent waiting for receive,4 for received,5 for refund'*/
	private List<OrderDetail> orderDetail;
	
	
	
	
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public String getoId() {
		return oId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public BigDecimal getoTotal() {
		return oTotal;
	}
	public void setoTotal(BigDecimal oTotal) {
		this.oTotal = oTotal;
	}
	public Date getoTime() {
		return oTime;
	}
	public void setoTime(Date oTime) {
		this.oTime = oTime;
	}
	public int getoStatus() {
		return oStatus;
	}
	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
	}
	@Override
	public String toString() {
		return "Orders [oId=" + oId + ", uId=" + uId + ", aId=" + aId + ", oTotal=" + oTotal + ", oTime=" + oTime
				+ ", oStatus=" + oStatus + "]";
	}
	
	

}
