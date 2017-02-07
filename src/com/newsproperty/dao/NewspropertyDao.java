package com.newsproperty.dao;

import java.util.List;
import java.util.Map;

import com.newsproperty.model.Newsproperty;

public interface NewspropertyDao {

	public abstract int saveNewsproperty(Newsproperty newsproperty);

	public abstract int deleteNewspropertyById(String blockid);
	
	public abstract int modifyNewsproperty(Newsproperty newsproperty);

	public abstract Newsproperty getNewspropertyById(String blockid);
	
	public abstract int getNewspropertyCount(Map<?,?> paramsMap);

	public abstract List<Newsproperty> getAllNewspropertys(Map<?,?> paramsMap);
}
