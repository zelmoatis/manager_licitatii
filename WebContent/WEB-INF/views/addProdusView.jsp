<%--
  Created by IntelliJ IDEA.
  User: bujor
  Date: 30.05.2017
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Produs</title>
</head>
<body>
    <p>Hello: ${user.user_name}</p>

    Adaugati produsele:
    <form action="doAddProdus" method="post">
        Nume produs: <input type="text" name="nume">
        <br/>
        Pretul de pornire: <input type="text" name="pret_pornire">
        <br/>
        Numele vanzatorului: <input type="text" name="nume_vanzator">
        <br/>
        Calea catre poza: <input type="text" name="poza">
        <br/>
        <input type="submit" name="submit">
    </form>

    <p>${succesString}</p>
    <p>${errorString}</p>
</body>
</html>
