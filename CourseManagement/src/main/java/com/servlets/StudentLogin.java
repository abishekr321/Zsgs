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
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("userName");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(session.getAttribute("model")==null) {
		model=new Model();
		session.setAttribute("model",model);
		}
		else {
			model=(Model) session.getAttribute("model");
		}
		
		if(model.checkStudentLogin(uId, password)) {
			session.setAttribute("studentId", uId);
			response.sendRedirect("studentMenu.jsp");
		}
		else {
			session.setAttribute("failmsg","Invalid Credentials");
			response.sendRedirect("studentLogin.jsp");
		}
	   

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
