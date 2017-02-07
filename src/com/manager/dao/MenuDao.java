package com.manager.dao;

import java.util.List;
import java.util.Map;

import com.manager.model.Menu;

public interface MenuDao {
	
	/**
	 * 后台管理左侧导航树
	 */
	public abstract List<Menu> getLeftTreeByParentId(Map<?, ?> paramsMap);
	
	/**
	 * 根据父节点获取所有子节点
	 */
	public abstract List<Menu> getMenuTreeByParentId(Map<?, ?> paramsMap);
	
//	public abstract List<Menu> getMenuListByParentId(Map<?, ?> paramsMap);
	public abstract List<Menu> getAllMenus(Map<?,?> paramsMap);
	
	public abstract int saveMenu(Menu menu);

	public abstract int deleteMenuById(String menuid);
	
	public abstract int modifyMenu(Menu menu);

	public abstract Menu getMenuById(String menuid);
	
	public abstract int getMenuCount(Map<?,?> paramsMap);

}
