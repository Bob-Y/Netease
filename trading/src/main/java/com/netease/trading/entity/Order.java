package com.netease.trading.entity;
import java.util.Date;
public class Order {
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Product getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(Product orderProduct) {
		this.orderProduct = orderProduct;
	}
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public User getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}

	private Long orderId;
	private Date orderTime;
	private Product orderProduct;
	private Integer orderQuantity;
	private Double orderPrice;
	private User orderUser;
	
}
