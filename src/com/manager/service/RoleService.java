package com.manager.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manager.model.Role;
import com.manager.model.RolePermissionRel;
import com.manager.model.UserRoleRel;

public interface RoleService {

	public abstract int saveRole(Role role);

	public abstract int deleteRoleById(String[] params);

	public abstract int modifyRole(Role role);

	public abstract Role getRoleById(String role_id);

	public abstract int getRoleCount(Map<?, ?> paramsMap);

	public abstract List<Role> getAllRoles(Map<?, ?> paramsMap);

	//获取某个角色所有的权限
	public abstract List getRolePermissionList(Map<?, ?> paramsMap);
	
	public abstract int deleteRolePermissionById(String[] params);
	//根据permissionId和roleId删除角色中的包含的权限
	public abstract int deleteRolePermissionById(String[] params, String role_d);

	public abstract int addPermissionToRole(RolePermissionRel rolePermissionRel);

	/**
	 * 根据用户名获取该用户的所有角色
	 * @param username
	 * @return
	 */
	public abstract List<String> getRolesByUserName(String username);
	
	public Set getRoleSetByResourceId(String resourceId);

	public abstract int getPermissionsCountBelongsToARole(Map paramsMap);

	public abstract List getPermissionsListBelongsToARole(Map paramsMap);

	public abstract int getPermissionsCountNotBelongsToARole(Map paramsMap);

	public abstract List getPermissionsListNotBelongsToARole(Map paramsMap);

	public abstract int deletePermissionFromRole(Map paramsMap);

}

