package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class teacherViewStudents
 */
@WebServlet("/TeacherViewStudents")
public class TeacherViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Model model;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String teacherId=(String) session.getAttribute("teacherId");
			if(session.getAttribute("model")==null) {	
			model=new Model();
			session.setAttribute("model",model);
			}
			else {
				  model=(Model) session.getAttribute("model");
			}
			ResultSet set=model.showteacherStudents(teacherId);
			request.setAttribute("teacherStudents",set);
			RequestDispatcher rd=request.getRequestDispatcher("teacherStudents.jsp");
			rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
