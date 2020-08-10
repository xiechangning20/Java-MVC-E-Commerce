package com.Myshop.dao;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.Myshop.entity.Cart;
import com.Myshop.entity.Product;
import com.Myshop.utils.C3P0Utils;

public class CartDaoImp implements CartDao {

	@Override
	public Cart selectCart(int uId, int pId) throws SQLException, IllegalAccessException, InvocationTargetException {
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "SELECT p.p_id as pId, p.pt_id as ptId, p.p_name as pName,p.p_price as pPrice,"
				+ "p.p_date as pDate,p.p_availability as pAvailability,p.p_star as pStar,"
				+ "p.p_description as pDescription, p.p_image as pImage, c.c_id as cId, c.u_id as uId, c.c_num as cNum, c.c_total as cTotal"
				+ " from product p join cart c on p.p_id = c.p_id where c.u_id=? and c.p_id=?;";
		
		Map<String, Object> query = queryRunner.query(sql, new MapHandler(),uId,pId);
		
		if(query==null){
			return null;
		}else{
		
		Cart cart = new Cart();
		Product product = new Product();
		BeanUtils.populate(cart,query);
		BeanUtils.populate(product, query);
		
		cart.setProduct(product);
		
		return cart;
		}
	} 

	@Override
	public void updateCart(Cart cart) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "update cart set c_num = ?, c_total = ? where c_id=?";
		
		queryRunner.update(sql,cart.getcNum(),cart.getcTotal(),cart.getcId());
		
	}

	@Override
	public void Insert(Cart newCart) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
//		//p_id int not null comment'id for product',
//	    u_id int not null comment'id for user',
//	    c_num int comment'number of products',
//	    c_total decimal(12,2) 
		String sql = "insert into cart (u_id,p_id,c_num,c_total) values(?,?,?,?);";
		queryRunner.update(sql,newCart.getuId(),newCart.getpId(),newCart.getcNum(),
				newCart.getcTotal());
		
	}

	@Override
	public List<Cart> selectCart(int uId) throws SQLException, IllegalAccessException, InvocationTargetException {
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "SELECT p.p_id as pId, p.pt_id as ptId, p.p_name as pName,p.p_price as pPrice,"
				+ "p.p_date as pDate,p.p_availability as pAvailability,p.p_star as pStar,"
				+ "p.p_description as pDescription, p.p_image as pImage, c.c_id as cId, c.u_id as uId, c.c_num as cNum, c.c_total as cTotal"
				+ " from product p join cart c on p.p_id = c.p_id where c.u_id=?;";
		
		List<Map<String,Object>> mapList = queryRunner.query(sql, new MapListHandler(), uId);
		
		if(mapList == null){
			return null;
		}else{
		 List<Cart> cartList = new ArrayList();
		for(Map map : mapList){
			Cart cart = new Cart();
			Product product = new Product();
		    BeanUtils.populate(cart, map);
		    BeanUtils.populate(product, map);
		    cart.setProduct(product);
		    cartList.add(cart);
			
			
		}
		
		return cartList;
		}
	}

	@Override
	public int deleteById(int cId) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "Delete from cart where c_id = ? ";
		
		int row = queryRunner.update(sql,cId);
		
		return row;
	}

	@Override
	public void updateCart(String cId, BigDecimal cNum, BigDecimal cTotal) throws SQLException {
		
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "update cart set c_num=?, c_total=? where c_id=?";
		
		 queryRunner.update(sql,cNum,cTotal,cId);
		
	}

	@Override
	public void clearAll(String uId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "Delete from cart where u_id = ? ";
		
		int row = queryRunner.update(sql,uId);
		
	}

}
