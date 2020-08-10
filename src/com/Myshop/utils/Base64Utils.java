package com.Myshop.utils;

import java.util.Base64;

public class Base64Utils {
//base 64 encryption and deciphering
	
	//encryption
	public static String encode(String msg){
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
	
	//deciphering
	public static String decode(String msg){
		return new String(Base64.getDecoder().decode(msg));
	}
}
