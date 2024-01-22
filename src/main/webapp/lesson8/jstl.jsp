<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>JSTL</title>
</head>
<body>

<c:set var="users" value="${['Alex', 'Jon']}" />

<h1>Users:</h1>
<ul>
    <c:forEach var="user" items="${users}">
        <li>${user}</li>
    </c:forEach>
</ul>

</body>
</html>