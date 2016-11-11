package com.item.dao;

import java.util.List;
import java.util.Map;

import com.item.model.Pay;

public interface PayDao {

	public abstract int savePay(Pay pay);

	public abstract int deletePayById(String pay_id);
	
	public abstract int modifyPay(Pay pay);

	public abstract Pay getPayById(String pay_id);
	
	public abstract int getPayCount(Map<?,?> paramsMap);

	public abstract List<Pay> getAllPays(Map<?,?> paramsMap);

	public abstract Pay getPayByUserName(String user_Name);

	public abstract int paySuccess(Map paramsMap);

	public abstract int modifyWeiguiCishu(Pay pay);

	public abstract int kouChuJinE(Pay pay);
}
