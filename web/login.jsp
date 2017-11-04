<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<h3 align="right">Login</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="login">
    <table border="0" align="right">
        <tr>
            <td>login</td>
            <td><input type="text" name="userName" value= "${user.loginName}" /> </td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password" value= "${user.password}" /> </td>
        </tr>
        <tr>
            <td colspan ="1">
                <input type="submit" value= "Login" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
