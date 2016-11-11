package com.chanel.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.chanel.dao.ChanelDao;
import com.chanel.model.Chanel;

@Repository
public class ChanelDaoImpl implements ChanelDao {

	private final String GET_LIST = "getChanelList";
	private final String GET_COUNT = "getChanelCount";
	private final String GET_BY_ID = "getChanelById";
	private final String MODIFY = "modifyChanel";
	private final String SAVE = "saveChanel";
	private final String DELETE_BY_ID = "deleteChanelById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteChanelById(String chanelid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, chanelid);
	}

	public List<Chanel> getAllChanels(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Chanel getChanelById(String chanelid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, chanelid);
	}

	public int getChanelCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyChanel(Chanel chanel) {
		return sqlSessionTemplate.update(MODIFY, chanel);
	}

	public int saveChanel(Chanel chanel) {
		return sqlSessionTemplate.insert(SAVE, chanel);
	}

}

