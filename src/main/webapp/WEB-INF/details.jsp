<%@ page  contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
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
            <td> First name
            <c:out value="{$order.user.firstName}" /> </td>
            <td> Id  <c:out value="{$order.id}" />  </td>
    </tr>

     <tr>
                <td> Last name  <c:out value="{$order.user.lastName}" /> </td>
                <td> Tour  <c:out value="{$order.tour.title}" /> </td>
     </tr>

     <tr>
                <td> Middle name  <c:out value="{$order.user.middleName}" /> </td>
                <td> Description  <c:out value="{$order.tour.description}" /> </td>
     </tr>

     <tr>
                     <td> Phone  <c:out value="{$order.user.phone}" /> </td>
                     <td> Status
                     <c:when test="${order.tour.isHot eq ('true')}">
                     Hot
                      </c:when>
                     </td>
     </tr>
     <tr>
                <td> Email  <c:out value="{$order.user.email}" /> </td>
                <td> Number of days  <c:out value="{$order.days}" /> </td>
     </tr>
     <tr>
                     <td> Address  <c:out value="{$order.user.address}" /> </td>
                     <td> City  <c:out value="{$order.tour.city}" /> </td>
     </tr>
     <tr>
                          <td> Language  <c:out value="{$order.user.language}" /> </td>
                          <td> Price  <c:out value="{$order.price}" /> </td>
          </tr>
     <tr>
                               <td> Is admin
                               <c:choose>
                                               <c:when test="${user.isAdmin eq ('true')}">
                                                   <td><c:out value="Yes"/></td>
                                               </c:when>
                                               <c:otherwise>
                                                   <td><c:out value="No"/></td>
                                               </c:otherwise>
                                           </c:choose>
                               </td>
                               <td> Number of days  <c:out value="{$order.days}" /> </td>
     </tr>
     <tr>
                               <td>  </td>
                               <td> Type  <c:out value="{$order.type}" /> </td>
     </tr>
    </tbody>
    </table>
    <table border = "0">
    <tr>
    <td> <a href="admin?action=approve"> approve </a> </td>
    <td> <a href="admin?action=disapprove"> disapprove </a> </td>
    <td> <a href="admin?action=back"> back </a> </td>
    </tr>
    </table>
</body>
</html>