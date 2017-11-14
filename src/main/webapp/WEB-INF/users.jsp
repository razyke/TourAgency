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
 <h1 id="logo"><a href="index.html">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            <li class="current"><a href="admin?action=users"> Users </a></li>
            <li><a href="/?action=signOut" class="button special">Sign out</a></li>

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

<section class="wrapper style3 special container 75%">
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
        <th></th>
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
            <td>
            <c:choose>
                <c:when test="${user.isAdmin eq ('true')}">
                    <td><c:out value="Yes"/></td>
                </c:when>
                <c:otherwise>
                    <td><c:out value="No"/></td>
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
    </c:forEach>
 </table>

 <a href="admin?action=delete"> delete user </a>
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