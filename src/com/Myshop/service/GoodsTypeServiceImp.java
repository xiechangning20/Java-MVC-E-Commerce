package com.Myshop.service;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.controller.GoodsTypeController;
import com.Myshop.dao.TypeDaoImp;
import com.Myshop.entity.ProductType;

public class GoodsTypeServiceImp implements GoodsTypeService {

	@Override
	public List<ProductType> findAllgoodsType() throws SQLException {
		TypeDaoImp tdi= new TypeDaoImp();
		 List <ProductType> typeList = tdi.findAllTypes();
		return typeList;
	}

}
