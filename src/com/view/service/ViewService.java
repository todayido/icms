package com.view.service;

import java.util.List;
import java.util.Map;

import com.view.model.View;

public interface ViewService {

	public abstract int saveView(View view);

	public abstract int deleteViewById(String[] params);

	public abstract int modifyView(View view);

	public abstract View getViewById(String viewid);

	public abstract int getViewCount(Map<?, ?> paramsMap);

	public abstract List<View> getAllViews(Map<?, ?> paramsMap);

	public abstract List<View> getAllViews();

	public abstract List getViewsByType(Map<?, ?> paramsMap);
}

