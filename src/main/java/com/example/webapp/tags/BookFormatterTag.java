package com.example.webapp.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.*;

public class BookFormatterTag extends TagSupport {
    private String title;
    private String author;

    // Setters for the attributes
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("<div style='border: 1px solid #ddd; padding: 10px; margin: 10px;'>");
            out.write("<h3 style='color: navy;'>" + title + "</h3>");
            out.write("<p><strong>Author:</strong> " + author + "</p>");
            out.write("</div>");
        } catch (IOException e) {
            throw new JspException("Error in BookFormatterTag", e);
        }
        return SKIP_BODY; // Indicates that the body of the tag is not evaluated
    }
}
