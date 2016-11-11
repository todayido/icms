package  com.manager.model;

public class Role{
    //角色id
    private String role_id;
    //角色名
    private String role_name;
    //角色描述
    private String description;
    //优先级排序字段
    private String priority;
    //是否是超级管理员
    private String issuper;
    public void setRole_id(String role_id){  
        this.role_id=role_id;  
    }
    public String getRole_id(){
        return this.role_id;
    }
    public void setRole_name(String role_name){  
        this.role_name=role_name;  
    }
    public String getRole_name(){
        return this.role_name;
    }
    public void setDescription(String description){  
        this.description=description;  
    }
    public String getDescription(){
        return this.description;
    }
    public void setPriority(String priority){  
        this.priority=priority;  
    }
    public String getPriority(){
        return this.priority;
    }
    public void setIssuper(String issuper){  
        this.issuper=issuper;  
    }
    public String getIssuper(){
        return this.issuper;
    }
}