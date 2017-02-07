package com.dictionary.dao;

import java.util.List;
import java.util.Map;

import com.dictionary.model.Dictionary;

public interface DictionaryDao {

	public abstract int saveDictionary(Dictionary dictionary);

	public abstract int deleteDictionaryById(String dic_id);
	
	public abstract int modifyDictionary(Dictionary dictionary);

	public abstract Dictionary getDictionaryById(String dic_id);
	
	public abstract int getDictionaryCount(Map<?,?> paramsMap);

	public abstract List<Dictionary> getAllDictionarys(Map<?,?> paramsMap);

	public abstract List<Dictionary> getDictionaryListByName(String dic_name);
}
