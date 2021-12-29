package org.sai.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String para = request.getParameter("page");
		if (para.equals("login")) {
			getServletContext().getRequestDispatcher("/Login").forward(request, response);
		} else if (para.equals("createaccount")) {
			getServletContext().getRequestDispatcher("/CreateAccount_3.jsp").forward(request, response);
		} else if (para.equals("CreateAccount")) {
			getServletContext().getRequestDispatcher("/CreateAccount").forward(request, response);
		} else if (para.equals("dcoperation")) {
			getServletContext().getRequestDispatcher("/DebitCreditOperation").forward(request, response);
		} else if (para.equals("transaction")) {
			getServletContext().getRequestDispatcher("/Transaction_4.jsp").forward(request, response);
		} else if (para.equals("auth")) {
			getServletContext().getRequestDispatcher("/AuthorizeCreditCard").forward(request, response);
		} else if (para.equals("authcredit")) {
			getServletContext().getRequestDispatcher("/AuthorizeCredit.jsp").forward(request, response);
		} else if (para.equals("display")) {
			getServletContext().getRequestDispatcher("/DisplayStatement.jsp").forward(request, response);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
