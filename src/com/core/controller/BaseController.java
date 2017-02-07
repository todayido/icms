package com.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class BaseController {
	
	/**
	 * 
	 * @return logger
	 */
	public Logger logger(){
	    return Logger.getLogger(this.getClass()); 
	}

	/**
	 * 
	 * @return request
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 
	 * @return session
	 */
	public HttpSession getSession() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);
	}

}
