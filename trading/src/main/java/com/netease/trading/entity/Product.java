package com.netease.trading.entity;

public class Product {

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
	
	private Long productId;
	private String productTitle;
	private String productAbstract;
	private String productDetail;
	private double productPrice;
	private Integer productStatus;
	private String productImgAddr;
	private Integer productImgType;
	private User productUser;
}
