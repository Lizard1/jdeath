<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>MusicCatalog</title>
</head>
<body>
<div>
    <div>
        <form action="/UserServlet" method="get">
            <p>Print users.</p>
            <p><input type="submit" value="Yes" name="nameStrParam"></p>
        </form>
    </div>

    <div>
        <form action="/AccountServlet" method="get">
            <p>Print accounts.</p>
            <p><input type="submit" value="Yes" name="nameStrAcParam"></p>
        </form>
    </div>
</div>

<div>
    <form action="/UserServlet" method="get">
        <p>Print one user.</p>
        <input type="text" placeholder="enter id" name="idUser">
        <p><input type="submit" value="Yes" name="nameStrParam"></p>
    </form>
</div>

<div>
    <form action="/AccountServlet" method="get">
        <p>Print one account.</p>
        <input type="text" placeholder="enter id" name="idAccount">
        <p><input type="submit" value="Yes" name="nameStrAcParam"></p>
    </form>
</div>
</div>


<div>
    <form action="/UserServlet" method="get">
        <input type="text" value="richest-user" name="nameStrParam">
        <input type="submit" value="get">
    </form>
</div>


<div>
    <form action="/AccountServlet" method="get">
        <input type="text" value="sum-accounts" name="nameStrAcParam">
        <input type="submit" value="get">
    </form>
</div>
</body>
</html>