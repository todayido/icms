package com.core.model;

/**
 * 数据模型
 * @param date:freemarker要渲染的数据
 * @param dataname:freemarker数据的key值
 * @param newView:指定要返回的视图
 * @param nextAction:要跳转的下一个动作
 * @param skipType:跳转类型：服务器跳转和客户端跳转
 */
public class DataAndView<V> {

	String dataname;
	V data;
	String newView;
	String nextController;
	SkipType skipType;
	
	public DataAndView(String dataName, V data,String nextController, SkipType skipType){
		this.dataname = dataName;
		this.data = data;
		this.nextController = nextController;
		this.skipType = skipType;
	}
	
	public DataAndView(String dataName, V data,String newView,String nextController, SkipType skipType){
		this.dataname = dataName;
		this.data = data;
		this.newView = newView;
		this.nextController = nextController;
		this.skipType = skipType;
	}

	public V getData() {
		return data;
	}
	
	public String getNewView() {
		return newView;
	}

	public String getDataname() {
		return dataname;
	}

	public String getNextController() {
		return nextController;
	}

	public SkipType getSkipType() {
		return skipType;
	}
	
	
	
}
