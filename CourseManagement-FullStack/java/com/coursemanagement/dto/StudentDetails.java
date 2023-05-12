package com.coursemanagement.dto;

public class StudentDetails {
	private String studentId;
	private String studentName;
	private String emailAddress;
	private String mobileNumber;
	private String password;
	private String status;

	public StudentDetails() {

	}

	public StudentDetails(String studentId, String studentName, String emailAddress, String mobileNumber,
			String password, String status) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.status = status;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
