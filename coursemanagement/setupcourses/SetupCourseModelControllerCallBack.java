package com.zsgs.coursemanagement.setupcourses;

public interface SetupCourseModelControllerCallBack {

	void additionSuccess(String successMessage);

	void additionFailure(String failureMssage);

	void deletionSuccess(String successMesage);

	void deletionFailure(String failureMessage);

}
