package com.news.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.NewsDao;
import com.news.model.News;
import com.news.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Resource
	NewsDao newsDao;
	
	public int deleteNewsById(String[] params) {
		int row = 0;
		for(String newsid : params){
			row =+ newsDao.deleteNewsById(newsid);
		}
		return row;
	}

	public List<News> getAllNewss(Map<?, ?> paramsMap) {
		return newsDao.getAllNewss(paramsMap);
	}

	public News getNewsById(String newsid) {
		return newsDao.getNewsById(newsid);
	}

	public int getNewsCount(Map<?, ?> paramsMap) {
		return newsDao.getNewsCount(paramsMap);
	}

	public int modifyNews(News news) {
		return newsDao.modifyNews(news);
	}

	public int saveNews(News news) {
		return newsDao.saveNews(news);
	}

	public List getNewsMgrMenuByParentId(Map paramsMap) {
		return newsDao.getMgrMenuByParentId(paramsMap);
	}

}

