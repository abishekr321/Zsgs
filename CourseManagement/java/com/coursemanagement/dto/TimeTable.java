package com.coursemanagement.dto;

import java.sql.Date;
import java.sql.Time;

public class TimeTable {
	private String courseId;
	private String courseName;
	private String teacherName;
	private Date startingDate;
	private Date endingDate;
	private Time startingTime;
	private Time endingTime;

	public TimeTable() {

	}

	public TimeTable(String courseId, String courseName, String teacherName, Date startingDate, Date endingDate,
			Time startingTime, Time endingTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

}
