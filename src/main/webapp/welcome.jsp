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
<% if (request.getSession().isNew()) { %>
<form action=login>
    <p align="right">
        <button type="submit" value="login">Sign in</button>
    </p>
</form>
<% } else {%>
<p align="center"> Hello, user! </p>
<form method="post" action="signOut">
    <p align="right">
        <button type = submit value="signOut"> Sign out </button>
    </p>
</form>
<% } %>
</body>
</html>