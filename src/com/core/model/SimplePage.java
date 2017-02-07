package com.core.model;

/**
 * 简单分页类
 */
public class SimplePage{
	
	private static final long serialVersionUID = 1L;
	// 当前页码
	public int pageNo = 1;
	// 每页显示的条数
	public int pageSize = 10;
	// 总条数
	public int totalCount = 0;
	// 总页数
	public int totalPage = 0;
	
	public SimplePage(){
		
	}
	
	public SimplePage(int pageNo, int pageSize, int totalCount){
		setTotalCount(totalCount);
		setPageSize(pageSize);
		ajustTotalPage();
		ajustPageNo(pageNo);
	}
	
	/**
	 * 当前页号
	 */
	public void setPageNo(int pageNo){
		this.pageNo = pageNo;
	}
	public void ajustPageNo(int pageNo){
		if(pageNo<1){
			pageNo = 1;
		}
		if(pageNo>totalPage){
			pageNo = totalPage;
		}
		this.pageNo = pageNo;
	}
	public int getPageNo(){
		return this.pageNo;
	}
	/**
	 * 每页显示条数
	 */
	public void setPageSize(int pageSize){
		if(pageSize<1){
			this.pageSize = 1;
		}
		this.pageSize = pageSize;
	}
	public int getPageSize(){
		return this.pageSize;
	}
	/**
	 * 总共几条数据
	 */
	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 总页数
	 */
	public void ajustTotalPage() {
		int totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		this.totalPage = totalPage;
	}
	public int getTotalPage() {
		return this.totalPage;
	}

}
