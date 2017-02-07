package com.action.dao;

import java.util.List;
import java.util.Map;

import com.action.model.Action;

public interface ActionDao {

	public abstract int saveAction(Action action);

	public abstract int deleteActionById(String actionid);
	
	public abstract int modifyAction(Action action);

	public abstract Action getActionById(String actionid);
	
	public abstract int getActionCount(Map<?,?> paramsMap);

	public abstract List<Action> getAllActions(Map<?,?> paramsMap);

	/**
	 * 根据动作地址获取动作属性
	 * @param actionUri
	 * @return
	 */
	public abstract Action getActionByUri(String actionUri);
}
