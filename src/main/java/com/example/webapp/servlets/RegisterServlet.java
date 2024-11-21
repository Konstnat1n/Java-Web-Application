package com.example.webapp.servlets;

import com.example.webapp.utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Input Validation
        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty() ||
                email == null || email.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            request.setAttribute("errorMessage", "Invalid email format.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DBConnection.getConnection()) {
            // Check if username already exists
            String checkUsernameSql = "SELECT username FROM users WHERE username = ?";
            PreparedStatement checkUsernameStmt = connection.prepareStatement(checkUsernameSql);
            checkUsernameStmt.setString(1, username);
            ResultSet usernameRs = checkUsernameStmt.executeQuery();

            if (usernameRs.next()) {
                request.setAttribute("errorMessage", "Username already exists. Please choose another.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Check if email already exists
            String checkEmailSql = "SELECT email FROM users WHERE email = ?";
            PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailSql);
            checkEmailStmt.setString(1, email);
            ResultSet emailRs = checkEmailStmt.executeQuery();

            if (emailRs.next()) {
                request.setAttribute("errorMessage", "Email is already in use. Please use a different email.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Insert new user into the database
            String insertSql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSql);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password); // Hash password in real applications
            insertStmt.setString(3, email);
            insertStmt.executeUpdate();

            // Redirect to login page on success
            response.sendRedirect("login.jsp?success=1");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error. Please try again later.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
