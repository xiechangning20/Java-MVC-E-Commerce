package com.Myshop.service;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.controller.GoodsTypeController;
import com.Myshop.entity.User;

public interface UserService {
	
	boolean checkUsername(String username) throws SQLException;
	
	int registerUser(User user) throws SQLException;

	
	int activateUser(String uCode) throws SQLException;

	User loginUser(String username,String password) throws SQLException;
	
	
}
