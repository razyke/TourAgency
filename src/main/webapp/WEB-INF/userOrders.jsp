<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>
    <title>My orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
</head>

<body>

<header id="header">
<h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%>  <span>Java</span></a></h1>
<nav id="nav">
    <ul>
        <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%> </a></li>
    </ul>
</nav>
</header>
<% if ((request.getAttribute("idUser")==null)&&(request.getSession().getAttribute("role") != null)) { %>
<article id="main">
<header class="special container">
    <span class="icon fa-tags"></span>
    <h2> <% out.print(bundle.getString("global.hello"));%>, ${userName}! </h2>
    <p> <%out.print(bundle.getString("global.list_of_orders"));%> </p>
</header>

<section class="listings">
        <div class="wrapper style4 special container 75%">
            <div class="row">
                <div class="12u">
    <form method="post" name="manage">
    <table align = "center" border = "1">
        <tr>
            <strong>
                <th> <%out.print(bundle.getString("global.date"));%> </th>
                <th> <%out.print(bundle.getString("global.tour"));%> </th>
                <th> <%out.print(bundle.getString("global.price"));%> </th>
                <th> <%out.print(bundle.getString("global.city"));%></th>
                <th> <%out.print(bundle.getString("global.discounts"));%></th>
                <th> <%out.print(bundle.getString("global.manage"));%></th>
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
            <td> <c:out value="${order.orderDate}" /> </td>
            <td> <c:out value="${order.tour.title}" /> </td>
            <td> <c:out value="${order.price}" /> </td>
            <td> <c:out value="${order.tour.city}"/> </td>
            <td> <c:out value="${order.tour.discount}" /> </td>
            <c:choose>
                <c:when test="${order.active eq ('true')}">
                    <td>
                        <a href="userOrders?action=pay&idOrder=<c:out value="${order.id}"/>"> <%out.print(bundle.getString("global.pay"));%></a></br>
                        <a href="userOrders?action=delete&idOrder=<c:out value="${order.id}"/>"> <%out.print(bundle.getString("global.delete"));%></a>
                    </td>
                </c:when>
                <c:otherwise>
                    <td> <%out.print(bundle.getString("global.pay"));%> <br>
                        <%out.print(bundle.getString("global.delete"));%>
                    </td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>
        </form>
        </div>
        </div>
        <div class="more_listing">
                            <c:choose>
                                <c:when test="${orders.currentPage != 1}">
                                    <a href="/admin?page=1" class="more_listing_btn_small">
                                        <%out.print(bundle.getString("global.to_first_page"));%></a>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${orders.currentPage != 1}">
                                    <a href="/admin?page=<c:out value="${orders.currentPage-1}"/>" class="more_listing_btn_small">
                                        <%out.print(bundle.getString("global.back"));%></a>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${orders.currentPage != orders.totalPages}">
                                    <a href="/admin?page=<c:out value="${orders.currentPage+1}"/>" class="more_listing_btn_small">
                                        <%out.print(bundle.getString("global.forward"));%></a>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${orders.currentPage != orders.totalPages}">
                                    <a href="/admin?page=<c:out value="${orders.totalPages}"/>" class="more_listing_btn_small">
                                        <%out.print(bundle.getString("global.to_last_page"));%></a>
                                </c:when>
                            </c:choose>
                        </div>
                        </div>
</section>
</article>
<% } else {%>
<article id="main">
    <header class="special container">
        <span class="icon fa-tags"></span>
        <h2> <% out.print(bundle.getString("global.hello"));%> </h2>
        <p> <%out.print(bundle.getString("global.list_of_orders_empty"));%> </p>
    </header>
    <section class="listings">
        <div class="wrapper">
            <div class="more_listing">
                <a href="/" class="more_listing_btn"><%out.print(bundle.getString("global.choose_tour"));%></a>
            </div>
        </div>
    </section>
</article>
<%}%>
</body>
</html>
