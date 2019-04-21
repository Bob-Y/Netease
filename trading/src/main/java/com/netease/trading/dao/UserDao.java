package com.netease.trading.dao;
import java.util.List;
import com.netease.trading.entity.User;
public interface UserDao {
	/**
	 * 查询所有user
	 * @return List<User>
	 */
	List<User> queryUser();

	/**
	 * 根据user_name查询对应user
	 * @param username
	 * @return User
	 */
	User findUser(String username);

	/**
	 * 根据user_id查询对应的user
	 * @param id
	 * @return User
	 */
	User findById(Integer id);
}
