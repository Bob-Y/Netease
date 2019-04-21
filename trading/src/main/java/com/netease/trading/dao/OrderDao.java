package com.netease.trading.dao;

import java.util.List;

import com.netease.trading.dto.CartItemDto;
import com.netease.trading.entity.Order;
import com.netease.trading.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderDao {
	/**
	 * 新增order
	 * @param order
	 * @return int
	 */
	int insertOrder(Order order);

	/**
	 * 更新order
	 * @param order
	 * @return int
	 */
	int updateOrder(Order order);
	
	/**
	 * 根据order_user_id查询用户order信息
	 * @return orderList
	 */
	List<Order> queryUserOrder(Integer userId);

	/**
	 * 增加新的用户order
	 * @param item
	 * @param uid
	 * @return int
	 */
	int addOrder(@Param("item") CartItemDto item, @Param("uid") Long uid);

	/**
	 * 根据order_product查询order_price
	 * @param pid
	 * @return Double
	 */
	Double queryPriceByProduct(Long pid);
}
