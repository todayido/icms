package com.manager.dao;

import java.util.List;
import java.util.Map;

import com.manager.model.Permission;
import com.manager.model.RolePermissionRel;

public interface PermissionDao {

	public abstract int savePermission(Permission permission);

	public abstract int deletePermissionById(String permission_id);
	
	public abstract int modifyPermission(Permission permission);

	public abstract Permission getPermissionById(String permission_id);
	
	public abstract int getPermissionCount(Map<?,?> paramsMap);

	public abstract List<Permission> getAllPermissions(Map<?,?> paramsMap);

	public abstract int getPermissionRoleCount(Map paramsMap);

	public abstract List getPermissionRoleList(Map paramsMap);

	public abstract int getOtherPermissionRoleCount(Map paramsMap);

	public abstract List getOtherPermissionRoleList(Map paramsMap);

	public abstract int deletePermissionRoleById(String permissionId);

	public abstract int addRoleToPermission(RolePermissionRel rel);

}
