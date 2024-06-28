<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/views/form_header.jsp"/>
<html>
<body>
<table>
    <form:form method="post" modelAttribute="article">
        <form:hidden path="id"/>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"/><form:errors path="title" element="div" cssClass="errorDiv"/></td>
        </tr>
        <tr>
            <td> Author:</td>
            <td><form:select path="author" items="${authors}" itemLabel="fullName" itemValue="id"/></td>
        </tr>
        <tr>
            <td> Content:</td>
            <td><form:input path="content"/></td>
            <form:errors path="content" element="div" cssClass="errorDiv"/>
        </tr>
        <tr>
            <td> Categories:</td>
            <td><form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"/></td>
            <form:errors path="categories" element="div" cssClass="errorDiv"/>
        </tr>
        <tr>
            <td> Created:</td>
            <td><form:input type="date" path="created"/></td>
        </tr>
        <tr>
            <td> Updated:</td>
            <td><form:input type="date" path="updated"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </form:form>
</table>
</body>
</html>