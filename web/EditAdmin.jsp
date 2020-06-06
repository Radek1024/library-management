<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (request.getSession().getAttribute("admin") == null) {
        response.sendRedirect("loginPage.jsp");
    }
%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        input, form {
            text-align: center;
            margin: 0 auto
        }
    </style>
    <title>update admin</title>
</head>
<body>
<h1 style="text-align: center">Edit admin</h1>
<hr>
<form action="${pageContext.request.contextPath}/EditAdmin" method="post">
    <input type="text" name="name" value="${dao.getName()}">
    <input type="email" name="email" value="${dao.getEmail()}">
    <input type="text" name="id" value="${dao.getId()}">
    <input type="submit" value="update user">
</form>
</body>
</html>
