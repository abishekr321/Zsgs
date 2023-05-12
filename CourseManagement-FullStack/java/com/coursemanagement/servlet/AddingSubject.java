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
 * Servlet implementation class AddingSubject
 */
@WebServlet("/AddingSubject")
public class AddingSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		String subjectName = request.getParameter("subjectName");
		String startingDate = request.getParameter("startingDate");
		String endingDate = request.getParameter("endingDate");
		String startingTime = request.getParameter("startingTime");
		String endingTime = request.getParameter("endingTime");
		HttpSession session = request.getSession();
		if (session.getAttribute("model") == null) {
			model = new Model();
			session.setAttribute("model", model);
		} else {
			model = (Model) session.getAttribute("model");
		}
		if (model.addSubjects(subjectId, subjectName, startingDate, endingDate, startingTime, endingTime)) {
			session.setAttribute("addSubjectSuccess", "Added Successfully!");
			response.sendRedirect("Admin/AdminSetup.jsp");

		} else {
			session.setAttribute("addSubjectFailure", "Already Exist,Failed To Add");
			response.sendRedirect("Admin/AdminSetup.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
