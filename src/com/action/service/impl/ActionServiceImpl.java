package com.action.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.action.dao.ActionDao;
import com.action.model.Action;
import com.action.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {

	@Resource
	ActionDao actionDao;
	
	public int deleteActionById(String[] params) {
		int row = 0;
		for(String actionid : params){
			row =+ actionDao.deleteActionById(actionid);
		}
		return row;
	}

	public List<Action> getAllActions(Map<?, ?> paramsMap) {
		return actionDao.getAllActions(paramsMap);
	}

	public Action getActionById(String actionid) {
		return actionDao.getActionById(actionid);
	}

	public int getActionCount(Map<?, ?> paramsMap) {
		return actionDao.getActionCount(paramsMap);
	}

	public int modifyAction(Action action) {
		return actionDao.modifyAction(action);
	}

	public int saveAction(Action action) {
		return actionDao.saveAction(action);
	}

	/**
	 * 根据动作地址获取动作属性
	 */
	public Action getActionByUri(String actionUri) {
		return actionDao.getActionByUri(actionUri);
	}

}

