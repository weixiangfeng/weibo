/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hb.weibo.entity.WeiboOwner;

public interface WeiboOwnerDao extends PagingAndSortingRepository<WeiboOwner, Long> {
	@Modifying
	@Query("update WeiboOwner weiboOwner set weiboOwner.flag=1,weiboOwner.checktime=?1  where weiboAccount.type=?2 and weiboAccount.username=?3")
	void updateNormalFlag(Date checktime, Long type, String username);

	@Modifying
	@Query("update WeiboOwner weiboOwner set weiboOwner.flag=?1,weiboOwner.checktime=?2,weiboOwner.reason=?3  where weiboAccount.type=?4 and weiboAccount.username=?5")
	void updateFlag(int flag, Date checktime, String reason, Long type, String username);

	@Modifying
	@Query("update WeiboOwner weiboOwner set weiboOwner.telephone=?1 where weiboAccount.type=?2 and weiboAccount.username=?3")
	void updateTelephone(String telephone, Long type, String username);

}
