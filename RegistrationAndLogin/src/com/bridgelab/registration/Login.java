package com.bridgelab.registration;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;


 
/**
 *author :ambi
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String username=request.getParameter("loginname");
		String password=request.getParameter("Password");
		PrintWriter out=response.getWriter();
		boolean str=validate(username,password);
		if (str==true) {
			out.print("its is successfully");
			if (str) {
				if (username.equals("admin"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
					rd.forward(request, response);
				}
			}
		}
		else {
			out.print("please check username and password");
		}
		
	}
       
	public static boolean validate(String username,String password) {
		
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbRegistration","ambi","ambi");
			PreparedStatement pre=con.prepareStatement("select*from register_table where username=? and password=?");
		     pre.setString(1,username );
		     pre.setString(2,password );
		    
    
		     ResultSet rs=pre.executeQuery();
		     while(rs.next()) {
		    	 if(username.equals(rs.getString(1)) && password.equals(rs.getString(3)))
		    		 status= true;
		    	 else
		    		 status=false;
		    	 
		     }
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return status;
				
	}
	
}
