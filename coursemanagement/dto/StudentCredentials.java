package com.zsgs.coursemanagement.dto;

public class StudentCredentials extends Student {
	private String password;
	public StudentCredentials(String userName,String userLName,String mobileNumber,String emailAddress,String userId,String password) {
		super.setStudentName(userName);
		super.setEmailAddress(emailAddress);
		super.setMobileNumber(mobileNumber);
		super.setStudentLName(userLName);
		super.setUserId(userId);
		this.setPassword(password);

	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
