package com.core.model;

public class ControllerView {
	
	/**
	 * 模板名称
	 */
	private String name;
	/**
	 * 模板路径
	 * com/xx/xxx.ftl
	 */
	private String viewPath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getViewPath() {
		return viewPath;
	}
	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}
	
	

}
