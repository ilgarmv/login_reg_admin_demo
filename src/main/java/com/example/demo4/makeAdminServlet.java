package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(value="/makeAdmin")
public class makeAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection conn = null;

    public void init() throws ServletException {
        conn = Util.getConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");

            Connection conn = Util.getConnection();
            String updateQuery = "UPDATE users SET is_admin = 1 WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {


                preparedStatement.setString(1, id);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    response.sendRedirect("/musayev/admin.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

}

