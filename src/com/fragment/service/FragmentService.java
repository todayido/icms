package com.fragment.service;

import java.util.List;
import java.util.Map;

import com.fragment.model.Fragment;

public interface FragmentService {

	public abstract int saveFragment(Fragment fragment);

	public abstract int deleteFragmentById(String[] params);

	public abstract int modifyFragment(Fragment fragment);

	public abstract Fragment getFragmentById(String fragmentid);

	public abstract int getFragmentCount(Map<?, ?> paramsMap);

	public abstract List<Fragment> getAllFragments(Map<?, ?> paramsMap);
}

