package com.newsproperty.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.newsproperty.dao.NewspropertyDao;
import com.newsproperty.model.Newsproperty;

@Repository
public class NewspropertyDaoImpl implements NewspropertyDao {

	private final String GET_LIST = "getNewspropertyList";
	private final String GET_COUNT = "getNewspropertyCount";
	private final String GET_BY_ID = "getNewspropertyById";
	private final String MODIFY = "modifyNewsproperty";
	private final String SAVE = "saveNewsproperty";
	private final String DELETE_BY_ID = "deleteNewspropertyById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteNewspropertyById(String blockid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, blockid);
	}

	public List<Newsproperty> getAllNewspropertys(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Newsproperty getNewspropertyById(String blockid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, blockid);
	}

	public int getNewspropertyCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyNewsproperty(Newsproperty newsproperty) {
		return sqlSessionTemplate.update(MODIFY, newsproperty);
	}

	public int saveNewsproperty(Newsproperty newsproperty) {
		return sqlSessionTemplate.insert(SAVE, newsproperty);
	}

}

