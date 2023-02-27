package com.zsgs.coursemanagement.setupcourses;

import java.util.List;

import com.zsgs.coursemanagement.Repository.CourseRepository;
import com.zsgs.coursemanagement.dto.StudentCredentials;
import com.zsgs.coursemanagement.dto.TeacherCredentials;

public class SetupCourseModel implements SetupCourseModelCallBack {
	private SetupCourseModelControllerCallBack setupCourseController;
	public SetupCourseModel(SetupCourseModelControllerCallBack setupCourseController) {
		this.setupCourseController=setupCourseController;
	}
	@Override
	public void addCourses(String subjectId, String subjectName, String subjectStartDate, String subjectEndDate,
			String subjectStartTime, String subjectEndTime) {
   if( CourseRepository.getInstance().addCourses(subjectId,subjectName,subjectStartDate,subjectEndDate,subjectStartTime, subjectEndTime)) {
	   setupCourseController.additionSuccess(subjectId+" Added Successfully");
   }else {
	   setupCourseController.additionFailure(subjectId+" Already Exist");
   }
		
	}
	@Override
	public void deleteCourses(String subjectId) {
		if(CourseRepository.getInstance().removeCourses(subjectId)) {
			setupCourseController.deletionSuccess(subjectId+" Removed Successfully");
		}
		else {
			setupCourseController.deletionFailure(subjectId+" Doesn't Exist");
		}
		
	}
	@Override
	public List<TeacherCredentials> getTeacherList() {
		
		return CourseRepository.getInstance().getTeacherList();
	}
	@Override
	public List<StudentCredentials> getStudentList() {
		
		return CourseRepository.getInstance().getStudentList();
	}

}
