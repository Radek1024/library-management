<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Title</title>
    <style>
        * {
            box-sizing: border-box;
         }
        .addBook{
            width: 100%;
            float: top;
            padding: 50px;

        }
        .books{
            width: 100%;
            float: inherit;
            padding: 50px;
        }
        .rentedBooks{
            width: 100%;
            float: bottom;
            padding: 50px;
        }
        body{
            background-image: url("https://weneedfun.com/wp-content/uploads/2016/01/Flower-Wallpaper-28.jpg");
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        label {
            text-align: left;
            color: darkslategray;

        }
        h1 {
            text-align: center;
            color: cornsilk;
            padding: 30px;
        }

        h2, table, form {
            text-align: center;
            color: black;
        }

        table {
            width: 100%;
        }

        header {
            background-color: darksalmon;
        }
    </style>

</head>
<body >
<header>
    <c:forEach var="user" items="${user}">
        <h1>Welcome ${user.getName()}</h1>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/logout">logout</a>
</header>
<h2>add book</h2>
<div class="addBook">
<form action="${pageContext.request.contextPath}/AddBook">
    <div>
        <label for="title">title</label><br>
        <input type="text" id="title" name="title" placeholder="title" required>
    </div>
    <div>
        <label>author</label><br>
        <input type="text" name="author" placeholder="author" required>
    </div>
    <div>
        <label>quantity</label><br>
        <input type="text" name="quantity" placeholder="quantity" required>
    </div>
    <div>
        <input type="submit" value="add book">
    </div>
</form>
</div>
<hr>
<h2>books list</h2>
<div class="books">
<table>
    <tr>
        <th>
            title
        </th>
        <th>
            author
        </th>
        <th>
            quantity
        </th>
        <th>
            id
        </th>
        <th>
            action
        </th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>
                    ${book.getTitle()}
            </td>
            <td>
                    ${book.getAuthor()}
            </td>
            <td>
                    ${book.getQuantity()}
            </td>
            <td>
                    ${book.getId()}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/Rent?title=${book.getTitle()}">rent</a>,
                <a href="${pageContext.request.contextPath}/GetBookByTitle?title=${book.getTitle()}">edit</a>,
                <a href="${pageContext.request.contextPath}/RemoveBook?title=${book.getTitle()}"> remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
<hr>
<h2>rented books</h2>
<div class="rentedBooks">
    <table>
        <tr>
            <th>
                name
            </th>
            <th>
                books rented
            </th>
            <th>
                time
            </th>
            <th>
                action
            </th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    ${user.getName()} ${user.getLastName()}
                </td>
                <c:if test="${user.getBook() != null }">
                <td>
                    ${user.getBook()}, ${user.getBooksRented()}
                </td>
                </c:if>
                <td>
                   rent: ${user.getBeginning()} due: ${user.getEnd()}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/RemoveUser?lastName=${user.getLastName()}&title=${user.getBook()}&quantity=${user.getBooksRented()}">remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
