package com.component.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.component.dao.ComponentDao;
import com.component.model.Component;

@Repository
public class ComponentDaoImpl implements ComponentDao {

	private final String GET_LIST = "getComponentList";
	private final String GET_COUNT = "getComponentCount";
	private final String GET_BY_ID = "getComponentById";
	private final String GET_BY_TYPE = "getComponentByType";
	private final String MODIFY = "modifyComponent";
	private final String SAVE = "saveComponent";
	private final String DELETE_BY_ID = "deleteComponentById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteComponentById(String componentid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, componentid);
	}

	public List<Component> getAllComponents(Map<?, ?> paramsMap) {
		if(paramsMap==null){
			return sqlSessionTemplate.selectList(GET_LIST,null);
		}else{
			int offset = (Integer)paramsMap.get("begin");
			int limit = (Integer)paramsMap.get("end");
			RowBounds rowBounds = null;
			if(limit!=0){
				rowBounds = new RowBounds(offset, limit);
				return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
			}
			return sqlSessionTemplate.selectList(GET_LIST, paramsMap);
		}
		
	}

	public Component getComponentById(String componentid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, componentid);
	}

	public int getComponentCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyComponent(Component component) {
		return sqlSessionTemplate.update(MODIFY, component);
	}

	public int saveComponent(Component component) {
		return sqlSessionTemplate.insert(SAVE, component);
	}

	//根据组建类型获取组建
	public Component getComponentByType(String componenttype) {
		return sqlSessionTemplate.selectOne(GET_BY_TYPE,componenttype);
	}

}

