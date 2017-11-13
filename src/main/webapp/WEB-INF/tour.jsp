%@ page  contentType="text/html" pageEncoding="UTF-8"%>
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