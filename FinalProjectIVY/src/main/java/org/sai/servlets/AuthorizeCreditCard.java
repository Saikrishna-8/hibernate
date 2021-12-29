package org.sai.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Thread;

public class AuthorizeCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorizeCreditCard() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection con = DatabaseConnection.initializeDatabase();

		String name = request.getParameter("name");
		String card = request.getParameter("card");
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		double amount = Double.parseDouble(request.getParameter("amount"));

		String query = "select * from credit_card where card_number=? and cvv=? and available_balence>=?";
		try {
			PreparedStatement pstat = con.prepareStatement(query);
			pstat.setString(1, card);
			pstat.setInt(2, cvv);
			pstat.setDouble(3, amount);

			ResultSet rs = pstat.executeQuery();
			if (rs.next() && amount <= 100000) {

				    out.println("<html><body>");
				    out.println("<script type=\"text/javascript\">");
				    out.println("var popwin = window.open(\"popup1.jsp\")");
				    out.println("setTimeout(function(){ popwin.close(); window.location.href='mainDisplay_2.jsp';},4000)");
				    out.println("</script>");
				    out.println("</body></html>");
			} else {
				 out.println("<html><body>");
				    out.println("<script type=\"text/javascript\">");
				    out.println("var popwin = window.open(\"popup2.jsp\")");
				    out.println("setTimeout(function(){ popwin.close(); window.location.href='AuthorizeCredit.jsp';},4000)");
				    out.println("</script>");
				    out.println("</body></html>");
				
			}
		} catch (SQLException e) {
			out.print(e.getMessage());
		}
	}

}
