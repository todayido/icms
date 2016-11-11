package com.core.model;

import java.io.Serializable;

public class Sequence implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tablename;
	private String nextvalue;
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getNextvalue() {
		return nextvalue;
	}
	public void setNextvalue(String nextvalue) {
		this.nextvalue = nextvalue;
	}
	
}
