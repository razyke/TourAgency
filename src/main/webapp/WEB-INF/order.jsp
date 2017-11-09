<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<form method = "post" name="days">
<input type="radio" name="days" value="7"> </input>
<input type="radio" name="days" value="10"> </input>
</form>
</body>
</html>