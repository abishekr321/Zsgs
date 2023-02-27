package com.zsgs.coursemanagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeTable {
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
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
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public LocalDate getSubjectStartingDate() {
		return subjectStartingDate;
	}
	public void setSubjectStartingDate(LocalDate subjectStartingDate) {
		this.subjectStartingDate = subjectStartingDate;
	}
	public LocalDate getSubjectEndingDate() {
		return subjectEndingDate;
	}
	public void setSubjectEndingDate(LocalDate subjectEndingDate) {
		this.subjectEndingDate = subjectEndingDate;
	}
	public LocalTime getSubjectStartingTime() {
		return subjectStartingTime;
	}
	public void setSubjectStartingTime(LocalTime subjectStartingTime) {
		this.subjectStartingTime = subjectStartingTime;
	}
	public LocalTime getSubjectEndingTime() {
		return subjectEndingTime;
	}
	public void setSubjectEndingTime(LocalTime subjectEndingTime) {
		this.subjectEndingTime = subjectEndingTime;
	}
	public TimeTable(String studentId, String teacherId, String teacherName, String subjectId, String subjectName,
			LocalDate subjectStartingDate, LocalDate subjectEndingDate, LocalTime subjectStartingTime,
			LocalTime subjectEndingTime) {
	
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectStartingDate = subjectStartingDate;
		this.subjectEndingDate = subjectEndingDate;
		this.subjectStartingTime = subjectStartingTime;
		this.subjectEndingTime = subjectEndingTime;
	}
	private String studentId;
	private String teacherId;
	private String teacherName;
	private String subjectId;
	private String subjectName;
	private LocalDate subjectStartingDate;
	private LocalDate subjectEndingDate;
	private LocalTime subjectStartingTime;
	private LocalTime subjectEndingTime;

}
