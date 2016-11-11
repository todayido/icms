package  com.manager.model;

public class MenuPermission{
    //权限id
    private String permission_id;
    //权限名称
    private String permission_name;
    //父节点ID
    private String parent_id;
    //是否有子节点
    private String has_next;
    //资源(动作URI)
    private String resource;
    //描述
    private String description;
    //排序优先级
    private String priority;
    public void setPermission_id(String permission_id){  
        this.permission_id=permission_id;  
    }
    public String getPermission_id(){
        return this.permission_id;
    }
    public void setPermission_name(String permission_name){  
        this.permission_name=permission_name;  
    }
    public String getPermission_name(){
        return this.permission_name;
    }
    public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public void setResource(String resource){  
        this.resource=resource;  
    }
    public String getResource(){
        return this.resource;
    }
    public void setDescription(String description){  
        this.description=description;  
    }
    public String getDescription(){
        return this.description;
    }
	public String getHas_next() {
		return has_next;
	}
	public void setHas_next(String has_next) {
		this.has_next = has_next;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
}