<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles.css">

    <script type="text/javascript">
        if(<%= session.getAttribute("id") %> = null) {
            window.location.replace("login.jsp");
        }
    </script>
</head>
<body>
<div>
<div>
<form>
<h1>Welcome to Dashboard</h1>
<label >ID: ${id}</label><br>
<label>Your name: ${name}</label><br>
<label>YOur surname: ${surname}</label><br>
<label>Your email : ${mail}</label>


</form>
</div>
<br><br>
<div>

    <form action="updateName" method="post">
        <h3>New Name: </h3><input type="text" name="newName">
        <input type="submit" value="Update Name">
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
