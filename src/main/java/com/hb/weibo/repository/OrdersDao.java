/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hb.weibo.entity.Orders;

public interface OrdersDao extends PagingAndSortingRepository<Orders, Long> {

	List<Orders> findByCurrentflag(String currentflag);

	List<Orders> findBySid(String sid);

	@Modifying
	@Query("update Orders orders set orders.currentflag=?1 where orders.id in ?2")
	void updateFlags(String currentflag, List<Long> ids);

	@Modifying
	@Query("update Orders orders set orders.currentflag=?1 where orders.id=?2")
	void updateFlag(String currentflag, Long id);

	@Modifying
	@Query("update Orders orders set orders.currentflag=?1,orders.imgurl=?2 where orders.id=?3")
	void updateImg(String flag, String imgurl, Long id);

}
