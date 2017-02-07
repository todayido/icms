package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsCommon {
	/**
	 * @param str
	 * @return
	 * 判断指定字符串为“”或者为null,返回true,否则返回false
	 */
	public static boolean isEmperty(String str){
		if(null==str ||"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNumeric(String str){
		
		if(isEmperty(str)){
			return false;
		}
		
		Pattern pattern = Pattern.compile("^[1-9][0-9]*"); 
	    Matcher isNumeric = pattern.matcher(str);
	    if(isNumeric.matches()){
	       return true; 
	    } 
	    return false;
	}
	
	public static void main(String[] args) {
	}
}
