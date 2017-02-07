package com.manager.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.manager.dao.MenuDao;
import com.manager.model.Menu;

@Repository
public class MenuDaoImpl implements MenuDao {

	private final String GET_LEFT_TREE_BY_PARENT_ID = "getLeftTreeByParentId";
	private final String GET_MENU_TREE_BY_PARENT_ID = "getMenuTreeByParentId";
	
	private final String GET_LIST = "getMenuList";
//	private final String GET_LIST_BY_PARENT_ID = "getMenuListByParentId";
	private final String GET_COUNT = "getMenuCount";
	private final String GET_BY_ID = "getMenuById";
	private final String MODIFY = "modifyMenu";
	private final String SAVE = "saveMenu";
	private final String DELETE_BY_ID = "deleteMenuById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List getLeftTreeByParentId(Map<?, ?> paramsMap) {
		try{
			return sqlSessionTemplate.selectList(GET_LEFT_TREE_BY_PARENT_ID, paramsMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List getMenuTreeByParentId(Map<?, ?> paramsMap) {
		try{
			return sqlSessionTemplate.selectList(GET_MENU_TREE_BY_PARENT_ID, paramsMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public List<Menu> getMenuListByParentId(Map<?, ?> paramsMap) {
//		try{
//			return sqlSessionTemplate.selectList(GET_LIST_BY_PARENT_ID, paramsMap);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public List<Menu> getAllMenus(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}
	
	public int getMenuCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}
	
	
	public int deleteMenuById(String menuid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, menuid);
	}

	public Menu getMenuById(String menuid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, menuid);
	}

	public int modifyMenu(Menu menu) {
		return sqlSessionTemplate.update(MODIFY, menu);
	}

	public int saveMenu(Menu menu) {
		return sqlSessionTemplate.insert(SAVE, menu);
	}

}
