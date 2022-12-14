<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
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

        h3 {
            background: #D9FFAD;
            color: green;
            padding: 2px;
            width: fit-content;
        }
    </style>
</head>
<body>
<div>
    <h2>My shopping cart</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Language</th>
            <th>Author</th>
            <th>Price</th>
            <th width="10%">Action</th>
        </tr>
        <c:forEach var="product" items="${myList}">
            <c:url var="deleteButton" value="/order/deleteProduct">
                <c:param name="productId" value="${product.id}"></c:param>
            </c:url>
            <tr>
                <td>${product.name}</td>
                <td>${product.language}</td>
                <td>${product.author}</td>
                <td>${product.price}</td>
                <td><input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3>Amount to pay: ${amountToPay}</h3>
    <br><br>
    <c:url var="buyNowButton" value="/order/buyNow">
    </c:url>
    <input type="button" value="Buy now" onclick="window.location.href = '${buyNowButton}'"/>
    <br><br>
    <form action="/home">
        <button type="submit">Return to home page</button>
    </form>
    <p style="color: red">${message}</p>
</div>
</body>
</html>
