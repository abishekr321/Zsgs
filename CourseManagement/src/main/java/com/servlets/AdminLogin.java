package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.Model;

@WebServlet("/AdminLogin")
public class  AdminLogin extends HttpServlet {
	/**
	 * 
	 */
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
		
		
		
		if(model.checkAdminLogin(uId, password)) {
			session.setAttribute("adminId", uId);
			response.sendRedirect("adminSetup.jsp");
		}
		else {
			session.setAttribute("failmsg","Invalid Credentials");
			response.sendRedirect("adminLogin.jsp");
		}
	   

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doGet(request, response);
		
//
//		
//		HttpSession session=request.getSession();
//		session.setAttribute("userName", userName );
//		Cookie cookie =new Cookie("Name",userName);
//		response.addCookie(cookie);
//		response.addCookie(new Cookie("user",user));
//		
//		response.sendRedirect("summa");
		//RequestDispatcher rd=request.getRequestDispatcher("summa");
		//rd.forward(request, response);
	}

}
