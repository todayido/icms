package com.dictionary.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dictionary.dao.DictionaryDao;
import com.dictionary.model.Dictionary;

@Repository
public class DictionaryDaoImpl implements DictionaryDao {

	private final String GET_LIST = "getDictionaryList";
	private final String GET_LIST_BY_NAME = "getDictionaryListByName";
	private final String GET_COUNT = "getDictionaryCount";
	private final String GET_BY_ID = "getDictionaryById";
	private final String MODIFY = "modifyDictionary";
	private final String SAVE = "saveDictionary";
	private final String DELETE_BY_ID = "deleteDictionaryById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteDictionaryById(String dic_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, dic_id);
	}

	public List<Dictionary> getAllDictionarys(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Dictionary getDictionaryById(String dic_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, dic_id);
	}

	public int getDictionaryCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyDictionary(Dictionary dictionary) {
		return sqlSessionTemplate.update(MODIFY, dictionary);
	}

	public int saveDictionary(Dictionary dictionary) {
		return sqlSessionTemplate.insert(SAVE, dictionary);
	}

	public List<Dictionary> getDictionaryListByName(String dic_name) {
		return sqlSessionTemplate.selectList(GET_LIST_BY_NAME, dic_name);
	}

}

