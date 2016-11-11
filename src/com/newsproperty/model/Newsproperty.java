package  com.newsproperty.model;

import java.util.Date;
 
public class Newsproperty{  
	//栏目ID
	private String blockid;  
	//栏目标题
	private String title;  
	//首页显示条数
	private int blockpage;  
	//列表显示条数
	private int listpage;  
	//是否允许评论
	private String iscomments;  
	//栏目描述
	private String description;  
	//创建时间
	private Date createtime;  
	public void setBlockid(String blockid){  
        this.blockid=blockid;  
    }  
    public String getBlockid(){  
        return this.blockid;  
    }  
	public void setTitle(String title){  
        this.title=title;  
    }  
    public String getTitle(){  
        return this.title;  
    }  
	public int getBlockpage() {
		return blockpage;
	}
	public void setBlockpage(int blockpage) {
		this.blockpage = blockpage;
	}
	public int getListpage() {
		return listpage;
	}
	public void setListpage(int listpage) {
		this.listpage = listpage;
	}
	public void setIscomments(String iscomments){  
        this.iscomments=iscomments;  
    }  
    public String getIscomments(){  
        return this.iscomments;  
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