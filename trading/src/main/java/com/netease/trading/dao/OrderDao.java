package com.netease.trading.dao;

import java.util.List;

import com.netease.trading.dto.CartItemDto;
import com.netease.trading.entity.Order;
import com.netease.trading.entity.User;

public interface OrderDao {
	/**
	 * 新增order
	 * 
	 * @param order
	 * @return
	 */
	int insertOrder(Order order);

	/**
	 * 更新order
	 * 
	 * @param order
	 * @return
	 */
	int updateOrder(Order order);
	
	/**
	 * list order
	 * @return orderList
	 */
	List<Order> queryUserOrder(Integer userId);

	int addOrder(CartItemDto item, Long uid);
}
