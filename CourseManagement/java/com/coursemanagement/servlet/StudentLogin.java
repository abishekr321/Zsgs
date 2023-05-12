package com.coursemanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coursemanagement.model.Model;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentsLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("userName");
		String password = (String) request.getAttribute("password");
		HttpSession session = request.getSession();
		if (session.getAttribute("model") == null) {
			model = new Model();
			session.setAttribute("model", model);
		} else {
			model = (Model) session.getAttribute("model");
		}

		if (model.checkStudentLogin(studentId, password)) {
			session.setAttribute("studentId", studentId);
			response.sendRedirect("Student/StudentMenu.jsp");
		} else {
			session.setAttribute("failmsg", "Invalid Credentials");
			response.sendRedirect("Student/StudentLogin.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
