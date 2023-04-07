package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class EnrollStudents
 */
@WebServlet("/EnrollStudents")
public class EnrollStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Model model;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
	      if(session.getAttribute("teacherId")==null){
	     	response.sendRedirect("studentMenu.jsp");
	     	
	     }
	     	
		  
		 String subjectId= request.getParameter("courseId");
		 String teacherId= request.getParameter("teacherId");
		   
		    String studentId=(String) session.getAttribute("studentId");
			if(session.getAttribute("model")==null) {	
			model=new Model();
			session.setAttribute("model",model);
			}
			else {
				  model=(Model)session.getAttribute("model");
			}
			if(model.enrollCourses(studentId,subjectId,teacherId)) {
				session.setAttribute("enrollSuccess", "Enrolled Successfully!...");
			    response.sendRedirect("studentMenu.jsp");
				
			}
			else {
				session.setAttribute("enrollFailure","Failed to Enroll.....");
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
