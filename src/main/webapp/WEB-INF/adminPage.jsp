<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>

<body>

<h3 align="center">Admin Page</h3>

<a href="/TourAgency/"> To main page </a>

<% if (request.getSession().getAttribute("role").equals("admin")) { %>

<p align="center"> Hello, admin! </p>

<form method="post" action="signOut">
    <p align="right">
        <button type = submit value="signOut"> Sign out </button>
    </p>
</form>

<table align = "center" border = "1">

 <thead>
    <tr>
        <th> Id</th>
        <th> Tour </th>
        <th> Price </th>
        <th>Language</th>
        <th>Client</th>
        <th>Phone</th>
        <th> Details </th>
    </tr>
    </thead>

 <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td> <c:out value="${order.idOrder}" /> </td>
            <td> <c:out value="${order.tourName}" /> </td>
            <td> <c:out value="${order.price}" /> </td>
            <td> <c:out value="${order.user.language}"/> </td>
            <td> <c:out value="${order.user.firstName  ${order.user.lastName}}" /> </td>
            <td> <c:out value="${order.user.phone}" /></td>
            <td> <a href="DetailsServlet?action=detail&idOrder=<c:out value="${order.idOrder}"/>"> Details </a> </td>
 <!-- Thread to create  details-->
        </tr>
</tbody>

</table>

<% }  else {%>

<p> Please sign in as administrator </p>

<% } %>

</body>
</html>
