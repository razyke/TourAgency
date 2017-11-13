<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>

</head>

<body>

<p align = "center" style = "color: green" > ${registration} </p>
        <form>
            <select id="language" name="language" onchange="submit()">
                <option value="EN" ${language == 'EN' ? 'selected' : ''}>English</option>
                <option value="RU" ${language == 'RU' ? 'selected' : ''}>Русский</option>
            </select>
        </form>
<h3 align="center"><fmt:message key="label.greeting" /></h3>
<h3 align="center"> Select Tour </h3>

<c:forEach items="${tours}" var="tour">
<a href = "order?action=order&tourId=<c:out value="${tour.id}"/>"></br></br>
    <c:out value = "${tour.title}"/> </a>
</c:forEach>

<% if (request.getSession().getAttribute("role")==null) { %>
<form form action=login>
    <p align="right">
        <button type="submit" value="login">Sign in</button>
    </p>
</form>

<form form action=register>
    <p align="right">
        <button type="submit" value="register">Register</button>
    </p>

</form>
<% } else {%>
<a href="admin"> To admin page </a>
<p align="center"> Hello, ${userName}! </p>
<p align="center"> You signed as  ${role}. </p>
<a href="welcome?action=signOut"> sign out </a>

<% } %>
</body>
</html>