package com.zsgs.coursemanagement.Login;

import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.TeacherCredentials;

public interface LoginModelControllerCallBack {

	void signUpSuccess(String userId, String successMessage);

	void signUpFailure(String userId,String errorMessage);

	void signInFailure(String errorMessage);

	void adminSignInSuccess(String successMessage);

	void studentSignInSuccess(StudentCredentials student);

	void teacherSignInSuccess(TeacherCredentials teacher);

}
