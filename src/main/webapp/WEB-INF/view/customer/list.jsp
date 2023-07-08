<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>

<table id="customers">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Number</th>
        <th>Edit</th>
        <%--TODO--%>
    </tr>

    <c:forEach items="${data}" var="dto">
        <tr>
            <td>${dto.id}</td>
            <td>${dto.fullName}</td>
            <td>${dto.number}</td>
            <td><a href="/app/customer/edit/${dto.id}">Edit</a></td>
                <%--TODO--%>
        </tr>
    </c:forEach>
</table>

</body>
</html>
