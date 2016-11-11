package com.template.service;

import java.util.List;
import java.util.Map;

import com.template.model.Template;

public interface TemplateService {

	public abstract int saveTemplate(Template template);

	public abstract int deleteTemplateById(String[] params);

	public abstract int modifyTemplate(Template template);

	public abstract Template getTemplateById(String templateid);

	public abstract int getTemplateCount(Map<?, ?> paramsMap);

	public abstract List<Template> getAllTemplates(Map<?, ?> paramsMap);

	/**
	 * 获取所有模板数据
	 */
	public abstract List getAllTemplates();
}

