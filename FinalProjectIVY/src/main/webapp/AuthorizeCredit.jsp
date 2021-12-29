<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightgreen">
<h1> Authorize Credit Card</h1>

<form action="<%= request.getContextPath() %>/Controller?page=auth" method="post">
			<table style="width: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Card Number</td>
					<td><input type="text" name="card" /></td>
				</tr>
				
				<tr>
					<td>CVV </td>
					<td><input type="password" name="cvv" /></td>
				</tr>
				
				<tr>
					<td> Amount</td>
					<td><input type="text" name="amount" /></td>
				</tr>
				
				
			</table>
			<br/>
			<input type="submit" value="Authorize" />
		</form>
</body>
</html>