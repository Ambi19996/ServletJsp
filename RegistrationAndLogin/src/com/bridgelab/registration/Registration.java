package com.bridgelab.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Register")
public class Registration extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		
		Register reg=new Register();
		
		String username=request.getParameter("username");
		String lusername=request.getParameter("lusername");
		String password=request.getParameter("Password");
		String email=request.getParameter("Email");
		
		String submitvalied=request.getParameter("submit");
		
//			RequestDispatcher reg1=request.getRequestDispatcher("Frontpage.jsp");
//			reg1.forward(request, response);
//		}
//	
		
		reg.setUsername(username);
		reg.setlusername(lusername);
		reg.setPassword(password);
		reg.setEmail(email);
		
		
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbRegistration","ambi","ambi");
			PreparedStatement pre=con.prepareStatement("insert into register_table(username,lusername,password,email) values(?,?,?,?)");					
			pre.setString(1,username);
			pre.setString(2,lusername);
			pre.setString(3, password);
			pre.setString(4, email);						
			pre.execute();
			if (submitvalied.equalsIgnoreCase("register")) {
			RequestDispatcher reg1=request.getRequestDispatcher("login.jsp");
			reg1.forward(request, response);
			}
			
			if (submitvalied.equalsIgnoreCase("cancel")) {
				RequestDispatcher reg1=request.getRequestDispatcher("Frontpage.jsp");
				reg1.forward(request, response);
				
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

	