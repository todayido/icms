package  com.template.model;

import java.util.Date;
 
public class Template{  
	//模板标识
	private String templateid;  
	//模板名称
	private String templatename;  
	//描述
	private String description;
	//是否是默认模板
	private String isdefault;
	//创建时间
	private Date createtime;  
	public void setTemplateid(String templateid){  
        this.templateid=templateid;  
    }  
    public String getTemplateid(){  
        return this.templateid;  
    }  
	public void setTemplatename(String templatename){  
        this.templatename=templatename;  
    }  
    public String getTemplatename(){  
        return this.templatename;  
    }  
	public void setDescription(String description){  
        this.description=description;  
    }  
    public String getDescription(){  
        return this.description;  
    }
	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}  
    
}  