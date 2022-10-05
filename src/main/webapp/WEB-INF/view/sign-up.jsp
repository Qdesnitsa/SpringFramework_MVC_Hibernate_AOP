<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        div {
            margin-top: 10%;
            margin-left: 40%;
        }
    </style>
</head>
<body>
<div>
    <h1>Registration form</h1>
    <s:form action="/sign-up" method="POST" modelAttribute="newUser">
        <table>
            <tr>
                <td>Name:</td>
                <td><s:input path="name" placeholder="First name"/></td>
                <td><s:errors path="name"/></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><s:input path="surname" placeholder="Second name"/></td>
                <td><s:errors path="surname"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><s:input path="email" placeholder="E-mail"/></td>
                <td><s:errors path="email"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><s:input path="password" type="password" placeholder="Password"/></td>
                <td><s:errors path="password"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><s:input path="country" placeholder="Country"/></td>
                <td><s:errors path="country"/></td>
            </tr>
            <tr>
                <td>Choose:</td>
                <td>
                    <select name="role_id">
                        <option value="3">Buyer</option>
                        <option value="2">Seller</option>
                    </select>
                </td>
            </tr>
            <tr align="center" height="50">
                <td><s:button>SIGN UP</s:button></td>
            </tr>
            <tr>
                <td colspan="3"><p style="color: red">${message}</p></td>
            </tr>
        </table>
    </s:form>
    <form action="/">
        Already have an account?<a href="/sign-in"> Sign In</a>
    </form>
</div>
</body>
</html>
