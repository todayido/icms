package com.chanel.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chanel.dao.ChanelDao;
import com.chanel.model.Chanel;
import com.chanel.service.ChanelService;

@Service
public class ChanelServiceImpl implements ChanelService {

	@Resource
	ChanelDao chanelDao;
	
	public int deleteChanelById(String[] params) {
		int row = 0;
		for(String chanelid : params){
			row =+ chanelDao.deleteChanelById(chanelid);
		}
		return row;
	}

	public List<Chanel> getAllChanels(Map<?, ?> paramsMap) {
		return chanelDao.getAllChanels(paramsMap);
	}

	public Chanel getChanelById(String chanelid) {
		return chanelDao.getChanelById(chanelid);
	}

	public int getChanelCount(Map<?, ?> paramsMap) {
		return chanelDao.getChanelCount(paramsMap);
	}

	public int modifyChanel(Chanel chanel) {
		return chanelDao.modifyChanel(chanel);
	}

	public int saveChanel(Chanel chanel) {
		return chanelDao.saveChanel(chanel);
	}

}

