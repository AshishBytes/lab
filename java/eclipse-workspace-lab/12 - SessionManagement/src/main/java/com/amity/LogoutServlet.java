package com.amity;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the current session and invalidate it
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate(); // End the session
        }

        response.setContentType("text/html");
        response.getWriter().println("<h2>You have been logged out successfully!</h2>");
        response.getWriter().println("<p><a href='login.html'>Login Again</a></p>");
    }
}
