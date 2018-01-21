package com.jwt.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.UserDAO;

public class UserControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//HttpSession session = request.getSession(true);
		try {
			UserDAO userDAO = new UserDAO();
			userDAO.addUserDetails(firstName, lastName, age);
			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
