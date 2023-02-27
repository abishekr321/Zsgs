package com.zsgs.coursemanagement.dto;

public class TeacherCredentials extends Teacher{
	private String password;

	public TeacherCredentials(String userName,String userLName,String mobileNumber,String emailAddress,String teachingSubjectId,String userId,String password) {
		super.setUserName(userName);
		super.setEmailAddress(emailAddress);
		super.setMobileNumber(mobileNumber);
		super.setUserLName(userLName);
		super.setUserId(userId);
		super.setTeachingSubjectId(teachingSubjectId);
		this.setPassword(password);
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
