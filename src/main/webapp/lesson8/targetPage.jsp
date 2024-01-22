<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>Target page</title>
</head>
<body>
<h1>This is a target page JSP</h1>
<p>Message: <%= request.getAttribute("message") %></p>
</body>
</html>