package com.zsgs.coursemanagement.setupcourses;

import java.util.List;

import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.TeacherCredentials;

public class SetupCourseController implements SetupCourseControllerCallBack,SetupCourseModelControllerCallBack {
          private SetupCourseViewCallBack setupCourseView;
          private SetupCourseModelCallBack setupCourseModel;
          public SetupCourseController(SetupCourseViewCallBack setupCourseView) {
        	  this.setupCourseView=setupCourseView;
        	  setupCourseModel=new SetupCourseModel(this);
        	  
          }
		@Override
		public void addCourses(String subjectId, String subjectName, String subjectStartDate, String subjectEndDate,
				String subjectStartTime, String subjectEndTime) {
			setupCourseModel.addCourses(subjectId,subjectName,subjectStartDate,subjectEndDate,subjectStartTime, subjectEndTime);
			
		}
		@Override
		public void deleteCourses(String subjectId) {
			setupCourseModel.deleteCourses(subjectId);
			
		}
		@Override
		public void additionSuccess(String successMessage) {
			setupCourseView.additionSuccess(successMessage);
			
		}
		@Override
		public void additionFailure(String failureMessage) {
			setupCourseView.additionfailure(failureMessage);
			
		}
		@Override
		public void deletionSuccess(String successMessage) {
			setupCourseView.deletionSuccess(successMessage);
			
		}
		@Override
		public void deletionFailure(String failureMessage) {
			setupCourseView.deletionfailure(failureMessage);
			
		}
		@Override
		public List<TeacherCredentials> getTeacherList() {
			return setupCourseModel.getTeacherList()  ;
		}
		@Override
		public List<StudentCredentials> getStudentList() {
			
			return setupCourseModel.getStudentList();
		}
	
}
