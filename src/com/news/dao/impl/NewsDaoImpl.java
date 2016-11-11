package com.news.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.dao.NewsDao;
import com.news.model.News;

@Repository
public class NewsDaoImpl implements NewsDao {

	private final String GET_LIST = "getNewsList";
	private final String GET_COUNT = "getNewsCount";
	private final String GET_BY_ID = "getNewsById";
	private final String MODIFY = "modifyNews";
	private final String SAVE = "saveNews";
	private final String DELETE_BY_ID = "deleteNewsById";
	private final String GET_MGR_MENU_BY_PARENTID = "getMgrMenuByParentId";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteNewsById(String newsid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, newsid);
	}

	public List<News> getAllNewss(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public News getNewsById(String newsid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, newsid);
	}

	public int getNewsCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyNews(News news) {
		return sqlSessionTemplate.update(MODIFY, news);
	}

	public int saveNews(News news) {
		return sqlSessionTemplate.insert(SAVE, news);
	}

	public List getMgrMenuByParentId(Map paramsMap) {
		return sqlSessionTemplate.selectList(GET_MGR_MENU_BY_PARENTID, paramsMap);
	}

}

