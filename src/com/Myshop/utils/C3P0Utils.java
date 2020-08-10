package com.Myshop.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//获取配置文件信息
	private static DataSource ds = new ComboPooledDataSource();
	//向外部提供访问
	public static DataSource getDataSource(){
		return ds;
	}
	//向外部提供连接
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	//释放资源
	
	public static void release(ResultSet rs, Statement stmt, Connection conn){
		
			try {
				if(rs!=null){
				rs.close();
				}
				if(stmt!=null){
				stmt.close();	
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
	
		
	}

}
