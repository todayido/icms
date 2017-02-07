package com.depart.dao;

import java.util.List;
import java.util.Map;

import com.depart.model.Depart;

public interface DepartDao {

	public abstract int saveDepart(Depart depart);

	public abstract int deleteDepartById(String depart_id);
	
	public abstract int modifyDepart(Depart depart);

	public abstract Depart getDepartById(String depart_id);
	
	public abstract int getDepartCount(Map<?,?> paramsMap);

	public abstract List<Depart> getAllDeparts(Map<?,?> paramsMap);

	public abstract List getDepartByParentId(Map paramsMap);

	public abstract Map getDepartMapById(String depart_id);
}
