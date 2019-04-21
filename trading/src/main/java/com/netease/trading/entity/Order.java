package com.netease.trading.entity;
import java.util.Date;
public class Order {

	// 订单id
	private Long orderId;

	// 订单生成时间
	private Date orderTime;

	// 订单商品
	private Product orderProduct;

	// 订单商品数量
	private Integer orderQuantity;

	// 订单商品价格
	private Double orderPrice;

	// 订单所属用户
	private User orderUser;
	
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
}
