<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <title>login page</title>
    <style>
        * {
            box-sizing: border-box;
        }

        .admin {
            text-align: left;
            padding: 20px;
            margin-left: 32%;

        }

        .librarian {
            text-align: left;
            padding: 20px;
            margin-left: 32%;
        }

        ::placeholder {
            color: black;
        }

        body {
            background-image: url("https://www.latrobe.edu.au/galleries/sydney-campus-library/library-sydney03.jpg");
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        div {
            text-align: center
        }

        h1 {
            text-align: left;
            margin-left: 31%;
            margin-top: 10%;
            padding: 25px;
            color: black;
        }

        h2 {
            text-align: left;
            margin-left: 31%;
            /*margin-top: 10%;*/
            padding: 25px;
            color: black;
        }

    </style>
</head>
<body>

<h1>Admin login</h1>
<div class="admin">
    <form action="${pageContext.request.contextPath}/AdminSession" method="post">
        <input placeholder="name" type="text" name="name" required><br>
        <input placeholder="email" type="email" name="email"><br>
        <input type="submit" value="login">
    </form>
</div>

<h2>Librarian login</h2>
<div class="librarian">
    <form action="${pageContext.request.contextPath}/LibrarianSession" method="post">
        <input placeholder="name" type="text" name="name" required><br>
        <input placeholder="last name" type="text" name="lastName" required><br>
        <input placeholder="email" type="text" name="email"><br>
        <input type="submit" value="login">
    </form>
</div>
</body>
</html>
