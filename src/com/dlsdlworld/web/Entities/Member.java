package com.dlsdlworld.web.Entities;

import java.util.Date;

public class Member {
	private String userId = "";
	private String userPw = "";
	private String userNick = "";
	/**
	 * @param userId
	 * @param userPw
	 * @param userNick
	 */
	public Member(String userId, String userPw, String userNick) {
// 		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userNick = userNick;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	
}
