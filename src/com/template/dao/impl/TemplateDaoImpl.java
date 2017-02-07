package com.template.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.template.dao.TemplateDao;
import com.template.model.Template;

@Repository
public class TemplateDaoImpl implements TemplateDao {

	private final String GET_LIST = "getTemplateList";
	private final String GET_COUNT = "getTemplateCount";
	private final String GET_BY_ID = "getTemplateById";
	private final String MODIFY = "modifyTemplate";
	private final String SAVE = "saveTemplate";
	private final String DELETE_BY_ID = "deleteTemplateById";
	private final String GET_ALL_TAMPLATES = "getAllTemplates";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteTemplateById(String templateid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, templateid);
	}

	public List<Template> getAllTemplates(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Template getTemplateById(String templateid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, templateid);
	}

	public int getTemplateCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyTemplate(Template template) {
		return sqlSessionTemplate.update(MODIFY, template);
	}

	public int saveTemplate(Template template) {
		return sqlSessionTemplate.insert(SAVE, template);
	}
	/**
	 * 获取所有模板数据
	 */
	public List<Template> getAllTemplates(){
		return sqlSessionTemplate.selectList(GET_ALL_TAMPLATES);
	}

}

