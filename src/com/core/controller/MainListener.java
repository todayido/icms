package com.core.controller;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.ehcache.*;

import org.apache.log4j.Logger;

import com.utils.EhcacheUtils;

public class MainListener implements ServletContextListener {
	
	static Logger logger = Logger.getLogger(MainListener.class.toString());

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("【工程启动 开始！】 ");
		logger.debug("【监听器加载配置文件 开始！】 ");
		new ControllerBeanFactory();
		logger.debug("【监听器加载配置文件 结束！】 ");
		
		logger.debug("【载入缓存 开始，工程启动开始！】 ");
		URL url = this.getClass().getResource("/ehcache.xml");
		CacheManager cacheManager = new CacheManager(url);
		EhcacheUtils.cacheMap.put("ehcache", cacheManager);
		logger.debug("【载入缓存 开始，工程启动开始！】 ");
		logger.debug("【工程启动 成功！】 ");
	}

}
