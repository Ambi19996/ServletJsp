package com.bridgelab.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;


@WebServlet("/pagingpage")
public class Pagination extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String spageid=request.getParameter("page");
		int pageid=Integer.parseInt(spageid);
         int total=5;
         
         if (pageid==1) {
        	 
		}
         else {
			pageid=pageid-1;
			pageid=pageid*total+1;
		}
		ArrayList<Register>list=getrecord(pageid,total);
		HttpSession sesson=request.getSession();
		sesson.setAttribute("data", list);
		
		    
		
	        
	        
	        out.print("</table>");
	        
	        out.print("<a href='Pagination?page=1'>1</a>");
	        out.print("<a href='Pagination?page=2'>2</a>");
	        out.print("<a href='Pagination?page=3'>3</a>");
		out.close();
		
		
	}

	private ArrayList<Register> getrecord(int start, int total) {
		ArrayList<Register>list=new ArrayList<Register>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbRegistration","ambi","ambi");
	      
			PreparedStatement st=con.prepareStatement("select* from register_table"+(start-1)+","+total);
	        ResultSet rs=st.executeQuery();
	       
	        
	        	
	        	while (rs.next()) {
	        		Register reg=new Register();
	        		reg.setUsername(rs.getString(1));
	        		reg.setlusername(rs.getString(2));
	        		reg.setPassword(rs.getString(3));
	        		reg.setEmail(rs.getString(4));
	        		list.add(reg);
	        		
					
				}
	        	con.close();
	        	
		} catch (Exception e) {
			
		}
		
		
		return list;
	}

}
