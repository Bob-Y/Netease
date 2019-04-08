package com.netease.trading.dao;

import com.netease.trading.entity.ShoppingCart;

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
}
