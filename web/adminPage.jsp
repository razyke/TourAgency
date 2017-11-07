<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h3 align="center">Admin Page</h3>
<% if (request.getSession().getAttribute("role")==null) { %>
<form action=/login>
    <p align="right">
        <button type="submit" value="login">Sign in</button>
    </p>
</form>
<% } else if(request.getSession().getAttribute("role").equals("admin")){%>
<p align="center"> Hello, admin! </p>
<form action="/signOut">
    <p align="right">
        <button type = submit value="signOut"> Sign out </button>
    </p>
</form>
<% } %>

</body>
</html>
