package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class UpdateGradeSheet
 */
@WebServlet("/UpdateGradeSheet")
public class UpdateGradeSheet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Model model;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String teacherId= (String) session.getAttribute("teacherId");
			if(session.getAttribute("model")==null) {	
			model=new Model();
			session.setAttribute("model",model);
			}
			else {
				  model=(Model) session.getAttribute("model");
			}
			
			ResultSet set=model.getteacherGradeSheet(teacherId);
			try {
				while(set.next()) {
					String studentId = set.getString(1);
					String grades=request.getParameter(studentId);
					model.updateGradeSheet(studentId,teacherId,grades);
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("teacherMenu.jsp");
			
			

	        	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
