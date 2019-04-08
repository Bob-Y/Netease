package com.netease.trading.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.trading.BaseTest;
import com.netease.trading.entity.User;

public class UserServiceTest extends BaseTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	@Ignore
	public void testGetUserList() {
		List<User>userList = userService.getUserList();
		assertEquals("seller",userList.get(0).getUserName());
	}
}
