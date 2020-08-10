package com.Myshop.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.Myshop.controller.Constants;
import com.Myshop.entity.User;
import com.Myshop.utils.C3P0Utils;
import com.Myshop.utils.MD5Utils;

public class UserDaoImp implements UserDao {

	@Override
	public User selectUserByName(String username) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		User user = 
		queryRunner.query(Constants.SelectUserSql+" where u_name=?", new BeanHandler<User>(User.class),username);
		
		return user;
	}

	@Override
	public int insertUser(User user) throws SQLException {
//		u_id int AUTO_INCREMENT KEY COMMENT 'USER primary key',
//		u_name varchar(20) not null,
//		u_password varchar(20) not null,
//		u_email varchar(50) not null,
//		u_sex varchar(5) not null, 
//		u_role int comment '0 for user,1 for admin',
//	    u_code varchar(50) comment'CDKEY',
//	    u_status
//		
	  QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	   String sql = "INSERT INTO user (u_name,u_password,u_email,u_role,u_code,u_status) VALUE(?,?,?,?,?,?)";
	   int rows = queryRunner.update(sql, user.getuName(),user.getuPassword(),user.getuEmail(),user.getuRole(),user.getuCode(),
			   user.getuStatus());
		
		return rows;
	}

	@Override
	public User selectUserByUcode(String uCode) throws SQLException {
	   QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	   String sql = Constants.SelectUserSql+" WHERE u_code=?";//注意空格！！
	   User user = queryRunner.query(sql, new BeanHandler<User>(User.class),uCode);
		return user;
	}

	@Override
	public int activateUser(int uId) throws SQLException {
	    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	    String sql = "update user set u_status = ? where u_id = ?";
	    queryRunner.update(sql,Constants.activeStatus,uId);
		
		return 0;
	}

	

	

}
