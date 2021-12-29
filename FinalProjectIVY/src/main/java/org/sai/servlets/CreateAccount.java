package org.sai.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateAccount() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accNumber = getAccNumber();
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");

		String dob = request.getParameter("dob");
		String email = request.getParameter("email");

		String address = request.getParameter("address");

		String account = request.getParameter("account");

		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String query = "insert into account_details values(?,?,?,?,?,?,?,?)";
			PreparedStatement stat = con.prepareStatement(query);
			stat.setString(1, Login.UserName);
			stat.setString(2, accNumber);
			stat.setString(3, name);
			stat.setString(4, dob);
			stat.setString(5, email);
			stat.setString(6, address);
			stat.setString(7, account);
			stat.setDouble(8, 1000);

			int result = stat.executeUpdate();
			// ResultSet rs = stat.executeQuery();
			if (result > 0) {
				 out.println("<html><body>");
				    out.println("<script type=\"text/javascript\">");
				    out.println("var popwin = window.open(\"popup3.jsp\")");
				    out.println("setTimeout(function(){ popwin.close(); window.location.href='mainDisplay_2.jsp';},4000)");
				    out.println("</script>");
				    out.println("</body></html>");
				//request.getRequestDispatcher("/mainDisplay_2.jsp").forward(request, response);
			} else
				//response.getWriter().append("Account Not Created ").append(request.getContextPath());
			// request.getRequestDispatcher("/loginpage_1.jsp").forward(request, response);
			{
				 out.println("<html><body>");
				    out.println("<script type=\"text/javascript\">");
				    out.println("var popwin = window.open(\"popup4.jsp\")");
				    out.println("setTimeout(function(){ popwin.close(); window.location.href='mainDisplay_2.jsp';},4000)");
				    out.println("</script>");
				    out.println("</body></html>");
			}

		} catch (SQLException e) {
			 out.println("<html><body>");
			    out.println("<script type=\"text/javascript\">");
			    out.println("var popwin = window.open(\"popup4.jsp\")");
			    out.println("setTimeout(function(){ popwin.close(); window.location.href='mainDisplay_2.jsp';},4000)");
			    out.println("</script>");
			    out.println("</body></html>");
			//out.print(e.getMessage());
		}

	}

	private String getAccNumber() {
		Random rand = new Random();
		String acc = "";
		for (int i = 0; i < 12; i++) {
			int n = rand.nextInt(10);
			acc += Integer.toString(n);
		}
		return acc;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
