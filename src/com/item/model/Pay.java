package  com.item.model;

public class Pay{
    //主键，序列生成
    private String pay_id;
    //用户ID
    private String user_id;
    //登录名
    private String user_name;
    //总金额（可取现）
    private double user_jine;
    //冻结的金额
    private double user_dongjie;
    //支付宝账号
    private String zhifubao;
    //支付宝姓名
    private String zhifubao_name;
    //银行卡号
    private String yinhangka;
    //银行卡姓名
    private String yinhangka_name;
    //操作违规次数
    private int weigui_cishu;
    //安全码
    private String anquanma;
    public void setPay_id(String pay_id){  
        this.pay_id=pay_id;  
    }
    public String getPay_id(){
        return this.pay_id;
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
    public void setUser_jine(double user_jine){  
        this.user_jine=user_jine;  
    }
    public double getUser_jine(){
        return this.user_jine;
    }
    public void setUser_dongjie(double user_dongjie){  
        this.user_dongjie=user_dongjie;  
    }
    public double getUser_dongjie(){
        return this.user_dongjie;
    }
    public void setZhifubao(String zhifubao){  
        this.zhifubao=zhifubao;  
    }
    public String getZhifubao(){
        return this.zhifubao;
    }
    public void setZhifubao_name(String zhifubao_name){  
        this.zhifubao_name=zhifubao_name;  
    }
    public String getZhifubao_name(){
        return this.zhifubao_name;
    }
    public void setYinhangka(String yinhangka){  
        this.yinhangka=yinhangka;  
    }
    public String getYinhangka(){
        return this.yinhangka;
    }
    public void setYinhangka_name(String yinhangka_name){  
        this.yinhangka_name=yinhangka_name;  
    }
    public String getYinhangka_name(){
        return this.yinhangka_name;
    }
    public void setWeigui_cishu(int weigui_cishu){  
        this.weigui_cishu=weigui_cishu;  
    }
    public int getWeigui_cishu(){
        return this.weigui_cishu;
    }
	public String getAnquanma() {
		return anquanma;
	}
	public void setAnquanma(String anquanma) {
		this.anquanma = anquanma;
	}
}