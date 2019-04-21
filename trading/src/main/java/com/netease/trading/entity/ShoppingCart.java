package com.netease.trading.entity;


public class ShoppingCart {
	
	// 购物车id
	private Long shoppingCartID;

	// 购物车所属用户
	private User shoppingCartUser;

	public Long getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(Long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public User getShoppingCartUser() {
		return shoppingCartUser;
	}

	public void setShoppingCartUser(User shoppingCartUser) {
		this.shoppingCartUser = shoppingCartUser;
	}
}
