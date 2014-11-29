/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.hb.weibo.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hb.weibo.service.appuser.AppUserService;
import com.hb.weibo.service.weiboaccount.WeiboAccountService;
import com.hb.weibo.service.weiboowner.WeiboOwnerService;

@RestController
@RequestMapping(value = "/api")
public class AccountRestController {

	@Autowired
	private AppUserService appUserService;
	@Autowired
	private WeiboAccountService weiboAccountService;
	@Autowired
	private WeiboOwnerService weiboOwnerService;

	@RequestMapping(value = "appuser/visit", method = RequestMethod.GET)
	public String GetResult(String userid) {
		appUserService.updateLastViewTime(userid);
		return "1";
	}

	@RequestMapping(value = "account/maintenance", method = RequestMethod.GET)
	public String AccountManage(String content) {
		// 解析content类型:nickname、loginerror、mobileyz
		String[] resultArray = StringUtils.split(content, "|");
		if (resultArray.length == 0 || resultArray.length != 7) {
			return "0";
		}
		int type = Integer.parseInt(resultArray[4]);
		String username = resultArray[5];
		String typeString = resultArray[0];
		if (typeString.equals("nickname")) {
			String nick = resultArray[6];
			weiboAccountService.updateNick(nick, type, username);
			weiboOwnerService.updateFlag(1, "", type, username);
		} else if (typeString.equals("loginerror")) {
			String reason = resultArray[6];
			weiboOwnerService.updateFlag(1, reason, type, username);
		} else if (typeString.equals("mobileyz")) {
			String telephone = resultArray[6];
			weiboOwnerService.updateTelephone(telephone, type, username);
		} else {
			return "0";
		}
		return "1";
	}
}
