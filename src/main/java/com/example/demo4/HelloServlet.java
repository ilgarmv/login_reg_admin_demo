package com.example.demo4;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static com.example.demo4.Util.getConnection;
import static java.lang.System.out;


@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {


    Connection conn = null;

    public void init() throws ServletException {
        conn = Util.getConnection();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Util.getConnection();

            String sql = "SELECT id, name, surname, mail FROM users";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String mail = rs.getString("mail");

                response.getWriter().println("ID: " + id);
                response.getWriter().println("Name: " + name);
                response.getWriter().println("Surname: " + surname);
                response.getWriter().println("Mail: " + mail);
                response.getWriter().println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
    }

}
