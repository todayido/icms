package com.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.model.User;
import com.manager.service.AccessService;
import com.manager.service.RoleService;

@Service
public class AccessServiceImpl implements AccessService {

	@Resource
	RoleService roleService;
	public boolean access(User user, String resourceId) {
		Set<?> resourceRolesSet = roleService.getRoleSetByResourceId(resourceId);
		/*
		 * 1.该资源配置配置权限，任何用户都能访问。
		 * 2.该资源未登陆可以访问。
		 */
		if(resourceRolesSet.isEmpty() || resourceRolesSet.contains("nologin")){
			return true;
		}else{
			if(user==null){
				return false;
			}else{
				List<?> userRoleList = user.getRoleList();
				Map<?, ?> map = new HashMap<Object, Object>();
				for(int i=0;i<userRoleList.size();i++){
					map = (Map<?, ?>)userRoleList.get(i);
					if(resourceRolesSet.contains(map.get("ROLE_ID")) || map.get("ISSUPER").equals("1")){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
}
