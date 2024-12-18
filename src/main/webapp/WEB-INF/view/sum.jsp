<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 18/12/2024
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
<%--    inport bootstrap 5--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form action="/sum" method="post">
    Number 1: <input name="num1">
    Number 2: <input name="num2">
    <input type="submit" value="Sum">
</form>
<p>${sum}</p>
</body>
</html>
