package  com.chanel.model;

import java.util.Date;
 
public class Chanel{  
	//频道ID
	private String chanelid;  
	//频道名称
	private String chanelname;  
	//频道描述
	private String description;  
	//创建时间
	private Date createtime;  
	public void setChanelid(String chanelid){  
        this.chanelid=chanelid;  
    }  
    public String getChanelid(){  
        return this.chanelid;  
    }  
	public void setChanelname(String chanelname){  
        this.chanelname=chanelname;  
    }  
    public String getChanelname(){  
        return this.chanelname;  
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