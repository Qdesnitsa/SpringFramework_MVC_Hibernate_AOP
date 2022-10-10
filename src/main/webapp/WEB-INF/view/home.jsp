<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Hello, ${sessionScope.currentUser.name} ${sessionScope.currentUser.surname}!</h2>
You registered as a/an ${sessionScope.currentUser.userRole.userRole}<br>
Your current status is ${sessionScope.currentUser.userStatus.userStatus}<br><br>

<!--ADMIN (edit, delete), SELLER (-), BUYER (add to shopping cart)-->
<s:form action="/product/show-books" method="get">
    <input type="hidden" name="page" value="0"/>
    <input type="hidden" name="pageSize" value="5"/>
    <button type="submit">Show all books</button>
</s:form>

<!--ADMIN (edit, delete), SELLER (-), BUYER (add to shopping cart)-->
<form action="/product/show-videos">
    <button type="submit">Show all videos</button>
</form>

<c:if test="${sessionScope.currentUser.userRole.id != 1}">
    <!--SELLER (edit), BUYER (read, edit)-->
    <form action="/show-my-products">
        <button type="submit">Show my products</button>
    </form>
</c:if>

<!--BUYER (delete product, clean shopping cart, buy now)-->
<form action="/order/show-my-shopping-cart">
    <button type="submit">Show my shopping cart</button>
</form>

<!--BUYER (-)-->
<form action="/order/show-my-shopping-history">
    <button type="submit">Show my shopping history</button>
</form>

<!--ADMIN, SELLER-->
<form action="/product/add-new-book">
    <button type="submit">Add new book</button>
</form>

<!--ADMIN, SELLER-->
<form action="/product/add-new-video">
    <button type="submit">Add new video</button>
</form>

<br><br><br><br><br>

<!--ADMIN, SELLER, BUYER-->
<form action="/sign-out">
    <button type="submit">Sign out</button>
</form>
<p style="color: red">${message}</p>
</body>
</html>
