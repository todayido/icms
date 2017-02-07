package  com.news.model;

import java.util.Date;
 
public class News{  
	//新闻ID
	private String newsid;  
	//栏目ID
	private String blockid;  
	//新闻标题
	private String title;  
	//新闻短标题
	private String shorttitle;  
	//关键字
	private String keywords;  
	//作者
	private String author;  
	//编辑
	private String editor;  
	//内容来源
	private String source;  
	//新闻内容
	private String content;  
	//访问量
	private int count;  
	//评论量
	private int commentcount;  
	//创建时间
	private Date createtime;  
	//最后编辑时间
	private Date lastedittime;  
	//审核状态
	private String audit;  
	
	public void setNewsid(String newsid){  
        this.newsid=newsid;  
    }  
    public String getNewsid(){  
        return this.newsid;  
    }  
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
	public void setShorttitle(String shorttitle){  
        this.shorttitle=shorttitle;  
    }  
    public String getShorttitle(){  
        return this.shorttitle;  
    }  
	public void setKeywords(String keywords){  
        this.keywords=keywords;  
    }  
    public String getKeywords(){  
        return this.keywords;  
    }  
	public void setAuthor(String author){  
        this.author=author;  
    }  
    public String getAuthor(){  
        return this.author;  
    }  
	public void setEditor(String editor){  
        this.editor=editor;  
    }  
    public String getEditor(){  
        return this.editor;  
    }  
	public void setSource(String source){  
        this.source=source;  
    }  
    public String getSource(){  
        return this.source;  
    }  
	public void setContent(String content){  
        this.content=content;  
    }  
    public String getContent(){  
        return this.content;  
    }  
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getLastedittime() {
		return lastedittime;
	}
	public void setLastedittime(Date lastedittime) {
		this.lastedittime = lastedittime;
	}
	public void setAudit(String audit){  
        this.audit=audit;  
    }  
    public String getAudit(){  
        return this.audit;  
    }
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
}  