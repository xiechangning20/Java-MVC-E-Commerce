package com.Myshop.service;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.dao.ProductDao;
import com.Myshop.dao.ProductDaoImp;
import com.Myshop.entity.PageBean;
import com.Myshop.entity.Product;

public class ProductServiceImp implements ProductService {

	@Override
	public PageBean<Product> findPage(int tId, int page, int pageSize) throws SQLException {
		
	   ProductDao pd = new ProductDaoImp();
	   long count = pd.selectCountById(tId);
	   List<Product> productList = pd.findProductById(page,pageSize,tId);
	   
		
		
		return new PageBean<Product>(productList,page,count,pageSize);
	}

	@Override
	public Product findProduct(int pId) throws SQLException {
		//invoke dao
		ProductDao pd = new ProductDaoImp();
		Product product = pd.selectProductById(pId);
		return product;
	}
	

}
