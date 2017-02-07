package com.manager.dao;

import java.util.List;
import java.util.Map;

import com.manager.model.User;
import com.manager.model.UserRoleRel;

public interface UserDao {

	public abstract int saveUser(User user);

	public abstract int deleteUserById(String user_id);
	
	public abstract int modifyUser(User user);

	public abstract User getUserById(String user_id);
	
	public abstract int getUserCount(Map<?,?> paramsMap);

	public abstract List getAllUsers(Map<?,?> paramsMap);

	public abstract List getUserRoleList(Map<?, ?> paramsMap);
	public abstract int getUserRoleCount(Map<?, ?> paramsMap);
	
	public abstract List getOtherRoleList(Map<?, ?> paramsMap);
	public abstract int getOtherRoleCount(Map<?, ?> paramsMap);

	public abstract int deleteUserRoleById(String user_role_id);

	public abstract int addRoleToUser(UserRoleRel userRoleRel);

	public abstract User getUserInfo(Map paramsMap);

	public abstract List getUserRoleListByUserId(String user_id);

	public abstract int modifyUserPassword(User user);

	public abstract Map getUserAndDepartInfoById(String user_id);

	public abstract int modifyUserErrorTimes(User userUpdate);

}
