package com.item.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.item.dao.PaylogDao;
import com.item.model.Paylog;

@Repository
public class PaylogDaoImpl implements PaylogDao {

	private final String GET_LIST = "getPaylogList";
	private final String GET_COUNT = "getPaylogCount";
	private final String GET_BY_ID = "getPaylogById";
	private final String MODIFY = "modifyPaylog";
	private final String SAVE = "savePaylog";
	private final String DELETE_BY_ID = "deletePaylogById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deletePaylogById(String user_pay_log_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, user_pay_log_id);
	}

	public List<Paylog> getAllPaylogs(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Paylog getPaylogById(String user_pay_log_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, user_pay_log_id);
	}

	public int getPaylogCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyPaylog(Paylog payLog) {
		return sqlSessionTemplate.update(MODIFY, payLog);
	}

	public int savePaylog(Paylog payLog) {
		return sqlSessionTemplate.insert(SAVE, payLog);
	}

}

