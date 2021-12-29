<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color: lightgreen">

	
		<h1>Banking System</h1>

		<form action="<%= request.getContextPath() %>/Controller?page=login" method="post">
			<table style="width: 50%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="user" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" /></td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="Login" />
		</form>
	</body>
</html>