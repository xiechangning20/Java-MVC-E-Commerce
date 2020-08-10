package com.Myshop.service;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.entity.Address;

public interface AddService {

	List<Address> selectAddByUid(int uId) throws SQLException;
	
	void add(Address address) throws SQLException;

	void deleteByAid(String aId) throws SQLException;

	void setDafault(String aId) throws SQLException;

}
