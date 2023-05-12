package com.coursemanagement.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.coursemanagement.dto.TeacherDetails;
import com.coursemanagement.model.Model;

/**
 * Servlet implementation class StudentViewTeachers
 */
@WebServlet("/StudentViewTeachers")
public class StudentViewTeachers extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Model model;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseId = request.getParameter("courseId");
		HttpSession session = request.getSession();
		if (session.getAttribute("model") == null) {
			model = new Model();
			session.setAttribute("model", model);
		} else {
			model = (Model) session.getAttribute("model");
		}
		List<TeacherDetails> teacherDetails = model.getCourseTeachers(courseId);
		JSONArray jsonArray = new JSONArray();
		for (TeacherDetails teacher : teacherDetails) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("teacherId", teacher.getTeacherId());
			jsonObject.put("teacherName", teacher.getTeacherName());
			jsonObject.put("courseId", teacher.getCourseId());
			jsonObject.put("slot", teacher.getSlot());
			jsonArray.add(jsonObject);
		}
		response.getWriter().print(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
