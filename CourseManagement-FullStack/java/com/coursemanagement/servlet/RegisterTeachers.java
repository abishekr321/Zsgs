package com.coursemanagement.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coursemanagement.model.Model;

/**
 * Servlet implementation class RegisterTeachers
 */
@WebServlet("/RegistersTeachers")
public class RegisterTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String mobileNumber = request.getParameter("mobileNumber");
		String subjectId = request.getParameter("subject");
		String password = (String) request.getAttribute("password");
		HttpSession session = request.getSession();
		if (session.getAttribute("model") == null) {
			model = new Model();
			session.setAttribute("model", model);
		} else {
			model = (Model) session.getAttribute("model");
		}
		String teacherId = model.addTeachers(firstName, lastName, emailAddress, mobileNumber, subjectId, password);
		session.setAttribute("newteacherId", teacherId);
		if (teacherId.length() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Teacher/TeacherLogin.jsp");
			rd.forward(request, response);

		} else {
			session.setAttribute("registerTeachers", "Failed to Register.....");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
