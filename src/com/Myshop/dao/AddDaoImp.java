package com.Myshop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Myshop.entity.Address;
import com.Myshop.utils.C3P0Utils;

public class AddDaoImp implements AddDao {

	@Override
	public List<Address> selectAdd(int uId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "SELECT a_id as aId, u_id as uId, a_receiver as aReceiver, a_phone as aPhone, a_address"
				+ " as aAddress, a_isDefault as isDefault from address where u_id = ? order by a_isDefault desc";
		
		List<Address> listAddress = queryRunner.query(sql, new BeanListHandler<Address>(Address.class),uId);	
        
		
		return listAddress;
	}

	@Override
	public void add(Address add) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into address (u_id,a_receiver,a_phone,a_address,a_isDefault) values(?,?,?,?,?)";
		queryRunner.update(sql,add.getuId(),add.getaReceiver(),add.getaPhone(),add.getaAddress(),add.getIsDefault());
		
		
	}

	@Override
	public void delete(String aId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from address where a_id = ?";
		queryRunner.update(sql,aId);
		
	}

	@Override
	public void setNonDefault() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update address set a_isDefault = ? where a_isDefault = ?";
		queryRunner.update(sql,0,1);
		
	}

	@Override
	public void setDefault(String aId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update address set a_isDefault = ? where a_id = ?";
		queryRunner.update(sql,1,aId);
		
	}

}
