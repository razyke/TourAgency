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
        <nav id="nav">
            <ul>
                <li class="current"><a href="/">To main page </a></li>
                </li>
                <% if (request.getSession().getAttribute("role")!=null) { %>
                <li><a href="welcome?action=signOut" class="button special">Sign out</a></li>
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


    <%--<% if (request.getSession().getAttribute("role")!=null) { %>

    <p align="center"> Hello, ${userName}! </p>

    <p align="center"> You signed as  ${role}. </p>

    <form method="post" action="signOut">
        <p align="right">
            <button type = "submit" value="signOut"> Sign out </button>
        </p>
    </form>

    <% } else {%>

     <c:forEach items="${registration}" var="reg">

         <p align="center" style="color: red">${reg}<br> </p>

      </c:forEach>

        <form method="post" action="register">

            <table border="1" width="30%" cellpadding="5" align="center">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td>First Name*</td>
                        <td><input type="text" name="firstName" value="${user.firstName}" /></td>
                    </tr>

                    <tr>
                         <td>Middle name</td>
                         <td><input type="text" name="middleName" value="${user.middleName}" /></td>
                     </tr>

                    <tr>
                        <td>Last Name*</td>
                        <td><input type="text" name="lastName" value="${user.lastName}" /></td>
                    </tr>

                    <tr>
                        <td>Email*</td>
                        <td><input type="text" name="email" value="${user.email}" /></td>
                    </tr>

                     <tr>
                         <td>Phone*</td>
                         <td><input type="phone" name="phone" value="${user.phone}" /></td>
                         </tr>
                    <tr>

                     <tr>
                     <td>Address</td>
                     <td><input type="text" name="address" value="${user.address}" /></td>
                     </tr>

                        <td>User Name*</td>
                        <td><input type="text" name="userName" value="${user.loginName}" /></td>
                     </tr>

                     <tr>
                        <td>Password*</td>
                        <td><input type="password" name="password" value="${user.password}" /></td>
                     </tr>

                     <tr>
                        <td>Repeat Password*</td>
                        <td><input type="password" name="password2" value="${user.password2}" /></td>
                     </tr>

                     <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>

                    <tr>
                        <td colspan="2">Already registered? sign in <a href="login">here</a></td>
                    </tr>

                </tbody>

            </table>

        </form>



    <% } %>
    --%>
    </body>
</html>