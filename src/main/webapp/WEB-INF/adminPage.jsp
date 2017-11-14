<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>
</head>

<body>

<header id="header">
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            <li class="current"><a href="admin?action=users"> Users </a></li>
            <li><a href="welcome?action=signOut" class="button special">Sign out</a></li>

        </ul>
    </nav>
</header>

<% if (request.getSession().getAttribute("role").equals("admin")) { %>
<article id="main">
    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2>Hello, admin, </h2>
        <p>it's time to WORK! </p>

    </header>

<%--
<p align="right">
<a href="welcome?action=signOut"> sign out </a>
</p>
<a href="admin?action=tours"> Tours </a>
</br>
<a href="admin?action=users"> Users </a>
--%>
<section class="wrapper style3 special container 75%">
<table align = "center" border = "1">
    <tr>
    <strong>
        <th> Id</th>
        <th> Tour </th>
        <th> Price </th>
        <th>Language</th>
        <th>Client</th>
        <th>Phone</th>
        <th> Details </th>
    </strong>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td> <c:out value="${order.id}" /> </td>
            <td> <c:out value="${order.tour.title}" /> </td>
            <td> <c:out value="${order.price}" /> </td>
            <td> <c:out value="${order.user.language}"/> </td>
            <td> <c:out value="${order.user.firstName}" />  <c:out value="${order.user.lastName}" /> </td>
            <td> <c:out value="${order.user.phone}" /></td>
            <td> <a href="admin?action=detail&idOrder=<c:out value="${order.id}"/>"> Details </a> </td>
        </tr>
   </c:forEach>
</table>
</section>
</article>
<% }  else {%>

<article id="main">
    <p align="right" ></p>
    <header class="special container">
        <h2>Classified</h2>
        <p>Please sign as administranor</p>
    </header>

<% } %>

</body>
</html>
