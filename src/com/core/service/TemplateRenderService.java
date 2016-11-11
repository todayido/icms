package com.core.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.core.model.DataModel;
import com.manager.model.User;
import com.utils.BeanUtils;
import com.utils.EhcacheUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 渲染模板
 */
public class TemplateRenderService{
	
	private final static Logger logger = Logger.getLogger(TemplateRenderService.class);  
	
	public static Configuration freemarkerCfg = (Configuration) BeanUtils.getSpringBean("freemarkerConfig");
	
	public TemplateRenderService(){
		try {
			freemarkerCfg.setEncoding(Locale.CHINA, "UTF-8");
			freemarkerCfg.setDirectoryForTemplateLoading(new File(this.getClass().getClassLoader().getResource("").getPath().replace("/classes", "")));
		} catch (IOException e) {
			logger.error("TemplateRenderService：加载freemarker configuration失败...");
			e.printStackTrace();
		} 
	}
	
	public Template getTemplateByName(String templateName){
		Template temp = null;
		try{
			if(EhcacheUtils.templateCache().get(templateName)!=null){
				temp = (Template)EhcacheUtils.templateCache().get(templateName).getObjectValue();
			}else{
				synchronized(this){
					temp = freemarkerCfg.getTemplate(templateName);
					EhcacheUtils.templateCache().put(new Element(templateName,temp));
				}
			}
			
			return temp;
		}catch(Exception e){
			logger.error("TemplateRenderServiceImpl-getTemplateByName:加载模板失败...");
			e.printStackTrace();
		}
		
		return temp;
		
	}
	
	public void removeCache(String templateName){
		EhcacheUtils.templateCache().remove(templateName);
	}
	
	public StringWriter render(String templateFilePath, DataModel dataModel){
		try{
			Template template = getTemplateByName(templateFilePath);
			StringWriter sw = new StringWriter();
			template.process(dataModel, sw);
			return sw;
		}catch(Exception e){
			logger.error("TemplateRenderServiceImpl-render:渲染模板失败...");
			e.printStackTrace();
		}
		return null;
	}
	
}
