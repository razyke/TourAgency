<%--%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Users</title>
</head>

<body>

<h3 align="center"> <c:out value="tour.title"> </h3>
<form method="post" action="admin">
<p> Tour title <br> </p>
<input type="text" value = "${tour.title}"> </input>
<p> Tour description <br> </p>
<input type="text" value = "${tour.description}"> </input>
</form>
</body>
</html>
--%>
<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title> Edit tour </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/m2.css" />
</head>
<body class="contact">
<header id="header">
 <h1 id="logo"><a href="index.html">TourAgenstvo <span>Java</span></a></h1>
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

							<!-- Content -->
								<div class="content">
									<form>
								<div class="row 50%">
                   					<div class="6u 12u(mobile)">
                                    	<p> Title </p>
                                    		</div>
                                    			<div class="6u 12u(mobile)">
                  									<p> City </p>
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
                                    	<p> Type </p>
                                    		</div>
                                    			<div class="6u 12u(mobile)">
                  									<p> Hot </p>
              									</div>

										<div class="row 50%">
											<div class="6u 12u(mobile)">
												<c:choose>
                                                    <c:when test="${tour.type eq ('excursion')}">
                                                    <select id="group" name="groupId">
                                                        <option selected value="1"> Excursion </option>
                                                        <option value="2"> Shopping </option>
                                                        <option value="3"> Rest </option>
                                                    </select>
                                                    <br/>
                                                    </c:when>
											</div>
											<div class="6u 12u(mobile)">
												<c:choose>
                                                        <c:when test="${tour.isHot eq ('true')}">
                                                            <input
                                                                    type="checkbox" name="isHot" checked="checked"
                                                                    value="true" /><br /><br/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input
                                                                    type="checkbox" name="isHot"
                                                                    value="true" /><br /><br/>
                                                        </c:otherwise>
                                                    </c:choose>
											</div>
										</div>

										<div class="row 50%">
											<div class="12u">
												<textarea name="description" value="${tour.description}"></textarea>
											</div>
										</div>

										<div class="row">
											<div class="12u">
												<ul class="buttons">
													<li><input type="submit" class="special" value="Edit" /></li>
												</ul>
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