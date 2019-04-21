package com.netease.trading.dao;

import com.netease.trading.entity.CartItem;

public interface CartItemDao {
	/**
	 * 新增cartItem
	 * @param cartItem
	 * @return int
	 */
	int insertCartItem(CartItem cartItem);

	/**
	 * 更新cartItem
	 * @param cartItem
	 * @return int
	 */
	int updateCartItem(CartItem cartItem);

	/**
	 * 根据cartItem_id删除cartItem
	 * @param cartItemId
	 * @return int
	 */
	int deleteCartItem(long cartItemId);

	/**
	 * 根据cart_id删除cartItem
	 * @param id
	 * @return int
	 */
	int delCart(Integer id);

	/**
	 * 根据cartItem_product_id删除cartItem
	 * @param pid
	 * @return int
	 */
	int delCartByProductId(Integer pid);

	/**
	 * 根据cartItem_product_id查询cartItem
	 * @param pid
	 * @return CartItem
	 */
	CartItem query(Integer pid);
}
