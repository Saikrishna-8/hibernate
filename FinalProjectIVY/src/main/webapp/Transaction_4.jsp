<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body style="background-color: lightgreen">
<h1>  Perform Debit Or Credit Operation</h1>

<form action="<%=request.getContextPath()%>/Controller?page=dcoperation" method="post">

	<label for="name"> Account Number:</label>
	<input type="text" id="name"name="accnum"><br><br/>

	<label for="name"> Amount:</label>
	<input type="text" id="name"name="amount"><br><br/>
	
	<input type="submit" name="debit" value="Debit From"/>  <input type="submit" name="credit" value="Credit To"/>	
</form>
</body>
</html>