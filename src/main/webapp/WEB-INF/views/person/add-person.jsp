<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Person</title>
    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
            rel="stylesheet"
    />

    <!-- MDB -->
    <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
    ></script>
</head>
<body>

<%--@elvariable id="person" type="com.example.model.Person"--%>
<form:form class="container" action="/app/person/add" method="post" modelAttribute="person">
    <div class="form-outline mb-4">
        <form:input type="text" id="firstName" name="firstName" class="form-control" path="firstName"/>
        <label class="form-label" for="firstName">First name : </label>
    </div>

    <div class="form-outline mb-4">
        <form:input path="lastName" type="text" id="lastName" name="lastName" class="form-control"/>
        <label class="form-label" for="lastName">Last Name :</label>
    </div>

    <div class="form-outline mb-4">
        <form:input path="age" type="number" id="age" name="age" class="form-control"/>
        <label class="form-label" for="age">Age</label>
    </div>

    <!-- Submit button -->
    <form:button type="submit" class="btn btn-primary btn-block mb-4">Save</form:button>
</form:form>

</body>
</html>
