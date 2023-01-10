package com.bit;

import java.io.Serializable;

public class ChatInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String msg;
	
	public ChatInfo(String userId, String msg) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.msg = msg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
