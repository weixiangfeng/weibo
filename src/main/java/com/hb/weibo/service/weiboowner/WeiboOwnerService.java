/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.service.weiboowner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hb.weibo.repository.WeiboOwnerDao;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class WeiboOwnerService {

	@Autowired
	private WeiboOwnerDao weiboOwnerDao;

	public void updateFlag(int flag, String reason, int type, String username) {
		Date checktime = new Date();
		weiboOwnerDao.updateFlag(flag, checktime, reason, type, username);
	}

	public void updateTelephone(String telephone, int type, String username) {

		weiboOwnerDao.updateTelephone(telephone, type, username);
	}

}
