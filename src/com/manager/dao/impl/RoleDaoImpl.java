package com.manager.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.manager.dao.RoleDao;
import com.manager.model.Role;
import com.manager.model.RolePermissionRel;

@Repository
public class RoleDaoImpl implements RoleDao {

	private final String GET_LIST = "getRoleList";
	private final String GET_COUNT = "getRoleCount";
	private final String GET_BY_ID = "getRoleById";
	private final String MODIFY = "modifyRole";
	private final String SAVE = "saveRole";
	private final String DELETE_BY_ID = "deleteRoleById";
	
	private final String GET_ROLE_PERMISSION_LIST = "getRolePermissionList";
	private final String ADD_PERMISSION_TO_ROLE = "addPermissionToRole";
	private final String DELETE_ROLE_PERMISSION_BY_ID = "deleteRolePermissionById";
	
	private final String GET_ROLES_BY_USERNAME = "getRolesByUsername";
	private final String GET_ROLES_BY_RESOURCE_ID = "getRolesByResourceId";
	
	private final String GET_PERMISSIONS_BELONGS_TO_A_ROLE = "getPermissionsBelongsToARole";
	private final String GET_PERMISSIONS_COUNT_BELONGS_TO_A_ROLE = "getPermissionsCountNotBelongsToARole";
	
	private final String GET_PERMISSIONS_NOT_BELONGS_TO_A_ROLE = "getPermissionsNotBelongsToARole";
	private final String GET_PERMISSIONS_COUNT_NOT_BELONGS_TO_A_ROLE = "getPermissionsCountNotBelongsToARole";
	
	
	private final String DELETE_PERMISSION_FROM_A_ROLE_BY_ID = "deletePermissionFromARole";
	
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteRoleById(String role_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, role_id);
	}

	public List<Role> getAllRoles(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Role getRoleById(String role_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, role_id);
	}

	public int getRoleCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyRole(Role role) {
		return sqlSessionTemplate.update(MODIFY, role);
	}

	public int saveRole(Role role) {
		return sqlSessionTemplate.insert(SAVE, role);
	}
	
	public List getRolePermissionList(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectList(GET_ROLE_PERMISSION_LIST, paramsMap);
	}
	
	public int deleteRolePermissionById(String role_permission_id) {
		return sqlSessionTemplate.delete(DELETE_ROLE_PERMISSION_BY_ID, role_permission_id);
	}
	
	public int deleteRolePermissionById(String permission_id, String role_id) {
		Map paramsMap = new HashMap();
		paramsMap.put("permission_id", permission_id);
		paramsMap.put("role_id", role_id);
		return sqlSessionTemplate.delete(DELETE_ROLE_PERMISSION_BY_ID, paramsMap);
	}

	public int addPermissionToRole(RolePermissionRel rolePermissionRel) {
		return sqlSessionTemplate.insert(ADD_PERMISSION_TO_ROLE, rolePermissionRel);
	}

	public List<String> getRolesByUserName(String username) {
		return sqlSessionTemplate.selectList(GET_ROLES_BY_USERNAME, username);
	}
	
	public List getRoleListByResourceId(String resourceId) {
		return sqlSessionTemplate.selectList(GET_ROLES_BY_RESOURCE_ID, resourceId);
	}

	public int getPermissionsCountBelongsToARole(Map paramsMap) {
		return sqlSessionTemplate.selectOne(GET_PERMISSIONS_COUNT_BELONGS_TO_A_ROLE, paramsMap);
	}

	public List getPermissionsListBelongsToARole(Map paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_PERMISSIONS_BELONGS_TO_A_ROLE, paramsMap, rowBounds);
	}

	public int getPermissionsCountNotBelongsToARole(Map paramsMap) {
		return sqlSessionTemplate.selectOne(GET_PERMISSIONS_COUNT_NOT_BELONGS_TO_A_ROLE, paramsMap);
	}

	public List getPermissionsListNotBelongsToARole(Map paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_PERMISSIONS_NOT_BELONGS_TO_A_ROLE, paramsMap, rowBounds);
	}

	public int deletePermissionFromRoleById(String rolePermissionId) {
		return sqlSessionTemplate.delete(DELETE_PERMISSION_FROM_A_ROLE_BY_ID, rolePermissionId);
	}

	public int deleteRolePermission(Map paramsMap) {
		return sqlSessionTemplate.delete(DELETE_PERMISSION_FROM_A_ROLE_BY_ID, paramsMap);
	}

}

