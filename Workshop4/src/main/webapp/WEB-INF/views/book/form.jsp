<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .errorDiv {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="book">
        <form:hidden path="id"/>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"/></td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td><form:input path="isbn"/></td>
        </tr>
        <tr>
            <td>Publisher:</td>
            <td><form:input path="publisher"/></td>
        </tr>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
        </tr>

    </form:form>
</table>
</body>
</html>
