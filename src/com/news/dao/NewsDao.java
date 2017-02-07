package com.news.dao;

import java.util.List;
import java.util.Map;

import com.news.model.News;

public interface NewsDao {

	public abstract int saveNews(News news);

	public abstract int deleteNewsById(String newsid);
	
	public abstract int modifyNews(News news);

	public abstract News getNewsById(String newsid);
	
	public abstract int getNewsCount(Map<?,?> paramsMap);

	public abstract List<News> getAllNewss(Map<?,?> paramsMap);

	public abstract List getMgrMenuByParentId(Map paramsMap);
}
