package com.example.demo4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection conn = null;

    public void init() throws ServletException {
        conn = Util.getConnection();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        try {
            Connection conn = Util.getConnection();
            String sql = "SELECT id, name, surname, is_admin FROM users WHERE mail=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mail);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                HttpSession session = request.getSession();
                session.setAttribute("id", rs.getInt("id"));
                session.setAttribute("mail", mail);
                session.setAttribute("name", rs.getString("name"));
                session.setAttribute("surname", rs.getString("surname"));
                session.setAttribute("is_admin", rs.getInt("is_admin"));
                int isAdmin = rs.getInt("is_admin");
                if (isAdmin == 1) {
                    response.sendRedirect("admin.jsp");
                } else {
                    response.sendRedirect("dashboard.jsp");
                }
            } else {
                out.println("<h3>Not found. Please try again.</h3>");
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            out.println("<h3>Connection error: " + e.getMessage() + "</h3>");
        }
    }







//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String email = request.getParameter("mail");
//        String password = request.getParameter("password");
//
//        Util.getConnection();
//
//        try {
//
//            String sql = "SELECT * FROM users WHERE mail=? AND password=?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, email);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                response.sendRedirect("dashboard.jsp");
//            } else {
//                out.println("<h3>Not found. Please try again.</h3>");
//            }
//
//            rs.close();
//            pst.close();
//            conn.close();
//
//        } catch (SQLException e) {
//            out.println("<h3>Connection error: " + e.getMessage() + "</h3>");
//        }
    }

