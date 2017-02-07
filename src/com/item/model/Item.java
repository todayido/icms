package  com.item.model;

import java.util.Date;

public class Item{
    //任务编号
    private String item_id;
    //任务发布人
    private String user_id;
    //任务个数
    private int item_count;
    //任务来源
    private String item_source;
    //总任务消耗金额
    private String item_all_cost;
    //宝贝连接地址
    private String item_link;
    //单个任务消耗金额
    private String item_one_cost;
    //0：已保存但未发布。1：审核通过已发布。2：已被接单，3：刷单已完成，4：卖家确认，5：审核通过已结算，6：违规被冻结
    private int item_state;
    //几天后评价
    private String comments_after;
    //几星评价
    private String comments_stars;
    //评价内容
    private String comments_content;
    //其他要求
    private String other_needs;
    //附件
    private String file_name;
    //发布时间
    private Date item_time;
    public void setItem_id(String item_id){  
        this.item_id=item_id;  
    }
    public String getItem_id(){
        return this.item_id;
    }
    public void setUser_id(String user_id){  
        this.user_id=user_id;  
    }
    public String getUser_id(){
        return this.user_id;
    }
    public void setItem_source(String item_source){  
        this.item_source=item_source;  
    }
    public String getItem_source(){
        return this.item_source;
    }
    public void setItem_all_cost(String item_all_cost){  
        this.item_all_cost=item_all_cost;  
    }
    public String getItem_all_cost(){
        return this.item_all_cost;
    }
    public void setItem_one_cost(String item_one_cost){  
        this.item_one_cost=item_one_cost;  
    }
    public String getItem_one_cost(){
        return this.item_one_cost;
    }
    public void setComments_content(String comments_content){  
        this.comments_content=comments_content;  
    }
    public String getComments_content(){
        return this.comments_content;
    }
    public void setOther_needs(String other_needs){  
        this.other_needs=other_needs;  
    }
    public String getOther_needs(){
        return this.other_needs;
    }
    public void setItem_time(Date item_time){  
        this.item_time=item_time;  
    }
    public Date getItem_time(){
        return this.item_time;
    }
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int itemCount) {
		item_count = itemCount;
	}
	public int getItem_state() {
		return item_state;
	}
	public void setItem_state(int itemState) {
		item_state = itemState;
	}
	public String getComments_after() {
		return comments_after;
	}
	public void setComments_after(String commentsAfter) {
		comments_after = commentsAfter;
	}
	public String getComments_stars() {
		return comments_stars;
	}
	public void setComments_stars(String commentsStars) {
		comments_stars = commentsStars;
	}
	public String getItem_link() {
		return item_link;
	}
	public void setItem_link(String itemLink) {
		item_link = itemLink;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
}