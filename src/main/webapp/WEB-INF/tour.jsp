%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Users</title>
</head>

<body>

<h3 align="center"> <c:out value="tour.title"> </h3>
<form method="post" action="admin">
<input type="text" value = "<c:out value="tour.title">"> </input>
</form>
</body>
</html>