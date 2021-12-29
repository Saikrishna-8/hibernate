package org.sai.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

public class DebitCreditOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DebitCreditOperation() {
		// super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();

		String debit = request.getParameter("debit");
		 String credit=request.getParameter("credit");
		String accnum = request.getParameter("accnum");
		double amount = Double.parseDouble(request.getParameter("amount"));
		Connection con = null;
		con = DatabaseConnection.initializeDatabase();
		try {
			String query1 = "select account_number,avl_balence from account_details where account_number=?";
			PreparedStatement stat1 = con.prepareStatement(query1);
			stat1.setString(1, accnum);
			ResultSet rs1 = stat1.executeQuery();
			if (rs1.next()) {
				// out.print("sai " + rs1.getString(1) + " " + rs1.getDouble(2));
			}
			// out.print("<br/>");
			String query2 = "select account_number,avl_balence from account_details where username=?";
			PreparedStatement stat2 = con.prepareStatement(query2);
			stat2.setString(1, Login.UserName);

			ResultSet rs2 = stat2.executeQuery();
			if (rs2.next()) {
				// out.print(rs2.getString(1) + " " + rs2.getDouble(2));
			}

			if (rs1 != null && rs2 != null && (!rs1.getString(1).equals(rs2.getString(1)))) {

				int res = 0;
				if (debit != null) {
					res = doTrnsaction(con, rs1, rs2, amount);
				} else {
					res = doTrnsaction(con, rs2, rs1, amount);
				}

				if (res == 4) {

					successful(out, "popup1.jsp");

				}
			} else {

				successful(out, "popup2.jsp");
			}
		} catch (SQLException e) {
			successful(out, "popup2.jsp");
		}
	}

	private void successful(PrintWriter out, String s) {

		String s2 = "var popwin = window.open(\"" + s + "\")";
		out.println("<html><body>");
		out.println("<script type=\"text/javascript\">");
		out.println(s2);
		out.println("setTimeout(function(){ popwin.close(); window.location.href='mainDisplay_2.jsp';},4000)");
		out.println("</script>");
		out.println("</body></html>");

	}

	private int doTrnsaction(Connection con, ResultSet rs1, ResultSet rs2, double amount) throws SQLException {
		// TODO Auto-generated method stub
		int x, x1, y, z;
		x = x1 = y = z = 0;
		if (rs1.getDouble(2) >= amount) {
			String query3 = "update account_details SET avl_balence=? where account_number=?";
			PreparedStatement stat3 = con.prepareStatement(query3);
			stat3.setDouble(1, (rs1.getDouble(2) - amount));
			stat3.setString(2, rs1.getString(1));

			x = stat3.executeUpdate();
			System.out.println("x==  " + x);

			String query31 = "update account_details SET avl_balence=? where account_number=?";
			PreparedStatement stat31 = con.prepareStatement(query31);
			stat31.setDouble(1, (rs2.getDouble(2) + amount));
			stat31.setString(2, rs2.getString(1));

			x1 = stat31.executeUpdate();
			System.out.println("x1==  " + x1);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate now = LocalDate.now();
			String date_str = dtf.format(now);
			System.out.println(date_str);
			String query4 = "insert into transactions values(?,?,?,?,?,?,?)";
			PreparedStatement stat4 = con.prepareStatement(query4);
			stat4.setString(1, rs1.getString(1));
			stat4.setString(2, date_str);
			stat4.setString(3, "WithDraw");
			stat4.setInt(4, 0);
			stat4.setDouble(5, amount);
			stat4.setDouble(6, 0);
			stat4.setDouble(7, rs1.getDouble(2) - amount);

			y = stat4.executeUpdate();
			System.out.println("y==  " + y);

			String query5 = "insert into transactions values(?,?,?,?,?,?,?)";
			PreparedStatement stat5 = con.prepareStatement(query5);
			stat5.setString(1, rs2.getString(1));
			stat5.setString(2, date_str);
			stat5.setString(3, "Deposit");
			stat5.setInt(4, 0);
			stat5.setDouble(5, 0);
			stat5.setDouble(6, amount);
			stat5.setDouble(7, rs2.getDouble(2) + amount);

			z = stat5.executeUpdate();
			System.out.println("z==  " + z);

		}
		return x + y + z + x1;
	}
}
