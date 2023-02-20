package com.zsgs.flightreservation.dto;

public class Credentials extends User {
	private String password;

	public Credentials(String userID, String userName, String password) {
		super.setUserId(userID);
		super.setUserName(userName);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
