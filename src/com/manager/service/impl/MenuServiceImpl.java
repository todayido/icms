package com.manager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.dao.MenuDao;
import com.manager.model.Menu;
import com.manager.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	MenuDao menuDao;
	
	public List<Menu> getLeftTreeByParentId(Map paramsMap) {
		return menuDao.getLeftTreeByParentId(paramsMap);
	}
	
	public List getMenuTreeByParentId(Map paramsMap) {
		return menuDao.getMenuTreeByParentId(paramsMap);
	}
	
	public List<Menu> getAllMenus(Map<?, ?> paramsMap) {
		return menuDao.getAllMenus(paramsMap);
	}
	
	public int getMenuCount(Map<?, ?> paramsMap) {
		return menuDao.getMenuCount(paramsMap);
	}

	public int deleteMenuById(String[] params) {
		int row = 0;
		for(String menuid : params){
			row =+ menuDao.deleteMenuById(menuid);
		}
		return row;
	}

	public Menu getMenuById(String menuid) {
		return menuDao.getMenuById(menuid);
	}

	public int modifyMenu(Menu menu) {
		return menuDao.modifyMenu(menu);
	}

	public int saveMenu(Menu menu) {
		return menuDao.saveMenu(menu);
	}

}
