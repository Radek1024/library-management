<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    if (request.getSession().getAttribute("admin") == null) {
        response.sendRedirect("loginPage.jsp");
    } %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        form, h1 {
            text-align: center
        }
    </style>
    <title>Edit librarian</title>
</head>
<body>
<h1>edit librarian</h1>
<form action="${pageContext.request.contextPath}/EditLibrarian" method="post">
    name<br>
    <input type="text" name="name" value="${librarian.getName()}">
    <br>
    last name<br>
    <input type="text" name="lastName" value="${librarian.getLastName()}">
    <br>
    e-mail<br>
    <input type="email" name="email" value="${librarian.getEmail()}">
    <br>
    id<br>
    <input type="text" name="id" value="${librarian.getId()}">
    <br>
    <input type="submit" value="update">
</form>
</body>
</html>
