package com.zsgs.coursemanagement.studentcoursemanage;

import java.util.List;

import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;
import com.zsgs.coursemanagement.dto.Teacher;
import com.zsgs.coursemanagement.dto.TimeTable;

public class StudentCourseManageController implements StudentCourseManageControllerCallBack,  StudentCourseManageModelControllerCallBack{
	private  StudentCourseManageViewCallBack  studentCourseManageView;
    private   StudentCourseManageModelCallBack  studentCourseManageModel;
         
	public StudentCourseManageController(StudentCourseManageView studentCourseManageView) {
		this.studentCourseManageView=studentCourseManageView;
		studentCourseManageModel=new StudentCourseManageModel(this);
	}

	@Override
	public List<Subject> showSubjects() {
		
		return studentCourseManageModel.showSubjects();
	}

	@Override
	public List<Teacher> showteachers(String subjectId) {
		
		return studentCourseManageModel.showteachers(subjectId);
	}

	@Override
	public void enrollingSubjects(String studentId, String subjectId, String teacherId) {
		studentCourseManageModel.enrollingSubjects(studentId,subjectId,teacherId);
		
	}

	@Override
	public void AdditionSuccess(String successMessage) {
		studentCourseManageView.AdditionSuccess(successMessage);
		
	}

	@Override
	public void AdditionFailure(String failureMessage) {
		studentCourseManageView.AdditionFailure(failureMessage);
		
	}

	@Override
	public List<TimeTable> showTimeTable(String studentId) {
		
		return studentCourseManageModel.showTimeTable(studentId);
	}

	@Override
	public List<GradeSheet> showGradeSheet(String studentId) {
		
		return studentCourseManageModel.showGradeSheet(studentId);
	}
		
}
