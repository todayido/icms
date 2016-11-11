package com.core.model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.core.service.impl.DicServiceImpl;
import com.core.template.TemplateDirectiveBlock;
import com.utils.BeanUtils;

import freemarker.template.SimpleHash;

public class DataModel extends SimpleHash{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DataModel(HttpServletRequest request, ServletContext content){
		//root路径
		this.put("root", request.getSession().getServletContext().getRealPath(""));
		//添加freemarker自定义标签
		this.put("block", new TemplateDirectiveBlock());
		this.put("DictionaryService", BeanUtils.getSpringBean("dicServiceImpl"));
		this.put("AccessService", BeanUtils.getSpringBean("accessServiceImpl"));
		HttpSession s = request.getSession();
		this.put("userModel", request.getSession().getAttribute("userModel"));
		this.put("payModel", request.getSession().getAttribute("payModel"));
		this.put("appSession", request.getSession());
	}

}
