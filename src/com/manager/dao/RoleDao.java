package com.manager.dao;

import java.util.List;
import java.util.Map;

import com.manager.model.Role;
import com.manager.model.RolePermissionRel;

public interface RoleDao {

	public abstract int saveRole(Role role);

	public abstract int deleteRoleById(String role_id);
	
	public abstract int modifyRole(Role role);

	public abstract Role getRoleById(String role_id);
	
	public abstract int getRoleCount(Map<?,?> paramsMap);

	public abstract List<Role> getAllRoles(Map<?,?> paramsMap);
	
	public abstract List getRolePermissionList(Map<?, ?> paramsMap);
	
	public abstract int deleteRolePermissionById(String role_permission_id);
	public abstract int deleteRolePermissionById(String role_permission_id, String role_id);

	public abstract int addPermissionToRole(RolePermissionRel rolePermissionRel);

	public abstract List<String> getRolesByUserName(String username);
	
	public abstract List getRoleListByResourceId(String resourceId);

	public abstract int getPermissionsCountBelongsToARole(Map paramsMap);

	public abstract List getPermissionsListBelongsToARole(Map paramsMap);

	public abstract int getPermissionsCountNotBelongsToARole(Map paramsMap);

	public abstract List getPermissionsListNotBelongsToARole(Map paramsMap);

	public abstract int deletePermissionFromRoleById(String rolePermissionId);

	public abstract int deleteRolePermission(Map paramsMap);

}
