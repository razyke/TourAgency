<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Users</title>
</head>

<body>

<h3 align="center"> Tours </h3>

<c:forEach items="${tours}" var="tour">

<table border="0">
<tr>
<td> <c:out value="${tour.title}" /> </td>
<td> <a href="admin?action=editeTour&tourId=<c:out value="${tour.id}" />"> edit </td>
<td> <a href="admin?action=delete"> delete </a>
</tr>

</table>

</c:forEach

<href="admin?action=addTour"> add </a>
</body>
</html>