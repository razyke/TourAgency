<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
          href="${pageContext.request.contextPath}/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.18.custom.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>
    <title>Orders</title>
</head>

<body>
<script>
    $(function() {
        $('input[name=Date]').datepicker();
    });
</script>
<h3 align="center">Orders</h3>
<a href="${pageContext.request.contextPath}"> To main page </a>
<h2> <c:out value="${tour.title}" /> </h2>

<p>
<c:out value="${tour.description}" /> <br>
</p>


<p> Choose number of days </p>

<!-- I don't think that wee need part of code below !-->
<%--<p> <c:out value="${language}" /> </p>--%>

<form method = "post" action = "order">

<input
        type="text" name="Date"
        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${order.date}" />" /> <br /><br/>

<input type="radio" name="days" value="seven"> Price for 7 days: ${tour.costSevenDays}<br> </input>
<br>
<input type="radio" name="days" value="ten"> Price for 10 days: ${tour.costTenDays} <br> </input>
    <% if (request.getSession().getAttribute("role") != null) {%>
    </br>
<input type="submit" value="order"> </input>
<br>
    <% } else { %>
    </br>
    To order please login or register.</br></br>
    <a href="login"> Login </a> </br></br>
    <a href="register"> Registration </a> </br>
    <% } %>
</form>

</body>
</html>