package com.Myshop.service;

import java.sql.SQLException;

import com.Myshop.entity.PageBean;
import com.Myshop.entity.Product;

public interface ProductService {

	PageBean<Product> findPage(int ptId, int page, int pageSize) throws SQLException;

	Product findProduct(int pId) throws SQLException;
      
}
