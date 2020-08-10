package com.Myshop.controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Myshop.entity.Address;
import com.Myshop.entity.Cart;
import com.Myshop.entity.Orders;
import com.Myshop.entity.User;
import com.Myshop.service.AddService;
import com.Myshop.service.AddServiceImp;
import com.Myshop.service.CartService;
import com.Myshop.service.CartServiceImp;
import com.Myshop.service.OrderService;
import com.Myshop.service.OrderServiceImp;


@WebServlet("/order")
public class OrderController extends BaseServlet {
	
	public String preview(HttpServletRequest req,HttpServletResponse res) throws NumberFormatException, SQLException, IllegalAccessException, InvocationTargetException{
		//get uId
		 String uId = req.getParameter("uId");
		//invoke Service using uid 
		 CartService cs = new CartServiceImp();
		 AddService as = new AddServiceImp();
		//get AddList and Order
		 List<Address> addList = as.selectAddByUid(Integer.parseInt(uId));
		 List<Cart> cartList = cs.getCartbyUid(Integer.parseInt(uId));
		
		//put into the region
		 req.setAttribute("addList", addList);
		 req.setAttribute("cartList", cartList);
		
		
		return Constants.Forward+"web/order.jsp";
	}
      
	public String createOrder(HttpServletRequest req,HttpServletResponse res) throws NumberFormatException, IllegalAccessException, InvocationTargetException, SQLException{
		//get paras;
		String aId = req.getParameter("aId");
		String uId = req.getParameter("uId");
		String sum = req.getParameter("sum");
		//invoke service using paras
		OrderService os = new OrderServiceImp();
		os.createOrder(aId,uId,sum);
		
		return Constants.Redirect+"order?method=showOrder";
	}
	
	public String showOrder(HttpServletRequest req,HttpServletResponse res) throws IllegalAccessException, InvocationTargetException, SQLException{
		//get User
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user == null){
			session.setAttribute("msg", "Please login first!");
			return Constants.Redirect+"web/login.jsp";
		}
		OrderService os = new OrderServiceImp();
		List<Orders> orderList = os.findOrdersByUId(user.getuId());
		req.setAttribute("orderList", orderList);
		return Constants.Forward + "web/orderList.jsp";
	}
	
	public String detail(HttpServletRequest req,HttpServletResponse res) throws IllegalAccessException, InvocationTargetException, SQLException{
		//get User
		String oId = req.getParameter("oId");
		OrderService os = new OrderServiceImp();
		Orders orders = os.findOrdersByOId(oId);
		req.setAttribute("order", orders);
		return Constants.Forward + "web/orderDetail.jsp";
	}
	
	public String pay(HttpServletRequest req,HttpServletResponse res) throws SQLException{
		//get oId
		String oId = req.getParameter("oId");
		OrderService os = new OrderServiceImp();
		os.payByOid(oId);
		
		return Constants.Forward + "web/orderSuccess.jsp";
	}
	
	public String delete(HttpServletRequest req,HttpServletResponse res) throws SQLException{
		String oId = req.getParameter("oId");
		OrderService os = new OrderServiceImp();
		os.deleteByOid(oId);
		
		
		return Constants.Redirect+"order?method=showOrder";
	}
	
	
}
