package com.item.service;

import java.util.List;
import java.util.Map;

import com.item.model.Paylog;

public interface PaylogService {

	public abstract int savePaylog(Paylog payLog);

	public abstract int deletePaylogById(String[] params);

	public abstract int modifyPaylog(Paylog payLog);

	public abstract Paylog getPaylogById(String user_pay_log_id);

	public abstract int getPaylogCount(Map<?, ?> paramsMap);

	public abstract List<Paylog> getAllPaylogs(Map<?, ?> paramsMap);
}

