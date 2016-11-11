package com.component.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.component.dao.ComponentDao;
import com.component.model.Component;
import com.component.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService {

	@Resource
	ComponentDao componentDao;
	
	public int deleteComponentById(String[] params) {
		int row = 0;
		for(String componentid : params){
			row =+ componentDao.deleteComponentById(componentid);
		}
		return row;
	}

	public List<Component> getAllComponents(Map<?, ?> paramsMap) {
		return componentDao.getAllComponents(paramsMap);
	}

	public Component getComponentById(String componentid) {
		return componentDao.getComponentById(componentid);
	}

	public int getComponentCount(Map<?, ?> paramsMap) {
		return componentDao.getComponentCount(paramsMap);
	}

	public int modifyComponent(Component component) {
		return componentDao.modifyComponent(component);
	}

	public int saveComponent(Component component) {
		return componentDao.saveComponent(component);
	}

	public Component getComponentByType(String componenttype) {
		//根据组建类型获取组建
		return componentDao.getComponentByType(componenttype);
	}

}

