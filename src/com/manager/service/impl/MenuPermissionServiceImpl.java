package com.manager.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.ehcache.Element;

import org.springframework.stereotype.Service;

import com.manager.dao.MenuPermissionDao;
import com.manager.model.MenuPermission;
import com.manager.service.MenuPermissionService;
import com.utils.EhcacheUtils;

@Service
public class MenuPermissionServiceImpl implements MenuPermissionService {

	@Resource
	MenuPermissionDao menuPermissionDao;
	
	public int deleteMenuPermissionById(String[] params) {
		int row = 0;
		for(String permission_id : params){
			row =+ menuPermissionDao.deleteMenuPermissionById(permission_id);
		}
		return row;
	}

	public List<MenuPermission> getAllMenuPermissions(Map<?, ?> paramsMap) {
		return menuPermissionDao.getAllMenuPermissions(paramsMap);
	}

	public MenuPermission getMenuPermissionById(String permission_id) {
		return menuPermissionDao.getMenuPermissionById(permission_id);
	}

	public int getMenuPermissionCount(Map<?, ?> paramsMap) {
		return menuPermissionDao.getMenuPermissionCount(paramsMap);
	}

	public int modifyMenuPermission(MenuPermission menuPermission) {
		return menuPermissionDao.modifyMenuPermission(menuPermission);
	}

	public int saveMenuPermission(MenuPermission menuPermission) {
		return menuPermissionDao.saveMenuPermission(menuPermission);
	}

	public List getMenuPermissionMenuByParentId(Map paramsMap) {
		return menuPermissionDao.getMenuPermissionMenuByParentId(paramsMap);
	}

}

