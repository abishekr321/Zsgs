package com.zsgs.coursemanagement.teachercoursemanage;

import java.util.List;

import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;

public class TeacherCourseManageController implements TeacherCourseManageControllerCallBack,TeacherCourseManageModelControllerCallBack {
	private TeacherCourseManageViewCallBack teacherCourseManageView;
    private TeacherCourseManageModelCallBack teacherCourseManageModel;
    
	public TeacherCourseManageController(TeacherCourseManageViewCallBack teacherCourseManageView) {
		this.teacherCourseManageView=teacherCourseManageView;
		teacherCourseManageModel=new TeacherCourseManageModel(this);
	
	}

	@Override
	public Subject getSubject(String teacherId) {
		return teacherCourseManageModel.getSubject(teacherId) ;
	}

	@Override
	public List<GradeSheet> setGrades(String teacherId) {
		return teacherCourseManageModel.setGrades(teacherId);
	}
		
           
	
}
