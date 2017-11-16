<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <% ResourceBundle bundle = (ResourceBundle) request.getSession().getAttribute("bundle"); %>
    <title><% out.print(bundle.getString("global.discounts"));%></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css"/>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>
</head>

<body>

<header id="header">
    <h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%> <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%></a></li>
            <% if ((!(request.getSession().getAttribute("role") == null)) && request.getSession().getAttribute("role").equals("admin")) { %>
            <li class="current"><a href="admin"><% out.print(bundle.getString("global.to_admin_page"));%></a></li>
            <li class="current"><a href="admin?action=users"><% out.print(bundle.getString("global.users"));%></a></li>
            <li><a href="/?action=signOut" class="button special"><%
                out.print(bundle.getString("global.sign_out"));%></a></li>
        </ul>
    </nav>
</header>


<article id="main">
    <header class="special container">
        <span class="icon fa-percent"></span>
        <h2><% out.print(bundle.getString("global.discounts"));%></h2>
        <p><% out.print(bundle.getString("global.list_of_all_discounts"));%></p>
    </header>

    <section class="wrapper style3 special container 75%">

        <form method="post" name="discount">
            <table align="center" border="1">
                <tr>
                    <strong>
                        <th> Id</th>
                        <th><% out.print(bundle.getString("global.name"));%></th>
                        <th><% out.print(bundle.getString("global.value"));%></th>
                        <th><% out.print(bundle.getString("global.author"));%></th>
                        <th><% out.print(bundle.getString("global.last_update"));%></th>
                    </strong>
                </tr>
                <c:forEach items="${discounts}" var="discount">
                    <td><c:out value="${discount.id}"/></td>
                    <input type="hidden" name="discountId" value="${discount.id}">
                    <td><c:out value="${discount.name}"/></td>
                    <td><input type="text" name="value" value="${discount.value}"/></td>
                    <td><c:out value="${discount.authorId}"/></td>
                    <td><c:out value="${discount.lastUpdate}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="row">
                <div class="12u">
                    <ul class="buttons">
                        <li><input type="submit" class="special" name="change"
                                   value="<% out.print(bundle.getString("global.change"));%>"/></li>
                        <li><input type="submit" class="special" name="change"
                                   value="<% out.print(bundle.getString("global.back"));%>"/></li>
                    </ul>
                </div>
            </div>
        </form>
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
