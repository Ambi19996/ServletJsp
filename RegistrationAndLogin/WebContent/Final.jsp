<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.bridgelab.registration.Register" %>
<!DOCTYPE html>
<html>

<body>
<h1>Page No:spageid</h1>;  
	        <table border='1' cellpadding='4' width='60%'>;  
	        <tr><th>Username</th><th>lusername</th><th>Password</th><th>Email</th></tr>

<%
ArrayList<Register>list=(ArrayList<Register>)session.getAttribute("data");
for (Register r:list) 
{
%>

<tr>
	<td><%= r.getUsername()%></td>
	<td><%= r.getlusername() %></td>
	<td><%= r.getPassword() %></td>
	<td><%= r.getEmail() %></td></tr>
     

			<% 	
			}
	        
	       %>
	        
</body>
</html>