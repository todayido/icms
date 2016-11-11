package  com.fragment.model;

import java.util.Date;
 
public class Fragment{  
	//主键
	private String blockid;  
	//单页名称
	private String fragmentname;  
	//单页描述
	private String description;
	//视图路径
	private String path;
	//单页创建时间
	private Date createtime;  
	public String getBlockid() {
		return blockid;
	}
	public void setBlockid(String blockid) {
		this.blockid = blockid;
	}
	public void setFragmentname(String fragmentname){  
        this.fragmentname=fragmentname;  
    }  
    public String getFragmentname(){  
        return this.fragmentname;  
    }  
	public void setDescription(String description){  
        this.description=description;  
    }  
    public String getDescription(){  
        return this.description;  
    }
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}  
    
}  