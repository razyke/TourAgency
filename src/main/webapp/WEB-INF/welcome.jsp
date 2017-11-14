<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <meta charset="UTF-8">
    <title>Welcome Page</title>

</head>

<body>
<section class="hero">
    <header>
        <div class="wrapper">
            <nav>
                <ul>

                    <% if (request.getSession().getAttribute("role")==null) { %>
                    <li><a href="register">Register</a></li>
                    <% } else {%>
                    <li><a href="admin">To admin page </a></li>
                    <% } %>
                </ul>
                <% if (request.getSession().getAttribute("role")==null) { %>
                <a href="login" class="login_btn"> Sign in </a>
                <% } else {%>
                <a href="/?action=signOut" class="login_btn"> Sign out </a>
                <% } %>
            </nav>
        </div>
    </header><!--  end header section  -->
<p align = "center" style = "color: green" > ${registration} </p>

    <h3 align="center" style="color:green" > ${registration}</h3>
    <h3 align="center" style="color:green" > ${message}</h3>
    <h3 align="center" style="color:red" > ${errorMessage}</h3>

    <section class="caption">
        <h2 class="caption">Find You Perfect Trip</h2>
        <h3 class="properties">Rest - Excursion - shopping</h3>
    </section>
</section><!--  end hero section  -->

    <h2 align= "center" > <strong> Our wonderful tours </strong></h2>


<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <c:forEach items="${tours}" var="tour">
            <li>
                <a href="order?action=order&tourId=<c:out value="${tour.id}"/>">
                    <img src="img/${tour.title}.jpg" alt="" title="" class="property_img"/>
                </a>
                <span class="price"><c:out value = "${tour.costSevenDays} $"/></span>
                <div class="property_details">
                    <h1>
                        <a href="order?action=order&tourId"><c:out value = "${tour.title}"/></a>
                    </h1>
                </div>
            </li>
            </c:forEach>
        </ul>
        <div class="more_listing">
            <a href="#" class="more_listing_btn">View More Tours</a>
        </div>
    </div>
</section>	<!--  end listing section  -->

</body>
</html>