<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>

</head>


<body class="contact">

<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <nav id="nav">
            <ul>
                <li class="current"><a href="/">To main page </a></li>
                </li>
                <% if (request.getSession().getAttribute("role")!=null) { %>
                <li><a href="/?action=signOut" class="button special">Sign out</a></li>
                <% } else {%>
                <li><a href="register" class="button special">Register</a></li>
                <% } %>
            </ul>
        </nav>
    </header>
        <% if (request.getSession().getAttribute("role")!=null) { %>
    <article id="main">
    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2>Hello, ${userName}!</h2>
        <p>You signed as  ${role}. </p>

    </header>
    </article>

<% } else {%>

<article id="main">
    <p align="right" ></p>
    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2>Login</h2>
        <p>Use the form below to sign in </p>
        <p style="color: red">${errorString} </p>
    </header>

    <!-- One -->
    <section class="wrapper style4 special container 75%">

        <!-- Content -->
        <div class="content">
            <form method="POST" action="login">
                <div class="row">
                    <div class="12u">
                        <input type="text" name="userName" value= "${user.loginName}" placeholder="Login" />
                    </div>

                </div>
                <div class="row">
                    <div class="12u">
                        <input type="password" name="password" value= "${user.password}" placeholder="Password" />
                    </div>
                </div>
                <div class="row">
                    <div class="12u">
                        <ul class="buttons">
                            <li><input type="submit" class="special" value="Sign in" /></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>

    </section>

</article>

<% } %>

</body>
</html>
