package com.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.utils.EhcacheUtils;

@Controller
public class EhcacheController extends BaseController implements IController {
	
	public DataAndView cacheIndex(HttpServletRequest request){
		Map countMap = new HashMap();
		int cacheCount = EhcacheUtils.templateCache().getSize();
		countMap.put("templateCacheCount", cacheCount);
		
		cacheCount = cacheCount + EhcacheUtils.userCache().getSize();
		countMap.put("actionCacheCount", EhcacheUtils.actionCache().getSize());
		
		cacheCount = cacheCount + EhcacheUtils.userCache().getSize();
		countMap.put("userCacheCount", EhcacheUtils.userCache().getSize());
		
		cacheCount = cacheCount + EhcacheUtils.permissionCache().getSize();
		countMap.put("permissionCacheCount", EhcacheUtils.permissionCache().getSize());
		
		cacheCount = cacheCount + EhcacheUtils.dictionaryCache().getSize();
		countMap.put("dictionaryCacheCount", EhcacheUtils.dictionaryCache().getSize());
		
		countMap.put("cacheCount", cacheCount);
		return new DataAndView("countMap",countMap,null,SkipType.REDIRECT);
	}
	
	/**
	 * 清理所有缓存
	 */
	public DataAndView removeAllCaches(HttpServletRequest request){
		EhcacheUtils.getCacheManager().clearAll();
		return new DataAndView("flag",1,null,SkipType.REDIRECT);
	}
	
	/**
	 * 清理指定缓存
	 */
	public DataAndView removeCache(HttpServletRequest request) throws Exception {
		String cacheName = request.getParameter("cacheName");
		Object obj = EhcacheUtils.getCacheManager();
		obj = EhcacheUtils.getCacheManager().getCache(cacheName);
		EhcacheUtils.getCacheManager().getEhcache(cacheName).removeAll();
		return new DataAndView("flag",1,null,SkipType.REDIRECT);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
