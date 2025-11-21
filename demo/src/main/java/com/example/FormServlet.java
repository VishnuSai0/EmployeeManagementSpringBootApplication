package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class FormServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
private static final String JDBC_USERNAME = "vishnu";
private static final String JDBC_PASSWORD = "vishnu";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String ageStr = req.getParameter("age");
        int age = ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            stmt.close();
            conn.close();

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h2>Data saved successfully!</h2>
            
            
            
            
            
            
            ");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
