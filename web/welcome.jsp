<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>

<body>
<h3 align="center">Welcome</h3>
<form action="login.jsp">
    <p align="right">
    <button type="submit">Sign in</button>
    </p>
</form>
<p style="color: red;">${errorString}</p>
</form>
</body>
</html>