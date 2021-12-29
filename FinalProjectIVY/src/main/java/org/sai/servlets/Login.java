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

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String UserName=null;
	public Login() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		String username = request.getParameter("user");
		String password = request.getParameter("pass");

		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String query = "select * from user_pass where username=? and password=?";
			PreparedStatement stat = con.prepareStatement(query);
			stat.setString(1, username);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
			
				
				if(rs.getString(1).equals(username)&&rs.getString(2).equals(password))
				{
					UserName=username;
					request.getRequestDispatcher("/mainDisplay_2.jsp").forward(request, response);
				}
				//else
					//request.getRequestDispatcher("/loginpage_1.jsp").forward(request, response);
			}
			else
				request.getRequestDispatcher("/loginpage_1.jsp").forward(request, response);
			
			// out.print(" DB connection?"+rs);
		} catch (SQLException e) {
			out.print(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
