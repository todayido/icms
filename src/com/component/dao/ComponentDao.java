package com.component.dao;

import java.util.List;
import java.util.Map;

import com.component.model.Component;

public interface ComponentDao {

	public abstract int saveComponent(Component component);

	public abstract int deleteComponentById(String componentid);
	
	public abstract int modifyComponent(Component component);

	public abstract Component getComponentById(String componentid);
	
	public abstract int getComponentCount(Map<?,?> paramsMap);

	public abstract List<Component> getAllComponents(Map<?,?> paramsMap);

	//根据组建类型获取组建
	public abstract Component getComponentByType(String componenttype);
}
