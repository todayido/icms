package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDGenerator {   
    public UUIDGenerator() {   
    }   
  
    public static String getUUID() {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        // 去掉"-"符号   
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);   
        return temp;   
    }   
    
    public static void main(String[] args) {
		System.out.println(getUUID());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String item_id = df.format(new Date()) + System.currentTimeMillis();// + new Random().nextInt(1000);
		
		System.out.println(item_id);
	}
}
