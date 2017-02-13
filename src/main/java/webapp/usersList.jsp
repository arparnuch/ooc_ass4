<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%--<form action="/users" method="get"></form>--%>
<form action="/users" method="post">
    <h1>User List Page</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <td>First name</td>
                <td>Last name</td>
                <td>E-mail</td>
            </tr>
        </thead>
        <c:forEach var="u" items="${userArrayList}">
            <tr>
                <td>${u.firstname}</td>
                <td>${u.lastName}</td>
                <td>${u.email}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit">
</form>

</body>
</html>