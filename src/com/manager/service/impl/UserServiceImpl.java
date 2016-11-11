package com.manager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.Element;

import org.springframework.stereotype.Service;

import com.core.model.DataAndView;
import com.manager.dao.UserDao;
import com.manager.model.Role;
import com.manager.model.User;
import com.manager.model.UserRoleRel;
import com.manager.service.UserService;
import com.utils.EhcacheUtils;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	public int deleteUserById(String[] params) {
		int row = 0;
		for(String user_id : params){
			row =+ userDao.deleteUserById(user_id);
		}
		return row;
	}

	public List getAllUsers(Map<?, ?> paramsMap) {
		return userDao.getAllUsers(paramsMap);
	}

	public User getUserById(String user_id) {
		return userDao.getUserById(user_id);
	}

	public int getUserCount(Map<?, ?> paramsMap) {
		return userDao.getUserCount(paramsMap);
	}

	public int modifyUser(User user) {
		return userDao.modifyUser(user);
	}

	public int saveUser(User user) {
		return userDao.saveUser(user);
	}

	public List getUserRoleList(Map<?, ?> paramsMap) {
		return userDao.getUserRoleList(paramsMap);
	}

	public int getUserRoleCount(Map<?, ?> paramsMap) {
		return userDao.getUserRoleCount(paramsMap);
	}
	
	public List getOtherRoleList(Map<?, ?> paramsMap) {
		return userDao.getOtherRoleList(paramsMap);
	}

	public int getOtherRoleCount(Map<?, ?> paramsMap) {
		return userDao.getOtherRoleCount(paramsMap);
	}

	public int deleteUserRoleById(String[] params) {
		int row = 0;
		for(String user_id : params){
			row =+ userDao.deleteUserRoleById(user_id);
		}
		return row;
	}

	public int addRoleToUser(UserRoleRel userRoleRel) {
		return userDao.addRoleToUser(userRoleRel);
	}

	public User getUserInfo(Map paramsMap) {
		User user = null;
		String user_name = (String)paramsMap.get("user_name");
		//从缓存中读取数据
		if(EhcacheUtils.userCache().get(user_name)!=null){
			user = (User)EhcacheUtils.userCache().get(user_name).getObjectValue();
		}else{
			synchronized(this){
				user = userDao.getUserInfo(paramsMap);
				// 用户存在
				if(user!=null){
					user.setRoleList(getUserRoleListByUserId(user.getUser_id()));
					EhcacheUtils.userCache().put(new Element(user.getUser_name(),user));
				}
			}
		}
		return user;
	}

	public List getUserRoleListByUserId(String user_id) {
		return userDao.getUserRoleListByUserId(user_id);
	}

	public int modifyUserPassword(User user) {
		return userDao.modifyUserPassword(user);
	}
	
	public Map getUserAndDepartInfoById(String user_id) {
		return userDao.getUserAndDepartInfoById(user_id);
	}
	
	public void removeCache(String username){
		EhcacheUtils.userCache().remove(username);
	}

	public int modifyUserErrorTimes(User userUpdate) {
		return userDao.modifyUserErrorTimes(userUpdate);
	}

}

