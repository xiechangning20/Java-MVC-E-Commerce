package com.Myshop.controller;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Myshop.entity.PageBean;
import com.Myshop.entity.Product;
import com.Myshop.service.ProductService;
import com.Myshop.service.ProductServiceImp;

@WebServlet("/product")
public class ProductController extends BaseServlet {
	
	public String show(HttpServletRequest req, HttpServletResponse res){
		//get tid
	int ptId = Integer.parseInt(req.getParameter("ptId"));
	//set PageSize;
	int pageSize = 8;
	//get currentPage
	String currentPage = req.getParameter("currentPage");
	int page = 1;
	if(currentPage != null){
		page = Integer.parseInt(currentPage);
	}
	
	//invoke product service
	ProductService ps = new ProductServiceImp();
	PageBean<Product> pageBean;
	try {
		pageBean = ps.findPage(ptId,page,pageSize);
		//response
		req.setAttribute("pageBean", pageBean);
		System.out.println(pageBean.getTotalPage());
		System.out.println(pageBean.getCurrentPage());
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return Constants.Forward+"/web/goodsList.jsp";
	}
	
	public String detail(HttpServletRequest req, HttpServletResponse res) throws SQLException{
		//get pId
		int pId = Integer.parseInt(req.getParameter("pId"));
		//invoke service
		ProductService ps = new ProductServiceImp();
		Product product = ps.findProduct(pId);
		req.setAttribute("product", product);
		
		
		return Constants.Forward+"/web/goodsDetail.jsp";
	}

}
