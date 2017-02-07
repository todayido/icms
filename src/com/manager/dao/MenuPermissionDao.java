package com.manager.dao;

import java.util.List;
import java.util.Map;

import com.manager.model.MenuPermission;

public interface MenuPermissionDao {

	public abstract int saveMenuPermission(MenuPermission menuPermission);

	public abstract int deleteMenuPermissionById(String permission_id);
	
	public abstract int modifyMenuPermission(MenuPermission menuPermission);

	public abstract MenuPermission getMenuPermissionById(String permission_id);
	
	public abstract int getMenuPermissionCount(Map<?,?> paramsMap);

	public abstract List<MenuPermission> getAllMenuPermissions(Map<?,?> paramsMap);

	public abstract List getMenuPermissionMenuByParentId(Map paramsMap);

}
