package com.template.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.template.dao.TemplateDao;
import com.template.model.Template;
import com.template.service.TemplateService;
import com.utils.EhcacheUtils;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Resource
	TemplateDao templateDao;
	
	public int deleteTemplateById(String[] params) {
		int row = 0;
		for(String templateid : params){
			row =+ templateDao.deleteTemplateById(templateid);
		}
		return row;
	}

	public List<Template> getAllTemplates(Map<?, ?> paramsMap) {
		return templateDao.getAllTemplates(paramsMap);
	}

	public Template getTemplateById(String templateid) {
		return templateDao.getTemplateById(templateid);
	}

	public int getTemplateCount(Map<?, ?> paramsMap) {
		return templateDao.getTemplateCount(paramsMap);
	}

	public int modifyTemplate(Template template) {
		return templateDao.modifyTemplate(template);
	}

	public int saveTemplate(Template template) {
		return templateDao.saveTemplate(template);
	}

	/**
	 * 获取所有模板数据
	 */
	public List getAllTemplates() {
		return templateDao.getAllTemplates();
	}
	
	public void removeCache(String templatename){
		EhcacheUtils.templateCache().remove(templatename);
	}

}

