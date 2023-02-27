package com.zsgs.coursemanagement.setupcourses;

import java.util.List;

import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.TeacherCredentials;

public interface SetupCourseModelCallBack {

	void addCourses(String subjectId, String subjectName, String subjectStartDate, String subjectEndDate,
			String subjectStartTime, String subjectEndTime);

	void deleteCourses(String subjectId);

	List<TeacherCredentials> getTeacherList();

	List<StudentCredentials> getStudentList();

}
