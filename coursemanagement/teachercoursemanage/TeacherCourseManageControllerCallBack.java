package com.zsgs.coursemanagement.teachercoursemanage;

import java.util.List;

import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;

public interface TeacherCourseManageControllerCallBack {

	Subject getSubject(String teacherId);

	List<GradeSheet> setGrades(String teacherId);

}
