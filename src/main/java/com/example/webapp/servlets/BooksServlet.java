package com.example.webapp.servlets;

import com.example.webapp.beans.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BooksServlet extends HttpServlet {
    private static final List<Book> books = new ArrayList<>();

    static {
        Book book1 = new Book();
        book1.setTitle("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        books.add(book1);

        Book book2 = new Book();
        book2.setTitle("1984");
        book2.setAuthor("George Orwell");
        books.add(book2);

        Book book3 = new Book();
        book3.setTitle("To Kill a Mockingbird");
        book3.setAuthor("Harper Lee");
        books.add(book3);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("books", books);
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
