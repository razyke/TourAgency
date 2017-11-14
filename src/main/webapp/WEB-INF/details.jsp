<%@ page  contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
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
<header id="header">
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            <li class="current"><a href="admin">To admin page </a></li>
            <li><a href="welcome?action=signOut" class="button special">Sign out</a></li>

        </ul>
    </nav>
</header>
<article id="main">

    <header class="special container">
        <h2>Order details</h2>
    </header>

    <!-- One -->
    <section class="wrapper style4 special container 75%">

        <!-- Content -->
        <div class="content">
             <form>
                <div class="row 50%">
                 <div class="12u">
                     <p> <strong> Client info </strong></p>
                 </div>
             </div>

                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> First name</p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.user.firstName}" /> </p>
                     </div>
                 </div>

                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Middle name</p>
                     </div>

                     <div class="12u(mobile)">
                         <p> <c:out value="${order.user.middleName}" /></p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Last name</p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.user.lastName}" /> </p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Phone </p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.user.phone}" /> </p>
                     </div>
                 </div>                <div class="row 50%">
                 <div class="12u(mobile)">
                     <p> email </p>
                 </div>
                 <div class="12u(mobile)">
                     <p> <c:out value="${order.user.email}" /> </p>
                 </div>
             </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Address</p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.user.address}" /> </p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Login </p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.user.loginName}" /> </p>
                     </div>
                 </div>

                 <div class="row 50%">
                     <div class="12u">
                         <p> <strong> Tour info </strong></p>
                     </div>
                 </div>

                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> id </p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.tour.id}" /> </p>
                     </div>
                 </div>

                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Title</p>
                     </div>

                     <div class="12u(mobile)">
                         <p> <c:out value="${order.tour.title}" /></p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Type </p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.tour.type}" /> </p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> City </p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.tour.city}" /> </p>
                     </div>
                 </div>
                 <div class="row 50%">
                 <div class="12u(mobile)">
                     <p> Days </p>
                 </div>
                 <div class="12u(mobile)">
                     <p> <c:out value="${order.days}" /> </p>
                 </div>
             </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Price </p>
                     </div>
                     <div class="12u(mobile)">
                         <p> <c:out value="${order.price}" /> </p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p> Hot </p>
                     </div>
                     <div class="12u(mobile)">
                         <c:choose>
                             <c:when test="${user.tour.isHot eq ('true')}">
                                 <p><c:out value="Yes"/></p>
                             </c:when>
                             <c:otherwise>
                                 <p><c:out value="No"/></p>
                             </c:otherwise>
                         </c:choose>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u">
                         <p> <c:out value="${order.tour.description}" /> </p>
                     </div>
                 </div>
                 <div class="row 50%">
                     <div class="12u">
                         <p> Description </p>
                     </div>
                 </div>
                <div class="row">
                    <div class="12u">
                        <ul class="buttons">
                            <li><input type="submit" class="special" value="Approve" /></li>
                            <li><input type="submit" class="special" value="Disapprove" /></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>

    </section>

</article>
</body>
</html>
<%--
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
            <c:out value="${order.user.firstName}" /> </td>
        <td> Id  <c:out value="${order.id}" />  </td>
    </tr>

    <tr>
        <td> Last name  <c:out value="${order.user.lastName}" /> </td>
        <td> Tour  <c:out value="${order.tour.title}" /> </td>
    </tr>

    <tr>
        <td> Middle name  <c:out value="${order.user.middleName}" /> </td>
        <td> Description  <c:out value="${order.tour.description}" /> </td>
    </tr>

    <tr>
        <td> Phone  <c:out value="${order.user.phone}" /> </td>
        <td> Status
            <%--  <c:when test="${order.tour.isHot eq ('true')}">
              Hot
               </c:when>--%>
       <%-- </td>
    </tr>
    <tr>
        <td> Email  <c:out value="${order.user.email}" /> </td>
        <td> Number of days  <c:out value="${order.days}" /> </td>
    </tr>
    <tr>
        <td> Address  <c:out value="${order.user.address}" /> </td>
        <td> City  <c:out value="${order.tour.city}" /> </td>
    </tr>
    <tr>
        <td> Language  <c:out value="${order.user.language}" /> </td>
        <td> Price  <c:out value="${order.price}" /> </td>
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
        <td> Number of days  <c:out value="${order.days}" /> </td>
    </tr>
    <tr>
        <td>  </td>
        <td> Type  NOT PREPARED<%--<c:out value="${order.type}"--%> /> <%--</td>
    </tr>
    </tbody>
</table>
<table border = "0">
    <tr>
        <td> <a href="admin?action=approve"> approve </a> </td>
        <td> <a href="admin?action=disapprove"> disapprove </a> </td>
        <td> <a href="admin?action=back"> back </a> </td>
    </tr>
</table>--%>
