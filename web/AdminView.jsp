<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Welcome admin</title>
    <style>
        *{
            box-sizing: border-box;
        }
        h1,  tr, td {
            text-align: center;
            color: cornsilk;
        }
        h2{
            text-align: center;
            color: darkgray;
        }
        th{
            text-align: center;
            color: mintcream;
        }
        table {
            text-align: center;
            width: 100%;
        }
        .adminList{
            padding: 30px;
        }
        .librarianList{
            padding: 30px;
        }

        body{
            background-image: url("https://wallpapercave.com/wp/wp2508260.jpg");
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        table {
            width: 80%
        }
    </style>
</head>
<body>
<h1>Welcome ${admin.getName()}</h1>
<p><a href="${pageContext.request.contextPath}/logout">logout</a></p>
<p><a href="${pageContext.request.contextPath}/AddLibrarian.jsp">add librarian</a></p>
<hr>
<h2>ADMIN LIST</h2>
<div class="adminList">
<table>
    <tr>
        <th>
            NAME
        </th>
        <th>
            E-MAIL
        </th>
        <th>
            ID
        </th>
        <th>
            ACTION
        </th>
    </tr>
    <tr>
        <td>
            ${admin.getName()}
        </td>
        <td>
            ${admin.getEmail()}
        </td>
        <td>
            ${admin.getId()}
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/GetAdminById?id=${admin.getId()}">edit</a>
        </td>
    </tr>
</table>
</div>
<hr>
<h2>LIBRARIAN LIST</h2>
<div class="librarianList">
<table>
    <tr>
        <th>
            NAME
        </th>
        <th>
            LAST NAME
        </th>
        <th>
            E-MAIL
        </th>
        <th>
            ID
        </th>
        <th>
            ACTION
        </th>
    </tr>
    <c:forEach var="lib" items="${librarian}">
        <tr>
            <td>
                    ${lib.getName()}
            </td>
            <td>
                    ${lib.getLastName()}
            </td>
            <td>
                    ${lib.getEmail()}
            </td>
            <td>
                    ${lib.getId()}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/GetLibrarianById?id=${lib.getId()} ">edit</a>,
                <a href="${pageContext.request.contextPath}/RemoveLibrarian?id=${lib.getId()}">remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
