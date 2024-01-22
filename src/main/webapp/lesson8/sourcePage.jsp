<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>Source page</title>
</head>
<body>
<h1>This is a source page JSP</h1>
<%
    request.setAttribute("message", "Hi from Source page");
    request.getRequestDispatcher("targetPage.jsp").forward(request, response);
%>
</body>
</html>