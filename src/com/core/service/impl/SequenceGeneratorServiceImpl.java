package com.core.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.service.SequenceGeneratorService;

/**
 * 主键生成器
 */
@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService{
	
	private static final String GTE_PRIMARY_KEY = "getPrimaryKey";
	private static final String MODIFY_PRIMARY_KEY = "modifyPrimaryKey";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 获取表的主键
	 * @param tableName 表名
	 * @return string 返回表的主键
	 */
	@Transactional
	public String getCurrentPrimaryKey(String tableName) {
		//主键加一
		sqlSessionTemplate.update(MODIFY_PRIMARY_KEY, tableName);
		//获取当前主键
		String primaryKey = sqlSessionTemplate.selectOne(GTE_PRIMARY_KEY, tableName);
		
		return primaryKey;
	}
}
