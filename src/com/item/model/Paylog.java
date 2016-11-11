package  com.item.model;

public class Paylog{
    //主键
    private String user_pay_log_id;
    //用户ID
    private String user_id;
    //用户名
    private String user_name;
    //充值账号
    private String pay_zhanghao;
    //充值金额
    private String money;
    //1、支付宝；2、银行卡；3、微信
    private String type;
    //备注
    private String beizhu;
    //申请时间
    private String apply_time;
    //状态：0、审核中；1、审核通过；2、审核不通过
    private String state;
    //审核不通过原因
    private String reason;
    //审核时间
    private String check_time;
    public void setUser_pay_log_id(String user_pay_log_id){  
        this.user_pay_log_id=user_pay_log_id;  
    }
    public String getUser_pay_log_id(){
        return this.user_pay_log_id;
    }
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
    public void setMoney(String money){  
        this.money=money;  
    }
    public String getMoney(){
        return this.money;
    }
    public void setType(String type){  
        this.type=type;  
    }
    public String getType(){
        return this.type;
    }
    public void setBeizhu(String beizhu){  
        this.beizhu=beizhu;  
    }
    public String getBeizhu(){
        return this.beizhu;
    }
    public void setApply_time(String apply_time){  
        this.apply_time=apply_time;  
    }
    public String getApply_time(){
        return this.apply_time;
    }
    public void setState(String state){  
        this.state=state;  
    }
    public String getState(){
        return this.state;
    }
    public void setReason(String reason){  
        this.reason=reason;  
    }
    public String getReason(){
        return this.reason;
    }
    public void setCheck_time(String check_time){  
        this.check_time=check_time;  
    }
    public String getCheck_time(){
        return this.check_time;
    }
	public String getPay_zhanghao() {
		return pay_zhanghao;
	}
	public void setPay_zhanghao(String payZhanghao) {
		pay_zhanghao = payZhanghao;
	}
}