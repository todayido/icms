package com.core.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.core.model.ControllerModel;
import com.core.model.ControllerView;

public class ControllerBeanFactory {

	static Logger logger = Logger.getLogger(ControllerBeanFactory.class.toString());
	//controllerMap:动作类
	private static Map<String, ControllerModel> controllerModelMap = new HashMap<String, ControllerModel>();

	ControllerBeanFactory() {
		Document doc = null;
		SAXReader saxReader;
		String path = this.getClass().getResource("/").getPath();
		
		try {
			// 加载动作和视图的 配置文件:classes/component.xml
			saxReader = new SAXReader();
			logger.debug("【加载配置文件："+path + "component.xml】");
			doc = saxReader.read(new File(path + "component.xml"));

			/**
			 * 循环解析配置文件中配置的所有的组件:classes/component-xxx.xml
			 */
			Element componentsElement = doc.getRootElement();
			Iterator it = componentsElement.elementIterator();
			while(it.hasNext()) {
				String xmlFilePath = ((Element) it.next()).attributeValue("src");
				logger.debug("【加载配置文件："+path+xmlFilePath+"】");
				
				/**
				 * 循环解析配置文件中配置的所有元素 actions和view
				 */
				Element componentElement = (Element)saxReader.read(new File(path+"/"+xmlFilePath)).getRootElement();
				String packageName = componentElement.attributeValue("package");
				Iterator itComponent = componentElement.elementIterator();
				while(itComponent.hasNext()) {
					Element actionElement = (Element) itComponent.next();
					//方法名
					String actionName = packageName + "/" + actionElement.attributeValue("id");
					//返回的类型:json,html
					String type = actionElement.attributeValue("type");
					//动作处理类
					String classPath = actionElement.attributeValue("class");
					//方法名称
					String name = actionElement.attributeValue("name");
					//要执行的名称
					String methodName = actionElement.attributeValue("method");
					
					ControllerModel controllerModel = new ControllerModel();
					controllerModel.setId(actionName);
					controllerModel.setMethodName(methodName);
					controllerModel.setName(name);
					controllerModel.setType(type);
					controllerModel.setClassPath(classPath);
					
					/**
					 * json类型的动作没有视图
					 * html类型的动作将第一个视图作为默认视图
					 */
					if(type.equalsIgnoreCase("html")){
						Iterator itView = actionElement.elementIterator();
						Element viewElement = (Element)itView.next();
						
						String viewName = viewElement.attributeValue("name");
						String viewPath = viewElement.getTextTrim();
						
						ControllerView controllerView = new ControllerView();
						controllerView.setName(viewName);
						controllerView.setViewPath(viewPath);
						controllerModel.setControllerView(controllerView);
					}
					controllerModelMap.put(actionName, controllerModel);
				}//while循环结束
				
				
			}
		}catch (Exception e) {
			logger.debug(this.getClass().toString()+"【加载配置文件出错！】");
			e.printStackTrace();
		}

	}
	
	/**
	 * 根据访问的方法名（配置文件中action的id）获取处理该方法的类。
	 * @param actionName
	 * @return
	 */
	static public Object getController(String actionName, HttpServletRequest request){
//		try {
//			ControllerModel controllerModel = (ControllerModel)controllerModelMap.get(actionName);
//			if(controllerModel==null){
//				logger.error("【访问的动作不存在！】ControllerBeanFactory-getController："+actionName);
//			}
//			String className = controllerModel.getClassPath();
//		
//			return Class.forName(className);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return null;
		
		ControllerModel controllerModel = (ControllerModel)controllerModelMap.get(actionName);
		if(controllerModel==null){
			logger.error("【访问的动作不存在！】ControllerBeanFactory-getController："+actionName);
		}
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		/**
		 * spring以类名的第一个字符为标识创建一个bean，直接根据配置文件中的className获取实例即可。
		 */
		String classPath = controllerModel.getClassPath();
		String beanName = classPath.substring(classPath.lastIndexOf(".")+1,classPath.length());
		
		String first = beanName.substring(0, 1).toLowerCase();
		String rest = beanName.substring(1, beanName.length());
		beanName = first+rest;
		
		return applicationContext.getBean(beanName);
	}
	/**
	 * 
	 * @param methodName
	 * @return
	 */
	static public ControllerModel getControllerModel(String actionName){
		return (ControllerModel)controllerModelMap.get(actionName);
	}
	
	/**
	 * 获取动作的默认视图路径
	 * @param methodName:动作id
	 * @return
	 */
	static public String getControllerView(String actionName){
		ControllerModel beanController = (ControllerModel)controllerModelMap.get(actionName);
		return beanController.getControllerView().getViewPath();
	}
	
	static public String getControllerType(String actionName){
		return ((ControllerModel)controllerModelMap.get(actionName)).getType();
	}
}
