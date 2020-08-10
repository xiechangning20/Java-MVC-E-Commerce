package com.Myshop.dao;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.Address;

public interface AddDao {

	List<Address> selectAdd(int uId) throws SQLException;

	void add(Address address) throws SQLException;

	void delete(String aId) throws SQLException;

	void setNonDefault() throws SQLException;

	void setDefault(String aId) throws SQLException;

}
