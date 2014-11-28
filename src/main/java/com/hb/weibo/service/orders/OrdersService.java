/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.service.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hb.weibo.entity.Orders;
import com.hb.weibo.repository.OrdersDao;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	public Orders getOrders(long id) {
		return ordersDao.findOne(id);
	}

	public List<Orders> getUntreatedOrders() {
		return ordersDao.findByCurrentflag("0");
	}

	public void updateFlag(String currentflag, Long id) {
		ordersDao.updateFlag(currentflag, id);
	}

	public void updateImg(String flag, String imgurl, Long id) {
		ordersDao.updateImg(flag, imgurl, id);
	}

}
