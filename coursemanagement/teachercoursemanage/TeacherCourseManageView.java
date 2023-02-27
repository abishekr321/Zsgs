package com.zsgs.coursemanagement.teachercoursemanage;

import java.util.List;
import java.util.Scanner;

import com.zsgs.coursemanagement.Login.LoginView;
import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;

public class TeacherCourseManageView implements TeacherCourseManageViewCallBack {
	private Scanner scanner=new Scanner(System.in);
	private TeacherCourseManageControllerCallBack teacherCourseManageController;
	private LoginView loginView;
	public TeacherCourseManageView (LoginView loginView) {
		this.loginView=loginView;
		teacherCourseManageController=new TeacherCourseManageController(this);
	}
	public void teacherMenu(String teacherId) {
		System.out.println("Enter 1 to View Subject details\nEnter 2 to grade Student\nEnter 3 to logout");
		char choice=scanner.next().charAt(0);
		switch(choice) {
		case '1':
			subjectdetails(teacherId);
			break;
		case '2':
			gradeStudents(teacherId);
			break;
		case '3':
			loginView.loginMenu();
			break;
		default:
			System.out.println("Enter the valid input");
			teacherMenu(teacherId);
		}
		
	}
	private void gradeStudents(String teacherId) {
	    List<GradeSheet> gradeSheets=teacherCourseManageController.setGrades(teacherId);
	    for(GradeSheet grades:gradeSheets) {
	    	System.out.println("Enter the Grade for "+grades.getStudentId()+" for "+grades.getSubjectName());
	    	grades.setGrade(scanner.next());
	    }
		teacherMenu(teacherId);
		
		
	}
	private void subjectdetails(String teacherId) {
		Subject subject=teacherCourseManageController.getSubject(teacherId);
		System.out.printf("%-15s%-25s%-25s%-25s%-25s","SubjectId","Subject Name","Starting Date","Ending Date","Slot");
	    System.out.printf("%-15s%-25s%-25s%-25s%-25s",subject.getSubjectId(),subject.getSubjectName(),subject.getSubjectStartDate(),subject.getSubjectEndDate(),subject.getSubjectstartTime()+"-"+subject.getSubjectEndTime());
	    teacherMenu(teacherId);
	    
		}

}
