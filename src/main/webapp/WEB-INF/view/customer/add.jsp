<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register Customer</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<form:form action="/app/customer" method="post" modelAttribute="registerDto">

    <label for="firstName">First name:</label>
    <form:input id="firstName" path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>

    <br/>
    <label for="lastName">Last name:</label>
    <form:input id="lastName" path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>

    <br/>
    <label for="phoneNumber">Phone Number: </label>
    <form:input id="phoneNumber" path="number"/>
    <form:errors path="number" cssClass="error"/>

    <br/>
    <form:button>Save</form:button>

</form:form>

</body>
</html>
