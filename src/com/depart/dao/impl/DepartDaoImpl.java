package com.depart.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.depart.dao.DepartDao;
import com.depart.model.Depart;

@Repository
public class DepartDaoImpl implements DepartDao {

	private final String GET_LIST = "getDepartList";
	private final String GET_LIST_BY_PARENT_ID = "getDepartByParentId";
	private final String GET_DEPART_MAP_BY_ID = "getDepartMapById";
	private final String GET_COUNT = "getDepartCount";
	private final String GET_BY_ID = "getDepartById";
	private final String MODIFY = "modifyDepart";
	private final String SAVE = "saveDepart";
	private final String DELETE_BY_ID = "deleteDepartById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteDepartById(String depart_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, depart_id);
	}

	public List<Depart> getAllDeparts(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Depart getDepartById(String depart_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, depart_id);
	}

	public int getDepartCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyDepart(Depart depart) {
		return sqlSessionTemplate.update(MODIFY, depart);
	}

	public int saveDepart(Depart depart) {
		return sqlSessionTemplate.insert(SAVE, depart);
	}

	public List getDepartByParentId(Map paramsMap) {
		return sqlSessionTemplate.selectList(GET_LIST_BY_PARENT_ID, paramsMap);
	}

	public Map getDepartMapById(String depart_id) {
		Map map = sqlSessionTemplate.selectOne(GET_DEPART_MAP_BY_ID, depart_id);
		return map;
	}

}

