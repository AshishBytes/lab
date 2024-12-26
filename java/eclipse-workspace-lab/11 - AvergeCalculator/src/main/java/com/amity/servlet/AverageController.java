package com.amity.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/averageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("hello");
		int x = Integer.parseInt(request.getParameter("f1"));
		int y = Integer.parseInt(request.getParameter("f2"));
		AverageCalculator model = new AverageCalculator();
		int z = model.calculate(x, y);
		request.setAttribute("result", z);
		RequestDispatcher rs =request.getRequestDispatcher("AverageDisplay.jsp");
		rs.forward(request, response);
	}

}