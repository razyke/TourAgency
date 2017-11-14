<%@ page contentType="text/html" pageEncoding = "UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />

        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.dropotron.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.scrollgress.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/util.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Registration </title>
    </head>

    <body>
    <header id="header">
    <h1 id="logo"><a href="index.html">TourAgenstvo <span>Java</span></a></h1>
        <nav id="nav">
            <ul>
                <li class="current"><a href="/">To main page </a></li>
                </li>
                <% if (request.getSession().getAttribute("role")!=null) { %>
                <li><a href="/?action=signOut" class="button special">Sign out</a></li>
                <% } else {%>
                <li><a href="login" class="button special">Sign in</a></li>
                <% } %>
            </ul>
        </nav>
    </header>

    <% if (request.getSession().getAttribute("role")!=null) { %>
    <article id="main">
        <header class="special container">
            <span class="icon fa-envelope"></span>
            <h2>Hello, ${userName}!</h2>
            <p>You signed as  ${role}. </p>
        </header>
    </article>

    <% } else {%>

    <article id="main">
        <p align="right" ></p>
        <header class="special container">
            <span class="icon fa-envelope"></span>
            <h2>Registration</h2>
            <p align = "center">  *Mandatory fields </p>
            <c:forEach items="${registration}" var="reg">

                <p align="center" style="color: red">${reg}<br> </p>

            </c:forEach>
        </header>

        <!-- One -->
        <section class="wrapper style4 special container 75%">

            <!-- Content -->
            <div class="content">
                <form method="POST" action="register">
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="firstName" value="${user.firstName}" placeholder="First name*" />
                        </div>

                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="middleName" value="${user.middleName}" placeholder="Middle name" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="lastName" value="${user.lastName}" placeholder="Last name*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="email" value="${user.email}" placeholder="email*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="phone" value="${user.phone}" placeholder="Phone*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="address" value="${user.address}"  placeholder="Address*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="text" name="userName" value="${user.loginName}" placeholder="Login*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="password" name="password" value="${user.password}" placeholder="Password*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <input type="password" name="password2" value="${user.password2}" placeholder="Repeat password*" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="12u">
                            <ul class="buttons">
                                <li><input type="submit" class="special" value="Register" /></li>
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