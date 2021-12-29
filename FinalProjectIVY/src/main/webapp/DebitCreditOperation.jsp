<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightgreen">
	<h1>Debit or Credit Operation</h1>

	<form action="<%=request.getContextPath()%>/Controller?page=dcoperation" method="post">
		<table style="width: 50%">
			<tr>
				<td>Account Number</td>
				<td><input type="text" name="acnumber" /></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Credit To" /><input type="submit" value="Debit From"/>
	</form>

</body>
</html>