package com.manager.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.ehcache.Element;

import org.springframework.stereotype.Service;

import com.manager.dao.RoleDao;
import com.manager.model.Role;
import com.manager.model.RolePermissionRel;
import com.manager.service.RoleService;
import com.utils.EhcacheUtils;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	RoleDao roleDao;
	
	public int deleteRoleById(String[] params) {
		int row = 0;
		for(String role_id : params){
			row =+ roleDao.deleteRoleById(role_id);
		}
		return row;
	}

	public List<Role> getAllRoles(Map<?, ?> paramsMap) {
		return roleDao.getAllRoles(paramsMap);
	}

	public Role getRoleById(String role_id) {
		return roleDao.getRoleById(role_id);
	}

	public int getRoleCount(Map<?, ?> paramsMap) {
		return roleDao.getRoleCount(paramsMap);
	}

	public int modifyRole(Role role) {
		return roleDao.modifyRole(role);
	}

	public int saveRole(Role role) {
		return roleDao.saveRole(role);
	}
	
	public List getRolePermissionList(Map<?, ?> paramsMap) {
		return roleDao.getRolePermissionList(paramsMap);
	}

	public int deleteRolePermissionById(String[] params) {
		int row = 0;
		for(String role_permission_id : params){
			row =+ roleDao.deleteRolePermissionById(role_permission_id);
		}
		return row;
	}
	
	public int deleteRolePermissionById(String[] params, String role_id) {
		int row = 0;
		for(String permission_id : params){
			row =+ roleDao.deleteRolePermissionById(permission_id,role_id);
		}
		return row;
	}

	public int addPermissionToRole(RolePermissionRel rolePermissionRel) {
		return roleDao.addPermissionToRole(rolePermissionRel);
	}

	public List<String> getRolesByUserName(String username) {
		return roleDao.getRolesByUserName(username);
	}
	
	public Set getRoleSetByResourceId(String resourceId) {
		Set set = null;
		//从缓存中读取数据
		if(EhcacheUtils.permissionCache().get(resourceId)!=null){
			try{
				set = (Set)EhcacheUtils.permissionCache().get(resourceId).getObjectValue();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			synchronized(this){
				List list = roleDao.getRoleListByResourceId(resourceId);
				set = new HashSet();
				for(int i=0;i<list.size();i++){
					set.add(list.get(i));
				}
				EhcacheUtils.permissionCache().put(new Element(resourceId,set));
			}
		}
		return set;
	}
	
	public void removeCache(String resourceId){
		EhcacheUtils.permissionCache().remove(resourceId);
	}

	public int getPermissionsCountBelongsToARole(Map paramsMap) {
		return roleDao.getPermissionsCountBelongsToARole(paramsMap);
	}

	public List getPermissionsListBelongsToARole(Map paramsMap) {
		return roleDao.getPermissionsListBelongsToARole(paramsMap);
	}

	public int getPermissionsCountNotBelongsToARole(Map paramsMap) {
		return roleDao.getPermissionsCountNotBelongsToARole(paramsMap);
	}

	public List getPermissionsListNotBelongsToARole(Map paramsMap) {
		return roleDao.getPermissionsListNotBelongsToARole(paramsMap);
	}

	public int deletePermissionFromRole(Map paramsMap) {
		return roleDao.deleteRolePermission(paramsMap);
	}
	
}

