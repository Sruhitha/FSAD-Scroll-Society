package com.klu.request;

import com.klu.Model.User;

public class ChatRequest {

	private Integer userId;
	
	public ChatRequest() {
		
	}

	public ChatRequest(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

	
	
	
}
