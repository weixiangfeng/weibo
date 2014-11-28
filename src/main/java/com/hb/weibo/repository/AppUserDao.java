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

import com.hb.weibo.entity.AppUser;

public interface AppUserDao extends PagingAndSortingRepository<AppUser, Long> {

	@Modifying
	@Query("update AppUser appUser set appUser.lastviewtime=?1 where appUser.userid=?2")
	void updateLastViweTime(Date lasttime, String userid);
}
