<%--
  Created by IntelliJ IDEA.
  User: azizalyahya
  Date: 2019-02-05
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp" />
</head>
    <jsp:include page="partials/navbar.jsp" />
    <body>
        <form action="/login" method="post">
            Username:<br>
            <input id="username" type="text" name="username"><br>
            Password:<br>
            <input id="password" type="password" name="password">
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
