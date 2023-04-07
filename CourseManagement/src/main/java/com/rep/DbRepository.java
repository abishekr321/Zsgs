package com.rep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public boolean validAdmin(String userName,String password) {
		String query="select * from admindetails where adminName=? and adminPassword=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet set=statement.executeQuery();
			if(set.next())
			{ 
				return true;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		}

	public ResultSet getteacherCourses() {
		String query="select courseId,courseName from coursedetails";
		try {
			statement=connection.prepareStatement(query);
			ResultSet set=statement.executeQuery();
			return set;
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public boolean validStudent(String userId, String password) {
		String query="select * from studentdetails where studentId=? and Password=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, password);
			ResultSet set=statement.executeQuery();
			if(set.next())
			{ 
				return true;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		}
	

	public boolean validTeacher(String userId, String password) {
		String query="select * from teacherdetails where teacherId=? and Password=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, password);
			ResultSet set=statement.executeQuery();
			if(set.next())
			{ 
				return true;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		}

	public boolean addSubjects(String subjectId, String subjectName, String startingDate, String endingDate,
			String startingTime, String endingTime) {
		String query="Insert into coursedetails values(?,?,?,?,?,?)";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1,subjectId);
			statement.setString(2, subjectName);
			statement.setString(3, startingDate);
			statement.setString(4, endingDate);
			statement.setString(5, startingTime);
			statement.setString(6, endingTime);
			 int val=statement.executeUpdate();
			 if(val>0) {
				 return true;
			 }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public ResultSet showCourses() {
		String query="select * from coursedetails";
		try {
			statement=connection.prepareStatement(query);
			ResultSet set=statement.executeQuery();
				return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ResultSet showTeachers() {
		String query="select teacherdetails.teacherId,teacherdetails.teacherName,teacherdetails.emailAddress,teacherdetails.mobileNumber,teacherdetails.courseId,coursedetails.courseName,teacherdetails.slot from teacherdetails inner join coursedetails on coursedetails.courseId=teacherdetails.courseId";
		try {
			statement=connection.prepareStatement(query);
			ResultSet set=statement.executeQuery();
				return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	public ResultSet showStudents() {
		String query="select * from studentdetails";
		try {
			statement=connection.prepareStatement(query);
			ResultSet set=statement.executeQuery();
				return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ResultSet showteacherStudents(String teacherId) {
		String query="select * from studentdetails inner join gradesheet on studentdetails.studentId=gradesheet.studentId where gradesheet.teacherId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, teacherId);
			ResultSet set=statement.executeQuery();
			return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	
	}

	public ResultSet getCourseTeachers(String courseId) {
		String query="select * from teacherdetails where courseId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, courseId);
			ResultSet set=statement.executeQuery();
			return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	public ResultSet viewTimeTable(String studentId) {
		String query="select * from coursedetails inner join gradesheet on coursedetails.courseId=gradesheet.courseId inner join teacherdetails on gradesheet.teacherId=teacherdetails.teacherId where gradeSheet.studentId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, studentId);
			ResultSet set=statement.executeQuery();
			return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ResultSet viewGradeSheet(String studentId) {
		String query="select coursedetails.courseId,coursedetails.courseName,gradeSheet.GradeSheet from coursedetails inner join gradesheet on coursedetails.courseId=gradesheet.courseId where gradeSheet.studentId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, studentId);
			ResultSet set=statement.executeQuery();
			return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	public ResultSet getteacherGradeSheet(String teacherId) {
		String query="select studentdetails.studentId,studentdetails.studentName,gradeSheet.GradeSheet from gradesheet inner join studentdetails on studentdetails.studentId=gradesheet.studentId  where gradesheet.teacherId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, teacherId);
			ResultSet set=statement.executeQuery();
			return set;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
		
	}

	public boolean deleteSubjects(String courseId) {
		String query="delete from coursedetails where courseId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1,courseId);
			int val=statement.executeUpdate();
			if(val>0) {
				return true;
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean enrollCourses(String studentId,String courseId, String teacherId) {
		String query="Insert into gradesheet values(?,?,?,?)";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, studentId);
			statement.setString(2, courseId);
			statement.setString(3, teacherId);
			statement.setString(4, "NA");
			 int val=statement.executeUpdate();
			 if(val>0) {
				 updateTeachSlot(teacherId);
				 return true;
			 }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	

	private void updateTeachSlot(String teacherId) {
		String query=
				
		
		
		
	}

	public String addStudents(String firstName, String lastName, String emailAddress, String mobileNumber,
			String password) {
		String query="Insert into studentdetails values(?,?,?,?,?)";
		try {
			ResultSet set=showStudents();
			int num=1;
			while(set.next()) {
					num++;
				}

			
			String studentId=2023+""+11+""+num;
			statement=connection.prepareStatement(query);
			statement.setString(1, studentId);
			statement.setString(2, firstName+" "+lastName);
			statement.setString(3, emailAddress);
			statement.setString(4, mobileNumber);
			statement.setString(5, password);
			 int val=statement.executeUpdate();
			 if(val>0) {
				 return studentId;
			 }
		}
		catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		return "";
		
		
	}

	public String addTeachers(String firstName, String lastName, String emailAddress, String mobileNumber,
			String subjectId, String password) {
		String query="Insert into teacherdetails values(?,?,?,?,?,?,?)";
		try {
		
			ResultSet set=showTeachers();
			int num=1;
			while(set.next()) {
					num++;
				}
		
			String teacherId=2023+""+10+""+num;
			statement=connection.prepareStatement(query);
			statement.setString(1, teacherId);
			statement.setString(2, firstName+" "+lastName);
			statement.setString(3, emailAddress);
			statement.setString(4, mobileNumber);
			statement.setString(5, subjectId);
			statement.setInt(6, 100);
			statement.setString(7, password);
			 int val=statement.executeUpdate();
			 if(val>0) {
				 return teacherId;
			 }
		}
		catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
		
		return "";
	
	}

	

	public void updateGradeSheet(String studentId, String teacherId, String grades) {
		String query="update gradesheet set Gradesheet=? where studentId=? and teacherId=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, grades);
			statement.setString(2, studentId);
			statement.setString(3, teacherId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	
	
	

}
