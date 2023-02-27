package com.zsgs.coursemanagement.Login;

import java.util.List;
import java.util.Scanner;

import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.Subject;
import com.zsgs.coursemanagement.dto.TeacherCredentials;
import com.zsgs.coursemanagement.setupcourses.SetupCourseView;
import com.zsgs.coursemanagement.studentcoursemanage.StudentCourseManageView;
import com.zsgs.coursemanagement.teachercoursemanage.TeacherCourseManageView;
import com.zsgs.coursemanagement.util.Validate;

public class LoginView implements LoginViewCallBack {
	private LoginControllerCallBack loginController;
	private boolean boolCheck;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.loginMenu();
	}

	public void loginMenu() {
		System.out.println("------->OHO Schools<------");
		System.out.println("Enter 1 to Existing User SignIn\nEnter 2 to New User SignUp\nEnter 3 to Exit");
		char choice = scanner.next().charAt(0);
		switch (choice) {
		case '1':
			SignIn();
			break;
		case '2':
			SignUp();
			break;
		case '3':
			System.out.println("-------->Happy Learning<--------");
			System.exit(0);
		default:
			System.out.println("Enter the valid key");
			loginMenu();
		}
	}

	private void SignUp() {
		System.out.println("Enter First Name");
		String userName = scanner.next();
		System.out.println("Enter Last Name");
		String userLName = scanner.next();
		boolCheck = true;
		String emailAddress = "";
		while (boolCheck) {
			System.out.println("Enter email address");
			emailAddress = scanner.next();
			if (Validate.Email(emailAddress)) {
				boolCheck = false;
			} else {
				System.out.println("please Enter Valid Email Address");
			}
		}
		boolCheck = true;
		String mobileNumber = "";
		while (boolCheck) {
			System.out.println("Enter phone Number");
			mobileNumber = scanner.next();
			if (Validate.mobileNumber(mobileNumber)) {
				boolCheck = false;
			} else {
				System.out.println("please Enter valid Mobile number");
			}
		}
		boolCheck = true;
		String password = "";
		while (boolCheck) {
			System.out.println("Enter the password");
			password = loginController.hashingPassword(scanner.next());
			System.out.println("Re Enter the password");
			String password1 = loginController.hashingPassword(scanner.next());
			if (Validate.validpassword(password, password1)) {
				boolCheck = false;
			} else {
				System.out.println("Re-entered passwords are incorrect ");

			}
		}
		boolCheck = true;
		String designation = "";
		String teacherSubject = "";
		while (boolCheck) {
			System.out.println("Enter 1 for designation as student\nEnter 2 for designation as teacher");
			char choice = scanner.next().charAt(0);
			switch (choice) {
			case '1':
				designation = "Student";
				teacherSubject = null;
				boolCheck = false;
				break;
			case '2':
				designation = "Teacher";
				teacherSubject = choosingSubject();
				boolCheck = false;
				break;
			default:
				System.out.println("please Enter valid Input");
				boolCheck = true;
			}
		}

		loginController.SignUp(userName, userLName, emailAddress, mobileNumber, designation, teacherSubject, password);
	}

	private String choosingSubject() {
		List<Subject> subjectdetails=loginController.showSubjects();
		System.out.printf("%-15s%-25s%-25s%-25s%-25s","SubjectId","Subject Name","Starting Time","Ending Time","Slot");
		for(Subject subject:subjectdetails) {
			System.out.printf("%-15s%-25s%-25s%-25s%-25s",subject.getSubjectId(),subject.getSubjectName(),subject.getSubjectStartDate(),subject.getSubjectEndDate(),subject.getSubjectstartTime()+"-"+subject.getSubjectEndTime());
		}
		    System.out.println("Enter the subject Code to teach");
			return scanner.next() ;
		
	}

	private void SignIn() {
		System.out.println("Enter UserId");
		String userId = scanner.next();
		System.out.println("Enter password");
		String userpassword =loginController.hashingPassword(scanner.next());
		loginController.SignIn(userId, userpassword);
	}

	@Override
	public void signUpSuccess(String userId, String successMessage) {
		System.out.println(successMessage);
		System.out.println("Your userId is " + userId);
		SignIn();

	}

	@Override
	public void signUpFailure(String userId, String failureMessage) {
		System.out.println(failureMessage);
		System.out.println("Your userId is " + userId);
		SignIn();

	}

	@Override
	public void sigInFailure(String errorMessage) {
		System.out.println(errorMessage);
		loginMenu();

	}

	@Override
	public void adminSignInSuccess(String successMessage) {
		System.out.println(successMessage);
		SetupCourseView setupCourseView=new SetupCourseView(this);
		setupCourseView.setupMenu();
		

	}

	@Override
	public void studentsSignInSuccess(StudentCredentials student) {
       System.out.println("Welcome "+student.getStudentName()+" "+student.getStudentLName());
       StudentCourseManageView studentCourseManageView = new StudentCourseManageView(this);
       studentCourseManageView.studentMenu(student.getUserId()); 
       
       
	}

	@Override
	public void teacherSignInSuccess(TeacherCredentials teacher) {
       System.out.println("Welcome "+teacher.getUserName()+" "+teacher.getUserLName());
       TeacherCourseManageView teacherCourseManageView = new TeacherCourseManageView(this);
       teacherCourseManageView.teacherMenu(teacher.getUserId()); 

       
	}

}
