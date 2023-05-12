package com.coursemanagement.dto;

public class TeacherDetails {
	private String teacherId;
	private String teacherName;
	private String emailAddress;
	private String mobileNumber;
	private String courseId;
	private String courseName;
	private int slot;
	private String status;
	private String password;

	// Constructors
	public TeacherDetails() {
	}

	public TeacherDetails(String teacherId, String teacherName, String emailAddress, String mobileNumber,
			String courseId, int slot, String status) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.courseId = courseId;
		this.slot = slot;
		this.status = status;
	}

	// Getters and setters
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
