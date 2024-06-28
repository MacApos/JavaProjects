<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            table-layout: auto;
            width: 80%;
            font-size: 100%;
        }

        td {
            vertical-align: center;
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <th></th>
    <th>Author</th>
    <th>ISBN</th>
    <th>Publisher</th>
    <th>Title</th>
    <th>Type</th>
    </thead>

    <c:forEach items="${books}" var="book">
        <tr>
            <td style="width: max-content">${book.id}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
            <td>${book.publisher}</td>
            <td>${book.title}</td>
            <td>${book.type}</td>
            <td><a href='<c:url value="/books/delete?id=${book.id}"/>'>
                <button>Delete</button>
            </a></td>
            <td><a href='<c:url value="/books/form?id=${book.id}"/>'>
                <button>Edit</button>
            </a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href='<c:url value="/books/form?id="/>'>
            <button>Add</button>
        </a></td>
    </tr>
</table>
</body>
</html>
