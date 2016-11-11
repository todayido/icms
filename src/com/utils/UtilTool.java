package com.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class UtilTool {

	
	public static final String YMD_="yyyy-MM-dd";
	public static final String YMDHMS_="yyyy-MM-dd HH:mm:ss";
	public static final String YMDHM_="yyyy-MM-dd HH:mm";
	public static final String YMDHMS="yyyyMMddHHmmss";
	public static final String YMDHM="yyyyMMddHHmm";
	public static final String YMD="yyyyMMdd";

	public static  String convertListToString(List<String> list){
		StringBuffer str=new StringBuffer("");
		
		if(list !=null && list.size()>0){
			
			for(String s:list){
				
				str.append(s).append(",");
				
			}
			
		}
		return str.toString();
	}
	

public static String getRecentTime(Date d,int day){
	String retval="";
	Calendar c=Calendar.getInstance();
	c.setTime(d);
	c.add(Calendar.DAY_OF_MONTH, day);
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	System.out.println();
	retval=sim.format(c.getTime());
	
	return retval;
	
}

public static String getTimeByType(String type){
	String retval="";

	SimpleDateFormat sim=new SimpleDateFormat(type);

	retval=sim.format(new Date());
	
	return retval;

}
//淇濈暀涓�涓皬鏁�
public static String getSubdata(String data){
	
	BigDecimal big=new BigDecimal(data);
	return big.setScale(1, BigDecimal.ROUND_HALF_UP).toString();
	
}


public static void main(String[] args) {
	
	System.out.println(getSubdata("2.56"));
	
	Calendar c=Calendar.getInstance();
	c.setTime(new Date());
	c.add(Calendar.DAY_OF_MONTH, -14);
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(sim.format(c.getTime()));
	
}

}
