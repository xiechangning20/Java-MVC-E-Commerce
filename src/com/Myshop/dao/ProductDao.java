package com.Myshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.Product;


public interface ProductDao {

	long selectCountById(int tId) throws SQLException;

	List<Product> findProductById(int page, int pageSize, int tId) throws SQLException;

	Product selectProductById(int pId) throws SQLException;

}
