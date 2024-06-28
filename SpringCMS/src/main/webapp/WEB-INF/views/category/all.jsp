<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${categories}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.description}</td>
            <td>${author.name}</td>
            <td><a href='<c:url value="/category/delete?id=${author.id}"/>'>
                <button>Delete</button>
            </a></td>
            <td><a href='<c:url value="/category/form?id=${author.id}"/>'>
                <button>Edit</button>
            </a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href='<c:url value="/category/form?id="/>'>
            <button>Add</button>
        </a></td>
    </tr>
</table>
</body>
</html>
