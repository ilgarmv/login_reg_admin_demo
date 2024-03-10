
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
  <link rel="stylesheet" href="styles.css?=999">

  <script type="text/javascript">
    if(<%= session.getAttribute("id") %> !== null) {
      window.location.replace("dashboard.jsp");
    }
  </script>

</head>
<body>
<form action="/musayev/register" method="post">
  <h1>Register</h1>
  <label for="name">Ad:</label><br>
  <input type="text" id="name" name="name" required><br>
  <label for="surname">Soyad:</label><br>
  <input type="text" id="surname" name="surname" required><br>
  <label for="mail">E-mail:</label><br>
  <input type="email" id="mail" name="mail" required ><br>
  <label for="password">Şifrə:</label><br>
  <input type="password" id="password" name="password" required minlength="6"><br><br>
  <input type="submit" value="Qeydiyyatdan keç">
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
      <a href="/musayev/login.jsp" style="color: white; text-decoration: none;">Giris et</a>
    </button>
  </div>
</form>


</body>
</html>
