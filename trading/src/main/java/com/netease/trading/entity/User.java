package com.netease.trading.entity;

public class User {

	// 用户id
	private Long userId;

	// 用户名
	private String userName;

	// 用户类型 userType=1买家 userType=2卖家
	private Integer userType;

	// 用户密码
	private String userPassword;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
