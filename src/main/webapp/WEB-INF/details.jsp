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
 <h1 id="logo"><a href="#">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            <li class="current"><a href="admin">To admin page </a></li>
            <li><a href="/?action=signOut" class="button special">Sign out</a></li>

        </ul>
    </nav>
</header>
<% if (request.getSession().getAttribute("role").equals("admin")) { %>
<article id="main">

    <header class="special container">
     <span class="icon fa-keyboard-o"></span>
        <h2>Order details</h2>
    </header>

    <!-- One -->
    <section class="wrapper style4 special container 75%">

        <form method="post" name="manage">

    <table align = "center">

    <theah>
    <th colspan = "2" align = "center"> Client info </th>
    <th colspan = "2" align = "center"> Tour info </th>
    </theah>
    <tbody>

    <tr>
    <td> <strong> First name </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.firstName}" /> </td>

    <td> id </td>
    <td style="color: silver"> <c:out value="${order.tour.id}" /> </td>
    </tr>

    <tr>
    <td> <strong> Middle name </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.middleName}" /> </td>

    <td> Title </td>
    <td style="color: silver"> <c:out value="${order.tour.title}" /> </td>
    </tr>

    <tr>
    <td> <strong> Last name </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.lastName}" /> </td>

    <td> Type </td>
    <td style="color: silver"> <c:out value="${order.tour.type}" /> </td>
    </tr>

    <tr>
    <td> <strong> Phone </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.phone}" /> </td>

    <td> City </td>
    <td style="color: silver"> <c:out value="${order.tour.city}" /> </td>
    </tr>

    <tr>
    <td> <strong> email  </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.email}" /> </td>

    <td> Description </td>
    <td style="color: silver">
    <c:out value="${order.tour.description}" />
     <input type="hidden" name="orderId" value="${order.id}"></td>
    </tr>

    <tr>
    <td> Address <strong>   </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.address}" /> </td>

    <td> Cost </td>
    <td style="color: silver"> <c:out value="${order.price}" /> </td>
    </tr>

    <tr>
    <td> Login <strong>  </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.loginName}" />
      <input type="hidden" name="userId" value="${order.user.id}"> </td>

    <td> Hot </td>
    <td style="color: silver">
     <c:choose>
         <c:when test="${order.tour.hot eq ('true')}">
             <p><c:out value="Yes"/></p>
         </c:when>
         <c:otherwise>
             <p><c:out value="No"/></p>
         </c:otherwise>
     </c:choose>
     </td>
    </tr>

    <tr>
    </tbody>
    </table>
 <div class="row">
                    <div class="12u">
                        <ul class="buttons">
                            <li><input type="submit" class="special" name="manage" value="Approve" /></li>
                            <li><input type="submit" class="special" name="manage" value="Disapprove" /></li>
                        </ul>
                    </div>
                </div>
            </form>
<% }  else {%>

<article id="main">
    <p align="right" ></p>
    <header class="special container">
        <h2>Classified</h2>
        <p>Please sign as administrator</p>
    </header>

<% } %>
</section>

</article>
</body>
</html>
