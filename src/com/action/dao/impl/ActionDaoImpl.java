package com.action.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.action.dao.ActionDao;
import com.action.model.Action;

@Repository
public class ActionDaoImpl implements ActionDao {

	private final String GET_LIST = "getActionList";
	private final String GET_COUNT = "getActionCount";
	private final String GET_BY_ID = "getActionById";
	private final String MODIFY = "modifyAction";
	private final String SAVE = "saveAction";
	private final String DELETE_BY_ID = "deleteActionById";
	private final String GET_BY_URI = "getActionByUri";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteActionById(String actionid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, actionid);
	}

	public List<Action> getAllActions(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Action getActionById(String actionid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, actionid);
	}

	public int getActionCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyAction(Action action) {
		return sqlSessionTemplate.update(MODIFY, action);
	}

	public int saveAction(Action action) {
		return sqlSessionTemplate.insert(SAVE, action);
	}

	/**
	 * 根据动作地址获取动作属性
	 */
	public Action getActionByUri(String actionUri) {
		return sqlSessionTemplate.selectOne(GET_BY_URI, actionUri);
	}

}

