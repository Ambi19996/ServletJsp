package com.bridgelab.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logoutpage")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button=request.getParameter("logout");
		if (button.equalsIgnoreCase("logout")) {
			RequestDispatcher req=request.getRequestDispatcher("login.jsp");
			req.forward(request, response);
			
		}
	}

	

}
