/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hb.weibo.entity.Orders;
import com.hb.weibo.service.orders.OrdersService;

@RestController
@RequestMapping(value = "/api")
public class RegRestController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "orders", method = RequestMethod.GET)
	public List<Orders> getOrders() {
		return ordersService.getUntreatedOrders();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable("id") long id) {
		return "";
	}

	@RequestMapping(value = "getinput", method = RequestMethod.GET)
	public String showInput(long id, String type, String content) {
		Orders orders = ordersService.getOrders(id);
		String result = "0";
		if (type.equals("img")) {
			// 发送过图片地址
			String imgUrl = orders.getImgurl();
			if (StringUtils.isBlank(imgUrl)) {
				// 更新数据库currentflag和imgurl，使用jpql语句更新，关注下批量更新。
				ordersService.updateImg("img", content, id);
			}
			String imgString = orders.getImg();
			result = StringUtils.isBlank(imgString) ? "0" : imgString;
		} else if (type.equals("msg")) {
			// 短信验证码，更新currentflag
			ordersService.updateFlag("msg", id);
			String msgsString = orders.getMsg();
			result = StringUtils.isBlank(msgsString) ? "0" : msgsString;
		} else if (type.equals("msg2")) {
			ordersService.updateFlag("msg2", id);
			result = "1";
		} else if (type.equals("phone")) {
			// 请求手机号，更新currentflag
			ordersService.updateFlag("phone", id);
			String phoneString = orders.getTelephone();
			result = StringUtils.isBlank(phoneString) ? "0" : phoneString;
		} else {
			result = "error type";
		}
		return result;
	}

	@RequestMapping(value = "result", method = RequestMethod.GET)
	public String GetResult(long id, String account, String pwd, String nickname, String flag) {
		return "";
	}
}
