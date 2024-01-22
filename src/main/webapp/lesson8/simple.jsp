<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>Simple JSP example</title>
</head>
<body>
    <p>This is a simple JSP page. Here is your request method: <%= request.getMethod() %> </p>
    <p>Today is <%= LocalDate.now() %></p>
</body>
</html>