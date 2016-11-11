package com.manager.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.manager.dao.UserDao;
import com.manager.model.Role;
import com.manager.model.User;
import com.manager.model.UserRoleRel;

@Repository
public class UserDaoImpl implements UserDao {

	private final String GET_LIST = "getUserList";
	private final String GET_USER_DEPART_INFO_BY_ID = "getUserAndDepartInfoById";
	private final String GET_COUNT = "getUserCount";
	
	private final String GET_BY_ID = "getUserById";
	private final String MODIFY = "modifyUser";
	private final String SAVE = "saveUser";
	private final String DELETE_BY_ID = "deleteUserById";
	
	private final String GET_USER_ROLE_LIST = "getUserRoleList";
	private final String GET_USER_ROLE_COUNT = "getUserRoleCount";
	
	private final String GET_OTHER_ROLE_LIST = "getOtherRoleList";
	private final String GET_OTHER_ROLE_COUNT = "getOtherRoleCount";
	
	private final String ADD_ROLE_TO_USER = "addRoleToUser";
	private final String DELETE_USER_ROLE_BY_ID = "deleteUserRoleById";
	//获取用户信息
	private final String GET_USER_INFO = "getUserInfo";
	//根据用户ID获取用户角色
	private final String GET_ROLES_LIST_BY_USER_ID = "getRolesListByUserId";
	//修改用户密码
	private final String MODIFY_PASSWORD_BY_USER_ID = "modifyPasswordByUserId";
	//修改用户错误登陆次数
	private final String MODIFY_ERROE_TIMES = "modifyUserErrorTimes";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteUserById(String user_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, user_id);
	}

	public List getAllUsers(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public User getUserById(String user_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, user_id);
	}

	public int getUserCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyUser(User user) {
		return sqlSessionTemplate.update(MODIFY, user);
	}

	public int saveUser(User user) {
		return sqlSessionTemplate.insert(SAVE, user);
	}

	public List getUserRoleList(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_USER_ROLE_LIST, paramsMap, rowBounds);
	}

	public int getUserRoleCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_USER_ROLE_COUNT, paramsMap);
	}
	
	public List getOtherRoleList(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_OTHER_ROLE_LIST, paramsMap, rowBounds);
	}

	public int getOtherRoleCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_OTHER_ROLE_COUNT, paramsMap);
	}

	public int deleteUserRoleById(String user_role_id) {
		return sqlSessionTemplate.delete(DELETE_USER_ROLE_BY_ID, user_role_id);
	}

	public int addRoleToUser(UserRoleRel userRoleRel) {
		return sqlSessionTemplate.insert(ADD_ROLE_TO_USER, userRoleRel);
	}

	public User getUserInfo(Map paramsMap) {
		return sqlSessionTemplate.selectOne(GET_USER_INFO, paramsMap);
	}

	public List getUserRoleListByUserId(String user_id) {
		return sqlSessionTemplate.selectList(GET_ROLES_LIST_BY_USER_ID, user_id);
	}

	public int modifyUserPassword(User user) {
		return sqlSessionTemplate.update(MODIFY_PASSWORD_BY_USER_ID, user);
	}

	public Map getUserAndDepartInfoById(String user_id) {
		return sqlSessionTemplate.selectOne(GET_USER_DEPART_INFO_BY_ID, user_id);
	}

	public int modifyUserErrorTimes(User userUpdate) {
		return sqlSessionTemplate.update(MODIFY_ERROE_TIMES, userUpdate);
	}

}

