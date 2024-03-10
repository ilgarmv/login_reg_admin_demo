<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="styles.css">

    <script type="text/javascript">
        if(<%= session.getAttribute("id") %> == null) {
            window.location.replace("login.jsp");
        }
    </script>
    <script type="text/javascript">
        if(<%= session.getAttribute("is_admin") %> != '1') {
            window.location.replace("dashboard.jsp");
        }
    </script>
</head>
<body>
<div>
    <div>
        <form>
            <h1 style="color:#f4511e">Welcome to Admin</h1>
            <label >ID: ${id}</label><br>
            <label>Your name: ${name}</label><br>
            <label>Your surname: ${surname}</label><br>
            <label>Your email : ${mail}</label>

            <h3 style="color:#f4511e">You can show all users!</h3>

        </form>
    </div>
    <br><br>
    <div>

        <form action="/musayev/makeAdmin" method="post">
            <label for="id">User ID to make admin:</label><br>
            <input type="text" id="id" name="id" required><br>
            <input type="submit" value="Make Admin">
        </form>

        <form  method="get" action="/musayev/HelloServlet?id=?">
            <input type="submit" value="Show all users">

        </form>
        <form action="/musayev/logout">
            <input type="submit" value="Logout">

        </form>


    </div>
</div>
</body>
</html>
