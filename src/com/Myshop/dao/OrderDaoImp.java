package com.Myshop.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.Myshop.entity.Address;
import com.Myshop.entity.OrderDetail;
import com.Myshop.entity.Orders;
import com.Myshop.entity.Product;
import com.Myshop.utils.C3P0Utils;

public class OrderDaoImp implements OrderDao{

	@Override
	public void insert(Orders orders) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
//		u_id int not null,
//	    a_id int not null,
//	    o_total decimal(12,2),
//	    o_time datetime,,
//	    o_status int comment
		String sql = "Insert into orders (o_id,u_id,a_id,o_total,o_time,o_status) values(?,?,?,?,?,?)";
		queryRunner.update(sql,orders.getoId(),orders.getuId(),orders.getaId(),orders.getoTotal(),orders.getoTime(),orders.getoStatus());
	}

	@Override
	public void insertOrderDetail(List<OrderDetail> odList) throws SQLException {
//		p_id int not null,
//	    o_id varchar(64) not null,
//	    od_total decimal(12,2),
//	    od_num int
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "Insert into orderDetail(p_id,o_id,od_total,od_num) values(?,?,?,?)";
		Object [][] odArray = new Object[odList.size()][];
		for(int i = 0;i<odList.size();i++){
			OrderDetail od = odList.get(i);
			odArray[i] = new Object [] {od.getpId(),od.getoId(),od.getOdTotal(),od.getOdNum()};
		}
		
		queryRunner.batch(sql, odArray);
		
	}

	@Override
	public List<Orders> selectOrderByUId(int uId) throws SQLException, IllegalAccessException, InvocationTargetException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select o.o_id as oId, o.u_id as uId, o.a_id as aId,o.o_total as oTotal,o.o_time "
				+ "as oTime, o.o_status as oStatus, a.a_receiver as aReceiver, a.a_phone as aPhone,"
				+ "a.a_address as aAddress, a.a_isDefault as isDefault from orders o join address a on o.a_id = a.a_id where o.u_id = ?";
		List<Map<String,Object>> listMap = queryRunner.query(sql, new MapListHandler(),uId);
		if(listMap == null){
			return null;
		}else{
			List<Orders> orderList = new ArrayList<>();
			for(Map<String,Object> map:listMap){
				Orders orders = new Orders();
				Address address = new Address();
				BeanUtils.populate(orders, map);
				BeanUtils.populate(address, map);
				orders.setAddress(address);
				orderList.add(orders);
				
				}
			return  orderList;
		}
		
		
	}

	@Override
	public Orders selectOrderByOId(String oId) throws IllegalAccessException, InvocationTargetException, SQLException {
		
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select o.o_id as oId, o.u_id as uId, o.a_id as aId,o.o_total as oTotal,o.o_time "
				+ "as oTime, o.o_status as oStatus, a.a_receiver as aReceiver, a.a_phone as aPhone,"
				+ "a.a_address as aAddress, a.a_isDefault as isDefault from orders o join address a on o.a_id = a.a_id where o.o_id = ?";
		
		Map<String,Object> orderMap = queryRunner.query(sql, new MapHandler(),oId);
		if(orderMap == null){
			return null;
		}else{
			
				Orders orders = new Orders();
				Address address = new Address();
				BeanUtils.populate(orders, orderMap);
				BeanUtils.populate(address, orderMap);
				orders.setAddress(address);
				
				
				
			return  orders;
		}
	}

	@Override
	public List<OrderDetail> selectOdByOId(String oId) throws SQLException, IllegalAccessException, InvocationTargetException {
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "SELECT p.p_id as pId, p.pt_id as ptId, p.p_name as pName,p.p_price as pPrice,"
				+ "p.p_date as pDate,p.p_availability as pAvailability,p.p_star as pStar,"
				+ "p.p_description as pDescription, p.p_image as pImage, "
				+ "d.od_id as odId, d.p_id as pId, d.o_id as oId, d.od_Total as odTotal, d.od_num"
				+ " as odNum from product p join orderDetail d on p.p_id = d.p_id where d.o_id=?;";
		List<Map<String,Object>> mapList = queryRunner.query(sql, new MapListHandler(),oId);
		
		if(mapList == null)
		{
			return null;
		
		}else{
			List<OrderDetail> odList = new ArrayList();
			for(Map<String,Object> map : mapList){
				OrderDetail orderDetail = new OrderDetail();
				Product product = new Product();
				BeanUtils.populate(orderDetail, map);
				BeanUtils.populate(product, map);
				orderDetail.setProduct(product);
				 odList.add(orderDetail);
			}
			return odList;
		}
	}

	@Override
	public void payByOid(String oId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "update orders set o_status = 2 where o_id = ? ";
		
		queryRunner.update(sql,oId);
		
	}

	@Override
	public void deleteByOid(String oId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "delete from orders where o_id = ? ";
		
		queryRunner.update(sql,oId);
		
	}

	@Override
	public void deleteOdByOid(String oId) throws SQLException {
		
       QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "delete from orderDetail where o_id = ? ";
		
		queryRunner.update(sql,oId);
	}

	@Override
	public Orders selectOdByAId(String aId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from orders where a_id = ?";
		Orders orders = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class),aId);
		
		return orders;
	}

}
