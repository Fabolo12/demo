<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>JavaBean</title>
</head>
<body>

<section>
    <jsp:useBean id="bot" scope="request" type="com.jr.module3.lesson8.model.Bot"/>
    <form method="post" action="/JavaRush/lesson8/bot?action=submit">
        <dl>
            <dt>ID: </dt>
            <dd><input type="number" name="id" value="${bot.id}" placeholder="${bot.id}" /></dd>
        </dl>
        <dl>
            <dt>Name: </dt>
            <dd><input type="text" name="name" value="${bot.name}" placeholder="${bot.name}" /></dd>
        </dl>
        <dl>
            <dt>Serial number: </dt>
            <dd><input type="number" name="serial" value="${bot.serial}" placeholder="${bot.serial}" /></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>

</body>
</html>