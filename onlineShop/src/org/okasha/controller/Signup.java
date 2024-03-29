package org.okasha.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.okasha.model.*;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("Email");
		String name = request.getParameter("Name");
		String mobileNo = request.getParameter("MobileNo");
		String address = request.getParameter("Address");
		String password = request.getParameter("Password");
		if (email.isEmpty() || name.isEmpty() || mobileNo.isEmpty() || address.isEmpty() || password.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
			out.println("<font color=red> Please, fill all the fields </font>");
			rd.include(request, response);
		} else if (email.contains("@") == false || email.contains(".") == false) {
			RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
			out.println("<font color=red> Please, Wrong Email format! </font>");
			rd.include(request, response);
		} else {
			User user = new User();
			user.setEmail(email);
			user.setName(name);
			user.setMobileNo(mobileNo);
			user.setAddress(address);
			user.setPassword(password);
			boolean added = user.insertUser();
			if (added) {
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			} else if (!added) {
				RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
			}
		}
	}
}