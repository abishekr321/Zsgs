package com.zsgs.coursemanagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Subject {
	private String subjectName;
	private String subjectId;
	private LocalDate subjectStartDate;
	private LocalDate subjectEndDate;
	private LocalTime subjectstartTime;
	private LocalTime subjectEndTime;
	public Subject(String subjectName, String subjectId, LocalDate subjectStartDate, LocalDate subjectEndDate,
			LocalTime subjectstartTime, LocalTime subjectEndTime) {
	
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.subjectStartDate = subjectStartDate;
		this.subjectEndDate = subjectEndDate;
		this.subjectstartTime = subjectstartTime;
		this.subjectEndTime = subjectEndTime;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public LocalDate getSubjectStartDate() {
		return subjectStartDate;
	}
	public void setSubjectStartDate(LocalDate subjectStartDate) {
		this.subjectStartDate = subjectStartDate;
	}
	public LocalDate getSubjectEndDate() {
		return subjectEndDate;
	}
	public void setSubjectEndDate(LocalDate subjectEndDate) {
		this.subjectEndDate = subjectEndDate;
	}
	public LocalTime getSubjectstartTime() {
		return subjectstartTime;
	}
	public void setSubjectstartTime(LocalTime subjectstartTime) {
		this.subjectstartTime = subjectstartTime;
	}
	public LocalTime getSubjectEndTime() {
		return subjectEndTime;
	}
	public void setSubjectEndTime(LocalTime subjectEndTime) {
		this.subjectEndTime = subjectEndTime;
	}
	
	
	
	
}
