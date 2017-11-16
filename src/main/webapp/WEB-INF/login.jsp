<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>

    <meta charset="UTF-8">
    <title><% out.print(bundle.getString("global.login_page"));%></title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />

</head>


<body class="contact">

<div id="page-wrapper">

    <header id="header">
     <h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%> <span>Java</span></a></h1>
        <nav id="nav">
            <ul>
                <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%> </a></li>
                </li>
                <% if (request.getSession().getAttribute("role")!=null) { %>
                <li><a href="/?action=signOut" class="button special"><% out.print(bundle.getString("global.sign_out"));%></a></li>
                <% } else {%>
                <li><a href="register" class="button special"><% out.print(bundle.getString("global.register"));%></a></li>
                <% } %>
            </ul>
        </nav>
    </header>
        <% if (request.getSession().getAttribute("role")!=null) { %>
    <article id="main">
    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2><% out.print(bundle.getString("global.welcome"));%>, ${userName}!</h2>
        <p><% out.print(bundle.getString("global.y_s_a"));%>  ${role}. </p>

    </header>
    </article>

<% } else {%>

<article id="main">
    <p align="right" ></p>
    <header class="special container">
        <span class="icon fa-key"></span>
        <h2><% out.print(bundle.getString("global.login"));%></h2>
        <p><% out.print(bundle.getString("global.u_f_b"));%></p>
        <p style="color: red">${errorString} </p>
    </header>


    <section class="wrapper style4 special container 75%">

        <div class="content">
            <form method="POST" action="login">
                <div class="row">
                    <div class="12u">
                        <input type="text" name="userName" value= "${user.loginName}" placeholder="<% out.print(bundle.getString("global.login"));%>" />
                    </div>

                </div>
                <div class="row">
                    <div class="12u">
                        <input type="password" name="password" value= "${user.password}" placeholder="<% out.print(bundle.getString("global.password"));%>" />
                    </div>
                </div>
                <div class="row">
                    <div class="12u">
                        <ul class="buttons">
                            <li><input type="submit" class="special" value="<% out.print(bundle.getString("global.sign_in"));%>" /></li>
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
