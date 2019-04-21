package com.netease.trading.dao;

import com.netease.trading.dto.CartItemDto;
import com.netease.trading.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
	/**
	 * 新增ShoppingCart
	 * @param shoppingCart
	 * @return int
	 */
	int insertShoppingCart(ShoppingCart shoppingCart);

	/**
	 * 更新ShoppingCart
	 * @param shoppingCart
	 * @return int
	 */
	int updateShoppingCart(ShoppingCart shoppingCart);

	/**
	 * 根据shoppingCart_user_id查询对应的shoppingCart_id
	 * @param uid
	 * @return shoppingCart_id
	 */
	Integer query(Integer uid);

	/**
	 * 根据shoppingCart_user_id查询对应购物车信息
	 * @param uid
	 * @return List<CartItemDto>
	 */
	List<CartItemDto> getCart(Integer uid);

	/**
	 * 根据shoppingCart_user_id删除对应的shoppingCart
	 * @param uid
	 * @return int
	 */
	int delCart(Integer uid);
}
