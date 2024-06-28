<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href='<c:url value="style.css"/>'>

    <style>
        body{
            background: repeat url("image.png");
        }
        table {
            border-collapse: collapse;
            table-layout: auto;
            width: 80%;
            font-size: 80%;
        }

        th, td {
            vertical-align: top;
            text-align: center;
            border-left: 1px solid black;
            border-bottom: 1px solid black;
        }

        th:first-child, td:first-child {
            border-left: none;
        }

        tr:last-child td {
            border-bottom: none;
        }

        .no-borders {
            border: none;
            text-align: left;
            width: 1%;
        }
    </style>
</head>
</html>