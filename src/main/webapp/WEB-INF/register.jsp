<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <% ResourceBundle bundle = (ResourceBundle) request.getSession().getAttribute("bundle"); %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title> <% out.print(bundle.getString("global.registration"));%> </title>

</head>

<body>

<header id="header">

    <h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%> <span> Java </span> </a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%></a></li>
            </li>
            <% if (request.getSession().getAttribute("role") != null) { %>
            <li><a href="/?action=signOut" class="button special"><%
                out.print(bundle.getString("global.sign_out"));%></a></li>

            <% } else {%>

            <li><a href="login" class="button special"><% out.print(bundle.getString("global.sign_in"));%></a></li>

            <% } %>

        </ul>
    </nav>
</header>

<% if (request.getSession().getAttribute("role") != null) { %>
<article id="main">
    <header class="special container">
        <span class="icon fa-envelope"></span>
        <h2><a href="/"><% out.print(bundle.getString("global.hello"));%>, ${userName}!</h2>
        <p><% out.print(bundle.getString("global.y_s_a"));%>  ${role}. </p>
    </header>
</article>

<% } else {%>

<article id="main">

    <header class="special container">
        <span class="icon fa-user-plus"> </span>

        <h2><% out.print(bundle.getString("global.registration"));%></h2>

        <p align="center"><% out.print(bundle.getString("global.mandatory"));%></p>

        <c:forEach items="${registration}" var="reg">
            <p align="center" style="color: red">${reg}<br></p>
        </c:forEach>
    </header>

    <section class="wrapper style4 special container 75%">

        <div class="content">

            <form method="POST" action="register">

                <div class="row">
                    <div class="12u">
                        <input type="text" name="firstName" value="${user.firstName}"
                               placeholder="<% out.print(bundle.getString("global.first_name"));%>*"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="text" name="middleName" value="${user.middleName}"
                               placeholder="<% out.print(bundle.getString("global.middle_name"));%>"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="text" name="lastName" value="${user.lastName}"
                               placeholder="<% out.print(bundle.getString("global.last_name"));%>*"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="text" name="email" value="${user.email}"
                               placeholder="<% out.print(bundle.getString("global.email"));%>*"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="text" name="phone" value="${user.phone}"
                               placeholder="<% out.print(bundle.getString("global.first_name"));%>*"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="text" name="address" value="${user.address}"
                               placeholder="<% out.print(bundle.getString("global.address"));%>"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="text" name="userName" value="${user.loginName}"
                               placeholder="<% out.print(bundle.getString("global.login"));%>*"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <input type="password" name="password" value="${user.password}"
                               placeholder="<% out.print(bundle.getString("global.password"));%>*"/>
                    </div>
                </div>
                <div class="row">
                    <div class="12u">
                        <input type="password" name="password2" value="${user.password2}"
                               placeholder="<% out.print(bundle.getString("global.repeat_pass"));%>*"/>
                    </div>
                </div>

                <div class="row">
                    <div class="12u">
                        <ul class="buttons">
                            <li><input type="submit" class="special"
                                       value="<% out.print(bundle.getString("global.register"));%>"/></li>
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
