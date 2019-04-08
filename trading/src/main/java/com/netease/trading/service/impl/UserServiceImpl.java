package com.netease.trading.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.trading.dao.UserDao;
import com.netease.trading.entity.User;
import com.netease.trading.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUserList() {
		return userDao.queryUser();
	}

}
