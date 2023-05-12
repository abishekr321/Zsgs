package com.coursemanagement.model;

import java.util.List;

import com.coursemanagement.dto.*;
import com.coursemanagement.repository.DbRepository;

public class Model {

	public boolean checkAdminLogin(String userId, String password) {
		return DbRepository.getInstance().validAdmin(userId, password);
	}

	public boolean checkStudentLogin(String userId, String password) {
		return DbRepository.getInstance().validStudent(userId, password);
	}

	public boolean checkTeacherLogin(String userId, String password) {
		return DbRepository.getInstance().validTeacher(userId, password);
	}

	public boolean addSubjects(String subjectId, String subjectName, String startingDate, String endingDate,
			String startingTime, String endingTime) {
		return DbRepository.getInstance().addSubjects(subjectId, subjectName, startingDate, endingDate, startingTime,
				endingTime);

	}

	public List<CourseDetails> showCourses() {
		return DbRepository.getInstance().showCourses();
	}

	public List<TeacherDetails> showTeachers() {
		return DbRepository.getInstance().showTeachers();
	}

	public List<StudentDetails> showStudents() {
		return DbRepository.getInstance().showStudents();
	}

	public List<GradeSheet> showteacherStudents(String teacherId) {
		return DbRepository.getInstance().showteacherStudents(teacherId);
	}

	public List<TeacherDetails> getCourseTeachers(String courseId) {
		return DbRepository.getInstance().getCourseTeachers(courseId);
	}

	public List<TimeTable> viewTimeTable(String studentId) {
		return DbRepository.getInstance().viewTimeTable(studentId);
	}

	public List<GradeSheet> GradeSheet(String studentId) {
		return DbRepository.getInstance().viewGradeSheet(studentId);
	}

	public List<GradeSheet> getteacherGradeSheet(String teacherId) {
		return DbRepository.getInstance().getteacherGradeSheet(teacherId);

	}

	public boolean deleteSubjects(String courseId) {
		return DbRepository.getInstance().deleteSubjects(courseId);
	}

	public boolean enrollCourses(String studentId, String subjectId, String teacherId) {
		return DbRepository.getInstance().enrollCourses(studentId, subjectId, teacherId);
	}

	public String addStudents(String firstName, String lastName, String emailAddress, String mobileNumber,
			String password) {
		return DbRepository.getInstance().addStudents(firstName, lastName, emailAddress, mobileNumber, password);
	}

	public String addTeachers(String firstName, String lastName, String emailAddress, String mobileNumber,
			String subjectId, String password) {
		return DbRepository.getInstance().addTeachers(firstName, lastName, emailAddress, mobileNumber, subjectId,
				password);
	}

	public void updateGradeSheet(String studentId, String teacherId, String grades) {
		DbRepository.getInstance().updateGradeSheet(studentId, teacherId, grades);

	}

}
