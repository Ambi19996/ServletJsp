<%@page import="com.bridgelab.registration.Register" %>
<%@page import="java.util.ArrayList" %>
<%@  page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
<body>
	<table border="1px solid blue" >
	<tr>
	<th>Username</th>
	<th>Lusername</th>
	<th>Password</th>
	<th>Email</th>
	</tr>
<%
ArrayList<Register> newlist=(ArrayList<Register>)session.getAttribute("data");

for( Register al:newlist)
{
	%>
	
	
	<tr>
	<td><%= al.getUsername()%></td>
	<td><%= al.getlusername() %></td>
	<td><%= al.getPassword() %></td>
	<td><%= al.getEmail() %></td></tr>
	
	
<%
}

%>
</table>
<form action ="pagingpage" method ="post">
<a href="Pagination?page=1">view data</a>
</form>
</body>
</html>