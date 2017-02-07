package com.core.model;

import com.core.model.ControllerView;

public class ControllerModel {

	/**
	 * 动作id:类中的动作名称
	 */
	private String id;
	/**
	 * 方法名称
	 */
	private String name;
	/**
	 * 方法类型
	 * JSON:直接返回数据
	 * HTML:渲染view后返回渲染后的数据
	 */
	private String type;
	/**
	 * 处理方法的类，由该类调用方法，方法即为方法id
	 */
	private String classPath;
	/**
	 * 动作类中的方法名
	 */
	private String methodName;
	/**
	 * 方法对应的模板
	 */
	private ControllerView controllerView;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClassPath() {
		return classPath;
	}
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public ControllerView getControllerView() {
		return controllerView;
	}
	public void setControllerView(ControllerView controllerView) {
		this.controllerView = controllerView;
	}
	
	
}
