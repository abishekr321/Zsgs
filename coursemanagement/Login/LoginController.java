package com.zsgs.coursemanagement.Login;

import java.util.List;

import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.Subject;
import com.zsgs.coursemanagement.dto.TeacherCredentials;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack {
 private LoginViewCallBack loginView;
 private LoginModelCallBack loginModel;
 public LoginController(LoginViewCallBack loginView) {
	 this.loginView=loginView;
	 loginModel =new LoginModel(this);
 }

@Override
public String hashingPassword(String password) {
	int i=11;
	String passedword="";
	 for(char c: password.toCharArray()) {
		passedword+=((c+i++)%26); 
		 
	 }
	return passedword;
}

@Override
public void SignUp(String userName, String userLName, String emailAddress, String mobileNumber, String designation,
		String teacherSubject, String password) {
	loginModel.SignUp(userName,userLName,emailAddress,mobileNumber,designation,teacherSubject,password);
	
}

@Override
public void SignIn(String userId, String userpassword) {
	loginModel.SignIn(userId,userpassword);
	
}


@Override
public void signUpSuccess(String userId, String successMessage) {
	loginView.signUpSuccess(userId,successMessage);
	
}

@Override
public void signUpFailure(String userId, String errorMessage) {
	loginView.signUpFailure(userId,errorMessage);
	
}

@Override
public void signInFailure(String errorMessage) {
	 loginView.sigInFailure(errorMessage);
	
}

@Override
public void adminSignInSuccess(String successMessage) {
	loginView.adminSignInSuccess(successMessage);
	
}

@Override
public void studentSignInSuccess(StudentCredentials student) {
	loginView.studentsSignInSuccess(student);
}

@Override
public void teacherSignInSuccess(TeacherCredentials teacher) {
	loginView.teacherSignInSuccess(teacher);
	
}

@Override
public List<Subject> showSubjects() {
	
	return loginModel.showSubjects();
}
}
