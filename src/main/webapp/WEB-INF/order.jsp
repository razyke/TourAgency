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

<p> <c:out value="${language}" />" </p>

<form method = "post" action = "order">

<input
        type="text" name="Date"
        value="<fmt:formatDate pattern="MM/dd/yyyy" value="${order.date}" />" /> <br /><br/>

<input type="radio" name="days" value="seven"> Price for 7 days: ${tour.costSevenDays}<br> </input>
<br>
<input type="radio" name="days" value="ten"> Price for 10 days: ${tour.costTenDays} <br> </input>
<input type="submit" value="order"> </input>
<br>
</form>

</body>
</html>