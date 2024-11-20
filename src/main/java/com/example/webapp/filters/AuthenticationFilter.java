package com.example.webapp.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/books")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String loginURI = httpRequest.getContextPath() + "/login";
        String logoutURI = httpRequest.getContextPath() + "/logout";

        boolean loggedIn = (session != null && session.getAttribute("loggedInUser") != null);
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean logoutRequest = httpRequest.getRequestURI().equals(logoutURI);

        if (loggedIn || loginRequest || logoutRequest) {
            chain.doFilter(request, response); // Allow access
        } else {
            httpResponse.sendRedirect("index.jsp"); // Redirect to login page
        }
    }
}