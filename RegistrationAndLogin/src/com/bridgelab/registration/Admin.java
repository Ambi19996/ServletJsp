package com.bridgelab.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;


@WebServlet("/adminpage")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ArrayList<Register>list=new ArrayList<Register>();
		list=gettingDao();
		
		HttpSession session=request.getSession();
		session.setAttribute("data", list);
		
		
		String submit=request.getParameter("submit");
		if (submit.equalsIgnoreCase("admin")) {
			out.print("succesfully enter Adminpage");
			RequestDispatcher req=request.getRequestDispatcher("Adminstration.jsp");
			req.forward(request, response);
			
		}
		
	}
//
	
	private ArrayList<Register> gettingDao() {
		ArrayList<Register>data=new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbRegistration","ambi","ambi");
			java.sql.Statement st=con.createStatement();
			System.out.println(con);
		   ResultSet rs=st.executeQuery("select * from register_table");
			while(rs.next()) {
				Register reg=new Register();
				reg.setUsername(rs.getString(1));
				reg.setlusername(rs.getString(2));
				reg.setPassword(rs.getString(3));
				reg.setEmail(rs.getString(4));
				data.add(reg);
					
				}
			
			
				
			
			
		
	} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return data;
	}

	

}
