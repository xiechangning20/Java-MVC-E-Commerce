package com.Myshop.service;

import java.sql.SQLException;
import java.util.List;

import com.Myshop.dao.AddDao;
import com.Myshop.dao.AddDaoImp;
import com.Myshop.dao.OrderDao;
import com.Myshop.dao.OrderDaoImp;
import com.Myshop.entity.Address;
import com.Myshop.entity.Orders;

public class AddServiceImp implements AddService {

	@Override
	public List<Address> selectAddByUid(int uId) throws SQLException {
		//invoke addDao
		AddDao ad = new AddDaoImp();
		List<Address> listAddress =  ad.selectAdd(uId);
		
		
		return listAddress;
	}

	@Override
	public void add(Address address) throws SQLException {
		//invoke addDao
		AddDao ad = new AddDaoImp();
		//if the first address, set as default
		List<Address> listAddress =  ad.selectAdd(address.getuId());
		System.out.println(listAddress);
		if(listAddress.size()==0){
			address.setIsDefault(1);
			ad.add(address);
			}else{
			ad.add(address);	
			}
		
	}

	@Override
	public void deleteByAid(String aId) throws SQLException {
	// invoke dao
		AddDao ad = new AddDaoImp();
	
		
		ad.delete(aId);
		
	}

	@Override
	public void setDafault(String aId) throws SQLException {
		//invoke dao
		AddDao ad = new AddDaoImp();
		ad.setNonDefault();
		ad.setDefault(aId);
	}

}
