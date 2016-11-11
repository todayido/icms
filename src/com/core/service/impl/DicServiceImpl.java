package com.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.ehcache.Element;

import com.core.service.DicService;
import com.dictionary.dao.DictionaryDao;
import com.dictionary.service.impl.DictionaryServiceImpl;
import com.utils.EhcacheUtils;

@Service
public class DicServiceImpl implements DicService{
	
	@Resource
	DictionaryDao dictionaryDao;
	
	static class SingletonHolder {
		static DictionaryServiceImpl instance = new DictionaryServiceImpl();
	}
	
	public static DictionaryServiceImpl getInstance(){
		return SingletonHolder.instance;
	}
	
	public List getDicList(String dic_name) {
		
		if(dic_name==null || "".equals(dic_name)){
			return new ArrayList();
		}
		
		List dicList;
		
		if (EhcacheUtils.dictionaryCache().get(dic_name)!=null){
			dicList=(List)EhcacheUtils.dictionaryCache().get(dic_name).getObjectValue();
		}else{
			//从缓存中读取数据
			synchronized(this){
				dicList = dictionaryDao.getDictionaryListByName(dic_name);
				EhcacheUtils.dictionaryCache().put(new Element(dic_name,dicList));
			}
		}
		return dicList;
	}

	
	public void removeCache(String dic_name){
		EhcacheUtils.dictionaryCache().remove(dic_name);
	}

}
