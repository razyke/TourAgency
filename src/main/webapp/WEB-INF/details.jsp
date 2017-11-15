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
<article id="main">

    <header class="special container">
     <span class="icon fa-laptop"></span>
        <h2>Order details</h2>
    </header>

    <!-- One -->
    <section class="wrapper style4 special container 75%">

    <table align = "center">

    <theah>
    <th colspan = "2" align = "center"> Client info </th>
    <th colspan = "2" align = "center"> Tour info </th>
    </theah>
    <tbody>

    <td> <strong> First name </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.firstName}" /> </td>

    <td> id </td>
    <td style="color: silver"> <c:out value="${order.tour.id}" /> </td>

    <td> <strong> Middle name </strong> </td>
    <td style="color: silver"> <c:out value="${order.user.middleName}" /> </td>

    <td> Title </td>
    <td style="color: silver"> <c:out value="${order.tour.title}" /> </td>

    <td> <strong>  </strong> </td>
    <td style="color: silver">  </td>

    <td>  </td>
    <td style="color: silver">  </td>

    </tbody>
    </table>




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
                         <input type="hidden" name="userId" value="${order.user.id}">
                     </div>
                 </div>

                 <div class="row 50%">
                     <div class="12u">
                         <p> <strong> Tour info </strong></p>
                     </div>
                 </div>

                 <div class="row 50%">
                     <div class="12u(mobile)">
                         <p>  </p>
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
                             <c:when test="${order.tour.hot eq ('true')}">
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
                         <input type="hidden" name="orderId" value="${order.id}">
                     </div>
                 </div>
                <div class="row">
                    <div class="12u">
                        <ul class="buttons">
                            <li><input type="submit" class="special" name="manage" value="Approve" /></li>
                            <li><input type="submit" class="special" name="manage" value="Disapprove" /></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>

    </section>

</article>
</body>
</html>