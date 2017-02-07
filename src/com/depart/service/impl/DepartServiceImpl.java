package com.depart.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.depart.dao.DepartDao;
import com.depart.model.Depart;
import com.depart.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService {

	@Resource
	DepartDao departDao;
	
	public int deleteDepartById(String[] params) {
		int row = 0;
		for(String depart_id : params){
			row =+ departDao.deleteDepartById(depart_id);
		}
		return row;
	}

	public List<Depart> getAllDeparts(Map<?, ?> paramsMap) {
		return departDao.getAllDeparts(paramsMap);
	}

	public Depart getDepartById(String depart_id) {
		return departDao.getDepartById(depart_id);
	}

	public int getDepartCount(Map<?, ?> paramsMap) {
		return departDao.getDepartCount(paramsMap);
	}

	public int modifyDepart(Depart depart) {
		return departDao.modifyDepart(depart);
	}

	public int saveDepart(Depart depart) {
		return departDao.saveDepart(depart);
	}

	public List getDepartByParentId(Map paramsMap) {
		return departDao.getDepartByParentId(paramsMap);
	}

	public Map getDepartMapById(String depart_id) {
		return departDao.getDepartMapById(depart_id);
	}

}

