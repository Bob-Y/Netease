package com.netease.trading.entity;

public class Product {

	// 商品id
	private Long productId;

	// 商品名称
	private String productTitle;

	// 商品概要
	private String productAbstract;

	// 商品详情
	private String productDetail;

	// 商品价格
	private double productPrice;

	// 商品状态
	private Integer productStatus;

	// 商品图片地址
	private String productImgAddr;

	// 商品图片类型
	private Integer productImgType;

	// 商品所属用户
	private User productUser;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductAbstract() {
		return productAbstract;
	}

	public void setProductAbstract(String productAbstract) {
		this.productAbstract = productAbstract;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductImgAddr() {
		return productImgAddr;
	}

	public void setProductImgAddr(String productImgAddr) {
		this.productImgAddr = productImgAddr;
	}

	public User getProductUser() {
		return productUser;
	}

	public void setProductUser(User productUser) {
		this.productUser = productUser;
	}

	public Integer getProductImgType() {
		return productImgType;
	}

	public void setProductImgType(Integer productImgType) {
		this.productImgType = productImgType;
	}
}
