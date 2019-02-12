<%--
  Created by IntelliJ IDEA.
  User: azizalyahya
  Date: 2019-02-11
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
        <jsp:include page="/WEB-INF/partials/head.jsp" />
    </head>
    <body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h2>Register a new user</h2>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>

    </div>



    </body>
</html>
