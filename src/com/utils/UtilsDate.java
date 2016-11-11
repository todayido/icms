package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsDate {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
	/**
	 * 获取年月日时分秒
	 * 
	 * @return string yyyt-MM-dd hh:mm:ss
	 */
	public static String getStringDate(){
		return sdf.format(new Date());
	}

}
