package com.Myshop.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.Myshop.entity.User;
import com.Myshop.service.UserServiceImp;
import com.Myshop.utils.Base64Utils;
import com.Myshop.utils.MD5Utils;
import com.Myshop.utils.RandomUtils;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class UserController extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     * @throws IOException 
     * @throws SQLException 
     */
      public String checkUname(HttpServletRequest req, HttpServletResponse res) {
    	  String username = req.getParameter("username");
    	  //1.invoke userService
    	  UserServiceImp usi = new UserServiceImp();
    	  boolean Flag;
		try {
			Flag = usi.checkUsername(username);
			 if(Flag){
	    		  return "1";
	    	  }
	    	    return "0";
	      }
      
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "2";
		}}
    	 
      public String register(HttpServletRequest req, HttpServletResponse res){
    	  Map <String,String[]> userMap = req.getParameterMap();
    	  User user = new User();
    	  try {
    		  // getUsername password email
			BeanUtils.populate(user, userMap);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
    	  
    	  //Set other user parameters 
    	  user.setuCode(RandomUtils.getRandom());
    	  user.setuRole(0);
    	  user.setuStatus(0);

    	  //password encryption
    	 user.setuPassword(MD5Utils.md5(user.getuPassword()));
    	 //invoke register service
    	 UserServiceImp usi = new UserServiceImp();
    	 try {
			usi.registerUser(user);
			
		} catch (SQLException e) {
			//注册失败 返回注册界面并提示错误信息
			e.printStackTrace();
			req.setAttribute("registerMsg", "注册失败!");
			return Constants.Forward+"/web/register.jsp";
			
		}
				
    	 return Constants.Forward+"/web/registerSuccess.jsp";
				    
      }
      
      public String active(HttpServletRequest req, HttpServletResponse res){
    	  UserServiceImp usi = new UserServiceImp();
    	  //get and decode uCode
    	 String uCode =  Base64Utils.decode(req.getParameter("c"));
  
    	  //invoke service to activate
    	  try {
			int status = usi.activateUser(uCode);//0 for active failed,1 for success,2 for already actived
			if(status == 0)
				req.setAttribute("msg","Active Failed!");
			else if (status == 1)
				req.setAttribute("msg", "Active Success!");
			else 
				req.setAttribute("msg", "The account has already been activated!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	  
    	  return Constants.Forward+"web/message.jsp";
      }
      
      
      public String login(HttpServletRequest req, HttpServletResponse res){
    	  //get Uname & password;
    	    String username = req.getParameter("username");
    	    String password = req.getParameter("password");
    	    String auto = req.getParameter("auto");
    	    HttpSession session = req.getSession();
    	    //invoke login service;
    	    UserServiceImp usi = new UserServiceImp();
    	    try {
				User user = usi.loginUser(username, password);
				if(user == null){ //
					req.setAttribute("msg", "Incorrect username/password!");
					return Constants.Forward+"web/login.jsp";
				}else if(user.getuStatus()==0){
					req.setAttribute("msg", "Account has not been activated!");
					return Constants.Forward+"web/login.jsp";
				}else 
				{//put user into session
			    session.setAttribute("loginUser", user);
				
				//set Cookies for autoLogin
				if(auto == null){
				Cookie cookie = new Cookie(Constants.autoLoginCookie,"");
				 cookie.setPath("/");
				 cookie.setMaxAge(0);
				 res.addCookie(cookie);
				}else{
			    String content = username+":"+password;
				content = Base64Utils.encode(content);
				Cookie cookie = new Cookie(Constants.autoLoginCookie,content);
				cookie.setPath("/");
				cookie.setMaxAge(7*24*60*60);
				res.addCookie(cookie);
				}
				return Constants.Redirect+"web/index.jsp";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("msg", "Login Failed!");
				return Constants.Forward+"web/login.jsp";
				
			}
    	 
      }
      
      public String logOut(HttpServletRequest req, HttpServletResponse res){
    	  // remove user in session 
    	 HttpSession session = req.getSession();
    	 session.removeAttribute("loginUser");
    	 // overlap cookie
    	 Cookie cookie = new Cookie(Constants.autoLoginCookie,"");
    	 cookie.setPath("/");
    	 cookie.setMaxAge(0);
    	 res.addCookie(cookie);
    	    
    	  return Constants.Redirect+"web/login.jsp";
      }

}
