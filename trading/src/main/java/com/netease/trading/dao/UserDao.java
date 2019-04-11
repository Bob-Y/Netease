package com.netease.trading.dao;
import java.util.List;
import com.netease.trading.entity.User;
public interface UserDao {
	/**
	 * list users
	 * @return userList
	 */
	List<User> queryUser();

	User findUser(String username);
}
