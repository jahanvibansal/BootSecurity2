<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="products"> <!-- spring form: automatically generate csrf token -->
<input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
    Id: <input type="number" id="id" name="id"/><br/>
    Name: <input type="text" id="name" name="name"/><br/>
     Username: <input type="text" id="user" name="user"/><br/>
<input type="submit"/>

</form>
</body>
</html>