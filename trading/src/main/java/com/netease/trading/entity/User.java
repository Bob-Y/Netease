package com.netease.trading.entity;

public class User {
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

	private Long userId;
	private String userName;
	private Integer userType;
	private String userPassword;
}
