package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtils {
	
	static class SingletonHolder {
		static ApplicationContext instance = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	public static ApplicationContext getInstance(){
		return SingletonHolder.instance;
	}
	
	public static Object getSpringBean(String beanName){
		System.out.println(BeanUtils.getInstance().toString());
		return BeanUtils.getInstance().getBean(beanName);
	}
}
