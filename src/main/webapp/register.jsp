<!--http://www.javaknowledge.info/login-and-registration-example-in-jsp-with-session/!-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
    <a href="welcome.jsp"> To main page </a>
    <% if (request.getSession().getAttribute("role")!=null) { %>
    <p align="center"> Hello, ${userName}! </p>
    <p align="center"> You signed as  ${role}. </p>
    <form method="post" action="signOut">
        <p align="right">
            <button type = "submit" value="signOut"> Sign out </button>
        </p>
    </form>
    <% } else {%>
        <form method="post" action="register">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="${user.firstName}" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="${user.lastName}" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="${user.email}" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="userName" value="${user.loginName}" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="${user.password}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="login.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    <% } %>
    </body>
</html>