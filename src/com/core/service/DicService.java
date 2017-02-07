package com.core.service;

import java.util.List;

/**
 * 根据字典名称获取字典表
 */
public interface DicService {
	public List getDicList(String dic_name);
	public void removeCache(String dic_name);
}
