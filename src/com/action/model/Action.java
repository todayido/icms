package  com.action.model;

import java.util.Date;
 
public class Action{  
	//动作ID
	private String actionid;  
	//动作名称
	private String actionname;  
	//动作路径
	private String actionurl;  
	//视图
	private String viewfile;  
	//模板
	private String contentfile;  
	//描述
	private String description;  
	//创建时间
	private Date createtime;  
	public void setActionid(String actionid){  
        this.actionid=actionid;  
    }  
    public String getActionid(){  
        return this.actionid;  
    }  
	public void setActionname(String actionname){  
        this.actionname=actionname;  
    }  
    public String getActionname(){  
        return this.actionname;  
    }  
	public void setActionurl(String actionurl){  
        this.actionurl=actionurl;  
    }  
    public String getActionurl(){  
        return this.actionurl;  
    }  
	public void setViewfile(String viewfile){  
        this.viewfile=viewfile;  
    }  
    public String getViewfile(){  
        return this.viewfile;  
    }  
	public void setContentfile(String contentfile){  
        this.contentfile=contentfile;  
    }  
    public String getContentfile(){  
        return this.contentfile;  
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