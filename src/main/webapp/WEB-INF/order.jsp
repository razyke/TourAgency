<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
          href="${pageContext.request.contextPath}/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.18.custom.min.js"></script>

    <title>Orders</title>
</head>

<body class="contact">

<script>
    $(function() {
        $('input[name=Date]').datepicker();
    });
</script>


<div id="page-wrapper">

    <header id="header">
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            </li>
            <% if (request.getSession().getAttribute("role")!=null) { %>
            <li><a href="welcome?action=signOut" class="button special">Sign out</a></li>
            <% } else {%>
            <li><a href="register" class="button special">Register</a></li>
            <li><a href="login" class="button special">Sign in</a></li>
            <% } %>
        </ul>
    </nav>
    </header>
    <section class="wrapper style4 container">

        <!-- Content -->
        <div class="content">
            <section>
                <a href="#" class="image featured"><img src="img/${tour.title}_b.jpg" alt="" title="" class="property_img"/> </a>
                <header>
                    <h3><c:out value="${tour.title}" /></h3>
                </header>
                <p>
                    <c:out value="${tour.description}" /> <br>
                </p>
            </section>
        </div>
        <form>
            <div class="row 50%">
                <div class="12u">
                    <p> <strong> Select date </strong></p>
                </div>
            </div>
            <div class="row">
                <div class="12u">
                    <input type="text" name="Date" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${order.date}" />" />
                </div>
            </div>

            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <input type="radio" name="days" value="seven"> Price for 7 days: ${tour.costSevenDays} </input>
                </div>
                <div class="6u 12u(mobile)">
                    <input type="radio" name="days" value="ten" checked> Price for 10 days: ${tour.costTenDays} </input>
                </div>
            </div>

            <div class="row">

                <div class="12u">
                    <ul class="buttons">
                        <% if (request.getSession().getAttribute("role") != null) {%>
                        <li><input type="submit" class="special" value="Order" /></li>
                        <% } else { %>
                        <li><input type="submit" class="special" value="Sign in" /></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </form>
    </section>
</div>
</body>
</html>