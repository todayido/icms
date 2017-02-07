package com.manager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.dao.PermissionDao;
import com.manager.model.Permission;
import com.manager.model.RolePermissionRel;
import com.manager.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	PermissionDao permissionDao;
	
	public int deletePermissionById(String[] params) {
		int row = 0;
		for(String permission_id : params){
			row =+ permissionDao.deletePermissionById(permission_id);
		}
		return row;
	}

	public List<Permission> getAllPermissions(Map<?, ?> paramsMap) {
		return permissionDao.getAllPermissions(paramsMap);
	}

	public Permission getPermissionById(String permission_id) {
		return permissionDao.getPermissionById(permission_id);
	}

	public int getPermissionCount(Map<?, ?> paramsMap) {
		return permissionDao.getPermissionCount(paramsMap);
	}

	public int modifyPermission(Permission permission) {
		return permissionDao.modifyPermission(permission);
	}

	public int savePermission(Permission permission) {
		return permissionDao.savePermission(permission);
	}

	public int getPermissionRoleCount(Map paramsMap) {
		return permissionDao.getPermissionRoleCount(paramsMap);
	}

	public List getPermissionRoleList(Map paramsMap) {
		return permissionDao.getPermissionRoleList(paramsMap);
	}

	public int getOtherPermissionRoleCount(Map paramsMap) {
		return permissionDao.getOtherPermissionRoleCount(paramsMap);
	}

	public List getOtherPermissionRoleList(Map paramsMap) {
		return permissionDao.getOtherPermissionRoleList(paramsMap);
	}

	public int deletePermissionRoleById(String[] params) {
		int row = 0;
		for(String permission_id : params){
			row =+ permissionDao.deletePermissionRoleById(permission_id);
		}
		return row;
	}

	public int addRoleToPermission(RolePermissionRel rel) {
		return permissionDao.addRoleToPermission(rel);
	}

}

