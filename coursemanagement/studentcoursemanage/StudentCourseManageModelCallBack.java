package com.zsgs.coursemanagement.studentcoursemanage;

import java.util.List;

import com.zsgs.coursemanagement.dto.GradeSheet;
import com.zsgs.coursemanagement.dto.Subject;
import com.zsgs.coursemanagement.dto.Teacher;
import com.zsgs.coursemanagement.dto.TimeTable;

public interface StudentCourseManageModelCallBack {

	List<Subject> showSubjects();

	List<Teacher> showteachers(String subjectId);

	void enrollingSubjects(String studentId, String subjectId, String teacherId);

	List<TimeTable> showTimeTable(String studentId);

	List<GradeSheet> showGradeSheet(String studentId);

}
