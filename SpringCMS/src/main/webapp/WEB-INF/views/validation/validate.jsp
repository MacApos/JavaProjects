<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nitro
  Date: 13.09.2023
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${violations}" var="violation">
    <c:out value="${violation.propertyPath}"/> :
    <c:out value="${violation.message}"/><br>
</c:forEach>
</body>
</html>
