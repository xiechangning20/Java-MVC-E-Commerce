package com.Myshop.dao;

import java.sql.SQLException;

import com.Myshop.entity.User;

public interface UserDao {
	User selectUserByName(String username) throws SQLException;
	
	int insertUser(User user) throws SQLException;
	
	User selectUserByUcode(String uCode) throws SQLException;
	
	int activateUser(int uId) throws SQLException;
	
	

}
