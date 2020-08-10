package com.Myshop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Myshop.dao.OrderDao;
import com.Myshop.dao.OrderDaoImp;
import com.Myshop.entity.Address;
import com.Myshop.entity.Orders;
import com.Myshop.entity.User;
import com.Myshop.service.AddService;
import com.Myshop.service.AddServiceImp;

@WebServlet("/add")
public class AddController extends BaseServlet{
	
	public String showAddress(HttpServletRequest req, HttpServletResponse rep) throws SQLException{
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user == null){
			req.setAttribute("msg", "Please login first!");
			return Constants.Forward+"/web/login.jsp";
		}
		else{
		     //get uid
			int uId = user.getuId();
			//invoke addService using uId
			AddService as = new AddServiceImp();
			List<Address> addressList = as.selectAddByUid(uId);
		
			req.setAttribute("addressList", addressList);
			
			return Constants.Forward+"/web/self_info.jsp";
		}
	}
    
	 public String add(HttpServletRequest req, HttpServletResponse rep) throws SQLException{
		 //get paras
		 int uId = Integer.parseInt(req.getParameter("uId"));
		 String aReceiver = req.getParameter("aReceiver");
		 String aPhone = req.getParameter("aPhone");
		 String aAddress = req.getParameter("aAddress");
		 //set paras
		 Address address = new Address();
		 address.setuId(uId);
		 address.setaReceiver(aReceiver);
		 address.setaPhone(aPhone);
		 address.setaAddress(aAddress);
		 address.setIsDefault(0);
		 
		 //invoke addService using the address
		 AddService as = new AddServiceImp();
		 as.add(address);
		 
		 return Constants.Redirect+req.getServletContext().getContextPath()+"/add?method=showAddress"; 
	 }
	 
	 public String delete(HttpServletRequest req, HttpServletResponse rep) throws SQLException{
		 String aId = req.getParameter("aId");
		 AddService as = new AddServiceImp();
		//if the address is attached to an Order, it cannot be delete
		 OrderDao od = new OrderDaoImp();
	     Orders orders = od.selectOdByAId(aId);
		 if(orders == null){ 
			 as.deleteByAid(aId);
		 
		 }	else{
			req.setAttribute("addMsg", "The address is attached to an Order, it cannot be delete!");
		 }
		
		 
		 
		 return Constants.Redirect+req.getServletContext().getContextPath()+"/add?method=showAddress";  
	 }
	 
	 public String setDefault(HttpServletRequest req, HttpServletResponse rep) throws SQLException{
		 String aId = req.getParameter("aId");
		 AddService as = new AddServiceImp();
		 as.setDafault(aId);
		 
		 return Constants.Redirect+req.getServletContext().getContextPath()+"/add?method=showAddress"; 
	 }
	 
}
