package com.core.controller;

import javax.servlet.http.HttpServletRequest;

import com.core.model.DataAndView;

public interface IController {
	public DataAndView execute(HttpServletRequest request) throws Exception;
}
