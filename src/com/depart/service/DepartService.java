package com.depart.service;

import java.util.List;
import java.util.Map;

import com.depart.model.Depart;

public interface DepartService {

	public abstract int saveDepart(Depart depart);

	public abstract int deleteDepartById(String[] params);

	public abstract int modifyDepart(Depart depart);

	public abstract Depart getDepartById(String depart_id);

	public abstract int getDepartCount(Map<?, ?> paramsMap);

	public abstract List<Depart> getAllDeparts(Map<?, ?> paramsMap);

	/**
	 * 获取子节点
	 */
	public abstract List getDepartByParentId(Map paramsMap);

	/**
	 * 获取组织机构的信息
	 */
	public abstract Map getDepartMapById(String depart_id);
}

