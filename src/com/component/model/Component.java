package  com.component.model;

public class Component{  
	//组件ID
	private String componentid;  
	//组件类型
	private String componenttype;  
	//组件名称
	private String componentname;  
	//组件描述
	private String description;  
	//是否为单实例
	private String issingleton;
	//组件配置文件路径
    private String confpath;
    //排序字段
	private String priority; 
	public void setComponentid(String componentid){  
        this.componentid=componentid;  
    }  
    public String getComponentid(){  
        return this.componentid;  
    }  
	public void setComponenttype(String componenttype){  
        this.componenttype=componenttype;  
    }  
    public String getComponenttype(){  
        return this.componenttype;  
    }  
	public void setComponentname(String componentname){  
        this.componentname=componentname;  
    }  
    public String getComponentname(){  
        return this.componentname;  
    }  
	public void setDescription(String description){  
        this.description=description;  
    }  
    public String getDescription(){  
        return this.description;  
    }
	public String getIssingleton() {
		return issingleton;
	}
	public void setIssingleton(String issingleton) {
		this.issingleton = issingleton;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getConfpath() {
		return confpath;
	}
	public void setConfpath(String confpath) {
		this.confpath = confpath;
	}  
    
}  