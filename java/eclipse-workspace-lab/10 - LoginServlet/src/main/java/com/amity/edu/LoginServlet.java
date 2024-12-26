package com.amity.edu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection con;

    @Override
    public void init() throws ServletException {
        // Get database parameters from web.xml
        String dbUrl = getServletConfig().getInitParameter("DB_URL");
        String dbUser = getServletConfig().getInitParameter("DB_USER");
        String dbPass = getServletConfig().getInitParameter("DB_PASS");

        try {
            // Ensure JDBC Driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Database connection established.");
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found.", e);
        } catch (SQLException e) {
            throw new ServletException("Error connecting to the database.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (con == null) {
            out.println("<h1>Database connection is not established. Please check the configuration.</h1>");
            return;
        }

        try {
            // Get user inputs
            String sname = request.getParameter("sname");
            String spass = request.getParameter("pass");

            if (sname == null || spass == null || sname.isEmpty() || spass.isEmpty()) {
                out.println("<h1>Invalid input: Username or password is empty.</h1>");
                return;
            }

            // Prepare SQL query
            String sql = "SELECT * FROM students WHERE sname = ? AND passwd = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sname);
            st.setString(2, spass);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // Successful login
                request.setAttribute("username", sname);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WelcomeServlet");
                dispatcher.forward(request, response);
            } else {
                // Login failed
                RequestDispatcher dispatcher = request.getRequestDispatcher("loginfail.html");
                dispatcher.include(request, response);
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            out.println("<h1>Error processing the request: " + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
