<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<h2>Users list</h2>
<c:forEach var="user" items="${users}">
    <p>${user.id}</p>
    <p>${user.name}</p>
    <p>${user.surname}</p>
    <p>-----------------</p>
</c:forEach>

</body>
</html>