package com.netease.trading.service.impl;

import java.util.List;

import com.netease.trading.util.MD5Util;
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

	@Override
	public int validate(String username, String pass) {
		User user = userDao.findUser(username);
		if (null == user) {
			return -1;
		}
		String oPass = MD5Util.getMD5(user.getUserPassword());
		if (oPass.equals(pass)) {
			return user.getUserType();
		}
		return -1;
	}

}
