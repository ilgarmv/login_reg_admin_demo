package com.example.demo4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.sql.*;


@WebServlet(name = "Register", value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection conn = null;
    public void init() throws ServletException {
        conn = Util.getConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Util.getConnection();

        try {
            conn = Util.getConnection();
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String mail = request.getParameter("mail");
            String password = request.getParameter("password");

            String sql = "INSERT INTO users (name, surname, mail, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, mail);
            pst.setString(4, password);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    out.println("<h2>Account created  " + id + " name : " + name + "</h2>");


                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Redirect</title>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("setTimeout(function() {");
                    out.println("    window.location.href = \"login.jsp\";");
                    out.println("}, 5000);");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("<body style=\"background-color: #1f1f1f;\">");
                    out.println("<h3 style=\"color:white\">Yonlendirilirsiniz (5sn)...</h3>");
                    out.println("</body>");
                    out.println("</html>");

                    out.close();

                }
            } else {
                out.println("<h2>Error.</h2>");
            }

            pst.close();
            conn.close();
        } catch (SQLException e) {
            out.println("<h2>COnnection error: " + e.getMessage() + "</h2>");
        }


    }
}
