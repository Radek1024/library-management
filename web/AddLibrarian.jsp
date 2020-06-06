<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getSession().getAttribute("admin") == null) {
        response.sendRedirect("loginPage.jsp");
    } %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">

    <title>Add librarian</title>
</head>
<body>
<h1>please add librarian</h1>
<form action="${pageContext.request.contextPath}/AddLibrarian" method="post">
    name<br>
    <input type="text" name="name" placeholder="librarian name">
    <br>
    last name<br>
    <input type="text" name="lastName" placeholder="librarian last name">
    <br>
    e-mail<br>
    <input type="email" name="email" placeholder="librarian email">
    <br>
    <br>
    <input type="submit" value="create">
</form>
</body>
</html>
