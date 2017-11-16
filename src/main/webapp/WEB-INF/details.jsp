<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <% ResourceBundle bundle = (ResourceBundle) request.getSession().getAttribute("bundle"); %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>

    <title><% out.print(bundle.getString("global.details"));%></title>
</head>

<body>
<header id="header">
    <h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%><span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%></a></li>
            <% if ((!(request.getSession().getAttribute("role") == null)) && request.getSession().getAttribute("role").equals("admin")) { %>
            <li class="current"><a href="admin"><% out.print(bundle.getString("global.to_admin_page"));%></a></li>
            <li><a href="/?action=signOut" class="button special"><%
                out.print(bundle.getString("global.sign_out"));%></a></li>
        </ul>
    </nav>
</header>

<article id="main">

    <header class="special container">
        <span class="icon fa-keyboard-o"></span>
        <h2><% out.print(bundle.getString("global.order_details"));%></h2>
    </header>

    <section class="wrapper style4 special container 75%">

        <form method="post" name="manage">

            <table align="center">

                <theah>
                    <th colspan="2" align="center"><% out.print(bundle.getString("global.client_info"));%></th>
                    <th colspan="2" align="center"><% out.print(bundle.getString("global.tour_info"));%></th>
                </theah>
                <tbody>

                <tr>
                    <td><strong><% out.print(bundle.getString("global.first_name"));%></strong></td>
                    <td style="color: silver"><c:out value="${order.user.firstName}"/></td>

                    <td> id</td>
                    <td style="color: silver"><c:out value="${order.tour.id}"/></td>
                </tr>

                <tr>
                    <td><strong><% out.print(bundle.getString("global.middle_name"));%></strong></td>
                    <td style="color: silver"><c:out value="${order.user.middleName}"/></td>

                    <td><% out.print(bundle.getString("global.title"));%></td>
                    <td style="color: silver"><c:out value="${order.tour.title}"/></td>
                </tr>

                <tr>
                    <td><strong><% out.print(bundle.getString("global.last_name"));%></strong></td>
                    <td style="color: silver"><c:out value="${order.user.lastName}"/></td>

                    <td><% out.print(bundle.getString("global.type"));%></td>
                    <td style="color: silver"><c:out value="${order.tour.type}"/></td>
                </tr>

                <tr>
                    <td><strong><% out.print(bundle.getString("global.phone"));%></strong></td>
                    <td style="color: silver"><c:out value="${order.user.phone}"/></td>

                    <td><% out.print(bundle.getString("global.city"));%></td>
                    <td style="color: silver"><c:out value="${order.tour.city}"/></td>
                </tr>

                <tr>
                    <td><strong><% out.print(bundle.getString("global.email"));%></strong></td>
                    <td style="color: silver"><c:out value="${order.user.email}"/></td>

                    <td><% out.print(bundle.getString("global.description"));%></td>
                    <td style="color: silver">
                        <c:out value="${order.tour.description}"/>
                        <input type="hidden" name="orderId" value="${order.id}"></td>
                </tr>

                <tr>
                    <td><% out.print(bundle.getString("global.address"));%> <strong> </strong></td>
                    <td style="color: silver"><c:out value="${order.user.address}"/></td>

                    <td><% out.print(bundle.getString("global.cost"));%></td>
                    <td style="color: silver"><c:out value="${order.price}"/></td>
                </tr>

                <tr>
                    <td><% out.print(bundle.getString("global.login"));%> <strong> </strong></td>
                    <td style="color: silver"><c:out value="${order.user.loginName}"/>
                        <input type="hidden" name="userId" value="${order.user.id}"></td>

                    <td><% out.print(bundle.getString("global.hot"));%></td>
                    <td style="color: silver">
                        <c:choose>
                            <c:when test="${order.tour.hot eq ('true')}">
                                <p><% out.print(bundle.getString("global.yes"));%></p>
                            </c:when>
                            <c:otherwise>
                                <p><% out.print(bundle.getString("global.no"));%></p>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>

                <tr>
                </tbody>
            </table>
            <div class="row">
                <div class="12u">
                    <ul class="buttons">
                        <li><input type="submit" class="special" name="manage"
                                   value="<%out.print(bundle.getString("global.approve"));%>"/></li>
                        <li><input type="submit" class="special" name="manage"
                                   value="<%out.print(bundle.getString("global.disapprove"));%>"/></li>
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

<%}%>
</body>
</html>
