package com.Myshop.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.OrderDetail;
import com.Myshop.entity.Orders;

public interface OrderDao {

	void insert(Orders orders) throws SQLException;

	void insertOrderDetail(List<OrderDetail> odList) throws SQLException;

	List<Orders> selectOrderByUId(int uId) throws SQLException, IllegalAccessException, InvocationTargetException;

	Orders selectOrderByOId(String oId) throws IllegalAccessException, InvocationTargetException, SQLException;

	List<OrderDetail> selectOdByOId(String oId) throws SQLException, IllegalAccessException, InvocationTargetException;

	void payByOid(String oId) throws SQLException;

	void deleteByOid(String oId) throws SQLException;

	void deleteOdByOid(String oId) throws SQLException;

	Orders selectOdByAId(String aId) throws SQLException;

}
