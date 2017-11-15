<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Discounts</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>
</head>

<body>

<header id="header">
 <h1 id="logo"><a href="index.html">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            <li class="current"><a href="admin">To admin page </a></li>
            <li class="current"><a href="admin?action=users"> Users </a></li>
            <li><a href="/?action=signOut" class="button special">Sign out</a></li>

        </ul>
    </nav>
</header>

<% if (request.getSession().getAttribute("role").equals("admin")) { %>
<article id="main">
    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2> Discounts </h2>
        <p>List of all discounts </p>

    </header>

<section class="wrapper style3 special container 75%">

<form method = "post">
<table align = "center" border = "1">
    <tr>
    <strong>
        <th> Id</th>
        <th> Name </th>
        <th> Value </th>
        <th>Author</th>
        <th>Last update</th>
    </strong>
    </tr>
    <c:forEach items="${discounts}" var="discount">
            <td> <c:out value="${discount.id}" /> </td>
            <td> <c:out value="${discount.name}" /> </td>
            <td> <input type="text" name="value" value="${discount.value}" /> </td>
            <td> <c:out value="${discount.authorId}" /> </td>
            <td> <c:out value="${discount.lastUpdate}" /> </td>
        </tr>
   </c:forEach>
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
</section>
</article>
<% }  else {%>

<article id="main">
    <p align="right" ></p>
    <header class="special container">
        <h2>Classified</h2>
        <p>Please sign as administrator</p>
    </header>

<% } %>

</body>
</html>
