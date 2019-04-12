package com.netease.trading.dao;

import com.netease.trading.dto.CartItemDto;
import com.netease.trading.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
	/**
	 * 新增ShoppingCart
	 * 
	 * @param shoppingCart
	 * @return
	 */
	int insertShoppingCart(ShoppingCart shoppingCart);

	/**
	 * 更新ShoppingCart
	 * 
	 * @param shoppingCart
	 * @return
	 */
	int updateShoppingCart(ShoppingCart shoppingCart);

	Integer query(Integer uid);

	List<CartItemDto> getCart(Integer uid);

	int delCart(Integer uid);
}
