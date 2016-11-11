package com.manager.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.manager.dao.MenuPermissionDao;
import com.manager.model.MenuPermission;

@Repository
public class MenuPermissionDaoImpl implements MenuPermissionDao {

	private final String GET_LIST = "getMenuPermissionList";
	private final String GET_COUNT = "getMenuPermissionCount";
	private final String GET_BY_ID = "getMenuPermissionById";
	private final String MODIFY = "modifyMenuPermission";
	private final String SAVE = "saveMenuPermission";
	private final String DELETE_BY_ID = "deleteMenuPermissionById";
	private final String GET_MENU_PERMISSION_MENU_BY_PARENTID = "getMenuPermissionMenuByParentId";
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteMenuPermissionById(String permission_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, permission_id);
	}

	public List<MenuPermission> getAllMenuPermissions(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public MenuPermission getMenuPermissionById(String permission_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, permission_id);
	}

	public int getMenuPermissionCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyMenuPermission(MenuPermission menuPermission) {
		return sqlSessionTemplate.update(MODIFY, menuPermission);
	}

	public int saveMenuPermission(MenuPermission manuPermission) {
		return sqlSessionTemplate.insert(SAVE, manuPermission);
	}

	public List getMenuPermissionMenuByParentId(Map paramsMap) {
		return sqlSessionTemplate.selectList(GET_MENU_PERMISSION_MENU_BY_PARENTID, paramsMap);
	}

}

