<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/user/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

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
                <h6 class="m-0 font-weight-bold text-primary">Edycja użytkownika</h6>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <form action="${pageContext.request.contextPath}/user/edit?id=${editUser.id}" method="post">
                        <div class="form-group">
                            <label for="editUsername">Nowa nazwa</label>
                            <input type="text" class="form-control" name="username" value="${editUser.userName}"
                                   id="editUsername" required>
                        </div>
                        <div class="form-group">
                            <label for="editEmail">Nowy email</label>
                            <input type="email" class="form-control" name="email" value="${editUser.email}"
                                   id="editEmail" required>
                        </div>
                        <div class="form-group">
                            <label for="editPassword">Nowe hasło</label>
                            <input type="password" class="form-control" name="password"
                                   id="editPassword" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Zapisz</button>
                    </form>
                </div>
            </div>

            <!-- Content Row -->
            <div class="row">

            </div>
        </div>
    </div>


</div>
<!-- /.container-fluid -->

<%@ include file="/user/footer.jsp" %>