package com.example.webapp.servlets;

import com.example.webapp.beans.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        for (User user : RegisterServlet.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", user);
                response.sendRedirect("books");
                return;
            }
        }
        response.sendRedirect("login.jsp?error=1");
    }
}
