<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<a href="/TourAgency/"> To main page </a>
<% if (request.getSession().getAttribute("role")!=null) { %>
<p align="center"> Hello, ${userName}! </p>
<p align="center"> You signed as  ${role}. </p>
<form method="post" action="signOut">
    <p align="right">
        <button type = "submit" value="signOut"> Sign out </button>
    </p>
</form>
<% } else {%>
<h3 align="right">Login</h3>

<p align="right" style="color: red">${errorString}</p>

<form method="POST" action="login">

    <table border="0" align="right">
        <tr>
            <td>login</td>
            <td><input type="text" name="userName" value= "${user.loginName}" /> </td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password" value= "${user.password}" /> </td>
        </tr>
        <tr>
            <td colspan ="1">
                <input type="submit"  value= "Login" />
            </td>
        </tr>
    </table>
</form>
<p align="right">
    <a href="register"> Register </a>
</p>
<% } %>
</body>
</html>