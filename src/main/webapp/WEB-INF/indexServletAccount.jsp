<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<h2>Accounts list</h2>

<c:forEach var="account" items="${accounts}">
    <p>${account.id}</p>
    <p>${account.accountNumber}</p>
    <p>${account.userId}</p>
    <p>-----------------</p>
</c:forEach>

</body>
</html>