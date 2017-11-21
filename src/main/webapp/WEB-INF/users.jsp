<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <% ResourceBundle bundle = (ResourceBundle) request.getSession().getAttribute("bundle"); %>
    <title><%out.print(bundle.getString("global.users"));%></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css"/>
</head>

<body>

<header id="header">
    <h1 id="logo"><a href="#">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"> <a href="/"><% out.print(bundle.getString("global.tomainpage"));%></a></li>
            <% if ((!(request.getSession().getAttribute("role") == null)) && request.getSession().getAttribute("role").equals("admin")) { %>
            <li class="current"><a href="admin"><% out.print(bundle.getString("global.to_admin_page"));%></a></li>
            <li><a href="/?action=signOut" class="button special"><%
                out.print(bundle.getString("global.sign_out"));%></a></li>

        </ul>
    </nav>
</header>


<article id="main">
    <header class="special container">
        <span class="icon fa-user"></span>
        <h2><%out.print(bundle.getString("global.users"));%></h2>
        <p><%out.print(bundle.getString("globla.list_of_all_users"));%></p>

    </header>

    <section class="listings">
        <div class="wrapper style4 special container 75%">
            <table border=1 align="center">

                <thead>

                <tr>
                    <th>Id</th>
                    <th><%out.print(bundle.getString("global.first_name"));%></th>
                    <th><%out.print(bundle.getString("global.middle_name"));%></th>
                    <th><%out.print(bundle.getString("global.last_name"));%></th>
                    <th><%out.print(bundle.getString("global.email"));%></th>
                    <th><%out.print(bundle.getString("global.address"));%></th>
                    <th><%out.print(bundle.getString("global.login"));%></th>
                    <th><%out.print(bundle.getString("global.admin"));%></th>
                    <th><%out.print(bundle.getString("global.manage"));%></th>
                </tr>

                </thead>

                <tbody>
                <c:forEach items="${users.items}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.middleName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.address}"/></td>
                    <td><c:out value="${user.loginName}"/></td>
                    <c:choose>
                        <c:when test="${user.admin eq ('true')}">
                            <td><%out.print(bundle.getString("global.yes"));%></td>
                        </c:when>
                        <c:otherwise>
                            <td><%out.print(bundle.getString("global.no"));%></td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a href="admin?action=delete&userId=<c:out value="${user.id}"/>"><%out.print(bundle.getString("global.delete"));%>
                            <br> </a>
                        <a href="admin?action=changeRole&userId=<c:out value="${user.id}"/>"><%out.print(bundle.getString("global.change"));%> <%out.print(bundle.getString("global.role"));%></a>
                    </td>
                </tr>
                </c:forEach>

            </table>

        <div class="more_listing">
            <c:choose>
                <c:when test="${users.currentPage != 1}">
                    <a href="/admin?action=users&page=1" class="more_listing_btn_small">
                        <%out.print(bundle.getString("global.to_first_page"));%></a>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${users.currentPage != 1}">
                    <a href="/admin?action=users&page=<c:out value="${users.currentPage-1}"/>" class="more_listing_btn_small">
                        <%out.print(bundle.getString("global.back"));%></a>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${users.currentPage != users.totalPages}">
                    <a href="/admin?action=users&page=<c:out value="${users.currentPage+1}"/>" class="more_listing_btn_small">
                        <%out.print(bundle.getString("global.forward"));%></a>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${users.currentPage != users.totalPages}">
                    <a href="/admin?action=users&page=<c:out value="${users.totalPages}"/>" class="more_listing_btn_small">
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
        <span class="icon fa-shield"></span>
        <h2><%out.print(bundle.getString("global.classified"));%></h2>
        <p><%out.print(bundle.getString("global.please_sign_in_as_admin"));%></p>
    </header>
</article>

<% } %>
</body>
</html>