<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="styleesheet" type="text/css" href ="${pageContext.request.contextPath}/css/Registration.css ">
</head>

<body>

<form action="Register" method="post">
<h1 align="center">Registration Form</h1>
<div class="center">
FirstNAME*<br></br><input type="text" placeholder="Enter NAME" name="username"><br></br>
lusername*<br></br><input type="text" placeholder="Enter NAME" name="lusername"><br></br>
Password*<br></br><input type="password" placeholder="Enter Password" name="Password"><br></br>
Email*<br></br><input type="text" placeholder="Enter Email" name="Email"><br></br>
<br></br>
<input type="submit" value="register" name="submit">
<input type="submit" value="cancel" name="submit">
</div>
</form>

</body>
</html>