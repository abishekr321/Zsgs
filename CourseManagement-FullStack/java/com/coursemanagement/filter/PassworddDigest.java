package com.coursemanagement.filter;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/TeachersLogin", "/StudentsLogin", "/RegistersStudents", "/RegistersTeachers" })
public class PassworddDigest implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String password = request.getParameter("password");
		request.removeAttribute("password");
		request.setAttribute("password", HashingString(password));
		filterChain.doFilter(request, response);

	}

	public static String HashingString(String input) {
		try {
			MessageDigest msgDst = MessageDigest.getInstance("MD5");
			byte[] msgArr = msgDst.digest(input.getBytes());
			BigInteger bi = new BigInteger(1, msgArr);
			String hshtxt = bi.toString(16);
			while (hshtxt.length() < 20) {
				hshtxt = "0" + hshtxt;
			}

			return hshtxt.substring(0, 20);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
