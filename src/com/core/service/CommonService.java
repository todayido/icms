package com.core.service;

import com.action.model.Action;

public interface CommonService {
	/**
	 * 查询动作配置的模板和视图
	 */
	public Action getActionConfigure(String actionUrl);
}
