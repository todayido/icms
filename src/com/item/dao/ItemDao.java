package com.item.dao;

import java.util.List;
import java.util.Map;

import com.item.model.Item;

public interface ItemDao {

	public abstract int saveItem(Item item);

	public abstract int deleteItemById(String item_id);
	
	public abstract int modifyItem(Item item);

	public abstract Item getItemById(String item_id);
	
	public abstract int getItemCount(Map<?,?> paramsMap);

	public abstract List<Item> getAllItems(Map<?,?> paramsMap);

	public abstract List getItemBlock(Map paramsMap);

	public abstract int getItemBlockCount(Map paramsMap);
}
