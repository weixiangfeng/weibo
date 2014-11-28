/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.service.appuser;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hb.weibo.repository.AppUserDao;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class AppUserService {

	@Autowired
	private AppUserDao appUserDao;

	public void updateLastViewTime(String userid) {
		Date lasttime = new Date();
		appUserDao.updateLastViweTime(lasttime, userid);
	}

}
