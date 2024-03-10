package com.example.demo4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="updatename" , value="/updateName")
public class UpdateNameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String newName = request.getParameter("newName");

        HttpSession session = request.getSession(false);
        if (session != null) {
            int id = (int) session.getAttribute("id");

            try {
                Connection conn = Util.getConnection();
                String sql = "UPDATE users SET name=? WHERE id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, newName);
                pst.setInt(2, id);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    session.setAttribute("name", newName);
                }

                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("dashboard.jsp");
    }
}

