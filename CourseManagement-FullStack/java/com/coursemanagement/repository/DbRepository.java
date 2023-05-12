package com.coursemanagement.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.coursemanagement.dto.CourseDetails;
import com.coursemanagement.dto.GradeSheet;
import com.coursemanagement.dto.StudentDetails;
import com.coursemanagement.dto.TeacherDetails;
import com.coursemanagement.dto.TimeTable;

public class DbRepository {
	private static DbRepository databaseAccess;
	private PreparedStatement statement;
	private static Connection connection;

	private DbRepository() {
		statement = null;
		connection = null;
	}

	public static DbRepository getInstance() {
		if (databaseAccess == null) {
			databaseAccess = new DbRepository();
			connection = databaseAccess.executeConnection();

		}
		return databaseAccess;
	}

	private Connection executeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/CourseManagement";
		String username = "root";
		String password = "Appu@321";
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean validAdmin(String userName, String password) {
		String query = "select * from admindetails where adminName=? and adminPassword=?";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List<CourseDetails> getteacherCourses() {
		String query = "select courseId,courseName from coursedetails";
		List<CourseDetails> teacherCourses = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				CourseDetails courseDetails = new CourseDetails();
				courseDetails.setCourseId(set.getString("courseId"));
				courseDetails.setCourseName(set.getString("courseName"));
				teacherCourses.add(courseDetails);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return teacherCourses;
	}

	public boolean validStudent(String userId, String password) {
		String query = "select * from studentdetails where studentId=? and Password=?";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, password);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean validTeacher(String userId, String password) {
		String query = "select * from teacherdetails where teacherId=? and Password=?";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, password);
			ResultSet set = statement.executeQuery();
			return set.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean addSubjects(String subjectId, String subjectName, String startingDate, String endingDate,
			String startingTime, String endingTime) {
		String query = "Insert into coursedetails values(?,?,?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, subjectId);
			statement.setString(2, subjectName);
			statement.setDate(3, Date.valueOf(startingDate));
			statement.setDate(4, Date.valueOf(endingDate));
			statement.setTime(5, Time.valueOf(startingTime));
			statement.setTime(6, Time.valueOf(endingTime));
			statement.setString(7, "Active");
			int val = statement.executeUpdate();
			if (val > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	public List<CourseDetails> showCourses() {
		String query = "select * from coursedetails where status='Active'";
		List<CourseDetails> courses = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				CourseDetails courseDetails = new CourseDetails();
				courseDetails.setCourseId(set.getString("courseId"));
				courseDetails.setCourseName(set.getString("courseName"));
				courseDetails.setStartingDate(set.getDate("startingDate"));
				courseDetails.setEndingDate(set.getDate("endingDate"));
				courseDetails.setStartingTime(set.getTime("startingTime"));
				courseDetails.setEndingTime(set.getTime("endingTime"));
				courses.add(courseDetails);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courses;
	}

	public List<TeacherDetails> showTeachers() {
		String query = "select t.*,c.courseName from teacherdetails t inner join coursedetails c on t.courseId=c.courseId where t.Status='Active'";
		List<TeacherDetails> teachers = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				TeacherDetails teacherDetails = new TeacherDetails();
				teacherDetails.setTeacherId(set.getString("teacherId"));
				teacherDetails.setTeacherName(set.getString("teacherName"));
				teacherDetails.setCourseId(set.getString("courseId"));
				teacherDetails.setCourseName(set.getString("courseName"));
				teacherDetails.setEmailAddress(set.getString("emailAddress"));
				teacherDetails.setMobileNumber(set.getString("mobileNumber"));
				teacherDetails.setSlot(set.getInt("slot"));
				teachers.add(teacherDetails);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teachers;

	}

	public List<StudentDetails> showStudents() {
		String query = "select * from studentdetails where status='Active'";
		List<StudentDetails> students = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				StudentDetails studentDetails = new StudentDetails();
				studentDetails.setStudentId(set.getString("studentId"));
				studentDetails.setStudentName(set.getString("studentName"));
				studentDetails.setEmailAddress(set.getString("emailAddress"));
				studentDetails.setMobileNumber(set.getString("mobileNumber"));
				students.add(studentDetails);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;
	}

	public List<GradeSheet> showteacherStudents(String teacherId) {
		String query = "select * from studentdetails inner join gradesheet on studentdetails.studentId=gradesheet.studentId where gradesheet.teacherId=?";
		List<GradeSheet> teacherStudents = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, teacherId);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				GradeSheet gradeSheet = new GradeSheet();
				gradeSheet.setStudentId(set.getString("studentId"));
				gradeSheet.setStudentName(set.getString("studentName"));
				gradeSheet.setGrade(set.getString("GradeSheet"));
				teacherStudents.add(gradeSheet);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teacherStudents;

	}

	public List<TeacherDetails> getCourseTeachers(String courseId) {
		String query = "select * from teacherdetails where courseId=?";
		List<TeacherDetails> courseTeachers = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, courseId);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				if (set.getInt("slot") > 0) {
					TeacherDetails teacherDetails = new TeacherDetails();
					teacherDetails.setTeacherId(set.getString("teacherId"));
					teacherDetails.setTeacherName(set.getString("teacherName"));
					teacherDetails.setCourseId(set.getString("courseId"));
					teacherDetails.setSlot(set.getInt("slot"));
					courseTeachers.add(teacherDetails);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courseTeachers;

	}

	public List<TimeTable> viewTimeTable(String studentId) {
		String query = "select * from coursedetails inner join gradesheet on coursedetails.courseId=gradesheet.courseId inner join teacherdetails on gradesheet.teacherId=teacherdetails.teacherId where gradeSheet.studentId=?";
		List<TimeTable> timetables = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, studentId);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				TimeTable timetable = new TimeTable();
				timetable.setCourseId(set.getString("courseId"));
				timetable.setCourseName(set.getString("courseName"));
				timetable.setTeacherName(set.getString("teacherName"));
				timetable.setEndingDate(set.getDate("endingDate"));
				timetable.setStartingDate(set.getDate("startingDate"));
				timetable.setStartingTime(set.getTime("startingTime"));
				timetable.setEndingTime(set.getTime("endingTime"));
				timetables.add(timetable);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return timetables;
	}

	public List<GradeSheet> viewGradeSheet(String studentId) {
		String query = "select coursedetails.courseId,coursedetails.courseName,gradeSheet.GradeSheet from coursedetails inner join gradesheet on coursedetails.courseId=gradesheet.courseId where gradeSheet.studentId=?";
		List<GradeSheet> gradeSheets = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, studentId);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				GradeSheet gradeSheet = new GradeSheet();
				gradeSheet.setCourseId(set.getString("courseId"));
				gradeSheet.setCourseName(set.getString("courseName"));
				gradeSheet.setGrade(set.getString("GradeSheet"));
				gradeSheets.add(gradeSheet);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gradeSheets;

	}

