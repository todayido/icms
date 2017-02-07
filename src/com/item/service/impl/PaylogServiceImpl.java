package com.item.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.item.dao.PaylogDao;
import com.item.model.Paylog;
import com.item.service.PaylogService;

@Service
public class PaylogServiceImpl implements PaylogService {

	@Resource
	PaylogDao payLogDao;
	
	public int deletePaylogById(String[] params) {
		int row = 0;
		for(String user_pay_log_id : params){
			row =+ payLogDao.deletePaylogById(user_pay_log_id);
		}
		return row;
	}

	public List<Paylog> getAllPaylogs(Map<?, ?> paramsMap) {
		return payLogDao.getAllPaylogs(paramsMap);
	}

	public Paylog getPaylogById(String user_pay_log_id) {
		return payLogDao.getPaylogById(user_pay_log_id);
	}

	public int getPaylogCount(Map<?, ?> paramsMap) {
		return payLogDao.getPaylogCount(paramsMap);
	}

	public int modifyPaylog(Paylog payLog) {
		return payLogDao.modifyPaylog(payLog);
	}

	public int savePaylog(Paylog payLog) {
		return payLogDao.savePaylog(payLog);
	}

}

