<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration </title>
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

     <c:forEach items="${registration}" var="reg">

         <p align="center" style="color: red">${reg}<br> </p>

      </c:forEach>

        <form method="post" action="register">

            <table border="1" width="30%" cellpadding="5" align="center">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td>First Name*</td>
                        <td><input type="text" name="firstName" value="${user.firstName}" /></td>
                    </tr>

                    <tr>
                         <td>Middle name</td>
                         <td><input type="text" name="middleName" value="${user.middleName}" /></td>
                     </tr>

                    <tr>
                        <td>Last Name*</td>
                        <td><input type="text" name="lastName" value="${user.lastName}" /></td>
                    </tr>

                    <tr>
                        <td>Email*</td>
                        <td><input type="text" name="email" value="${user.email}" /></td>
                    </tr>

                     <tr>
                         <td>Phone*</td>
                         <td><input type="phone" name="phone" value="${user.phone}" /></td>
                         </tr>
                    <tr>

                     <tr>
                     <td>Address</td>
                     <td><input type="text" name="address" value="${user.address}" /></td>
                     </tr>

                        <td>User Name*</td>
                        <td><input type="text" name="userName" value="${user.loginName}" /></td>
                     </tr>

                     <tr>
                        <td>Password*</td>
                        <td><input type="password" name="password" value="${user.password}" /></td>
                     </tr>

                     <tr>
                        <td>Repeat Password*</td>
                        <td><input type="password" name="password2" value="${user.password2}" /></td>
                     </tr>

                     <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>

                    <tr>
                        <td colspan="2">Already registered? sign in <a href="login">here</a></td>
                    </tr>

                </tbody>

            </table>

        </form>

        <p align = "center">  *Mandatory fields </p>

    <% } %>
    </body>
</html>