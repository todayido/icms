package com.item.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.item.dao.ItemDao;
import com.item.model.Item;
import com.item.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Resource
	ItemDao itemDao;
	
	public int deleteItemById(String[] params) {
		int row = 0;
		for(String item_id : params){
			row =+ itemDao.deleteItemById(item_id);
		}
		return row;
	}

	public List<Item> getAllItems(Map<?, ?> paramsMap) {
		return itemDao.getAllItems(paramsMap);
	}

	public Item getItemById(String item_id) {
		return itemDao.getItemById(item_id);
	}

	public int getItemCount(Map<?, ?> paramsMap) {
		return itemDao.getItemCount(paramsMap);
	}

	public int modifyItem(Item item) {
		return itemDao.modifyItem(item);
	}

	public int saveItem(Item item) {
		return itemDao.saveItem(item);
	}

	public List getItemBlock(Map paramsMap) {
		return itemDao.getItemBlock(paramsMap);
	}

	public int getItemBlockCount(Map paramsMap) {
		return itemDao.getItemBlockCount(paramsMap);
	}

}

