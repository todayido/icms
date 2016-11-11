package com.manager.service;

import java.util.List;
import java.util.Map;

import com.manager.model.Menu;

public interface MenuService{

	/**
	 * 后台管理左侧导航树
	 */
	public abstract List<Menu> getLeftTreeByParentId(Map paramsMap);
	
	/**
	 * 菜单管理树
	 * @param paramsMap
	 * @return
	 */
	public abstract List<Menu> getMenuTreeByParentId(Map paramsMap);
	
	public abstract List<Menu> getAllMenus(Map<?, ?> paramsMap);
	
	public abstract int getMenuCount(Map<?, ?> paramsMap);
	
	public abstract int saveMenu(Menu menu);

	public abstract int deleteMenuById(String[] params);

	public abstract int modifyMenu(Menu menu);

	public abstract Menu getMenuById(String menuid);
	
}
