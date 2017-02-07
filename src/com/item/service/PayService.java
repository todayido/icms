package com.item.service;

import java.util.List;
import java.util.Map;

import com.item.model.Pay;

public interface PayService {

	public abstract int savePay(Pay pay);

	public abstract int deletePayById(String[] params);

	public abstract int modifyPay(Pay pay);

	public abstract Pay getPayById(String pay_id);

	public abstract int getPayCount(Map<?, ?> paramsMap);

	public abstract List<Pay> getAllPays(Map<?, ?> paramsMap);

	public abstract Pay getPayByUserName(String user_name);

	/**
	 * 充值成功，用户平台币增加
	 * @param paramsMap
	 */
	public abstract int paySuccess(Map paramsMap);

	public abstract int modifyWeiguiCishu(Pay pay);

	public abstract int kouChuJinE(Pay pay);
}

