package com.zsgs.coursemanagement.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import com.zsgs.coursemanagement.dto.*;
import com.zsgs.coursemanagement.util.Validate;

public class CourseRepository {
	private static CourseRepository courseRepository;

	private CourseRepository() {

	}

	private List<StudentCredentials> studentDetails = new ArrayList<>();
	private List<TeacherCredentials> teacherDetails = new ArrayList<>();
	private List<Subject> subjectDetails = new ArrayList<>();
    private List<TimeTable> timetablelist=new ArrayList<>();
    private List<GradeSheet> gradeSheets=new ArrayList<>();
	public static CourseRepository getInstance() {
		if (courseRepository == null) {
			courseRepository = new CourseRepository();

		}
		return courseRepository;
	}

	public boolean signUp(String userName, String userLName, String emailAddress, String mobileNumber,
			String designation, String teachingSubject, String password) {

		if (designation.equalsIgnoreCase("Teacher")) {
			for (TeacherCredentials teacher : teacherDetails) {
				if (teacher.getEmailAddress().equals(emailAddress) || teacher.getMobileNumber().equals(mobileNumber)) {
					return false;
				}
			}
			String userId = "TEA" + (teacherDetails.size() + 1);
			teacherDetails.add(new TeacherCredentials(userName, userLName, mobileNumber, emailAddress, teachingSubject,
					password, userId));
			return true;
		} else if (designation.equalsIgnoreCase("Student")) {
			for (StudentCredentials student : studentDetails) {
				if (student.getEmailAddress().equals(emailAddress) || student.getMobileNumber().equals(mobileNumber)) {
					return false;
				}
			}
			String userId = "STU" + (studentDetails.size() + 1);
			studentDetails
					.add(new StudentCredentials(userName, userLName, mobileNumber, emailAddress, userId, password));
			return true;
		}
		return false;
	}

	public String getUserId(String emailAddress, String mobileNumber, String designation) {
		if (designation.equalsIgnoreCase("Teacher")) {
			for (TeacherCredentials teacher : teacherDetails) {
				if (teacher.getEmailAddress().equals(emailAddress) || teacher.getMobileNumber().equals(mobileNumber)) {
					return teacher.getUserId();
				}
			}
		} else {
			for (StudentCredentials student : studentDetails) {
				if (student.getEmailAddress().equals(emailAddress) || student.getMobileNumber().equals(mobileNumber)) {
					return student.getUserId();
				}
			}
		}
		return "";
	}

	public boolean adminSignIn(String userId, String userpassword) {
		if (userId.equals("admin") && userpassword.equals("admin"))
			return true;
		else
			return false;
	}

	public StudentCredentials studentSignIn(String userId, String userpassword) {
		for (StudentCredentials student : studentDetails) {
			if (student.getUserId().equals(userId) && student.getPassword().equals(userpassword)) {
				return student;
			}
		}
		return null;

	}

	public TeacherCredentials teacherSignIn(String userId, String userpassword) {
		for (TeacherCredentials teacher : teacherDetails) {
			if (teacher.getUserId().equals(userId) && teacher.getPassword().equals(userpassword)) {
				return teacher;
			}
		}
		return null;

	}

	public boolean addCourses(String subjectId, String subjectName, String subjectStartDate, String subjectEndDate,
			String subjectStartTime, String subjectEndTime) {
		for (Subject subject : subjectDetails) {
			if (subject.getSubjectId().equals(subjectId)) {
				return false;
			}
		}
		subjectDetails.add(new Subject(subjectId, subjectName, Validate.dateformat(subjectEndDate),
				Validate.dateformat(subjectEndDate), Validate.timeFormat(subjectEndTime),
				Validate.timeFormat(subjectEndTime)));
		return true;
	}

	public boolean removeCourses(String subjectId) {
		for (Subject subject : subjectDetails) {
			if (subject.getSubjectId().equals(subjectId)) {
				subjectDetails.remove(subject);
				return true;
			}
		}
		return false;

	}

	public List<TeacherCredentials> getTeacherList() {
		return teacherDetails;
	}

	public List<StudentCredentials> getStudentList() {
        return studentDetails;
	}

	public List<Subject> showSubjects() {
		return subjectDetails;
	}

	public List<Teacher> showTeachers(String subjectId) {
		List<Teacher> teachersdetails=new ArrayList<>();
		for(Teacher teacher:teacherDetails) {
			if(teacher.getTeachingSubjectId()==subjectId) {
				teachersdetails.add(teacher);
			}
		}
		return teachersdetails;
	}

	public boolean enrollingSubject(String studentId, String subjectId, String teacherId) {
	  for(TimeTable timetable:timetablelist) {
		  if(timetable.getStudentId().equals(studentId)) {
			  if(timetable.getSubjectId().equals(subjectId)||timetable.getTeacherId().equals(teacherId)) {
				  return false;
			  }
		  }  
	  }
	  Subject subject=null;
	  for(Subject subject2:subjectDetails) {
		  if(subject2.getSubjectId().equals(subjectId)) {
			  subject=subject2;
		  }
	  }
	  Teacher teacher=null;
	  for(Teacher teacher2:teacherDetails) {
			if(teacher2.getUserId().equals(teacherId)) {
				teacher=teacher2;
			}
	  }
	  gradeSheets.add(new GradeSheet(studentId,teacherId,subjectId,subject.getSubjectName(),"NA"));
	  timetablelist.add(new TimeTable(studentId,teacherId,teacher.getUserName()+" "+teacher.getUserLName(),subjectId,subject.getSubjectName(),subject.getSubjectStartDate(),subject.getSubjectEndDate(),subject.getSubjectstartTime(),subject.getSubjectEndTime()));
		return true;
	}
	

	public List<TimeTable> showTimeTable(String studentId) {
		List<TimeTable> timetables=new ArrayList<>();
		for(TimeTable timetable:timetablelist) {
			if(timetable.getStudentId().equals(studentId)) {
				timetables.add(timetable);
			}
		}
		return timetables;
	}

	public Subject getSubject(String teacherId) {
		Teacher teacher=null;
		for(Teacher teacher2:teacherDetails) {
			if(teacher2.getUserId().equals(teacherId)) {
				teacher=teacher2;
			}
	  }
		 Subject subject=null;
		  for(Subject subject2:subjectDetails) {
			  if(subject2.getSubjectId().equals(teacher.getTeachingSubjectId())) {
				  subject=subject2;
			  }
		  }
	 
		return subject;
	}

	public List<GradeSheet> showGradeSheets(String studentId) {
	 List<GradeSheet> gradeSheet=new ArrayList<>();
	 for(GradeSheet grades:gradeSheets) {
		 if(grades.getStudentId().equals(studentId)) {
			 gradeSheet.add(grades);
		 }
		 
	 }
		return gradeSheet ;
	}
	public List<GradeSheet> setGradeSheets(String teacherId){
		List<GradeSheet> gradeSheet=new ArrayList<>();
		for(GradeSheet grades:gradeSheets) {
			if(grades.getTeacherId().equals(teacherId)) {
				gradeSheet.add(grades);
			}
		}
		
		return gradeSheet;
		
	}

}
