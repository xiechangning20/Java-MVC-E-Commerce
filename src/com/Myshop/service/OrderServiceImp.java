package com.Myshop.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Myshop.dao.CartDao;
import com.Myshop.dao.CartDaoImp;
import com.Myshop.dao.OrderDao;
import com.Myshop.dao.OrderDaoImp;
import com.Myshop.entity.Cart;
import com.Myshop.entity.OrderDetail;
import com.Myshop.entity.Orders;
import com.Myshop.utils.RandomUtils;

public class OrderServiceImp implements OrderService {

	@Override
	public void createOrder(String aId, String uId, String sum) throws SQLException, NumberFormatException, IllegalAccessException, InvocationTargetException {
		//1.create new order obj;
		Orders orders = new Orders();
		BigDecimal bSum = new BigDecimal(sum);
		String oId = RandomUtils.creatOrderId();
		orders.setoId(oId);
		orders.setuId(Integer.parseInt(uId));
		orders.setaId(Integer.parseInt(aId));
		orders.setoTime(new Date());
		orders.setoTotal(bSum);
		orders.setoStatus(1);
		
		//2.save the order
		OrderDao od = new OrderDaoImp();
		od.insert(orders);
		
		//3.transfer cart to orderDetail
		CartService cs = new CartServiceImp();
		List<Cart> cartList = cs.getCartbyUid(Integer.parseInt(uId));
		List<OrderDetail> odList = new ArrayList<>();
		for(Cart cart:cartList){
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setoId(oId);
			orderDetail.setpId(cart.getpId());
			orderDetail.setOdNum(cart.getcNum());
			orderDetail.setOdTotal(cart.getcTotal());
			odList.add(orderDetail);
		}
		
		//4. save the order Detail  
		 od.insertOrderDetail(odList);
		//5.clear shopping cart
		 CartDao cd = new CartDaoImp();
		 cd.clearAll(uId);
	}

	@Override
	public List<Orders> findOrdersByUId(int uId) throws SQLException, IllegalAccessException, InvocationTargetException {
		OrderDao od = new OrderDaoImp();
		List<Orders> orderList = od.selectOrderByUId(uId);
		return orderList;
	}

	@Override
	public Orders findOrdersByOId(String oId) throws IllegalAccessException, InvocationTargetException, SQLException {
		//select order 
		OrderDao od = new OrderDaoImp();
		Orders orders = od.selectOrderByOId(oId);
		//select orderDetail
		List<OrderDetail> odList = od.selectOdByOId(oId);
		//
		orders.setOrderDetail(odList);
		
		
		return orders;
	}

	@Override
	public void payByOid(String oId) throws SQLException {
		// invoke dao
		OrderDao od = new OrderDaoImp();
		od.payByOid(oId);
		
		
	}

	@Override
	public void deleteByOid(String oId) throws SQLException {
		OrderDao od = new OrderDaoImp();
		od.deleteOdByOid(oId);//delete its foreign constraint
		od.deleteByOid(oId);
		
	}

}
