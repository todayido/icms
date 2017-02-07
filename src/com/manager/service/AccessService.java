package com.manager.service;

import com.manager.model.User;

public interface AccessService {

	/**
	 * @param user
	 * @param actionId
	 * @return
	 */
	public abstract boolean access(User user, String resourceId);

}
