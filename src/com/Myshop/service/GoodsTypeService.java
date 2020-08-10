package com.Myshop.service;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.controller.GoodsTypeController;
import com.Myshop.entity.ProductType;

public interface GoodsTypeService {
	List <ProductType> findAllgoodsType() throws SQLException;

}
