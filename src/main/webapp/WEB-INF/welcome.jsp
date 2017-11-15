<%@ page import="java.util.ResourceBundle" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="ru_RU" scope="session" />
<fmt:setBundle basename="text" scope="session" />
<!DOCTYPE html>

<html>
<head>
    <%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <meta charset="UTF-8">

    <title> Welcome </title>

</head>

<body>
<section class="hero">
    <header>
        <div class="wrapper">
            <nav>
                <ul>
                    <li><a href="/?action=changeLanguage"> <%out.print(bundle.getString("global.language"));%> </a></li>
                    <% if (request.getSession().getAttribute("role")==null) { %>
                    <li><a href="register"><%out.print(bundle.getString("global.register"));%></a></li>
                    <% } else  if (request.getSession().getAttribute("role").equals("admin")) {%>
                    <li><a href="admin"><%out.print(bundle.getString("global.to_admin_page"));%> </a></li>
                    <li><a href="editTour?action=addTour"> <%out.print(bundle.getString("global.add_tour"));%> </a></li>
                    <% } %>
                </ul>
                <% if (request.getSession().getAttribute("role")==null) { %>
                <a href="login" class="login_btn"> <%out.print(bundle.getString("global.sign_in"));%> </a>
                <% } else {%>
                <a href="/?action=signOut" class="login_btn"> <%out.print(bundle.getString("global.sign_out"));%> </a>
                <% } %>
            </nav>
        </div>
    </header><!--  end header section  -->

<!--remove me: resource bundle example-->
<!--<h2><fmt:message key="button.register" /></h2>-->
<!--remove me/-->

<h3 align = "center" style = "color: green" > ${registration} </h3>
<h3 align = "center" style="color: green"> ${message} </h3>
<h3 align = "center" style="color: red"> ${errorMessage} </h3>

    <section class="caption">
        <h2 class="caption">Find You Perfect Trip</h2>
        <h3 class="properties"><%out.print(bundle.getString("global.ad"));%></h3>
    </section>
</section><!--  end hero section  -->

    <h2 align= "center" > <strong> <%out.print(bundle.getString("global.wonderful_message"));%> </strong></h2>


<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <c:forEach items="${tours}" var="tour">
            <li>
            <% if (request.getSession().getAttribute("role")==null||request.getSession().getAttribute("role").equals("user")) { %>

               <a href="order?action=order&tourId=<c:out value="${tour.id}"/>">
                <% }  else {%>
                 <a href="editTour?action=edit&tourId=<c:out value="${tour.id}"/>">

                <% } %>
                    <img src="img/${tour.id}.jpg" alt="" title="" class="property_img"/>

                </a>
                <span class="price"><c:out value = "${tour.costSevenDays} $"/></span>
                <div class="property_details">
                    <h1>
                        <c:out value = "${tour.title}"/>
                    </h1>
                    <h2> <c:choose>
                       <c:when test="${order.tour.hot eq ('true')}">
                           <p style="color: red"><c:out value="Hot!"/></p>
                       </c:when>
                     </c:choose>
                    <c:out value = "${tour.type}"/><span class="property_size"></span></h2>
                </div>
            </c:forEach>
        </ul>
        <div class="more_listing">
            <a href="#" class="more_listing_btn"><%out.print(bundle.getString("global.view_more_tours"));%></a>
        </div>
    </div>
</section>	<!--  end listing section  -->

</body>
</html>