package com.Myshop.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//define reflection for its subclasses
		String methodStr = req.getParameter(Constants.Tag);
		
		//如果method为空,jump to index.jsp
		if(methodStr == null||methodStr == ""){
			methodStr = Constants.Index;
		}
		
		//1.load and get the subclasses
		Class clazz = this.getClass();
		
		//2.get method
		try {
			Method method = clazz.getDeclaredMethod(methodStr,HttpServletRequest.class,HttpServletResponse.class);
			//3.invoke method
			Object result = method.invoke(this, req,res);
			//集中处理返回值相应 转发，重定向，返回json
			if(result != null){
				String str = (String)result;
				if(str.startsWith(Constants.Forward)){
					String path = str.substring(str.indexOf(Constants.colon)+1);
					req.getRequestDispatcher(path).forward(req, res);	
				}else if(str.startsWith(Constants.Redirect)){
					String path = str.substring(str.indexOf(Constants.colon)+1);
					res.sendRedirect(path);
				}else{
					res.getWriter().print(str);
				}
				
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
			req.getSession().setAttribute("msg","The server has encounterd an error, please contact the admin!" );
			res.sendRedirect("web/index.jsp");
		}
		
		
	}
	    public String index(HttpServletRequest req,HttpServletResponse res){
	    	
            return Constants.Redirect+"web/index.jsp";	      
	    }
	
	

}
