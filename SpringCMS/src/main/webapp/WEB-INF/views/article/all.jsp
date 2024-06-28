<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/views/all_header.jsp"/>
<html>
<body>
<table>
    <th></th>
    <th>Title</th>
    <th>Content</th>
    <th>Category</th>
    <th>Created</th>
    <th>Updated</th>
    <th class="no-borders" style="border-left: 1px solid black; border-bottom: 1px solid black;"></th>
    <th class="no-borders" style="border-bottom: 1px solid black;"></th>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>
                <c:forEach items="${article.categories}" var="category">
                    ${category.name}<br>
                </c:forEach>
            </td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td class="no-borders" style="border-left: 1px solid black">
                <a href='<c:url value="/article/delete?id=${article.id}"/>'>
                    <button>Delete</button>
                </a>
            </td>
            <td class="no-borders">
                <a href='<c:url value="/article/form?id=${article.id}"/>'>
                    <button>Edit</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td class="no-borders">
            <a href='<c:url value="/article/form?id="/>'>
                <button>Add</button>
            </a>
        </td>
    </tr>
</table>
</body>
</html>
