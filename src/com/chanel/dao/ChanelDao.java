package com.chanel.dao;

import java.util.List;
import java.util.Map;

import com.chanel.model.Chanel;

public interface ChanelDao {

	public abstract int saveChanel(Chanel chanel);

	public abstract int deleteChanelById(String chanelid);
	
	public abstract int modifyChanel(Chanel chanel);

	public abstract Chanel getChanelById(String chanelid);
	
	public abstract int getChanelCount(Map<?,?> paramsMap);

	public abstract List<Chanel> getAllChanels(Map<?,?> paramsMap);
}
