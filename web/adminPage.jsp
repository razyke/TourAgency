<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>

<body>
<h3 align="center">Admin Page</h3>
<a href="welcome.jsp"> To main page </a>

<% if (request.getSession().getAttribute("role").equals("admin")) { %>
<p align="center"> Hello, admin! </p>
<form method="post" action="/signOut">
    <p align="right">
        <button type = submit value="signOut"> Sign out </button>
    </p>
</form>

<% }  else {%>
<p> Please sign in as administrator </p>
<% } %>
</body>
</html>
