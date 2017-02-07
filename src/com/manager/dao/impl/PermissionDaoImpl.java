package com.manager.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.manager.dao.PermissionDao;
import com.manager.model.Permission;
import com.manager.model.RolePermissionRel;

@Repository
public class PermissionDaoImpl implements PermissionDao {

	private final String GET_LIST = "getPermissionList";
	private final String GET_COUNT = "getPermissionCount";
	private final String GET_BY_ID = "getPermissionById";
	private final String MODIFY = "modifyPermission";
	private final String SAVE = "savePermission";
	private final String DELETE_BY_ID = "deletePermissionById";
	
	private final String GET_OTHER_PERMISSION_COUNT = "getOtherPermissionRoleCount";
	private final String GET_OTHER_PERMISSION_ROLE_LIST = "getOtherPermissionRoleById";
	private final String GET_PERMISSION_ROLE_COUNT = "getPermissionRoleCount";
	private final String GET_PERMISSION_ROLE_LIST = "getPermissionRoldById";
	private final String DELETE_PERMISSION_ROLE_BY_ID = "deletePermissionRoldById";
	private final String SAVE_ROLE_PERMISSON_REL = "saveRolePermissionRel";
	
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deletePermissionById(String permission_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, permission_id);
	}

	public List<Permission> getAllPermissions(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Permission getPermissionById(String permission_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, permission_id);
	}

	public int getPermissionCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyPermission(Permission permission) {
		return sqlSessionTemplate.update(MODIFY, permission);
	}

	public int savePermission(Permission permission) {
		return sqlSessionTemplate.insert(SAVE, permission);
	}

	/**
	 *  以下四个方法为权限对应的角色列表查询
	 * 
	 */
	public int getOtherPermissionRoleCount(Map paramsMap) {
		return sqlSessionTemplate.selectOne(GET_OTHER_PERMISSION_COUNT, paramsMap);
	}

	public List getOtherPermissionRoleList(Map paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_OTHER_PERMISSION_ROLE_LIST, paramsMap, rowBounds);
	}

	public int getPermissionRoleCount(Map paramsMap) {
		return sqlSessionTemplate.selectOne(GET_PERMISSION_ROLE_COUNT, paramsMap);
	}

	public List getPermissionRoleList(Map paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_PERMISSION_ROLE_LIST, paramsMap, rowBounds);
	}

	public int deletePermissionRoleById(String permissionId) {
		return sqlSessionTemplate.delete(DELETE_PERMISSION_ROLE_BY_ID, permissionId);
	}

	public int addRoleToPermission(RolePermissionRel rel) {
		return sqlSessionTemplate.insert(SAVE_ROLE_PERMISSON_REL, rel);
	}

}

