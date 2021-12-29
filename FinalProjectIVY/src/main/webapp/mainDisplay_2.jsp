<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
</head>
<body style="background-color: lightgreen">
	<h1 style="text-align: center">Banking System</h1>
	
	<br/><br/><br/>
	<a href="<%= request.getContextPath() %>/Controller?page=createaccount">Create Account</a><br/><br/>
	<a href="<%= request.getContextPath() %>/Controller?page=transaction">Transaction</a><br/><br/>
	<a href="<%= request.getContextPath() %>/Controller?page=display">Display Bank Statement</a><br/><br/>
	<a href="<%= request.getContextPath() %>/Controller?page=authcredit">Authorize Credit Card Transaction</a>
		
</body>
</html>