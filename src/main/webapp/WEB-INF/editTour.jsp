<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <%  ResourceBundle bundle = (ResourceBundle)request.getSession().getAttribute("bundle"); %>

    <title> <% out.print(bundle.getString("global.edit_tour"));%></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
</head>
<body class="contact">
<header id="header">
 <h1 id="logo"><a href="#"><% out.print(bundle.getString("global.touragency"));%> <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/"><% out.print(bundle.getString("global.tomainpage"));%> </a></li>
            <li><a href="/?action=signOut" class="button special"><% out.print(bundle.getString("global.sign_out"));%></a></li>
        </ul>
    </nav>
</header>
<article id="main">
					<header class="special container">
						<span class="icon fa-tablet"></span>
						<h2><% out.print(bundle.getString("global.edit_tour"));%></h2>
						<p><% out.print(bundle.getString("global.use_form_e_t"));%></p>
					</header>

					<!-- One -->
						<section class="wrapper style4 special container 75%">
								<div class="content">
        <form method="post">

            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> <% out.print(bundle.getString("global.title"));%> </strong> </p>
                </div>
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> <% out.print(bundle.getString("global.city"));%> </strong> </p>
                </div>
            </div>

            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <input type="text" name="title" value="${tour.title}" />
                </div>
                <div class="6u 12u(mobile)">
                    <input type="text" name="city" value="${tour.city}" />
                </div>
            </div>

            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> <% out.print(bundle.getString("global.price7"));%> </strong> </p>
                </div>
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> <% out.print(bundle.getString("global.price10"));%> </strong> </p>
                </div>
            </div>

            <% if (request.getParameter("tourId") != null) {%>
                        <div class="row 50%">
                            <div class="6u 12u(mobile)">
                                <input type="text" name="price7" value="${tour.costSevenDays}" />
                            </div>
                            <div class="6u 12u(mobile)">
                                <input type="text" name="price10" value="${tour.costTenDays}" />
                            </div>
                        </div>
            <% } else { %>
            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <input type="text" name="price7" value="0" />
                </div>
                <div class="6u 12u(mobile)">
                    <input type="text" name="price10" value="0" />
                </div>
            </div>
            <% } %>
            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> <% out.print(bundle.getString("global.type"));%> </strong> </p>
                </div>
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> <% out.print(bundle.getString("global.hot"));%> </strong>
                    <c:choose>
                            <c:when test="${tour.hot eq ('true')}">
                                <input
                                        type="checkbox" name="isHot" checked="checked"
                                        value="true" />
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" name="isHot"
                                                        value="false" />
                                            </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>

                            <div class="row 50%">
                                <div class="6u 12u(mobile)">
                                    <c:choose>
                                        <c:when test="${tour.type eq ('excursion')}">
                                        <select id="type" name="typeId">
                                            <option selected value="Excursion"> <% out.print(bundle.getString("global.excursion"));%> </option>
                                            <option value="Shopping"> <% out.print(bundle.getString("global.shopping"));%> </option>
                                            <option value="Rest"> <% out.print(bundle.getString("global.rest"));%> </option>
                                        </select>
                                        <br/>
                                        </c:when>
                                        <c:when test="${tour.type eq ('rest')}">
                                        <select id="type" name="typeId">
                                            <option selected value="Rest"> <% out.print(bundle.getString("global.rest"));%> </option>
                                            <option value="Shopping"> <% out.print(bundle.getString("global.shopping"));%></option>
                                            <option value="Excursion"> <% out.print(bundle.getString("global.excursion"));%> </option>
                                        </select>
                                        <br/>
                                        </c:when>
                                        <c:when test="${tour.type eq ('shopping')}">
                                        <select id="type" name="typeId">
                                            <option selected value="Shopping"> <% out.print(bundle.getString("global.shopping"));%> </option>
                                            <option value="Rest"> <% out.print(bundle.getString("global.rest"));%> </option>
                                            <option value="Excursion"> <% out.print(bundle.getString("global.excursion"));%> </option>
                                        </select>
                                        <br/>
                                        </c:when>
                                        <c:otherwise>
                                        <select id="type" name="typeId">
                                            <option selected value="Excursion"> <% out.print(bundle.getString("global.excursion"));%> </option>
                                            <option value="Shopping"> <% out.print(bundle.getString("global.shopping"));%></option>
                                            <option value="Rest"> <% out.print(bundle.getString("global.rest"));%> </option>
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
                                    <p align = "center"> <strong> <% out.print(bundle.getString("global.description"));%> </strong> </p>
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u">
                                    <input type="text"  name="description" value="${tour.description}"/>                                 </div>
                            </div>
                             <div class="row">
        <div class="12u">
<% if (request.getParameter("tourId") != null) { %>
<ul class="buttons">
    <input type="hidden" name="tourid" value="${tour.id}" />
                <li><input type="submit" class="special" name="manage" value="<% out.print(bundle.getString("global.edit"));%>" /></li>
                <li><input type="submit" class="special" name="manage" value="<% out.print(bundle.getString("global.delete"));%>" /></li>
            </ul>
            <% } else { %>
            <ul class="buttons">
                <li><input type="submit" class="special" name="manage" value="<% out.print(bundle.getString("global.add"));%>" /></li>
                <li><input type="submit" class="special" name="manage" value="<% out.print(bundle.getString("global.cancel"));%>" /></li>
            </ul>
            <% } %>
        </div>
    </div>

    </form>
    </div>
    </section>
</article>
<!-- Scripts -->
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/jquery.dropotron.min.js"></script>
            <script src="assets/js/jquery.scrolly.min.js"></script>
            <script src="assets/js/jquery.scrollgress.min.js"></script>
            <script src="assets/js/skel.min.js"></script>
            <script src="assets/js/util.js"></script>
            <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
            <script src="assets/js/main.js"></script>

                	</body>
                </html>
                           <%--<a href="admin?action=changeRole&userId=<c:out value="${user.id}"/>"> Change role </a>--%>