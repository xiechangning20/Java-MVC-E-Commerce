package com.Myshop.entity;

import java.util.List;

public class PageBean <T> {
	
    private List<Product> productList;
    private int currentPage;
    private long totalCount;
    private int pageSize;
    private int totalPage;
    
    
	public PageBean(List<Product> productList, int currentPage, long totalCount, int pageSize) {
		
		this.productList = productList;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return (int) Math.ceil(this.totalCount*1.0/this.pageSize);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
    
    
    
}
