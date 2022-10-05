<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign In</title>
    <style>
        div {
            margin-top: 10%;
            margin-left: 40%;
        }
    </style>
</head>
<body>
<div>
    <h1>Sign in</h1>
    <s:form action="/sign-in" method="POST" modelAttribute="existingUser">
        <table>
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
            <tr align="center" height="50">
                <td><s:button>SIGN IN</s:button></td>
            </tr>
            <tr>
                <td colspan="3"><p style="color: red">${message}</p></td>
            </tr>
        </table>
    </s:form>
    <form action="/">
        Don't have an account?<a href="/sign-up"> Sign Up</a>
    </form>
</div>

</body>
</html>
