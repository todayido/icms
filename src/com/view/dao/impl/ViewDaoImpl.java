package com.view.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.view.dao.ViewDao;
import com.view.model.View;

@Repository
public class ViewDaoImpl implements ViewDao {

	private final String GET_LIST = "getViewList";
	private final String GET_COUNT = "getViewCount";
	private final String GET_BY_ID = "getViewById";
	private final String MODIFY = "modifyView";
	private final String SAVE = "saveView";
	private final String DELETE_BY_ID = "deleteViewById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteViewById(String viewid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, viewid);
	}

	public List<View> getAllViews(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public View getViewById(String viewid) {
		try{
			return sqlSessionTemplate.selectOne(GET_BY_ID, viewid);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int getViewCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyView(View view) {
		return sqlSessionTemplate.update(MODIFY, view);
	}

	public int saveView(View view) {
		return sqlSessionTemplate.insert(SAVE, view);
	}

	public List<View> getAllViews() {
		return sqlSessionTemplate.selectList(GET_LIST);
	}

	public List<View> getViewsByType(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap);
	}

}

