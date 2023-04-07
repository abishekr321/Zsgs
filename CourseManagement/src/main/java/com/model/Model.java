package com.model;

import java.sql.ResultSet;

import com.rep.DbRepository;

public class Model {
	
	
	public boolean checkAdminLogin(String userId,String password) {
		return DbRepository.getInstance().validAdmin(userId, password);
	}
	
	public boolean checkStudentLogin(String userId,String password) {
		return DbRepository.getInstance().validStudent(userId,password);
	}
	
	public boolean checkTeacherLogin(String userId,String password) {
		return DbRepository.getInstance().validTeacher(userId,password);
	}
	

	public boolean addSubjects(String subjectId, String subjectName, String startingDate, String endingDate,
			String startingTime, String endingTime) {
		return DbRepository.getInstance().addSubjects(subjectId,subjectName,startingDate,endingDate,startingTime,endingTime);
		
	}

	public ResultSet showCourses() {
		return DbRepository.getInstance().showCourses();
	}

	public ResultSet showTeachers() {
		return DbRepository.getInstance().showTeachers();
	}

	public ResultSet showStudents() {
		return DbRepository.getInstance().showStudents();
	}

	public ResultSet showteacherStudents(String teacherId) {
		return DbRepository.getInstance().showteacherStudents(teacherId);
	}
	public ResultSet getCourseTeachers(String courseId) {
	     return DbRepository.getInstance().getCourseTeachers(courseId);
	}

	public ResultSet viewTimeTable(String studentId) {
		return DbRepository.getInstance().viewTimeTable(studentId);
	}

	public ResultSet GradeSheet(String studentId) {
		return DbRepository.getInstance().viewGradeSheet(studentId);
	}

	public ResultSet getteacherGradeSheet(String teacherId) {
		return DbRepository.getInstance().getteacherGradeSheet(teacherId);
	
	}

	public boolean deleteSubjects(String courseId) {
		return DbRepository.getInstance().deleteSubjects(courseId);
	}

	public boolean enrollCourses(String studentId,String subjectId, String teacherId) {
		 return DbRepository.getInstance().enrollCourses( studentId,subjectId,teacherId);
	}

	public String addStudents(String firstName, String lastName, String emailAddress, String mobileNumber,
			String password) {
		return DbRepository.getInstance().addStudents(firstName,lastName,emailAddress,mobileNumber,password);
	}

	public String addTeachers(String firstName, String lastName, String emailAddress, String mobileNumber,
			String subjectId, String password) {
		return DbRepository.getInstance().addTeachers(firstName,lastName,emailAddress,mobileNumber,subjectId,password);
	}

	public void updateGradeSheet(String studentId, String teacherId, String grades) {
		 DbRepository.getInstance().updateGradeSheet(studentId,teacherId,grades);
		
	}

	

}
