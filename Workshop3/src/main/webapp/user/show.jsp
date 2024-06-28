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
                <h6 class="m-0 font-weight-bold text-primary">Szczegóły użytkownika</h6>
            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <tbody>

                        <tr>
                            <th>Id</th>
                            <td>${showUser.id}</td>
                        </tr>
                        <tr>
                            <th>Nazwa użytkownika</th>
                            <td>${showUser.userName}</td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td>${showUser.email}</td>
                        </tr>


                        </tbody>
                    </table>
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