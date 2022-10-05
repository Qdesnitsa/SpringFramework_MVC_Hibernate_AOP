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
    </style>
</head>
<body>
<div>
    <h2>IT Educational products: Books</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Language</th>
            <th>Author</th>
            <th>Pages</th>
            <th>Year</th>
            <th>Price</th>
            <th>Status</th>
            <th width="25%">Action</th>
        </tr>
        <c:forEach var="book" items="${allBooks}">
            <c:url var="editButton" value="/product/editBook">
                <c:param name="bookId" value="${book.id}"></c:param>
            </c:url>
            <c:url var="deleteButton" value="/product/deleteBook">
                <c:param name="bookId" value="${book.id}"></c:param>
            </c:url>
            <c:url var="addButton" value="/product/addBookToShoppingCart">
                <c:param name="bookId" value="${book.id}"></c:param>
            </c:url>
            <tr>
                <td>${book.name}</td>
                <td>${book.language}</td>
                <td>${book.author}</td>
                <td>${book.pageNumber}</td>
                <td>${book.yearPublished}</td>
                <td>${book.price}</td>
                <td>${book.productStatus}</td>
                <td><input type="button" value="Update" onclick="window.location.href = '${editButton}'"/>
                    <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                    <input type="button" value="Add to shopping cart" onclick="window.location.href = '${addButton}'"/>
                </td>
            </tr>
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
