package com.Myshop.dao;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.Cart;

public interface CartDao {

	Cart selectCart(int uId, int pId) throws SQLException, IllegalAccessException, InvocationTargetException;

	void updateCart(Cart cart) throws SQLException;

	void Insert(Cart newCart) throws SQLException;

	List<Cart> selectCart(int uId) throws SQLException, IllegalAccessException, InvocationTargetException;

	int deleteById(int cId) throws SQLException;

	void updateCart(String cId, BigDecimal cNum, BigDecimal cTotal) throws SQLException;

	void clearAll(String uId) throws SQLException;

}
