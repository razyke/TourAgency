<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>
    <title>Admin Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
</head>

<body>

<header id="header">
 <h1 id="logo"><a href="#">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%> </a></li>
            <li class="current"><a href="admin?action=discounts"><%out.print(bundle.getString("global.discounts"));%> </a></li>
            <li class="current"><a href="admin?action=users"><%out.print(bundle.getString("global.users"));%></a></li>
            <li><a href="/?action=signOut" class="button special"><%out.print(bundle.getString("global.sign_out"));%></a></li>

        </ul>
    </nav>
</header>

<% if (request.getSession().getAttribute("role").equals("admin")) { %>
<article id="main">
    <header class="special container">
        <span class="icon fa-user-secret"></span>
        <h2><%out.print(bundle.getString("global.hello_admin"));%> </h2>
        <p><%out.print(bundle.getString("global.time_to_work"));%> </p>

    </header>

<section class="wrapper style3 special container 75%">
<table align = "center" border = "1">
    <tr>
    <strong>
        <th> Id</th>
        <th> <%out.print(bundle.getString("global.tour"));%> </th>
        <th> <%out.print(bundle.getString("global.price"));%> </th>
        <th> <%out.print(bundle.getString("global.language_after"));%></th>
        <th> <%out.print(bundle.getString("global.client"));%></th>
        <th> <%out.print(bundle.getString("global.phone"));%></th>
        <th> <%out.print(bundle.getString("global.details"));%></th>
    </strong>
    </tr>
    <c:forEach items="${orders.items}" var="order">
    <c:choose>
    <c:when test="${order.active eq ('true')}">
        <tr>
        </c:when>
    <c:otherwise>
        <tr style="color: silver">
    </c:otherwise>
      </c:choose>
            <td> <c:out value="${order.id}" /> </td>
            <td> <c:out value="${order.tour.title}" /> </td>
            <td> <c:out value="${order.price}" /> </td>
            <td> <c:out value="${order.user.language}"/> </td>
            <td> <c:out value="${order.user.firstName}" />  <c:out value="${order.user.lastName}" /> </td>
            <td> <c:out value="${order.user.phone}" /></td>
            <td> <a href="admin?action=detail&idOrder=<c:out value="${order.id}"/>"> <%out.print(bundle.getString("global.details"));%></a> </td>
        </tr>
   </c:forEach>
</table>
<div class="more_listing">
    <a href="/admin?page=<c:out value="${orders.currentPage+1}"/>" class="more_listing_btn"><%out.print(bundle.getString("global.view_more_tours"));%></a>
</div>
</section>
</article>
<% }  else {%>

<article id="main">
    <p align="right" ></p>
    <header class="special container">
        <h2><%out.print(bundle.getString("global.classified"));%></h2>
        <p><%out.print(bundle.getString("global.please_sign_in_as_admin"));%></p>
    </header>

<% } %>

</body>
</html>
