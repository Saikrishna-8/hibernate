<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightgreen">

	<h1>Account Creation Screen</h1>

	<form action="<%= request.getContextPath()%>/Controller?page=CreateAccount" method="post">
		<table style="width: 50%">
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" /> <br/></td> 
			</tr>
			<tr>
				<td>Date of Birth </td>
				<td><input type="datetime" name="dob" value="YYYY-MM-DD"/>  </td>
			</tr>
			<tr>
				<td>Email ID: </td>
				<td><input type="text" name="email" /> <br/> </td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><textarea id="address" name="address" rows="4" cols="50"></textarea><br/></td>
			</tr>
			<tr>
				<td>Account Type </td>
				<td><select name="account" id="account">
  								<option value="SB Account">SB Account</option>
  								<option value="Current Account">Current Account</option>
							</select> <br/></td>
			</tr>
		</table>
			<input	type="submit" value="Submit">
				 
	</form>
</body>
</html>