package com.amity;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");

        response.setContentType("text/html");

        if (username != null && !username.trim().isEmpty()) {
            // Create a session and store the username
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to the profile page
            response.sendRedirect("ProfileServlet");
        } else {
            // Handle invalid username
            response.getWriter().println("<h2>Invalid Username!</h2>");
            response.getWriter().println("<p>Please go back and enter a valid username.</p>");
            response.getWriter().println("<a href='login.html'>Back to Login</a>");
        }
    }
}
