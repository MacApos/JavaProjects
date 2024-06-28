<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/user/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">User CRUD</h1>

        <a class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
           href='<c:url value="/user/list" />'><i
                class="fas fa-download fa-sm text-white-50 fa-rotate-90"></i> Powrót do listy</a>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">List użytkowników</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">

                <div class="card-body">
                    <div class="table-responsive">

                        <form action="${pageContext.request.contextPath}/user/delete?id=${deleteUser.id}" method="post">
                            <div class="form-group">
                                <label for="deleteUser">Czy na pewno chcesz usunąć użytkownika ${deleteUser.userName}?</label>
                            </div>
                            <a class="btn btn-secondary" href='<c:url value="/user/list" />'>Nie</a>
                            <button class="btn btn-primary"  type="submit"  id="deleteUser">Tak</button>
                        </form>

                    </div>
                </div>

            </div>
        </div>
    </div>


</div>
<!-- /.container-fluid -->

<%@ include file="/user/footer.jsp" %>