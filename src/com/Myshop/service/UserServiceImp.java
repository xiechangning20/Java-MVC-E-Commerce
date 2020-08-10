package com.Myshop.service;

import java.sql.SQLException;

import com.Myshop.dao.UserDaoImp;
import com.Myshop.entity.User;
import com.Myshop.utils.EmailUtils;
import com.Myshop.utils.MD5Utils;

public class UserServiceImp implements UserService {

	@Override
	public boolean checkUsername(String username) throws SQLException {
		//invoke UserDao
		UserDaoImp udi= new UserDaoImp();
		User user = udi.selectUserByName(username);
		
		if(user!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public int registerUser(User user) throws SQLException {
		//invoke userDao to insert user;
		UserDaoImp udi = new UserDaoImp();
		int rows = udi.insertUser(user);
		EmailUtils.sendEmail(user);
		
				return rows;
	}

	@Override
	public int activateUser(String uCode) throws SQLException {
		UserDaoImp udi = new UserDaoImp();
		// select user by code 
		User user = udi.selectUserByUcode(uCode);
		
		if(user != null){
			int row = udi.activateUser(user.getuId());
			
			if(user.getuStatus() == 1){
				return 2;//alread activated 
			}
			else return 1;//success
		}
		
		return 0;//failed, couldn't find user with the Ucode
	}

	@Override
	public User loginUser(String username, String password) throws SQLException {
		//invoke userDao
		UserDaoImp udi = new UserDaoImp();
		User user = udi.selectUserByName(username);
		if(user!=null && user.getuPassword().equals(MD5Utils.md5(password))){
			
			return user;
		}
		
		
		return null;
	}

	
	
	

}
