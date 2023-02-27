package com.zsgs.coursemanagement.Login;

import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.TeacherCredentials;

public interface LoginViewCallBack {

	void signUpSuccess(String userId, String successMessage);

	void signUpFailure(String userId,String failureMessage);

	void sigInFailure(String errorMessage);

	void adminSignInSuccess(String successMessage);

	void studentsSignInSuccess(StudentCredentials student);

	void teacherSignInSuccess(TeacherCredentials teacher);

}
