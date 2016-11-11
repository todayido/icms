package com.view.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.view.dao.ViewDao;
import com.view.model.View;
import com.view.service.ViewService;

@Service
public class ViewServiceImpl implements ViewService {

	@Resource
	ViewDao viewDao;
	
	public int deleteViewById(String[] params) {
		int row = 0;
		for(String viewid : params){
			row =+ viewDao.deleteViewById(viewid);
		}
		return row;
	}
	
	public List<View> getAllViews() {
		return viewDao.getAllViews();
	}

	public List<View> getAllViews(Map<?, ?> paramsMap) {
		return viewDao.getAllViews(paramsMap);
	}

	public View getViewById(String viewid) {
		return viewDao.getViewById(viewid);
	}

	public int getViewCount(Map<?, ?> paramsMap) {
		return viewDao.getViewCount(paramsMap);
	}

	public int modifyView(View view) {
		return viewDao.modifyView(view);
	}

	public int saveView(View view) {
		return viewDao.saveView(view);
	}

	public List getViewsByType(Map<?, ?> paramsMap) {
		return viewDao.getViewsByType(paramsMap);
	}

}

