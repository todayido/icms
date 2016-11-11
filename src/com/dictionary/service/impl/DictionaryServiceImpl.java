package com.dictionary.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dictionary.dao.DictionaryDao;
import com.dictionary.model.Dictionary;
import com.dictionary.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	DictionaryDao dictionaryDao;
	
	public int deleteDictionaryById(String[] params) {
		int row = 0;
		for(String dic_id : params){
			row =+ dictionaryDao.deleteDictionaryById(dic_id);
		}
		return row;
	}

	public List<Dictionary> getAllDictionarys(Map<?, ?> paramsMap) {
		return dictionaryDao.getAllDictionarys(paramsMap);
	}

	public Dictionary getDictionaryById(String dic_id) {
		return dictionaryDao.getDictionaryById(dic_id);
	}

	public int getDictionaryCount(Map<?, ?> paramsMap) {
		return dictionaryDao.getDictionaryCount(paramsMap);
	}

	public int modifyDictionary(Dictionary dictionary) {
		return dictionaryDao.modifyDictionary(dictionary);
	}

	public int saveDictionary(Dictionary dictionary) {
		return dictionaryDao.saveDictionary(dictionary);
	}

}

