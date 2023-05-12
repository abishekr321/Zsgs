package com.coursemanagement.dto;

import java.sql.Date;
import java.sql.Time;

public class CourseDetails {
	private String courseId;
	private String courseName;
	private Date startingDate;
	private Date endingDate;
	private Time startingTime;
	private Time endingTime;
	private String status;

	public CourseDetails() {
	}

	public CourseDetails(String courseId, String courseName, Date startingDate, Date endingDate, Time startingTime,
			Time endingTime, String status) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.status = status;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public Time getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Time startingTime) {
		this.startingTime = startingTime;
	}

	public Time getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(Time endingTime) {
		this.endingTime = endingTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
