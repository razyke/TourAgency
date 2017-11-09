<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>

<body>
<h3 align="center">Orders</h3>
<a href="/TourAgency/"> To main page </a>

<table align = "center" border = "1">

 <thead>
    <tr>
        <th> Client info </th>
        <th> Tour info </th>

    </tr>
    </thead>

    <tbody>

    <tr>
            <td> First name  <c:out value="{$order.user.firstName}" /> </td>
            <td> Id  <c:out value="{$order.idOrder}" />  </td>
    </tr>

     <tr>
                <td> Last name  <c:out value="{$order.user.lastName}" /> </td>
                <td> Tour  <c:out value="{$order.tourName}" /> </td>
     </tr>

     <tr>
                <td> Middle name  <c:out value="{$order.user.middleName}" /> </td>
                <td> Description  <c:out value="{$order.tourDescription}" /> </td>
     </tr>

     <tr>
                     <td> Phone  <c:out value="{$order.user.phone}" /> </td>
                     <td> Status
                     <c:when test="${order.tourIsHot eq ('true')}">
                     Hot
                      </c:when>
                     </td>
     </tr>
     <tr>
                <td> Email  <c:out value="{$order.user.email}" /> </td>
                <td> Number of days  <c:out value="{$order.tourDays}" /> </td>
     </tr>
     <tr>
                     <td> Address  <c:out value="{$order.user.address}" /> </td>
                     <td> City  <c:out value="{$order.tourCity}" /> </td>
     </tr>
    </tbody>
</body>
</html>