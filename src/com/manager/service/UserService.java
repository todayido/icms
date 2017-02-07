package com.manager.service;

import java.util.List;
import java.util.Map;

import com.manager.model.Role;
import com.manager.model.User;
import com.manager.model.UserRoleRel;

public interface UserService {

	public abstract int saveUser(User user);

	public abstract int deleteUserById(String[] params);

	public abstract int modifyUser(User user);

	public abstract User getUserById(String user_id);

	public abstract int getUserCount(Map<?, ?> paramsMap);

	public abstract List getAllUsers(Map<?, ?> paramsMap);
	
	//获取某个用户所有的角色
	public abstract List getUserRoleList(Map<?, ?> paramsMap);
	public abstract int getUserRoleCount(Map<?, ?> paramsMap);
	
	//获取非该用户的角色
	public abstract List getOtherRoleList(Map<?, ?> paramsMap);
	public abstract int getOtherRoleCount(Map<?, ?> paramsMap);

	public abstract int deleteUserRoleById(String[] params);

	public abstract int addRoleToUser(UserRoleRel userRoleRel);

	/**
	 * 根据登录,状态...等名获取用户信息
	 */
	public abstract User getUserInfo(Map paramsMap);

	/**
	 * 根据用户ID获取该用户的角色
	 * @param user_id
	 * @return
	 */
	public abstract List getUserRoleListByUserId(String user_id);
	
	/**
	 * 根据用户ID修改用户密码
	 * @param user
	 */
	public abstract int modifyUserPassword(User user);

	/**
	 * 获取用户信息以及对应的部门信息
	 * @param user_id
	 * @return
	 */
	public abstract Map getUserAndDepartInfoById(String user_id);

	/**
	 * 用户登陆错误次数加1
	 * @param userUpdate
	 */
	public abstract int modifyUserErrorTimes(User userUpdate);

}

