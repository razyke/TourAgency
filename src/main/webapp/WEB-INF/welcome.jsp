<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>

<body>

<h3 align="center">Welcome</h3>
<h3 align="center"> Select Tour </h3>
<table align="center">
    <tr>
        <td> Paradise islands</td>
        <td> Country of castles</td>
        <td> Mountain paths</td>
    </tr>
    <tr>
        <td> Heights of heaven</td>
        <td> Delight of the seaside</td>
    </tr>
</table>
<% if (request.getSession().getAttribute("role")==null) { %>
<form form action=login>
    <p align="right">
        <button type="submit" value="login">Sign in</button>
    </p>
</form>
<form form action=register>
    <p align="right">
        <button type="submit" value="register">Register</button>
    </p>
</form>
<% } else {%>
<a href="admin"> To admin page </a>
<p align="center"> Hello, ${userName}! </p>
<p align="center"> You signed as  ${role}. </p>
<form method="post" action="signOut">
    <p align="right">
        <button type = "submit" value="signOut"> Sign out </button>
    </p>
</form>
<% } %>
</body>
</html>