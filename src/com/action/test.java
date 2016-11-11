package com.action;

public class test {
	public static void main(String[] args) {
		String a = "1@1";
		
		System.out.println(a.substring(0,1)+"********"+a.substring(a.lastIndexOf("@"), a.length()));
	}
}
