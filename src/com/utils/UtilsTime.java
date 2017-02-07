package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsTime {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
	/**
	 * 获取年月日时分秒
	 * yyyt-MM-dd hh:mm:ss
	 * @return
	 */
	public static String getStringDate(){
		return sdf.format(new Date());
	}

}
