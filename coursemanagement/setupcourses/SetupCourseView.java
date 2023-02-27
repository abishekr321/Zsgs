package com.zsgs.coursemanagement.setupcourses;

import java.util.*;

import com.zsgs.coursemanagement.Login.LoginView;
import com.zsgs.coursemanagement.dto.*;

public class SetupCourseView implements SetupCourseViewCallBack {
	private SetupCourseControllerCallBack setupCourseController;
	private LoginView loginView;
    private Scanner scanner=new Scanner(System.in);
    public SetupCourseView(LoginView loginView) {
    	this.loginView=loginView;
    	setupCourseController=new SetupCourseController(this);
    }
    public void setupMenu() {
    	System.out.println("Enter 1 for Add new Courses\nEnter 2 for delete Courses\nEnter 3 for view Student list\nEnter 4 for view Teacher list\nEnter 5 for logout");
    	char choice =scanner.next().charAt(0);
    	switch(choice) {
    	case '1':
    		addCourses();
    		break;
    	case '2':
    		deleteCourses();
    		break;
    	case '3':
    		viewStudents();
    		break;
    	case '4':
    		viewTeacher();
    		break;
    	case '5':
    		loginView.loginMenu();
    		break;
    	default:
    		setupMenu();
    	}
    }
	
	private void viewTeacher() {
	 List<TeacherCredentials> teacherList= setupCourseController.getTeacherList();
	     System.out.printf("%-15s%-30s%-15s%-15s%-20s","Teacher Id","Teacher Name","Subject","Contact No.","E-mail Id");
	 for(TeacherCredentials teacher:teacherList) {
		 System.out.printf("%-15s%-30s%-15s%-15s%-20s",teacher.getUserId(),teacher.getUserName()+" "+teacher.getUserLName(),teacher.getTeachingSubjectId(),teacher.getMobileNumber(),teacher.getEmailAddress());
	 }
	 setupMenu();
	}
	private void viewStudents() {
		List<StudentCredentials> studentList= setupCourseController.getStudentList();
		System.out.printf("%-15s%-30s%-15s%-20s","Student Id","Student Name","Contact No.","E-mail Id");
		for(StudentCredentials student:studentList) {
			System.out.printf("%-15s%-30s%-15s%-20s",student.getUserId(),student.getStudentName()+" "+student.getStudentLName(),student.getMobileNumber(),student.getEmailAddress());
		}
		setupMenu();
		
	}
	private void deleteCourses() {
		System.out.println("Enter the Subject Id");
		String subjectId=scanner.next();
		setupCourseController.deleteCourses(subjectId);
		
	}
	private void addCourses() {
		System.out.println("Enter the Subject Id");
		String subjectId=scanner.next();
		System.out.println("Enter the Subject Name");
		String subjectName=scanner.next();
		System.out.println("Enter the Subject Starting Date(dd-MM-yyy)");
		String subjectStartDate=scanner.next();
		System.out.println("Enter the Subject Ending Date(dd-MM-yyy)");
		String subjectEndDate=scanner.next();
		System.out.println("Enter the Slot Starting Time(HH:MM)");
		String subjectStartTime=scanner.next();
		System.out.println("Enter the Slot Ending time(HH:MM)");
		String subjectEndTime=scanner.next();
		setupCourseController.addCourses(subjectId,subjectName,subjectStartDate,subjectEndDate,subjectStartTime, subjectEndTime);		
	}
	@Override
	public void additionSuccess(String successMessage) {
		System.out.println(successMessage);
		setupMenu();
		
	}
	@Override
	public void deletionfailure(String failureMessage) {
		System.out.println(failureMessage);
		setupMenu();
		
	}
	@Override
	public void deletionSuccess(String successMessage) {
		System.out.println(successMessage);
		setupMenu();
		
	}
	@Override
	public void additionfailure(String failureMessage) {
		System.out.println(failureMessage);
		setupMenu();
		
	}
	

}
