package com.example.demo4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer isAdmin = (Integer) session.getAttribute("is_admin");

        if (isAdmin == null || isAdmin != 1) {
            response.sendRedirect("dashboard.jsp");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
        dispatcher.forward(request, response);
    }

}
