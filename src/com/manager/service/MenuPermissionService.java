package com.manager.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manager.model.MenuPermission;

public interface MenuPermissionService {

	public abstract int saveMenuPermission(MenuPermission menuPermission);

	public abstract int deleteMenuPermissionById(String[] params);

	public abstract int modifyMenuPermission(MenuPermission menuPermission);

	public abstract MenuPermission getMenuPermissionById(String permission_id);

	public abstract int getMenuPermissionCount(Map<?, ?> paramsMap);

	public abstract List<MenuPermission> getAllMenuPermissions(Map<?, ?> paramsMap);

	//根据父节点取权限菜单
	public abstract List getMenuPermissionMenuByParentId(Map paramsMap);
}

