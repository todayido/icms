package com.view.dao;

import java.util.List;
import java.util.Map;

import com.view.model.View;

public interface ViewDao {

	public abstract int saveView(View view);

	public abstract int deleteViewById(String viewid);
	
	public abstract int modifyView(View view);

	public abstract View getViewById(String viewid);
	
	public abstract int getViewCount(Map<?,?> paramsMap);

	public abstract List<View> getAllViews(Map<?,?> paramsMap);
	
	public abstract List<View> getAllViews();

	public abstract List<View> getViewsByType(Map<?, ?> paramsMap);

}
