package com.example.demo4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="DashboardServlet" , value="/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("id") != null) {
            int id = (int) session.getAttribute("id");
            String name = (String) session.getAttribute("name");
            String surname = (String) session.getAttribute("surname");
            String mail = (String) session.getAttribute("mail");

            out.println("<h2>Welcome to Dashboard, " + name + " " + surname + "!</h2>");
            out.println("<p>Your ID: " + id + "</p>");
            out.println("<p>Your Email: " + mail + "</p>");


        } else {
            out.println("<h2>Error: User not logged in!</h2>");
        }
    }
}
