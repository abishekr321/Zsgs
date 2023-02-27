package com.zsgs.coursemanagement.Login;

import java.util.List;

import com.zsgs.coursemanagement.Repository.CourseRepository;
import com.zsgs.coursemanagement.dto.*;

public class LoginModel implements LoginModelCallBack {
	private LoginModelControllerCallBack loginController;
	private StudentCredentials student;
	private TeacherCredentials teacher;
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController= loginController;
	}
	@Override
	public void SignUp(String userName, String userLName, String emailAddress, String mobileNumber, String designation,
			String teacherSubject, String password) {
		if(CourseRepository.getInstance().signUp(userName,userLName,emailAddress,mobileNumber,designation,teacherSubject,password)) {
			loginController.signUpSuccess(CourseRepository.getInstance().getUserId(emailAddress,mobileNumber,designation),"Account added Successfully");
		}
		else {
			loginController.signUpFailure(CourseRepository.getInstance().getUserId(emailAddress,mobileNumber,designation),"Account Already Exist");
		}
		
	}
	@Override
	public void SignIn(String userId, String userpassword) {
			if(userId.charAt(0)=='a') {
				if(!CourseRepository.getInstance().adminSignIn(userId,userpassword)) {
				loginController.adminSignInSuccess("Welcome Admin");
				}
				else {
					loginController.signInFailure(" Admin Invalid Credentials");
				}
			}
			else if(userId.charAt(0)=='S') {
				student=CourseRepository.getInstance().studentSignIn(userId,userpassword);
				if(student!=null)
				loginController.studentSignInSuccess(student);
				else
					loginController.signInFailure("Invalid Credentials");
			}
			else if(userId.charAt(0)=='T') {
				teacher=CourseRepository.getInstance().teacherSignIn(userId,userpassword);
				if(teacher!=null)
				loginController.teacherSignInSuccess(teacher);
				else
					loginController.signInFailure("Invalid Credentials");
				
			}
		}
	@Override
	public List<Subject> showSubjects() {
		
		return CourseRepository.getInstance().showSubjects() ;
	}
	


}
