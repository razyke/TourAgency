<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Orders</title>
</head>

<body>
<h3 align="center">Orders</h3>
<a href="/TourAgency/"> To main page </a>
<h2> <c:out value="${tour.title}" /> </h2>

<p>
<c:out value="${tour.description}" />
</p>

<table border = "0">
<tr>
<td> Price for 7 days: </td>
<td> "${tour.costSevenDays}"
</tr>
<tr>
<td> Price for 10 days: </td>
<td> "${tour.costTenDays}"
</tr>
</table>

<p> Choose number of days </p>

<form method = "post" action = "order">

<input type="radio" name="days" value="7"> </input>
<input type="radio" name="days" value="10"> </input>
<input type="submit" value="order ${tour.id}"> </input>

</form>

</body>
</html>