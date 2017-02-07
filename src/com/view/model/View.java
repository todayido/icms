package  com.view.model;

import java.util.Date;
 
public class View{  
	//视图ID
	private String viewid;  
	//视图类型
	private String viewtype;
	//视图名称
	private String viewname;  
	//视图路径
	private String viewpath;  
	//视图描述
	private String description;  
	//创建时间
	private Date createtime;
	public void setViewid(String viewid){  
        this.viewid=viewid;  
    }  
    public String getViewtype() {
		return viewtype;
	}
	public void setViewtype(String viewtype) {
		this.viewtype = viewtype;
	}
	public String getViewid(){  
        return this.viewid;  
    }  
	public void setViewname(String viewname){  
        this.viewname=viewname;  
    }  
    public String getViewname(){  
        return this.viewname;  
    }  
	public void setViewpath(String viewpath){  
        this.viewpath=viewpath;  
    }  
    public String getViewpath(){  
        return this.viewpath;  
    }  
	public void setDescription(String description){  
        this.description=description;  
    }  
    public String getDescription(){  
        return this.description;  
    }
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}  
}  