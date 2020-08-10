package com.Myshop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.Myshop.entity.Product;
import com.Myshop.utils.C3P0Utils;

public class ProductDaoImp implements ProductDao {

	@Override
	public long selectCountById(int tId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());	
		String sql = "Select count(1) from product where pt_id=?";
		Object Result = queryRunner.query(sql, new ScalarHandler(),tId);
		long count = (long)Result;
		return count;
	}

	@Override
	public List<Product> findProductById(int page, int pageSize, int tId) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

		String sql = "SELECT p_id as pId, pt_id as ptId, p_name as pName,p_price as pPrice,"
				+ "p_date as pDate,p_availability as pAvailability,p_star as pStar,"
				+ "p_description as pDescription, p_image as pImage from product where pt_id=? limit ?,?;";
		
		List <Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),tId,(page-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public Product selectProductById(int pId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

		String sql = "SELECT p_id as pId, pt_id as ptId, p_name as pName,p_price as pPrice,"
				+ "p_date as pDate,p_availability as pAvailability,p_star as pStar,"
				+ "p_description as pDescription, p_image as pImage from product where p_id=?;";
		
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class),pId);
		
		
		return product;
	}

}
