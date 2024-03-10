<%--
  Created by IntelliJ IDEA.
  User: musayev
  Date: 09.03.24
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles.css?=999">
    <script type="text/javascript">
        if(<%= session.getAttribute("id") %> != null) {
            window.location.replace("dashboard.jsp");
        }
    </script>
</head>
<body>
<form method="post" action="/musayev/login">
    <h1>Login</h1>
    <label for="mail">Mail:</label>
    <input type="email" id="mail" name="mail" style="width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    display: block;" required><br>
    <label for="password">Şifrə:</label><br>
    <input type="password" id="password" name="password" style="width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    display: block;" required minlength="6"><br><br>
    <input type="submit" value="Giris">
    <br>
    <div style="text-align: center;">
        <button style="border-radius: 4px;
                    background-color: #008eff;
                    border: none;
                    color: #FFFFFF;
                    text-align: center;
                    font-size: 17px;
                    padding: 3px;
                    width: 130px;
                    height: 50px;
                    transition: all 0.5s;
                    cursor: pointer;
                    margin: 5px;
                    text-decoration: none;">
            <a href="/musayev/register.jsp" style="color: white; text-decoration: none;">Qeydiyyatdan kec</a>
        </button>
    </div>
</form>

</body>
</html>
