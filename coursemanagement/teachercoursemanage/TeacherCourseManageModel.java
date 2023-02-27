package com.zsgs.coursemanagement.teachercoursemanage;

import java.util.List;

import com.zsgs.coursemanagement.Repository.CourseRepository;
import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;

public class TeacherCourseManageModel implements TeacherCourseManageModelCallBack {
	private TeacherCourseManageModelControllerCallBack teacherCourseManageController;
     public TeacherCourseManageModel(TeacherCourseManageModelControllerCallBack teacherCourseManageController) {
		this.teacherCourseManageController=teacherCourseManageController;
	}
	@Override
	public Subject getSubject(String teacherId) {
		
		return CourseRepository.getInstance().getSubject(teacherId);
	}
	@Override 
	public List<GradeSheet> setGrades(String teacherId) {
		
		return CourseRepository.getInstance().setGradeSheets(teacherId);
	}

	
     
}
