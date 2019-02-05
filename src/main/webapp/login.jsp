<%--
  Created by IntelliJ IDEA.
  User: azizalyahya
  Date: 2019-02-05
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login.jsp" method="post">
        Username:<br>
        <input id="username" type="text" name="username"><br>
        Password:<br>
        <input id="password" type="password" name="password">
        <button type="submit">Submit</button>
    </form>
</body>
</html>
