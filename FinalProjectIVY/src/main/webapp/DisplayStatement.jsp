<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection,org.sai.servlets.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!Connection con = null;%>
	<%!String message() {

	System.out.println("sai yadav");

	//Document.write("sai");
	return "I LOVE KRISHNA";
}%>
	<%
	//boolean flag=false;
	String sd = (request.getParameter("sdate") != null) ? request.getParameter("sdate") : "1900-07-29";
	String ed = (request.getParameter("edate") != null) ? request.getParameter("edate") : "1920-12-29";
	%>

	<form action="<%=request.getContextPath()%>/DisplayStatement.jsp"
		method="post">
		<table style="width: 50%">
			<tr>
				<td>Select Date Range</td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="date" name="sdate" value="<%=sd%>" /></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="date" name="edate" value="<%=ed%>" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Display"> <br /> <br />
	</form>
	<%
	if (ed!="1920-12-29") {

		//PrintWriter out=response.getWriter();
		con = DatabaseConnection.initializeDatabase();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		//String date_str = dtf.format(sd);
		String query = "select * from transactions where Tdate>=? and Tdate<=? ";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, sd);
		pst.setString(2, ed);

		ResultSet rs = pst.executeQuery();
		out.println("<table border=1 width=80% height=70% >");
		out.println(
		"<tr><th>Account Number</th><th>Date</th><th> Description</th> <th> Cheque NO</th><th> WithDraw </th><th>Deposit</th><th> Available Balence </th><tr>");
		while (rs.next()) {

			String s4 = "";
			if (rs.getInt(4) != 0) {
		s4 += rs.getInt(4);
			}

			String s5 = "";
			if (rs.getDouble(5) != 0) {
		s5 += rs.getDouble(5);
			}
			String s6 = "";
			if (rs.getDouble(6) != 0) {
		s6 += rs.getDouble(6);
			}

			out.println(
			"<tr><td>" + rs.getString(1) + "</td><td>" + rs.getDate(2) + "</td><td>" + rs.getString(3) + "</td><td>"
					+ s4 + "</td><td>" + s5 + "</td><td>" + s6 + "</td><td>" + rs.getDouble(7) + "</td></tr>");
		}
		out.println("</table>");

	}
	%>
</body>
</html>