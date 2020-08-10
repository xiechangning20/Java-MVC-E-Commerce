package com.Myshop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RandomUtils {
    public static String getTime(){
    	    
    	  return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
  
    }
    
    public static String getRandom(){
    	  
       return getTime() + Integer.toHexString(new Random().nextInt(1000));
    }
    
    public static String creatOrderId(){
    	return getTime();
    }
}
