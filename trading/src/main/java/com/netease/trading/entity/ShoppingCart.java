package com.netease.trading.entity;


public class ShoppingCart {
	
	private Long shoppingCartID;

	public Long getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(Long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	private User shoppingCartUser;

	public User getShoppingCartUser() {
		return shoppingCartUser;
	}

	public void setShoppingCartUser(User shoppingCartUser) {
		this.shoppingCartUser = shoppingCartUser;
	}
}
