package com.manager.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String menuid;
	/**
	 * 菜单名
	 */
	private String menuname;
	/**
	 * 链接地址
	 */
	private String menuurl;
	/**
	 * 上一级菜单id
	 */
	private String parentid;
	/**
	 * 是否有下级（0：否；1：是）
	 */
	private String hasnext;
	/**
	 * 优先级排序字段
	 */
	private String priority;
	/**
	 * 是否显示该菜单（0：不显示；1：显示）
	 */
	private String display;
	/**
	 * 结果集
	 */
	private List<?> resultList;
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getHasnext() {
		return hasnext;
	}
	public void setHasnext(String hasnext) {
		this.hasnext = hasnext;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public List<?> getResultList() {
		return resultList;
	}
	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}
	
}
