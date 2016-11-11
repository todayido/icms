package  com.depart.model;

import java.util.Date;

public class Depart{
    //主键
    private String depart_id;
    //上级部门
    private String parent_id;
    //是否有子节点
    private String has_next;
    //部门名称
    private String name;
    //部门编号
    private String number;
    //优先级排序字段
    private String priority;
    //前台是否显示
    private String is_show;
    //创建时间
    private Date create_time;
    public void setDepart_id(String depart_id){  
        this.depart_id=depart_id;
    }
    public String getDepart_id(){
        return this.depart_id;
    }
    public void setParent_id(String parent_id){  
        this.parent_id=parent_id;  
    }
    public String getParent_id(){
        return this.parent_id;
    }
    public void setName(String name){  
        this.name=name;  
    }
    public String getName(){
        return this.name;
    }
    public void setNumber(String number){  
        this.number=number;  
    }
    public String getNumber(){
        return this.number;
    }
    public void setPriority(String priority){  
        this.priority=priority;  
    }
    public String getPriority(){
        return this.priority;
    }
    public void setIs_show(String is_show){  
        this.is_show=is_show;  
    }
    public String getIs_show(){
        return this.is_show;
    }
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getHas_next() {
		return has_next;
	}
	public void setHas_next(String has_next) {
		this.has_next = has_next;
	}
}