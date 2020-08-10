package com.Myshop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Myshop.controller.GoodsTypeController;
import com.Myshop.entity.ProductType;
import com.Myshop.utils.C3P0Utils;

public class TypeDaoImp implements TypeDao {

	@Override
	public List <ProductType> findAllTypes() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());	
		String sql = "SELECT pt_id as ptId, pt_name as ptName, pt_description as ptDescription from productType";
		List <ProductType> typeList = queryRunner.query(sql, new BeanListHandler <ProductType>(ProductType.class));
		
		
		return typeList;
	}

}
