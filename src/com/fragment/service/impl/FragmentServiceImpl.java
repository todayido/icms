package com.fragment.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fragment.dao.FragmentDao;
import com.fragment.model.Fragment;
import com.fragment.service.FragmentService;

@Service
public class FragmentServiceImpl implements FragmentService {

	@Resource
	FragmentDao fragmentDao;
	
	public int deleteFragmentById(String[] params) {
		int row = 0;
		for(String fragmentid : params){
			row =+ fragmentDao.deleteFragmentById(fragmentid);
		}
		return row;
	}

	public List<Fragment> getAllFragments(Map<?, ?> paramsMap) {
		return fragmentDao.getAllFragments(paramsMap);
	}

	public Fragment getFragmentById(String fragmentid) {
		return fragmentDao.getFragmentById(fragmentid);
	}

	public int getFragmentCount(Map<?, ?> paramsMap) {
		return fragmentDao.getFragmentCount(paramsMap);
	}

	public int modifyFragment(Fragment fragment) {
		return fragmentDao.modifyFragment(fragment);
	}

	public int saveFragment(Fragment fragment) {
		return fragmentDao.saveFragment(fragment);
	}

}

