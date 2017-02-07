package com.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class test {

	public static void main(String[] args) throws Exception{
		 InputStream in;
		 in = new BufferedInputStream(new FileInputStream("src/cms.properties"));
		 Properties p = new Properties();
		 p.load(in);
		 String useCache = p.getProperty("useCache"); 
		 System.out.println(useCache);
	}
}
