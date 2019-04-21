package com.netease.trading.entity;

public class CartItem {

	// 购物项id
	private Long cartItemId;

	// 购物项商品
	private Product cartItemProduct;

	// 购物项商品数量
	private Integer cartItemQuantity;

	// 购物车id
	private Integer cartId;

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

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
}