	public List<GradeSheet> getteacherGradeSheet(String teacherId) {
		String query = "select studentdetails.studentId,studentdetails.studentName,gradeSheet.GradeSheet from gradesheet inner join studentdetails on studentdetails.studentId=gradesheet.studentId  where gradesheet.teacherId=?";
		List<GradeSheet> teachergradeSheets = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, teacherId);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				GradeSheet gradeSheet = new GradeSheet();
				gradeSheet.setStudentId(set.getString("studentId"));
				gradeSheet.setStudentName(set.getString("studentName"));
				gradeSheet.setGrade(set.getString("GradeSheet"));
				teachergradeSheets.add(gradeSheet);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teachergradeSheets;

	}

	public boolean deleteSubjects(String courseId) {
		String query = "update coursedetails set status='InActive' where courseId=?";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, courseId);
			int val = statement.executeUpdate();
			if (val > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	public boolean enrollCourses(String studentId, String courseId, String teacherId) {
		String query = "Insert into gradesheet values(?,?,?,?)";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, studentId);
			statement.setString(2, courseId);
			statement.setString(3, teacherId);
			statement.setString(4, "NA");
			int val = statement.executeUpdate();
			if (val > 0) {
				updateTeachSlot(teacherId);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	private void updateTeachSlot(String teacherId) {
		String query = "update teacherdetails set slot=slot-1 where teacherId=?";
		try {
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String addStudents(String firstName, String lastName, String emailAddress, String mobileNumber,
			String password) {
		String query = "Insert into studentdetails values(?,?,?,?,?,?)";
		try {

			int num = 1;
			num += showStudents().size();
			String studentId = 2023 + "" + 11 + "" + num;
			statement = connection.prepareStatement(query);
			statement.setString(1, studentId);
			statement.setString(2, firstName + " " + lastName);
			statement.setString(3, emailAddress);
			statement.setString(4, mobileNumber);
			statement.setString(5, password);
			statement.setString(6, "Active");
			int val = statement.executeUpdate();
			if (val > 0) {
				return studentId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	public String addTeachers(String firstName, String lastName, String emailAddress, String mobileNumber,
			String subjectId, String password) {
		String query = "Insert into teacherdetails values(?,?,?,?,?,?,?,?)";
		try {

			int num = 1;
			num += showTeachers().size();

			String teacherId = 2023 + "" + 10 + "" + num;
			statement = connection.prepareStatement(query);
			statement.setString(1, teacherId);
			statement.setString(2, firstName + " " + lastName);
			statement.setString(3, emailAddress);
			statement.setString(4, mobileNumber);
			statement.setString(5, subjectId);
			statement.setInt(6, 50);
			statement.setString(7, "Active");
			statement.setString(8, password);
			int val = statement.executeUpdate();
			if (val > 0) {
				return teacherId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return null;

	}

	public void updateGradeSheet(String studentId, String teacherId, String grades) {
		String query = "update gradesheet set Gradesheet=? where studentId=? and teacherId=?";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, grades);
			statement.setString(2, studentId);
			statement.setString(3, teacherId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
