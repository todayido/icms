package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * 读取静态文件内容
 */
public class UtilsFile {

	/**
	 * @param file 要读取的文件路径
	 * @return 返回文件的内容 
	 */
	public static String getFtlContent(File file){
		String tempString = "";
		StringBuffer tempBuffer = new StringBuffer();
		BufferedReader br;
		try {
			//文件不存在，创建改文件file
			if(!file.exists()){
				file.createNewFile();
			}
			//读取ftl文件
			br=new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()),"UTF-8"));  
			
			while((tempString = br.readLine()) != null){
				tempBuffer.append(tempString+"\n");
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		if(null==tempBuffer){
			return "";
		}else{
			return tempBuffer.toString();
		}
	}
	
	/**
	 * @param file 要写入的文件路径
	 * @param fileContent 要写入的内容
	 * @return 返回状态 
	 */
	public static int setFtlContent(File file, String fileContent){
		try {
			//文件不存在，创建该文件file
			if(!file.exists()){
				file.createNewFile();
			}
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath(), false),"UTF-8");
			osw.write(fileContent);
			osw.flush();
			osw.close();
		} catch (IOException e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
