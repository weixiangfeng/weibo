/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hb.weibo.entity.WeiboAccount;

public interface WeiboAccountDao extends PagingAndSortingRepository<WeiboAccount, Long> {
	@Modifying
	@Query("update WeiboAccount weiboAccount set weiboAccount.nick=?1 where weiboAccount.type=?2 and weiboAccount.username=?3")
	void updateNick(String nick, Long type, String username);
}
