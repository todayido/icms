package com.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class EhcacheUtils {
	
	public static Map<String,CacheManager> cacheMap=new HashMap<String,CacheManager>();
	
	// 读取配置文件
	static String useCache = "false";
	
	public static CacheManager getCacheManager(){
		return (CacheManager)cacheMap.get("ehcache");
	}
	
	public static Cache userCache(){
		return (Cache)cacheMap.get("ehcache").getCache("user"); 
	}
	
	public static Cache permissionCache(){
		return (Cache)cacheMap.get("ehcache").getCache("permission");
	}
	
	public static Cache dictionaryCache(){
		return (Cache)cacheMap.get("ehcache").getCache("dictionary");
	}
	
	public static Cache templateCache(){
		return (Cache)cacheMap.get("ehcache").getCache("template");
	}
	
	public static Cache actionCache(){
		return (Cache)cacheMap.get("ehcache").getCache("action");
	}
	
	/**
	 * 清理缓存
	 */
	public static boolean removeCache(String cacheName){
		cacheMap.get("ehcache").removeCache(cacheName);
		return true;
	}
	/**
	 * 清除所有缓存
	 */
	public static boolean removeAllCaches(){
		cacheMap.get("ehcache").removeAllCaches();
		return true;
	}
}  
