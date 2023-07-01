<%--
  Created by IntelliJ IDEA.
  User: mohsen
  Date: 7/1/23
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/test/api/user/register">
    <p>Username: </p>
    <input name="username" type="text">

    <p>Password: </p>
    <input name="password" type="password">

    <p>Password: </p>
    <input name="repeatPassword" type="password">

    <button>Register</button>

</form>

</body>
</html>
