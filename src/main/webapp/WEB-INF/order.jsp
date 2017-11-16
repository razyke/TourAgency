<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>
    <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
<link type="text/css"
          href="${pageContext.request.contextPath}/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.18.custom.min.js"></script>

    <title><% out.print(bundle.getString("global.orders"));%></title>
</head>

<body class="no-sidebar">

<script>
    $(function() {
        $('input[name=Date]').datepicker();
    });
</script>


<div id="page-wrapper">

    <header id="header">
     <h1 id="logo"><a href="index.html"><% out.print(bundle.getString("global.touragency"));%> <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%> </a></li>
            </li>
            <% if (request.getSession().getAttribute("role")!=null) { %>
            <li><a href="/?action=signOut" class="button special"><% out.print(bundle.getString("global.sign_out"));%></a></li>
            <% } else {%>
            <li><a href="register" class="button special"><% out.print(bundle.getString("global.register"));%></a></li>
            <li><a href="login" class="button special"><% out.print(bundle.getString("global.sign_in"));%></a></li>
            <% } %>
        </ul>
    </nav>
    </header>
    <article id="main">
    <header class="special container">
    						<span class="icon fa-mobile"></span>
    						<h2> <strong> <c:out value="${tour.city}" /></strong></h2>
    						<p> <c:out value="${tour.type}" /> tour </p>
    					</header>
    <section class="wrapper style4 container">

        <!-- Content -->
        <div class="content">
            <section>
                <a href="#" class="image featured"><img src="img/${tour.id}_b.jpg" alt="" title="" class="property_img"/> </a>
                <header>
                    <h3><c:out value="${tour.title}" /></h3>
                </header>
                <p>
                    <c:out value="${tour.description}" /> <br>
                </p>
            </section>
        </div>
        <%--<a href="admin?action=detail&idOrder=<c:out value="${order.id}"/>"> Details </a>--%>
        <form method="post" action="order">
            <input type="hidden" name="tourId" value="<c:out value="${tour.id}"/>">
            <div class="row 50%">
                <div class="12u">
                    <p> <strong> <% out.print(bundle.getString("global.select_date"));%> </strong></p>
                </div>
            </div>
            <div class="row">
                <div class="12u">
                    <input type="text" name="Date" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${order.date}" />" />
                </div>
            </div>

            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <input type="radio" name="days" value="seven"> <% out.print(bundle.getString("global.price7"));%>: ${tour.costSevenDays} </input>
                     <input type="hidden" name="cost7" value="${tour.costSevenDays}"> </input>
                </div>
                <div class="6u 12u(mobile)">
                    <input type="radio" name="days" value="ten" checked> <% out.print(bundle.getString("global.price10"));%>: ${tour.costTenDays} </input>
                    <input type="hidden" name="cost10" value="${tour.costTenDays}"> </input>
                </div>
            </div>

            <div class="row">

                <div class="12u">
                    <ul class="buttons">
                        <% if (request.getSession().getAttribute("role") != null) {%>
                        <li><input type="submit" class="special" value="<% out.print(bundle.getString("global.order"));%>" /></li>
                        <% } else { %>
                        <li><a href="login" class="button special"> <% out.print(bundle.getString("global.sign_in"));%> </a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </form>
    </section>
    </article>
</div>
<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollgress.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>