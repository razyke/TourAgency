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
                    <li><a href="admin">To admin page </a></li>
                    <% if (request.getSession().getAttribute("role")==null) { %>
                    <li><a href="register">Register</a></li>
                </ul>
                <a href="login" class="login_btn"> Sign in </a>
                <% } else {%>
                <a href="welcome?action=signOut" class="login_btn"> Sign out </a>
                <% } %>
            </nav>
        </div>
    </header><!--  end header section  -->
<p align = "center" style = "color: green" > ${registration} </p>

    <section class="caption">
        <h2 class="caption">Find You Perfect Trip</h2>
        <h3 class="properties">Rest - Excursion - shopping</h3>
    </section>
</section><!--  end hero section  -->

    <h2 align= "center" > <strong> Our wonderful tours </strong></h2>

<%-- <form>
            <select id="language" name="language" onchange="submit()">
                <option value="EN" ${language == 'EN' ? 'selected' : ''}>English</option>
                <option value="RU" ${language == 'RU' ? 'selected' : ''}>Русский</option>
            </select>
        </form>--%>
<%--<h3 align="center"><fmt:message key="label.greeting" /></h3>
<h3 align="center"> Select Tour </h3>--%>
<c:forEach items="${tours}" var="tour">
<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <li>
                <a href="order?action=order&tourId=<c:out value="${tour.id}"/>">
                    <img src="img/property_1.jpg" alt="" title="" class="property_img"/>
                </a>
                <span class="price"><c:out value = "${tour.costSevenDays}"/></span>
                <div class="property_details">
                    <h1>
                        <a href="#"><c:out value = "${tour.title}"/></a>
                    </h1>
                </div>
            </li>
            <li>
                <a href="order?action=order&tourId=<c:out value="${tour.id}"/>">
                    <img src="img/property_1.jpg" alt="" title="" class="property_img"/>
                </a>
                <span class="price"><c:out value = "${tour.costSevenDays}"/></span>
                <div class="property_details">
                    <h1>
                        <a href="#"><c:out value = "${tour.title}"/></a>
                    </h1>
                </div>
            </li>
            <li>
                <a href="order?action=order&tourId=<c:out value="${tour.id}"/>">
                    <img src="img/property_3.jpg" alt="" title="" class="property_img"/>
                </a>
                <span class="price"><c:out value = "${tour.costSevenDays}"/></span>
                <div class="property_details">
                    <h1>
                        <a href="#"><c:out value = "${tour.title}"/></a>
                    </h1>
                </div>
            </li>
        </ul>
    </div>
</section>	<!--  end listing section  -->
</c:forEach>

<%--<a href = "order?action=order&tourId=<c:out value="${tour.id}"/>"></br></br>
    <c:out value = "${tour.title}"/> </a>--%>






<%--< form action=register>
    <p align="right">
        <button type="submit" value="register">Register</button>
    </p>--%>


<%--<% } else {%>
</>
<a href="admin"> To admin page </a>
<p align="center"> Hello, ${userName}! </p>
<p align="center"> You signed as  ${role}. </p>
<a href="welcome?action=signOut"> sign out </a>
--%>

</body>
</html>