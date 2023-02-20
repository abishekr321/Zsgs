package com.zsgs.flightreservation.dto;

public class AdminCredentials extends Admin {
	private String password;

	public AdminCredentials(String adminID, String adminName, String password) {
		super.setAdminId(adminID);
		super.setAdminName(adminName);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
