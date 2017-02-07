package com.item.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.item.dao.PayDao;
import com.item.model.Pay;
import com.item.service.PayService;

@Service
public class PayServiceImpl implements PayService {

	@Resource
	PayDao payDao;
	
	public int deletePayById(String[] params) {
		int row = 0;
		for(String pay_id : params){
			row =+ payDao.deletePayById(pay_id);
		}
		return row;
	}

	public List<Pay> getAllPays(Map<?, ?> paramsMap) {
		return payDao.getAllPays(paramsMap);
	}

	public Pay getPayById(String pay_id) {
		return payDao.getPayById(pay_id);
	}

	public int getPayCount(Map<?, ?> paramsMap) {
		return payDao.getPayCount(paramsMap);
	}

	public int modifyPay(Pay pay) {
		return payDao.modifyPay(pay);
	}

	public int savePay(Pay pay) {
		return payDao.savePay(pay);
	}

	public Pay getPayByUserName(String user_name) {
		return payDao.getPayByUserName(user_name);
	}

	public int paySuccess(Map paramsMap) {
		return payDao.paySuccess(paramsMap);
		
	}

	public int modifyWeiguiCishu(Pay pay) {
		return payDao.modifyWeiguiCishu(pay);
	}

	public int kouChuJinE(Pay pay) {
		return payDao.kouChuJinE(pay);
	}

}

