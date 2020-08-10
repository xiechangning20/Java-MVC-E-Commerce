package com.Myshop.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Myshop.entity.Cart;
import com.Myshop.entity.User;
import com.Myshop.service.CartService;
import com.Myshop.service.CartServiceImp;

@WebServlet("/cart")
public class CartController extends BaseServlet {
	
	public String create(HttpServletRequest req,HttpServletResponse res) throws IllegalAccessException, InvocationTargetException, SQLException{
		
		//login or not?
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		if(user == null){
		  req.setAttribute("msg", "Please login first!");
		  return Constants.Redirect+"web/login.jsp";
		}
		
		//get userId and pId
		int uId = user.getuId();
		int pId = Integer.parseInt(req.getParameter("pId"));
		
		//invoke CartService
		CartService cs = new CartServiceImp();
		Cart cart = cs.createCart(uId,pId);
		
		return Constants.Redirect+"web/cartSuccess.jsp";
	}
	
	
	public String show(HttpServletRequest req,HttpServletResponse res) throws SQLException, IllegalAccessException, InvocationTargetException{
		
		//login or not?
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		if(user == null){
		  req.setAttribute("msg", "Please login first!");
		  return Constants.Forward+"web/login.jsp";
		}
		
		//get uId
		int uId = user.getuId();  
		//invoke cartService using uId
		CartService cs = new CartServiceImp();
		List<Cart> cartList = cs.getCartbyUid(uId);
		
		
		req.setAttribute("cartList", cartList);
		
		return Constants.Forward+"web/cart.jsp";
	}
	
	public String delete(HttpServletRequest req,HttpServletResponse res) throws SQLException{
		//get cid
		int cId = Integer.parseInt(req.getParameter("cId"));
		
		//invoke cartService using cId
		CartService cs = new CartServiceImp();
		int i = cs.deleteCart(cId);
		
		return Constants.Redirect+"/cart?method=show";
		
	}
	
	public String update(HttpServletRequest req,HttpServletResponse res) throws SQLException{
		//get para
//		int cId = Integer.parseInt(req.getParameter("cId"));
//		BigDecimal cNum = new BigDecimal(req.getParameter("cNum"));
//		BigDecimal cPrice = new BigDecimal(req.getParameter("pPrice"));
		String cId = req.getParameter("cId");
		String cNum = req.getParameter("cNum");
		String pPrice = req.getParameter("pPrice");
		
		//invoke service using paras
		
		CartService cs = new CartServiceImp();
		cs.updateCart(cId,cNum,pPrice);
		
		
		return Constants.Redirect+"/cart?method=show";
	}
	
	public String clearAll(HttpServletRequest req,HttpServletResponse res) throws SQLException{
		
		String uId = req.getParameter("uId");
		CartService cs = new CartServiceImp();
		cs.clear(uId);
		
		return Constants.Redirect+"/cart?method=show";
		
	}
   
}
