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
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <style>
        *{
            box-sizing: border-box;
        }

        body{
            background-image: url("https://weneedfun.com/wp-content/uploads/2016/01/Flower-Wallpaper-28.jpg");
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .title{
            width: 50%;
            color: black;
            padding: 50px;
            float: left;
        }
        .user{
            width: 50%;
            padding: 50px;
            float: top;
            color: black;
        }
        .rent{
            color: red;
            padding: 10px;
        }
        header{
            padding: 50px;
            background-color: darksalmon;
            text-align: center;
            color: cornsilk;
        }

    </style>
    <title>Book renting</title>
</head>
<body>
<header>
    <h1>book rent</h1>
</header>
<div class="title">
<dl>
    <dt>Title:</dt>
        <dd>${book.getTitle()}</dd>
    <dt>Author:</dt>
        <dd>${book.getAuthor()}</dd>
    <dt>quantity:</dt>
        <dd>${book.getQuantity()}</dd>
    <dt>id:</dt>
        <dd>${book.getId()}</dd>
</dl>
</div>
<div class="user">
    <form action="${pageContext.request.contextPath}/Rent1" method="post">
        <input type="text" name="name" placeholder="name"><br>
        <input type="text" name="lastName" placeholder="last name"><br>
        <input type="text" name="address" placeholder="address"><br>
        <input type="text" name="booksRented" placeholder="books rented"><br>
        <input type="text" name="book" value="${book.getTitle()}"><br>
        <div class="rent">
        <input type="submit" value="rent">
        </div>
    </form>
</div>
</body>
</html>
