<%@ page import="java.util.ResourceBundle" %>
<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title> Users </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
<%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>
</head>

<body>

<header id="header">
    <h1 id="logo"><a href="#">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%> </a></li>
            <li class="current"><a href="admin"><% out.print(bundle.getString("global.to_admin_page"));%> </a></li>
            <li><a href="/?action=signOut" class="button special"><% out.print(bundle.getString("global.sign_out"));%></a></li>

        </ul>
    </nav>
</header>

<% if (request.getSession().getAttribute("role").equals("admin")) { %>
<article id="main">
    <header class="special container">
        <span class="icon fa-user"></span>
        <h2> Users </h2>
        <p> List of all users </p>

    </header>
    <section class="wrapper style3 special container 75%">
    <table border=1 align="center">

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
            <th>Manage</th>
        </tr>

        </thead>

        <tbody>
        <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.middleName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.address}" /></td>
            <td><c:out value="${user.loginName}" /></td>
            <c:choose>
                <c:when test="${user.admin eq ('true')}">
                    <td><c:out value="Yes"/></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="No"/></td>
                </c:otherwise>
            </c:choose>
            <td><a href="admin?action=delete&userId=<c:out value="${user.id}"/>"> Delete <br> </a>
                <a href="admin?action=changeRole&userId=<c:out value="${user.id}"/>"> Change role </a>
            </td>
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
            <p>Please sign as administrator</p>
        </header>

            <% } %>

</body>
</html>