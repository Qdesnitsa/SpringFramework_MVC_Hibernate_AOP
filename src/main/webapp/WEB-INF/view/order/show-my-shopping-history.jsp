<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping history</title>
    <style>
        div {
            margin-top: 2%;
            margin-left: 2%;
        }

        table {
            table-layout: fixed;
            width: 80%;
            border-collapse: collapse;
            border: 1px solid gray;
        }

        tbody tr:nth-child(odd) {
            background-color: lightgrey;
        }

        tbody tr:nth-child(even) {
            background-color: whitesmoke;
        }
    </style>
</head>
<body>
<div>
    <h2>My shopping history</h2>
    <table>
        <tr>
            <th>Date of order</th>
            <th>Name</th>
            <th>Language</th>
            <th>Author</th>
            <th>Price</th>
        </tr>
        <c:forEach var="entry" items="${map}">
            <c:forEach var="order" items="${entry.value}">
                <c:forEach var="product" items="${order.value}">
                    <tr>
                        <td>${order.key}</td>
                        <td>${product.name}</td>
                        <td>${product.language}</td>
                        <td>${product.author}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </table>
    <br><br>
    <p style="color: red">${message}</p>
    <form action="/home">
        <button type="submit">Return to home page</button>
    </form>
</div>
</body>
</html>
