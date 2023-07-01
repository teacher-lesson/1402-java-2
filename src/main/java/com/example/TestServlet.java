package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/")
public class TestServlet extends HttpServlet {



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();

        final String name = getInitParameter("configLocation");
        System.out.println(name);

        if (req.getPathInfo().equalsIgnoreCase("/login")) {
            writer.println("Login page");
        } else if (req.getPathInfo().equalsIgnoreCase("/register")) {
            writer.println("Registre page");
        } else {
            writer.println("You are not allowed here!");
            resp.setStatus(404);
        }
    }
}
