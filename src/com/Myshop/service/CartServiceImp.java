package com.Myshop.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.Myshop.dao.CartDao;
import com.Myshop.dao.CartDaoImp;
import com.Myshop.dao.ProductDao;
import com.Myshop.dao.ProductDaoImp;
import com.Myshop.entity.Cart;
import com.Myshop.entity.Product;

public class CartServiceImp implements CartService {

	@Override
	public Cart createCart(int uId, int pId) throws SQLException, IllegalAccessException, InvocationTargetException {
		//根据uid和pid判断是否已添加购物车，若是则num+1
		CartDao cd = new CartDaoImp();
		Cart cart = cd.selectCart(uId,pId);
		if(cart!=null){
			cart.setcNum(cart.getcNum()+1);
			cd.updateCart(cart);
		}else{
			//get Product by id to pass to cart
			ProductDao pd = new ProductDaoImp();
			Product product = pd.selectProductById(pId);
			Cart newCart = new Cart();
			newCart.setcNum(1);
			newCart.setProduct(product);
			newCart.setuId(uId);
			newCart.setpId(pId);
			
			cd.Insert(newCart);
			
		}
		return null;
	}

	@Override
	public List<Cart> getCartbyUid(int uId) throws SQLException, IllegalAccessException, InvocationTargetException {
		// invoke cartDao
		CartDao cd = new CartDaoImp();
		List<Cart> cartList = cd.selectCart(uId);
		
		return cartList;
	}

	@Override
	public int deleteCart(int cId) throws SQLException {
		CartDao cd = new CartDaoImp();
		int row = cd.deleteById(cId);
		return row;
	}

	@Override
	public void updateCart(String cId, String cNum, String pPrice) throws SQLException {
		BigDecimal num = new BigDecimal(cNum);
		BigDecimal price = new BigDecimal(pPrice);
		BigDecimal cTotal = price.multiply(num);
		CartDao cd = new CartDaoImp();
		cd.updateCart(cId,num,cTotal);
		
		
	}

	@Override
	public void clear(String uId) throws SQLException {
		CartDao cd = new CartDaoImp();
		cd.clearAll(uId);
	}

}
