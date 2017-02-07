package com.dictionary.service;

import java.util.List;
import java.util.Map;

import com.dictionary.model.Dictionary;

public interface DictionaryService {

	public abstract int saveDictionary(Dictionary dictionary);

	public abstract int deleteDictionaryById(String[] params);

	public abstract int modifyDictionary(Dictionary dictionary);

	public abstract Dictionary getDictionaryById(String dic_id);

	public abstract int getDictionaryCount(Map<?, ?> paramsMap);

	public abstract List<Dictionary> getAllDictionarys(Map<?, ?> paramsMap);
	
}

