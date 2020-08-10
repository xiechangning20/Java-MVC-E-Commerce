package com.Myshop.Filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Myshop.controller.Constants;
import com.Myshop.entity.User;
import com.Myshop.service.UserServiceImp;
import com.Myshop.utils.Base64Utils;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
@WebFilter("/web/login.jsp")
public class AutoLoginFilter implements Filter {

    
    public AutoLoginFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse)response;
		Cookie [] cs = hsr.getCookies();
		
		String content = null;
		UserServiceImp usi = new UserServiceImp();
		
		if(cs != null){
		// has cookie
			for(Cookie cookie:cs){
				if(cookie.getName().equals(Constants.autoLoginCookie)){
					content = cookie.getValue();
				
				}
			}
			if(content!=null){
				
				content = Base64Utils.decode(content);
				String []split = content.split(":");
				String username = split[0];
				String password = split[1];
				try {
					User user = usi.loginUser(username, password);
				     if(user != null){
				    	 HttpSession session = hsr.getSession();
				    	 session.setAttribute("loginUser", user);
				    	 
				    	 res.sendRedirect("/Myshop/web/index.jsp");
				     }else{
				    	 hsr.setAttribute("msg", "Username/Password incorrect!");
				    	 res.sendRedirect("/Myshop/web/login.jsp");
				     }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//no content in the cookies;
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
