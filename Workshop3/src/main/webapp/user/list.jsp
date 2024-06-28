<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/user/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">User CRUD</h1>

        <a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" href='<c:url value="/user/add" />'><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">List użytkowników</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nazwa użytkownika</th>
                        <th>Email</th>
                        <th>Akcja</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user" varStatus="theCount">
                        <tr>
                            <th>${theCount.count}.</th>
                            <th>${user.userName}</th>
                            <th>${user.email}</th>
                            <th>
                                <a href='<c:url value="/user/edit?id=${user.id}"/>'>Edytuj</a>
                                <a href='<c:url value="/user/delete?id=${user.id}"/>'>Usuń</a>
                                <a href='<c:url value="/user/show?id=${user.id}"/>'>Pokaż</a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>
<!-- /.container-fluid -->


<%@ include file="/user/footer.jsp" %>