<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mohsen
  Date: 7/4/23
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserAddPage</title>
</head>
<body>

<%--@elvariable id="user" type="com.example.model.User"--%>
<form:form method="post" action="/app/user" modelAttribute="user">
    <form:input path="firstName"/>
    <br/>
    <form:input path="lastName"/>
    <br/>
    <form:input path="username"/>

    <br/>
    <br/>
    <form:button/>
</form:form>

</body>
</html>
