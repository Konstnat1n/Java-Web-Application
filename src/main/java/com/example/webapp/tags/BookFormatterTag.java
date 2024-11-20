package com.example.webapp.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class BookFormatterTag extends TagSupport {
    private String title;
    private String author;
    private String genre;
    private String description;

    public void setTitle(String title) {
        System.out.println("setTitle called with value: " + title);
        this.title = title;
    }

    public void setAuthor(String author) {
        System.out.println("setAuthor called with value: " + author);
        this.author = author;
    }

    public void setGenre(String genre) {
        System.out.println("setGenre called with value: " + genre);
        this.genre = genre;
    }



    public void setDescription(String description) {
        System.out.println("setDescription called with value: " + description);
        this.description = description;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();

            // Debugging: Log attributes
            System.out.println("Custom Tag: Title=" + title + ", Author=" + author);

            // Output book details
            out.write("<div style='border: 1px solid #ddd; padding: 10px; margin: 10px;'>");
            out.write("<h3 style='color: navy;'>" + title + "</h3>");
            out.write("<p><strong>Author:</strong> " + author + "</p>");
            out.write("<p><strong>Genre:</strong> " + genre + "</p>");
            out.write("<p>" + description + "</p>");
            out.write("</div>");
        } catch (IOException e) {
            throw new JspException("Error in BookFormatterTag", e);
        }
        return SKIP_BODY;
    }
}
