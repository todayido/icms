package com.item.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.item.dao.ItemDao;
import com.item.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	private final String GET_LIST = "getItemList";
	private final String GET_COUNT = "getItemCount";
	private final String GET_BY_ID = "getItemById";
	private final String MODIFY = "modifyItem";
	private final String SAVE = "saveItem";
	private final String DELETE_BY_ID = "deleteItemById";
	
	private final String GET_ITEM_BLOCK = "getItemBlock";
	private final String GET_ITEM_BLOCK_COUNT = "getItemBlockCount";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteItemById(String item_id) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, item_id);
	}

	public List<Item> getAllItems(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Item getItemById(String item_id) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, item_id);
	}

	public int getItemCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyItem(Item item) {
		return sqlSessionTemplate.update(MODIFY, item);
	}

	public int saveItem(Item item) {
		return sqlSessionTemplate.insert(SAVE, item);
	}

	public List getItemBlock(Map paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_ITEM_BLOCK, paramsMap, rowBounds);
	}

	public int getItemBlockCount(Map paramsMap) {
		try{
			return sqlSessionTemplate.selectOne(GET_ITEM_BLOCK_COUNT, paramsMap);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}

}

