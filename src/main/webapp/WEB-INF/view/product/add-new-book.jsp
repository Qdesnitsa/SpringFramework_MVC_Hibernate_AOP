<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New product</title>
    <style>
        div {
            margin-top: 10%;
            margin-left: 40%;
        }
    </style>
</head>
<body>
<div>
    <h2>Addition/Edition of product: Book</h2>
    <s:form action="/product/add-new-book" method="POST" modelAttribute="newBook">
        <s:hidden path="id"></s:hidden>
        <table>
            <tr>
                <td>Name:</td>
                <td><s:input path="name" placeholder="Name"/></td>
                <td><s:errors path="name"/></td>
            </tr>
            <tr>
                <td>Programming language:</td>
                <td><s:input path="language" placeholder="Programming language"/></td>
                <td><s:errors path="language"/></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><s:input path="author" placeholder="Author"/></td>
                <td><s:errors path="author"/></td>
            </tr>
            <tr>
                <td>Year of publishment:</td>
                <td><s:input path="yearPublished" placeholder="Year of publishment"/></td>
                <td><s:errors path="yearPublished"/></td>
            </tr>
            <tr>
                <td>Quantity of pages:</td>
                <td><s:input path="pageNumber" placeholder="Quantity of pages"/></td>
                <td><s:errors path="pageNumber"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><s:input path="price" placeholder="Price"/></td>
                <td><s:errors path="price"/></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><select name="statusId">
                    <option value="1">Available</option>
                    <option value="2">Unavailable</option>
                </select></td>
            </tr>
            <tr align="center" height="50">
                <td colspan="1"><s:button>Submit</s:button></td>
            </tr>
            <tr>
                <td colspan="3"><p style="color: red">${message}</p></td>
            </tr>
        </table>
    </s:form>
    <form action="/home">
        <button type="submit">Return to home page</button>
    </form>
</div>
</body>
</html>
