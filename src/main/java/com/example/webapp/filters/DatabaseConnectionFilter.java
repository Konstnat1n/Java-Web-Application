package com.example.webapp.filters;

import com.example.webapp.utils.DBConnection;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebFilter("/*")
public class DatabaseConnectionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection == null || connection.isClosed()) {
                throw new RuntimeException("Database connection is unavailable");
            }
            chain.doFilter(request, response); // Proceed if connection is valid
        } catch (Exception e) {
            e.printStackTrace();
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database connection error");
        }
    }
}
