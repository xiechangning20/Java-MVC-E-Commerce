package com.Myshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.controller.GoodsTypeController;
import com.Myshop.entity.ProductType;

public interface TypeDao {
	
	List <ProductType> findAllTypes() throws SQLException;

}
