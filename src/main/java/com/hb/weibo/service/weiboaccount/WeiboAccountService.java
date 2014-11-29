/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.service.weiboaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hb.weibo.repository.WeiboAccountDao;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class WeiboAccountService {

	@Autowired
	private WeiboAccountDao weiboAccountDao;

	public void updateNick(String nick, int type, String username) {
		weiboAccountDao.updateNick(nick, type, username);
	}
}
