package com.fragment.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fragment.dao.FragmentDao;
import com.fragment.model.Fragment;

@Repository
public class FragmentDaoImpl implements FragmentDao {

	private final String GET_LIST = "getFragmentList";
	private final String GET_COUNT = "getFragmentCount";
	private final String GET_BY_ID = "getFragmentById";
	private final String MODIFY = "modifyFragment";
	private final String SAVE = "saveFragment";
	private final String DELETE_BY_ID = "deleteFragmentById";
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteFragmentById(String fragmentid) {
		return sqlSessionTemplate.delete(DELETE_BY_ID, fragmentid);
	}

	public List<Fragment> getAllFragments(Map<?, ?> paramsMap) {
		int offset = (Integer)paramsMap.get("begin");
		int limit = (Integer)paramsMap.get("end");
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(GET_LIST, paramsMap, rowBounds);
	}

	public Fragment getFragmentById(String fragmentid) {
		return sqlSessionTemplate.selectOne(GET_BY_ID, fragmentid);
	}

	public int getFragmentCount(Map<?, ?> paramsMap) {
		return sqlSessionTemplate.selectOne(GET_COUNT, paramsMap);
	}

	public int modifyFragment(Fragment fragment) {
		return sqlSessionTemplate.update(MODIFY, fragment);
	}

	public int saveFragment(Fragment fragment) {
		return sqlSessionTemplate.insert(SAVE, fragment);
	}

}

