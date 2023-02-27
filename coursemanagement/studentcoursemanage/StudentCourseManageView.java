package com.zsgs.coursemanagement.studentcoursemanage;

import java.util.List;
import java.util.Scanner;

import com.zsgs.coursemanagement.Login.LoginView;
import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;
import com.zsgs.coursemanagement.dto.Teacher;
import com.zsgs.coursemanagement.dto.TimeTable;
public class StudentCourseManageView implements StudentCourseManageViewCallBack {
	private Scanner scanner=new Scanner(System.in);
	private StudentCourseManageControllerCallBack studentCourseManageController;
	private LoginView loginView;
	private  String studentId;
	public StudentCourseManageView(LoginView loginView) {
		this.loginView=loginView;
		studentCourseManageController =new StudentCourseManageController(this);
	}
	public void studentMenu(String studentId) {
		this.studentId=studentId;
		System.out.println("Enter 1 for Enrollment\nEnter 2  to View Time table\nEnter 3 to view Grades");
		char choice =scanner.next().charAt(0);
		switch(choice) {
		case '1':
			enrollingSubject(studentId);
			break;
		case '3':
			getTimeTable(studentId);
			break;
		case '4':
			viewGrades(studentId);
			break;
		case '5':
			loginView.loginMenu();
			break;
		default:
			System.out.println("Enter the valid input");
			studentMenu(studentId);

		}
	}
	private void viewGrades(String studentId) {
		List<GradeSheet> gradesheets=studentCourseManageController.showGradeSheet(studentId);
		System.out.printf("%-15s%-20s%-10s%n","Subject Id","Subject Name","Grades");
		for(GradeSheet grades:gradesheets) {
			System.out.printf("%-15s%-20s%-10s%n",grades.getSubjectId(),grades.getSubjectName(),grades.getGrade());	
		}
		studentMenu(studentId);
		
		
	}
	private void getTimeTable(String studentId) {
		List<TimeTable> timetables=studentCourseManageController.showTimeTable(studentId);
		System.out.printf("%-15s%-20s%-30s%-30s%-30s%n","Subject Id","Subject Name","Subject Teacher","Subject period","Subject slot");
		for(TimeTable timetable:timetables) {
			System.out.printf("%-15s%-20s%-30s%-30s%-30s%n",timetable.getSubjectId(),timetable.getSubjectName(),timetable.getTeacherName(),timetable.getSubjectStartingDate()+"-"+timetable.getSubjectEndingDate(),timetable.getSubjectStartingTime()+"-"+timetable.getSubjectEndingTime());
			
		}
		studentMenu(studentId);
		
	}
	private void enrollingSubject(String studentId) {
		List<Subject> subjectdetails=studentCourseManageController.showSubjects();
		System.out.printf("%-15s%-25s%-25s%-25s%-25s%n","SubjectId","Subject Name","Starting Time","Ending Time","Slot");
		for(Subject subject:subjectdetails) {
			System.out.printf("%-15s%-25s%-25s%-25s%-25s%n",subject.getSubjectId(),subject.getSubjectName(),subject.getSubjectStartDate(),subject.getSubjectEndDate(),subject.getSubjectstartTime()+"-"+subject.getSubjectEndTime());
		}
		System.out.println("Enter the SubjectId to enroll");
		String subjectId = scanner.next();
		List<Teacher> teacherDetails=studentCourseManageController.showteachers(subjectId);
		System.out.printf("%-15s%-15s%-35s%n","subject Id","Teacher Id","Teacher Name");
		for(Teacher teacher:teacherDetails) {
		System.out.printf("%-15s%-15s%-35s%n",teacher.getTeachingSubjectId(),teacher.getUserId(),teacher.getUserName()+" "+teacher.getUserLName());
			
		}
		String teacherId=scanner.next();
		studentCourseManageController.enrollingSubjects(studentId,subjectId,teacherId);
			
		
	}

	@Override
	public void AdditionSuccess(String successMessage) {
		System.out.println(successMessage);
		studentMenu(studentId);
	}
	@Override
	public void AdditionFailure(String failureMessage) {
	   System.out.println(failureMessage);
	   studentMenu(studentId);
	}

}
