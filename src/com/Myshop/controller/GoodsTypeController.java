package com.Myshop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Myshop.entity.ProductType;
import com.Myshop.service.GoodsTypeServiceImp;
import com.google.gson.Gson;

@WebServlet("/goodsType")
public class GoodsTypeController extends BaseServlet {
	
	public String findAll(HttpServletRequest req, HttpServletResponse res){
		//invoke
		GoodsTypeServiceImp gtsi = new GoodsTypeServiceImp();
		try {
			List <ProductType> typeList = gtsi.findAllgoodsType();
			Gson gson = new Gson();
			String json = gson.toJson(typeList);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}


}
