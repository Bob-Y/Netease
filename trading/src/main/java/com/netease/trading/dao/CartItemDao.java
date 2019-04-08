package com.netease.trading.dao;

import com.netease.trading.entity.CartItem;

public interface CartItemDao {
	/**
	 * 新增cartItem
	 * 
	 * @param cartItem
	 * @return
	 */
	int insertCartItem(CartItem cartItem);

	/**
	 * 更新cartItem
	 * 
	 * @param cartItem
	 * @return
	 */
	int updateCartItem(CartItem cartItem);
	/**
	 * 删除cartItem
	 * @param cartItemId
	 * @return
	 */
	int deleteCartItem(long cartItemId);
}
