<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("loginPage.jsp");
    } %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Edit book</title>
</head>
<body>
<h1>edit book</h1>
<form action="${pageContext.request.contextPath}/EditBook">
    <input type="text" name="title" value="${book.getTitle()}">
    <input type="text" name="author" value="${book.getAuthor()}">
    <input type="text" name="quantity" value="${book.getQuantity()}">
    <input type="text" name="id" value="${book.getId()}">
    <input type="submit" value="edit">
</form>
</body>
</html>
