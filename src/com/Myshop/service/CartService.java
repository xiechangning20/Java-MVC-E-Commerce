package com.Myshop.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.Cart;

public interface CartService {

	Cart createCart(int uId, int pId) throws SQLException, IllegalAccessException, InvocationTargetException;

	List<Cart> getCartbyUid(int uId) throws SQLException, IllegalAccessException, InvocationTargetException;

	int deleteCart(int cId) throws SQLException;

	void updateCart(String cId, String cNum , String pPrice) throws SQLException;

	void clear(String uId) throws SQLException;

}
