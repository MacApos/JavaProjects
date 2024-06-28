<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/views/form_header.jsp"/>
<html>
<body>
<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    First name: <form:input path="firstName"/><form:errors path="firstName" element="div" cssClass="errorDiv"/> <br>
    Last name: <form:input path="lastName"/><form:errors path="lastName" element="div" cssClass="errorDiv"/> <br>
    <input type="submit" value="Submit"/><br>
</form:form>
</body>
</html>
