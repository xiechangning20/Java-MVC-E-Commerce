package com.Myshop.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.Orders;

public interface OrderService {

	void createOrder(String aId, String uId, String sum) throws SQLException, NumberFormatException, IllegalAccessException, InvocationTargetException;

	List<Orders> findOrdersByUId(int getuId) throws SQLException, IllegalAccessException, InvocationTargetException;

	Orders findOrdersByOId(String oId) throws IllegalAccessException, InvocationTargetException, SQLException;

	void payByOid(String oId) throws SQLException;

	void deleteByOid(String oId) throws SQLException;

}
