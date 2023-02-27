package com.zsgs.coursemanagement.studentcoursemanage;

import java.util.List;

import com.zsgs.coursemanagement.Repository.CourseRepository;
import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;
import com.zsgs.coursemanagement.dto.Teacher;
import com.zsgs.coursemanagement.dto.TimeTable;

public class StudentCourseManageModel implements StudentCourseManageModelCallBack {
	private StudentCourseManageModelControllerCallBack studentCourseManageController; 

	public StudentCourseManageModel(StudentCourseManageModelControllerCallBack studentCourseManageController) {
		this.studentCourseManageController=studentCourseManageController;
		
	}

	@Override
	public List<Subject> showSubjects() {
		
		return CourseRepository.getInstance().showSubjects();
	}

	@Override
	public List<Teacher> showteachers(String subjectId) {
		
		return CourseRepository.getInstance().showTeachers(subjectId);
	}

	@Override
	public void enrollingSubjects(String studentId, String subjectId, String teacherId) {
		if(CourseRepository.getInstance().enrollingSubject(studentId, subjectId, teacherId)) {
			studentCourseManageController.AdditionSuccess(subjectId+" "+"Enrolled successfully");
		}
		else {
			studentCourseManageController.AdditionFailure(subjectId+" "+"Enrollment Failed");
		}
	}

	@Override
	public List<TimeTable> showTimeTable(String studentId) {
		return CourseRepository.getInstance().showTimeTable(studentId) ;
	}

	@Override
	public List<GradeSheet> showGradeSheet(String studentId) {
		
		return CourseRepository.getInstance().showGradeSheets(studentId);
	}
	

}
