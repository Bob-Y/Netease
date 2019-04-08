package com.netease.trading.entity;

public class CartItem {
	
	public Long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Product getCartItemProduct() {
		return cartItemProduct;
	}
	public void setCartItemProduct(Product cartItemProduct) {
		this.cartItemProduct = cartItemProduct;
	}
	public Integer getCartItemQuantity() {
		return cartItemQuantity;
	}
	public void setCartItemQuantity(Integer cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}

	private Long cartItemId;
	private Product cartItemProduct;
	private Integer cartItemQuantity;
}
