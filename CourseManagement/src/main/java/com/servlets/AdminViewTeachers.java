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
 * Servlet implementation class adminViewTeachers
 */
@WebServlet("/AdminViewTeachers")
public class AdminViewTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private Model model;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
			if(session.getAttribute("model")==null) {	
			model=new Model();
			session.setAttribute("model",model);
			}
			else {
				  model=(Model) session.getAttribute("model");
			}
			ResultSet set=model.showTeachers();
			request.setAttribute("viewTeachers",set);
			RequestDispatcher rd=request.getRequestDispatcher("viewTeachers.jsp");
			rd.forward(request, response);
		  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
