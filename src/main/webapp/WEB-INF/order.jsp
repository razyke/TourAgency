<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Orders</title>
</head>

<body>
<h3 align="center">Orders</h3>
<a href="/TourAgency/"> To main page </a>
<h2> <c:out value="${tour.tourName}" /> </h2>

<p>
    <c:out value="${tour.tourDescription}" />
</p>

<p> Choose number of days </p>

<form method = "post" name="days">

    <input type="radio" name="days" value="7"> </input>
    <input type="radio" name="days" value="10"> </input>
    <input type="submit" value="order ${tourId}"> </input>

</form>

</body>
</html>