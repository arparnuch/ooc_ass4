<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<title>Insert title here</title>--%>
</head>
<body>
<h1>Register Page</h1>
<form action="RegisterServlet" method="post">
    Enter your username : <input type="text" name="username"> <BR>
    Enter your password : <input type="password" name="password"> <BR>
    Enter your firstname : <input type="text" name="firstname"> <BR>
    Enter your lastname : <input type="text" name="lastname"> <BR>
    Enter your email : <input type="text" name="email"> <BR>
    <input type="submit" />
</form>
</body>
</html>