package com.example.webapp.servlets;

import com.example.webapp.beans.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RegisterServlet extends HttpServlet {
    private static final List<User> users = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        users.add(newUser);
        response.sendRedirect("login.jsp");
    }

    public static List<User> getUsers() {
        return users;
    }
}
