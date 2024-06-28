<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/views/all_header.jsp"/>
<style>
    tr:last-child td {
        border-bottom: none;
    }
</style>
<html>
<body>
<table>
    <th></th>
    <th>First name</th>
    <th>Last name</th>
    <th class="no-borders" style="border-left: 1px solid black; border-bottom: 1px solid black;"></th>
    <th class="no-borders" style="border-bottom: 1px solid black;"></th>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href='<c:url value="/author/delete?id=${author.id}"/>'>
                <button>Delete</button>
            </a></td>
            <td><a href='<c:url value="/author/form?id=${author.id}"/>'>
                <button>Edit</button>
            </a></td>
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
