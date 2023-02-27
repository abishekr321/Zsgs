package com.zsgs.coursemanagement.setupcourses;

public interface SetupCourseViewCallBack {

	void additionSuccess(String successMessage);

	void deletionfailure(String failureMessage);

	void deletionSuccess(String successMessage);

	void additionfailure(String failureMessage);

}
