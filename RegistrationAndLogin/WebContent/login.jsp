<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="styleesheet" type="text/css" href ="${pageContext.request.contextPath}/css/login.css ">
</head>

<body>

<form action="Login" method="post">
<div class="center">
<h1>Login Form</h1>
UserNAME*<br></br><input type="text" placeholder="Enter UserNAME" name="loginname"><br></br>
Password*<br></br><input type="password" placeholder="Enter Password" name="Password"><br></br>
<br></br>
<input type="submit" value="login">
<input type="submit" value="cancel">
</div>
</form>

</body>
</html>