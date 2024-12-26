package com.amity;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the current session
        HttpSession session = request.getSession(false);

        response.setContentType("text/html");

        if (session != null && session.getAttribute("user") != null) {
            String username = (String) session.getAttribute("user");
            response.getWriter().println("<h2>Welcome, " + username + "!</h2>");
            response.getWriter().println("<a href='LogoutServlet'>Logout</a>");
        } else {
            response.getWriter().println("<h2>No active session found.</h2>");
            response.getWriter().println("<p>Please <a href='login.html'>login</a>.</p>");
        }
    }
}
