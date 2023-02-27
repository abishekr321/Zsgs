package com.zsgs.coursemanagement.Login;

import java.util.List;

import com.zsgs.coursemanagement.dto.Subject;

public interface LoginModelCallBack {

	void SignUp(String userName, String userLName, String emailAddress, String mobileNumber, String designation,
			String teacherSubject, String password);

	void SignIn(String userId, String userpassword);

	List<Subject> showSubjects();

	

}
