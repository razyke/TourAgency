<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <% ResourceBundle bundle = (ResourceBundle) request.getSession().getAttribute("bundle"); %>

    <title><% out.print(bundle.getString("global.edit_tour"));%></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css"/>
</head>
<body class="contact">
<header id="header">
    <h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%> <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%></a></li>
            <li><a href="/?action=signOut"
                   class="button special"><% out.print(bundle.getString("global.sign_out"));%></a></li>
        </ul>
    </nav>
</header>
<% if ((!(request.getSession().getAttribute("role") == null)) && request.getSession().getAttribute("role").equals("admin")) { %>
<article id="main">
    <header class="special container">
        <span class="icon fa-edit"></span>
        <h2><% out.print(bundle.getString("global.edit_tour"));%></h2>
        <p><% out.print(bundle.getString("global.use_form_e_t"));%></p>
    </header>

    <section class="wrapper style4 special container 75%">
        <div class="content">
            <form method="post">

                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <p align="center"><strong><% out.print(bundle.getString("global.title"));%></strong></p>
                    </div>
                    <div class="6u 12u(mobile)">
                        <p align="center"><strong><% out.print(bundle.getString("global.city"));%></strong></p>
                    </div>
                </div>

                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <input type="text" name="title" value="${tour.title}"/>
                    </div>
                    <div class="6u 12u(mobile)">
                        <input type="text" name="city" value="${tour.city}"/>
                    </div>
                </div>

                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <p align="center"><strong><% out.print(bundle.getString("global.price7"));%></strong></p>
                    </div>
                    <div class="6u 12u(mobile)">
                        <p align="center"><strong><% out.print(bundle.getString("global.price10"));%></strong></p>
                    </div>
                </div>

                <% if (request.getParameter("tourId") != null) {%>
                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <input type="text" name="price7" value="${tour.costSevenDays}"/>
                    </div>
                    <div class="6u 12u(mobile)">
                        <input type="text" name="price10" value="${tour.costTenDays}"/>
                    </div>
                </div>
                <% } else { %>
                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <input type="text" name="price7" value="0"/>
                    </div>
                    <div class="6u 12u(mobile)">
                        <input type="text" name="price10" value="0"/>
                    </div>
                </div>
                <% } %>
                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <p align="center"><strong><% out.print(bundle.getString("global.type"));%></strong></p>
                    </div>
                    <div class="6u 12u(mobile)">
                        <p align="center"><strong><% out.print(bundle.getString("global.hot"));%></strong>
                            <c:choose>
                            <c:when test="${tour.hot eq ('true')}">
                            <input
                                    type="checkbox" name="isHot" checked="checked"
                                    value="true"/>
                            </c:when>
                            <c:otherwise>
                            <input type="checkbox" name="isHot"
                                   value="false"/>
                            </c:otherwise>
                            </c:choose>
                    </div>
                </div>

                <div class="row 50%">
                    <div class="6u 12u(mobile)">
                        <c:choose>
                            <c:when test="${tour.type eq ('excursion')}">
                                <select id="type" name="typeId">
                                    <option selected
                                            value="Excursion"><% out.print(bundle.getString("global.Excursion"));%></option>
                                    <option value="Shopping"><% out.print(bundle.getString("global.Shopping"));%></option>
                                    <option value="Rest"><% out.print(bundle.getString("global.Rest"));%></option>
                                </select>
                                <br/>
                            </c:when>
                            <c:when test="${tour.type eq ('rest')}">
                                <select id="type" name="typeId">
                                    <option selected
                                            value="Rest"><% out.print(bundle.getString("global.Rest"));%></option>
                                    <option value="Shopping"><% out.print(bundle.getString("global.Shopping"));%></option>
                                    <option value="Excursion"><% out.print(bundle.getString("global.Excursion"));%></option>
                                </select>
                                <br/>
                            </c:when>
                            <c:when test="${tour.type eq ('shopping')}">
                                <select id="type" name="typeId">
                                    <option selected
                                            value="Shopping"><% out.print(bundle.getString("global.Shopping"));%></option>
                                    <option value="Rest"><% out.print(bundle.getString("global.Rest"));%></option>
                                    <option value="Excursion"><% out.print(bundle.getString("global.Excursion"));%></option>
                                </select>
                                <br/>
                            </c:when>
                            <c:otherwise>
                                <select id="type" name="typeId">
                                    <option selected
                                            value="Excursion"><% out.print(bundle.getString("global.Excursion"));%></option>
                                    <option value="Shopping"><% out.print(bundle.getString("global.Shopping"));%></option>
                                    <option value="Rest"><% out.print(bundle.getString("global.Rest"));%></option>
                                </select>
                                <br/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="6u 12u(mobile)">

                    </div>
                </div>
                <div class="row 50%">
                    <div class="12u">
                        <p align="center"><strong><% out.print(bundle.getString("global.description"));%></strong></p>
                    </div>
                </div>
                <div class="row 50%">
                    <div class="12u">
                        <input type="text" name="description" value="${tour.description}"/></div>
                </div>
                <div class="row">
                    <div class="12u">
                        <% if (request.getParameter("tourId") != null) { %>
                        <ul class="buttons">
                            <input type="hidden" name="tourid" value="${tour.id}"/>
                            <li><input type="submit" class="special" name="manage"
                                       value="<% out.print(bundle.getString("global.edit"));%>"/></li>
                            <li><input type="submit" class="special" name="manage"
                                       value="<% out.print(bundle.getString("global.delete"));%>"/></li>
                        </ul>
                        <% } else { %>
                        <ul class="buttons">
                            <li><input type="submit" class="special" name="manage"
                                       value="<% out.print(bundle.getString("global.add"));%>"/></li>
                            <li><input type="submit" class="special" name="manage"
                                       value="<% out.print(bundle.getString("global.cancel"));%>"/></li>
                        </ul>
                        <% } %>
                    </div>
                </div>

            </form>
        </div>
    </section>
</article>
<% } else {%>

<article id="main">
    <header class="special container">
        <span class="icon fa-shield"></span>
        <h2><%out.print(bundle.getString("global.classified"));%></h2>
        <p><%out.print(bundle.getString("global.please_sign_in_as_admin"));%></p>
    </header>
</article>

<% } %>

</body>
</html>