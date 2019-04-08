package com.netease.trading.dao;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.trading.BaseTest;
import com.netease.trading.entity.User;

public class UserDaoTest extends BaseTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	@Ignore
	public void testQueryUser(){
		List<User> userList = userDao.queryUser();
		assertEquals(2, userList.size());
	}
	
}

