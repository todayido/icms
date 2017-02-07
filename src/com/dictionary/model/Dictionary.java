package  com.dictionary.model;

public class Dictionary{
    //字典id
    private String dic_id;
    //字典名称
    private String dic_name;
    //键
    private String dic_key;
    //值
    private String dic_value;
    //描述
    private String description;
    public void setDic_id(String dic_id){  
        this.dic_id=dic_id;  
    }
    public String getDic_id(){
        return this.dic_id;
    }
    public void setDic_name(String dic_name){  
        this.dic_name=dic_name;  
    }
    public String getDic_name(){
        return this.dic_name;
    }
    public void setDic_key(String dic_key){  
        this.dic_key=dic_key;  
    }
    public String getDic_key(){
        return this.dic_key;
    }
    public void setDic_value(String dic_value){  
        this.dic_value=dic_value;  
    }
    public String getDic_value(){
        return this.dic_value;
    }
    public void setDescription(String description){  
        this.description=description;  
    }
    public String getDescription(){
        return this.description;
    }
}