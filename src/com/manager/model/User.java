package  com.manager.model;

import java.util.Date;
import java.util.List;

public class User{
	//
	private String user_id;
	//用户名--登陆名
	private String user_name;
	//密码
	private String password;
	//部门
	private String depart_id;
	//别名
	private String user_alias;
	//职务
	private String duty_id;
	//邮箱
	private String email;
	//安全问题
	private String question;
	//安全问题答案
	private String answer;
	//qq号
	private String qq_number;
	//手机号
	private String phone;
	//排序
	private String priority;
	//注册时间
	private Date reg_time;
	//错误登录次数（5次将锁定账号）
	private int login_error_times;
	//最后登录时间
	private Date last_login_time;
	//最后登录IP地址
	private String last_login_ip;
	//登录系统次数
	private int login_times;
	//状态 0-有效 1-失效
	private String status;
	//角色列表
	private List roleList;
	public void setUser_id(String user_id){  
        this.user_id=user_id;  
    }
    public String getUser_id(){
        return this.user_id;
    }
	public void setUser_name(String user_name){  
        this.user_name=user_name;  
    }
    public String getUser_name(){
        return this.user_name;
    }
	public void setPassword(String password){  
        this.password=password;  
    }
    public String getPassword(){
        return this.password;
    }
	public void setDepart_id(String depart_id){  
        this.depart_id=depart_id;  
    }
    public String getDepart_id(){
        return this.depart_id;
    }
	public void setUser_alias(String user_alias){  
        this.user_alias=user_alias;  
    }
    public String getUser_alias(){
        return this.user_alias;
    }
	public String getDuty_id() {
		return duty_id;
	}
	public void setDuty_id(String dutyId) {
		duty_id = dutyId;
	}
	public void setEmail(String email){  
        this.email=email;  
    }
    public String getEmail(){
        return this.email;
    }
	public void setQuestion(String question){  
        this.question=question;  
    }
    public String getQuestion(){
        return this.question;
    }
	public void setAnswer(String answer){  
        this.answer=answer;  
    }
    public String getAnswer(){
        return this.answer;
    }
	public void setQq_number(String qq_number){  
        this.qq_number=qq_number;  
    }
    public String getQq_number(){
        return this.qq_number;
    }
	public void setPhone(String phone){  
        this.phone=phone;  
    }
    public String getPhone(){
        return this.phone;
    }
	public void setPriority(String priority){  
        this.priority=priority;  
    }
    public String getPriority(){
        return this.priority;
    }	
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public int getLogin_error_times() {
		return login_error_times;
	}
	public void setLogin_error_times(int login_error_times) {
		this.login_error_times = login_error_times;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public void setLast_login_ip(String last_login_ip){  
        this.last_login_ip=last_login_ip;  
    }
    public String getLast_login_ip(){
        return this.last_login_ip;
    }
	public void setLogin_times(int login_times){  
        this.login_times=login_times;  
    }
    public int getLogin_times(){
        return this.login_times;
    }
	public void setStatus(String status){  
        this.status=status;  
    }
    public String getStatus(){
        return this.status;
    }
	public List getRoleList() {
		return roleList;
	}
	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}
    
}