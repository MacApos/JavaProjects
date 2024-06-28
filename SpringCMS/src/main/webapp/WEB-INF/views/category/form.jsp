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
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    Description: <form:input path="description"/><br>
    Name: <form:input path="name"/><form:errors path="name" element="div" cssClass="errorDiv" /><br>
    <input type="submit" value="Submit"/><br>
</form:form>
</body>
</html>
