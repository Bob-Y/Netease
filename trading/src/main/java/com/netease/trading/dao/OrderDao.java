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

	int addOrder(@Param("item") CartItemDto item, @Param("uid") Long uid);

	Double queryPriceByProduct(Long pid);
}
