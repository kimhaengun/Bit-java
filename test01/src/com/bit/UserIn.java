package com.bit;

import java.io.Serializable;

public class UserIn implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userPassword;
	
	public UserIn(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}