<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Users</title>
</head>

<body>
<h3 align="center">Users</h3>
<a href="/TourAgency/"> To main page </a>
<table border=1>

    <thead>

    <tr>

        <th>Id</th>
        <th>First Name</th>
         <th>Middle Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Login</th>
        <th>Admin</th>
    </tr>
    </thead>
<tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.idUser}" /></td>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.middleName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.address}" /></td>
            <td><c:out value="${user.email}" /></td>
            <c:choose>
                <c:when test="${user.isAdmin eq ('true')}">
                    <td><c:out value="Yes"/></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="No"/></td>
                </c:otherwise>
            </c:choose>
 </table>
</body>
</html>