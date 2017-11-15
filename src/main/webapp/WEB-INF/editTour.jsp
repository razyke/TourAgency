<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title> Edit tour </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
</head>
<body class="contact">
<header id="header">
 <h1 id="logo"><a href="#">TourAgenstvo <span>Java</span></a></h1>
    <nav id="nav">
        <ul>
            <li class="current"><a href="/">To main page </a></li>
            <li class="current"><a href="admin?action=addTour"> Add tour </a></li>
            <li><a href="/?action=signOut" class="button special">Sign out</a></li>
        </ul>
    </nav>
</header>
<article id="main">
					<header class="special container">
						<span class="icon fa-tablet"></span>
						<h2>Edit tour</h2>
						<p>Use the form below to edit tour </p>
					</header>

					<!-- One -->
						<section class="wrapper style4 special container 75%">
								<div class="content">
									<form method="post">
<div class="row 50%">
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> Title </strong> </p>
                </div>
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> City </strong> </p>
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

            <div class="6u 12u(mobile)">
                                <p align = "center"> <strong> Price 7 days </strong> </p>
                            </div>
                            <div class="6u 12u(mobile)">
                                <p align = "center"> <strong> Price 10 days </strong> </p>
                            </div>
                        </div>

                        <div class="row 50%">
                            <div class="6u 12u(mobile)">
                                <input type="text" name="price7" value="${tour.costTenDays}" />
                            </div>
                            <div class="6u 12u(mobile)">
                                <input type="text" name="city" value="${tour.tenTenDays}" />
                            </div>
                        </div>
            <div class="row 50%">
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> Type </strong> </p>
                </div>
                <div class="6u 12u(mobile)">
                    <p align = "center"> <strong> Hot </strong>
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
                                            <option selected value="1"> Excursion </option>
                                            <option value="2"> Shopping </option>
                                            <option value="3"> Rest </option>
                                        </select>
                                        <br/>
                                        </c:when>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${tour.type eq ('rest')}">
                                        <select id="type" name="typeId">
                                            <option selected value="1"> Rest </option>
                                            <option value="2"> Shopping </option>
                                            <option value="3"> Excursion </option>
                                        </select>
                                        <br/>
                                        </c:when>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${tour.type eq ('shopping')}">
                                        <select id="type" name="typeId">
                                            <option selected value="1"> Shopping </option>
                                            <option value="2"> Rest </option>
                                            <option value="3"> Excursion </option>
                                        </select>
                                        <br/>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <div class="6u 12u(mobile)">

                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u">
                                    <p align = "center"> <strong> Description </strong> </p>
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u">
                                    <input type="text"  name="description" value="${tour.description}" rows="7"></input>
                                </div>
                            </div>
                             <div class="row">
        <div class="12u">
<% if request.getParameter("tourId") == null { %>
<ul class="buttons">
                <li><input type="submit" class="special" name="manage" value="Edit" /></li>
                <li><input type="submit" class="special" name="manage" value="Delete" /></li>
            </ul>
            <% } else { %}
            <ul class="buttons">
                <li><input type="submit" class="special" name="manage" value="Add" /></li>
                <li><input type="submit" class="special" name="manage" value="Cancel" /></li>
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
                           <a href="admin?action=changeRole&userId=<c:out value="${user.id}"/>"> Change role </a>