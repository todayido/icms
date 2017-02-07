package com.newsproperty.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newsproperty.dao.NewspropertyDao;
import com.newsproperty.model.Newsproperty;
import com.newsproperty.service.NewspropertyService;

@Service
public class NewspropertyServiceImpl implements NewspropertyService {

	@Resource
	NewspropertyDao newspropertyDao;
	
	public int deleteNewspropertyById(String[] params) {
		int row = 0;
		for(String blockid : params){
			row =+ newspropertyDao.deleteNewspropertyById(blockid);
		}
		return row;
	}

	public List<Newsproperty> getAllNewspropertys(Map<?, ?> paramsMap) {
		return newspropertyDao.getAllNewspropertys(paramsMap);
	}

	public Newsproperty getNewspropertyById(String blockid) {
		return newspropertyDao.getNewspropertyById(blockid);
	}

	public int getNewspropertyCount(Map<?, ?> paramsMap) {
		return newspropertyDao.getNewspropertyCount(paramsMap);
	}

	public int modifyNewsproperty(Newsproperty newsproperty) {
		return newspropertyDao.modifyNewsproperty(newsproperty);
	}

	public int saveNewsproperty(Newsproperty newsproperty) {
		return newspropertyDao.saveNewsproperty(newsproperty);
	}

}

