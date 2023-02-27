package com.zsgs.coursemanagement.dto;

public class GradeSheet {
	
	public GradeSheet(String studentId, String teacherId, String subjectId, String subjectName, String grade) {
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.grade = grade;
	}
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	private String studentId;
	private String teacherId;
	private String subjectId;
	private String subjectName;
	private String grade;

}
